package org.abubakarSadiq.models;

public class OriginalAlbum {
    private String name;
    private Artist artist;

    public OriginalAlbum(String name, Artist artist) {
        this.name = name;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public Artist getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return name + " by " + artist.getName();
    }
}
