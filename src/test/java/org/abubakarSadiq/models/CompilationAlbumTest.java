package org.abubakarSadiq.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

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
    void testToString() {
        String expected = "Compilation Album: Compilation Album by Artist Name";
        assertEquals(expected, compilationAlbum.toString());
    }
}
