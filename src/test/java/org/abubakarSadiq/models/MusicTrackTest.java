package org.abubakarSadiq.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


class MusicTrackTest {
    private MusicTrack track;
    private MusicTrack track2;
    private Artist artist;
    private Artist guestArtist;

    @BeforeEach
    void setUp() {
        artist = new Artist("Artist Name");
        guestArtist = new Artist("Guess Artist Name");

        // Create MusicTrack objects
        track = new MusicTrack("Track 1", artist, LocalDate.of(2023,10,9), 4.5, 4, "location1", 10.0, guestArtist, 5);
        track2 = new MusicTrack("Track 2", artist, LocalDate.of(2023,10,9), 3.5, 3, "location2", 8.0, guestArtist, 0);
    }

        @Test
    void testGetTitle() {
        String expected = "Track 1";
        assertEquals(expected, track.getTitle());
    }

    @Test
    void testSetTitle() {
        String expected = "New Track";
        track.setTitle("New Track");
        assertEquals(expected, track.getTitle());
    }

    @Test
    void testGetArtist() {
        assertEquals(artist, track.getArtist());
    }

    @Test
    void testSetArtist() {
        Artist artist2 = new Artist("Artist 2");
        track.setArtist(artist2);
        assertEquals(artist2, track.getArtist());
    }

    @Test
    void testGetDate() {
        LocalDate expected = LocalDate.of(2023,10,9);
        assertEquals(expected, track.getDate());
    }

    @Test
    void testSetDate() {
        LocalDate expected = LocalDate.of(2024,10,9);
        track.setDate(expected);
        assertEquals(expected, track.getDate());
    }

    @Test
    void testGetLength() {
        double expected = 4.5;
        assertEquals(expected, track.getLength(), 0.01);
    }

    @Test
    void testSetLength() {
        String expected = "Artist Name";
        track.setLength(5.0);
        assertEquals(5.0, track.getLength(), 0.01);
    }

    @Test
    void testGetRating() {
     int expected = 4;
     assertEquals(expected, track.getRating());
    }

    @Test
    void testSetRating() {
        int expected = 5;
        track.setRating(5);
        assertEquals(expected, track.getRating());
    }

    @Test
    void testGetLocation() {
         String expected = "location1";
         assertEquals(expected, track.getLocation());
    }

    @Test
    void testSetLocation() {
        String expected = "newLocation";
        track.setLocation(expected);
        assertEquals(expected, track.getLocation());
    }

    @Test
    void testGetSize() {
        double expected = 10.0;
        assertEquals(expected, track.getSize(), 0.01);
    }

    @Test
    void testSetSize() {
        double expected = 12.0;
        track.setSize(12.0);
        assertEquals(expected, track.getSize(), 0.01);
    }

    @Test
    void testGetGuestArtist() {
        assertEquals(guestArtist, track.getGuestArtist());
    }

    @Test
    void testSetGuestArtist() {

        Artist guestArtist = new Artist("Guest Artist");
        track.setGuestArtist(guestArtist);
        assertEquals(guestArtist, track.getGuestArtist());
    }

    @Test
    void testGetPlayCount() {
        int expected = 5;
        assertEquals(expected, track.getPlayCount());
    }

    @Test
    void testIncrementPlayCount() {
        int expected = 6;
        track.incrementPlayCount();
        assertEquals(expected, track.getPlayCount());
    }

    @Test
    void testSetPlayCount() {
        int expected = 10;
        track.setPlayCount(10);
        assertEquals(expected, track.getPlayCount());
    }

    @Test
    void testToString() {
        String expected = "Track 1 by Artist Name (2023-10-09) with Guess Artist Name";
         assertEquals(expected, track.toString());
    }

    @Test
    void testGetAllIndividualsOnTrack() {
        Artist mainArtist = new Artist("Main Artist");
        Artist guestArtist = new Artist("Guest Artist");
        mainArtist.addMember(new Artist("Band Member 1"));
        mainArtist.addMember(new Artist("Band Member 2"));

        MusicTrack trackWithGuest = new MusicTrack("Track with Guest", mainArtist, LocalDate.of(2023,10,9), 4.5, 4, "location1", 10.0, guestArtist, 0);
        MusicTrack trackWithoutGuest = new MusicTrack("Track without Guest", mainArtist, LocalDate.of(2023,10,9), 4.5, 4, "location1", 10.0, null, 0);

        // Verify the individuals on the track with and without a guest artist
        assertEquals(4, MusicTrack.getAllIndividualsOnTrack(trackWithGuest).size());
        assertEquals(3, MusicTrack.getAllIndividualsOnTrack(trackWithoutGuest).size());
    }

}
