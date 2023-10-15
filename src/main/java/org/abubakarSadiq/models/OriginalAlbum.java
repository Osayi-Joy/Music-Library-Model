package org.abubakarSadiq.models;

/**
 * Represents an original album in a music library.
 *
 * @author Abubakar Sadiq
 */
public class OriginalAlbum {
    private final String name;
    private final Artist artist;

    /**
     * Constructs a new original album with the specified details.
     *
     * @param name   The name of the original album.
     * @param artist The artist associated with the original album.
     */
    public OriginalAlbum(String name, Artist artist) {
        this.name = name;
        this.artist = artist;
    }

    /**
     * Get the name of the original album.
     *
     * @return The name of the original album.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the artist associated with the original album.
     *
     * @return The artist associated with the original album.
     */
    public Artist getArtist() {
        return artist;
    }

    /**
     * Get a string representation of the original album.
     *
     * @return A string representing the original album, including its name and the name of the associated artist.
     */
    @Override
    public String toString() {
        return name + " by " + artist.getName();
    }
}

