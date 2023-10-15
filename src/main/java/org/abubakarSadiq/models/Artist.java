package org.abubakarSadiq.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an Artist or a musical group, which may consist of multiple members.
 * An Artist is characterized by their name and can have a list of associated members.
 *
 * @author Abubakar Sadiq
 * @version 1.0
 */
public class Artist {
    private final String name;
    private final List<Artist> members;

    /**
     * Constructs an Artist with the specified name.
     *
     * @param name The name of the artist or musical group.
     */
    public Artist(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    /**
     * Get the name of the artist.
     *
     * @return The name of the artist.
     */
    public String getName() {
        return name;
    }

    /**
     * Add a member to the list of associated members of the artist.
     *
     * @param member The artist to add as a member.
     */
    public void addMember(Artist member) {
        members.add(member);
    }

    /**
     * Get the list of associated members of the artist.
     *
     * @return The list of members associated with the artist.
     */
    public List<Artist> getMembers() {
        return members;
    }

    /**
     * Get a string representation of the artist's name.
     *
     * @return A string representing the name of the artist or group.
     */
    @Override
    public String toString() {
        return name;
    }
}


