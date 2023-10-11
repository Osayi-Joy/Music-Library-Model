package org.abubakarSadiq.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AlbumTest {
    private Album album;
    private Artist artist;
    private String expectedTitle = "Album Title";
    private String expectedType = "Type";

    @BeforeEach
    void setUp() {
        artist = new Artist("Artist Name");
        album = new Album(expectedTitle, expectedType, artist);
    }

    @Test
    void testGetName() {
        assertEquals(expectedTitle, album.getName());
    }

    @Test
    void testSetName() {
        String expected = "New Album Title";
        album.setName(expected);
        assertEquals(expected, album.getName());
    }

    @Test
    void testGetType() {
        assertEquals(expectedType, album.getType());
    }

    @Test
    void testSetType() {
        String expected = "New Type";
        album.setType(expected);
        assertEquals(expected, album.getType());
    }

    @Test
    void testGetArtist() {
        assertEquals(artist, album.getArtist());
    }

    @Test
    void testSetArtist() {
        Artist newArtist = new Artist("New Artist Name");
        album.setArtist(newArtist);
        assertEquals(newArtist, album.getArtist());
    }

    @Test
    void testAddTrack() {
        MusicTrack track = new MusicTrack("Track 1", artist, LocalDate.of(2023, 10, 9), 4.5, 4, "location1", 10.0, null, 0);
        album.addTrack(track);
        assertEquals(1, album.getTracks().size());
    }

    @Test
    void testGetOverallRunningTime() {
        MusicTrack track1 = new MusicTrack("Track 1", artist, LocalDate.of(2023, 10, 9), 4.5, 4, "location1", 10.0, null, 0);
        MusicTrack track2 = new MusicTrack("Track 2", artist, LocalDate.of(2023, 10, 9), 3.5, 3, "location2", 8.0, null, 0);
        album.addTrack(track1);
        album.addTrack(track2);

        assertEquals(8.0, album.getOverallRunningTime(), 0.01);
    }

    @Test
    void testGetOverallFileSize() {
        MusicTrack track1 = new MusicTrack("Track 1", artist, LocalDate.of(2023, 10, 9), 4.5, 4, "location1", 10.0, null, 0);
        MusicTrack track2 = new MusicTrack("Track 2", artist, LocalDate.of(2023, 10, 9), 3.5, 3, "location2", 8.0, null, 0);
        album.addTrack(track1);
        album.addTrack(track2);

        assertEquals(18.0, album.getOverallFileSize(), 0.01);
    }

    @Test
    void testGetAverageRating() {
        MusicTrack track1 = new MusicTrack("Track 1", artist, LocalDate.of(2023, 10, 9), 4.5, 4, "location1", 10.0, null, 0);
        MusicTrack track2 = new MusicTrack("Track 2", artist, LocalDate.of(2023, 10, 9), 3.5, 3, "location2", 8.0, null, 0);
        album.addTrack(track1);
        album.addTrack(track2);

        assertEquals(3.5, album.getAverageRating(), 0.01);
    }

    @Test
    void testToString() {
        String expected = "Album Title by Artist Name";
        assertEquals(expected, album.toString());
    }

}