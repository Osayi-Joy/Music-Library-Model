package org.abubakarSadiq.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OriginalAlbumTest {

    @Test
    void testGetName() {
        Artist artist = new Artist("Artist Name");
        OriginalAlbum album = new OriginalAlbum("Album Name", artist);

        assertEquals("Album Name", album.getName());
    }

    @Test
    void testGetArtist() {
        Artist artist = new Artist("Artist Name");
        OriginalAlbum album = new OriginalAlbum("Album Name", artist);

        assertEquals(artist, album.getArtist());
    }

    @Test
    void testToString() {
        Artist artist = new Artist("Artist Name");
        OriginalAlbum album = new OriginalAlbum("Album Name", artist);

        assertEquals("Album Name by Artist Name", album.toString());
    }
}