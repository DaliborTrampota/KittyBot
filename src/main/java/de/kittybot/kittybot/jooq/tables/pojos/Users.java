/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.jooq.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long id;

    public Users(Users value) {
        this.id = value.id;
    }

    public Users(
        Long id
    ) {
        this.id = id;
    }

    /**
     * Getter for <code>public.users.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Users (");

        sb.append(id);

        sb.append(")");
        return sb.toString();
    }
}
