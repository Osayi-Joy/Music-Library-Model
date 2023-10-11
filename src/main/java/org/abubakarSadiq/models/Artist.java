package org.abubakarSadiq.models;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    private String name;
    private List<Artist> members;

    public Artist(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addMember(Artist member) {
        members.add(member);
    }

    public List<Artist> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        return name;
    }

}

