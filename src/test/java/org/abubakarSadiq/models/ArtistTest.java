package org.abubakarSadiq.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import java.util.List;


class ArtistTest {
    private Artist artist;

    @BeforeEach
    void setUp() {
        artist = new Artist("Artist Name");
    }

    @Test
    void testGetName() {
        String expected = "Artist Name";
        assertEquals(expected, artist.getName());
    }

    @Test
    void testAddMember() {
        Artist member1 = new Artist("Member 1");
        Artist member2 = new Artist("Member 2");

        artist.addMember(member1);
        artist.addMember(member2);

        List<Artist> members = artist.getMembers();
        assertEquals(2, members.size());
        assertTrue(members.contains(member1));
        assertTrue(members.contains(member2));
    }

    @Test
    void testGetMembers() {
        Artist member1 = new Artist("Member 1");
        Artist member2 = new Artist("Member 2");

        artist.addMember(member1);
        artist.addMember(member2);

        List<Artist> members = artist.getMembers();
        assertEquals(2, members.size());
        assertTrue(members.contains(member1));
        assertTrue(members.contains(member2));
    }

    @Test
    void testToString() {
        String expected = "Artist Name";
        assertEquals(expected, artist.toString());
    }
}
