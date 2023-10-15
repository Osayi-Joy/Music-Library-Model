package org.abubakarSadiq.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.List;


class CompilationAlbumTest {
    private CompilationAlbum compilationAlbum;

    @BeforeEach
    void setUp() {
        Artist artist = new Artist("Artist Name");
        compilationAlbum = new CompilationAlbum("Compilation Album", "Type", artist);
    }

    @Test
    void testAddOriginalAlbum() {
        OriginalAlbum originalAlbum1 = new OriginalAlbum("Original Album 1",  new Artist("Artist 1"));
        OriginalAlbum originalAlbum2 = new OriginalAlbum("Original Album 2",  new Artist("Artist 2"));

        compilationAlbum.addOriginalAlbum(originalAlbum1);
        compilationAlbum.addOriginalAlbum(originalAlbum2);

        List<OriginalAlbum> originalAlbums = compilationAlbum.getOriginalAlbums();
        assertEquals(2, originalAlbums.size());
        assertTrue(originalAlbums.contains(originalAlbum1));
        assertTrue(originalAlbums.contains(originalAlbum2));
    }

    @Test
    void testGetOriginalAlbums() {
        OriginalAlbum originalAlbum1 = new OriginalAlbum("Original Album 1", new Artist("Artist 1"));
        OriginalAlbum originalAlbum2 = new OriginalAlbum("Original Album 2",  new Artist("Artist 2"));

        compilationAlbum.addOriginalAlbum(originalAlbum1);
        compilationAlbum.addOriginalAlbum(originalAlbum2);

        List<OriginalAlbum> originalAlbums = compilationAlbum.getOriginalAlbums();
        assertEquals(2, originalAlbums.size());
        assertTrue(originalAlbums.contains(originalAlbum1));
        assertTrue(originalAlbums.contains(originalAlbum2));
    }

    @Test
    void testAddTrackWithOriginalAlbum() {
        OriginalAlbum originalAlbum1 = new OriginalAlbum("Original Album 1", new Artist("Artist 1"));
        OriginalAlbum originalAlbum2 = new OriginalAlbum("Original Album 2", new Artist("Artist 2"));
        MusicTrack track1 = new MusicTrack("Track 1", new Artist("Artist 1"), LocalDate.now(), 4.5, 4, "location1", 10.0, null, 0);
        MusicTrack track2 = new MusicTrack("Track 2", new Artist("Artist 2"), LocalDate.now(), 3.5, 3, "location2", 8.0, null, 5);

        compilationAlbum.addTrackWithOriginalAlbum(track1, originalAlbum1);
        compilationAlbum.addTrackWithOriginalAlbum(track2, originalAlbum2);

        List<MusicTrack> tracksWithOriginalAlbumInfo = compilationAlbum.getTracksWithOriginalAlbumInfo();
        assertEquals(2, tracksWithOriginalAlbumInfo.size());
        assertTrue(tracksWithOriginalAlbumInfo.contains(track1));
        assertTrue(tracksWithOriginalAlbumInfo.contains(track2));
    }

    @Test
    void testGetTracksWithOriginalAlbumInfo() {
        OriginalAlbum originalAlbum1 = new OriginalAlbum("Original Album 1", new Artist("Artist 1"));
        OriginalAlbum originalAlbum2 = new OriginalAlbum("Original Album 2", new Artist("Artist 2"));
        MusicTrack track1 = new MusicTrack("Track 1", new Artist("Artist 1"), LocalDate.now(), 4.5, 4, "location1", 10.0, null, 0);
        MusicTrack track2 = new MusicTrack("Track 2", new Artist("Artist 2"), LocalDate.now(), 3.5, 3, "location2", 8.0, null, 5);

        compilationAlbum.addTrackWithOriginalAlbum(track1, originalAlbum1);
        compilationAlbum.addTrackWithOriginalAlbum(track2, originalAlbum2);

        List<MusicTrack> tracksWithOriginalAlbumInfo = compilationAlbum.getTracksWithOriginalAlbumInfo();
        assertEquals(2, tracksWithOriginalAlbumInfo.size());
        assertTrue(tracksWithOriginalAlbumInfo.contains(track1));
        assertTrue(tracksWithOriginalAlbumInfo.contains(track2));
    }


    @Test
    void testToString() {
        OriginalAlbum originalAlbum1 = new OriginalAlbum("Original Album 1", new Artist("Artist 1"));
        OriginalAlbum originalAlbum2 = new OriginalAlbum("Original Album 2", new Artist("Artist 2"));
        MusicTrack track1 = new MusicTrack("Track 1", new Artist("Artist 1"), LocalDate.now(), 4.5, 4, "location1", 10.0, null, 0);
        MusicTrack track2 = new MusicTrack("Track 2", new Artist("Artist 2"), LocalDate.now(), 3.5, 3, "location2", 8.0, null, 5);

        compilationAlbum.addTrackWithOriginalAlbum(track1, originalAlbum1);
        compilationAlbum.addTrackWithOriginalAlbum(track2, originalAlbum2);

        String expected = compilationAlbum.getName() + " by " + compilationAlbum.getArtist().getName() + " (Compilation)\n" +
                "Track: Track 1 (Original Album: Original Album 1 by Artist 1)\n" +
                "Track: Track 2 (Original Album: Original Album 2 by Artist 2)\n";

        assertEquals(expected, compilationAlbum.toString());
    }
}
