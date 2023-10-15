package org.abubakarSadiq.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an Album that contains a collection of music tracks.
 * An Album is characterized by its name, type, associated artist, and a list of tracks.
 *
 * @author Abubakar Sadiq
 * @version 1.0
 */
public class Album {
    private String name;
    private String type;
    private Artist artist;
    private final List<MusicTrack> tracks;

    /**
     * Constructs an Album with the specified name, type, and artist.
     *
     * @param name   The name of the album.
     * @param type   The type or genre of the album.
     * @param artist The primary artist or band associated with the album.
     */
    public Album(String name, String type, Artist artist) {
        this.name = name;
        this.type = type;
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    /**
     * Get the name of the album.
     *
     * @return The name of the album.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the album.
     *
     * @param name The name to set for the album.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the type or genre of the album.
     *
     * @return The type or genre of the album.
     */
    public String getType() {
        return type;
    }

    /**
     * Set the type or genre of the album.
     *
     * @param type The type or genre to set for the album.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the primary artist or band associated with the album.
     *
     * @return The primary artist or band of the album.
     */
    public Artist getArtist() {
        return artist;
    }

    /**
     * Set the primary artist or band associated with the album.
     *
     * @param artist The primary artist to set for the album.
     */
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    /**
     * Add a music track to the album's collection of tracks.
     *
     * @param track The music track to add.
     */
    public void addTrack(MusicTrack track) {
        tracks.add(track);
    }

    /**
     * Get the list of music tracks in the album.
     *
     * @return The list of music tracks in the album.
     */
    public List<MusicTrack> getTracks() {
        return tracks;
    }

    /**
     * Get the overall running time of the album.
     *
     * @return The total running time of all tracks in the album.
     */
    public double getOverallRunningTime() {
        double totalTime = 0.0;
        for (MusicTrack track : tracks) {
            totalTime += track.getLength();
        }
        return totalTime;
    }

    /**
     * Get the overall file size of the album.
     *
     * @return The total file size of all tracks in the album.
     */
    public double getOverallFileSize() {
        double totalSize = 0.0;
        for (MusicTrack track : tracks) {
            totalSize += track.getSize();
        }
        return totalSize;
    }

    /**
     * Get the average rating of all tracks on the album.
     *
     * @return The average rating of all tracks on the album.
     */
    public double getAverageRating() {
        if (tracks.isEmpty()) {
            return 0.0;
        }

        int totalRating = 0;
        for (MusicTrack track : tracks) {
            totalRating += track.getRating();
        }

        return (double) totalRating / tracks.size();
    }

    /**
     * Get a string representation of the album.
     *
     * @return A string representing the album's name and associated artist.
     */
    @Override
    public String toString() {
        return name + " by " + artist.getName();
    }
}
