package de.kittybot.kittybot.utils.exporters;

import de.kittybot.kittybot.modules.PrometheusModule;
import de.kittybot.kittybot.objects.module.Modules;
import io.prometheus.client.Gauge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class MemoryUsageExporter{

	// ty Natan 👀 https://github.com/Mantaro/MantaroBot/blob/master/src/main/java/net/kodehawa/mantarobot/utils/exporters/MemoryUsageExports.java
	private static final Logger log = LoggerFactory.getLogger(MemoryUsageExporter.class);
	private static final Pattern SPLIT_PATTERN = Pattern.compile("\\s+");
	private static final Path SMAPS_ROLLUP = Path.of("/proc/self/smaps_rollup");

	private static final Gauge MEMORY_USAGE = Gauge.build()
		.name("jvm_os_memory_used_bytes")
		.help("Memory usage (RSS, PSS) reported by the OS for the JVM")
		.labelNames("type") // RSS/PSS
		.create();

	private static final Gauge.Child PSS = MEMORY_USAGE.labels("PSS");
	private static final Gauge.Child RSS = MEMORY_USAGE.labels("RSS");

	private ScheduledFuture<?> task;

	public void register(Modules modules){
		MEMORY_USAGE.register();

		if(!Files.exists(SMAPS_ROLLUP)){
			PSS.set(-1);
			RSS.set(-1);
			return;
		}

		this.task = modules.getScheduler().scheduleAtFixedRate(
			this::collect, 0,
			PrometheusModule.UPDATE_PERIOD.toMillis(), TimeUnit.MILLISECONDS
		);
	}

	/*
	 * Example smaps_rollup
	 *
	 * Rss:                1680 kB
	 * Pss:                 266 kB
	 * Shared_Clean:       1560 kB
	 * Shared_Dirty:          0 kB
	 * Private_Clean:        36 kB
	 * Private_Dirty:        84 kB
	 * Referenced:         1680 kB
	 * Anonymous:            84 kB
	 * LazyFree:              0 kB
	 * AnonHugePages:         0 kB
	 * ShmemPmdMapped:        0 kB
	 * Shared_Hugetlb:        0 kB
	 * Private_Hugetlb:       0 kB
	 * Swap:                  0 kB
	 * SwapPss:               0 kB
	 * Locked:                0 kB
	 */
	private void collect(){
		try(var stream = Files.lines(SMAPS_ROLLUP)){
			stream.forEach(line -> {
				if(line.startsWith("Rss:")){
					RSS.set(parse(line));
				}
				else if(line.startsWith("Pss:")){
					PSS.set(parse(line));
				}
			});
		}
		catch(IOException e){
			RSS.set(-1);
			PSS.set(-1);
			log.error("Error reading smaps_rollup", e);
			task.cancel(false);
		}
	}

	private long parse(String line){
		var parts = SPLIT_PATTERN.split(line.strip());
		int multiplier;
		switch(parts[2]){
			case "B":
				multiplier = 1;
				break;
			case "kB":
				multiplier = 1024;
				break;
			case "mB":
				multiplier = 1024 * 1024;
				break;
			case "gB":
				multiplier = 1024 * 1024 * 1024;
				break;
			default:
				multiplier = -1;
		}
		return Long.parseLong(parts[1]) * multiplier;
	}

}