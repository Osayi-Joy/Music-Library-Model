package org.abubakarSadiq.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



class MusicLibraryTest {
    private MusicLibrary musicLibrary;
    private MusicTrack track1;
    private MusicTrack track2;
    private MusicTrack track3;
    private Artist artist;
    private Artist guestArtist;
    private Album album1;
    private Album album2;

    @BeforeEach
    void setUp() {
        artist = new Artist("Artist Name");
        guestArtist = new Artist("Guess Artist Name");
        musicLibrary = new MusicLibrary();

        // Create MusicTrack objects
        track1 = new MusicTrack("Track 1", artist, LocalDate.of(2023,10,9), 4.5, 4, "location1", 10.0, guestArtist, 0);
        track2 = new MusicTrack("Track 2", artist, LocalDate.of(2023,10,9), 3.5, 3, "location2", 8.0, guestArtist, 0);
        track3 = new MusicTrack("Track 3", artist, LocalDate.of(2023,10,9), 2.0, 2, "location3", 7.0, guestArtist, 0);

        // Add MusicTrack objects to the MusicLibrary
        musicLibrary.addTrack(track1);
        musicLibrary.addTrack(track2);
        musicLibrary.addTrack(track3);

        //create albums objects and add them to the music library
        album1 = new Album("Album Name 1", "Test Type", artist);
        album2 = new Album("Album Name 1", "Test Type", artist);

        musicLibrary.addAlbum(album1);
        musicLibrary.addAlbum(album2);
    }

    @Test
    void testGetTracks() {
        List<MusicTrack> tracks = musicLibrary.getTracks();
        assertEquals(3, tracks.size());
        assertTrue(tracks.contains(track1));
        assertTrue(tracks.contains(track2));
        assertTrue(tracks.contains(track3));
    }
    @Test
    void testAddTracks() {
        MusicTrack newTrack = new MusicTrack("New Track", artist, LocalDate.of(2023,10,9), 3.5, 3, "location2", 8.0, guestArtist, 0);
        musicLibrary.addTrack(newTrack);
        List<MusicTrack> tracks = musicLibrary.getTracks();
        assertEquals(4, tracks.size());
        assertTrue(tracks.contains(newTrack));
    }

    @Test
    void testGetAlbums() {
        List<Album> albums = musicLibrary.getAlbums();
        assertEquals(2, albums.size());
        assertTrue(albums.contains(album1));
        assertTrue(albums.contains(album2));
    }

    @Test
    void testAddAlbums() {
        Album newAlbum = new Album("New Album Name", "Test Type", artist);
        musicLibrary.addAlbum(newAlbum);
        List<Album> albums = musicLibrary.getAlbums();
        assertEquals(3, albums.size());
        assertTrue(albums.contains(newAlbum));
    }

    @Test
    void testGetTracksWithLowestRating() {
        List<MusicTrack> tracksWithLowestRating = musicLibrary.getTracksWithLowestRating();
        assertEquals(1, tracksWithLowestRating.size());
        assertTrue(tracksWithLowestRating.contains(track3));
    }

    @Test
    void testBackupMusicTracks() {
        double discCapacity = 15.0;
        List<List<MusicTrack>> backupDiscs = musicLibrary.backupMusicTracks(discCapacity);

        assertEquals(2, backupDiscs.size()); //Two discs were created based on the disc capacity and the sizes of the tracks
        assertEquals(1, backupDiscs.get(0).size()); //First disc contains only one track
        assertEquals(2, backupDiscs.get(1).size()); //Second disc contains two tracks
        assertTrue(backupDiscs.get(0).contains(track1)); //the size of track 1 i 10.0 so the first disc and we are left with on 5mb free space
        assertTrue(backupDiscs.get(1).contains(track2)); //track2 is 8mb it was stored in the second disc since the first disc has only 5mb left
        assertTrue(backupDiscs.get(1).contains(track3)); //track3 is 7mb it was stored in the second disc as well
    }

    @Test
    void testToString() {
        String expected = "Music Library";
        assertEquals(expected, musicLibrary.toString());
    }

}