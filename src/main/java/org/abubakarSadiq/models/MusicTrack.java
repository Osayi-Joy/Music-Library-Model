package org.abubakarSadiq.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a music track in a music library.
 *
 * @author Abubakar Sadiq
 */
public class MusicTrack {
    private String title;
    private Artist artist;
    private LocalDate date;
    private double length;
    private int rating;
    private String location;
    private double size;
    private Artist guestArtist;
    private int playCount;

    /**
     * Constructs a new music track with the specified details.
     *
     * @param title       The title of the music track.
     * @param artist      The main artist of the track.
     * @param date        The date the track was released.
     * @param length      The length of the track in minutes.
     * @param rating      The rating of the track.
     * @param location    The file location of the track.
     * @param size        The file size of the track in MB.
     * @param guestArtist An optional guest artist on the track.
     * @param playCount   The number of times the track has been played.
     */
    public MusicTrack(String title, Artist artist, LocalDate date,
                      double length, int rating, String location,
                      double size, Artist guestArtist, int playCount) {
        this.title = title;
        this.artist = artist;
        this.date = date;
        this.length = length;
        this.rating = rating;
        this.location = location;
        this.size = size;
        this.guestArtist = guestArtist;
        this.playCount = playCount;
    }

    /**
     * Get the title of the music track.
     *
     * @return The title of the track.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the music track.
     *
     * @param title The new title of the track.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the main artist of the music track.
     *
     * @return The main artist of the track.
     */
    public Artist getArtist() {
        return artist;
    }

    /**
     * Set the main artist of the music track.
     *
     * @param artist The new main artist of the track.
     */
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    /**
     * Get the release date of the music track.
     *
     * @return The release date of the track.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Set the release date of the music track.
     *
     * @param date The new release date of the track.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Get the length of the music track.
     *
     * @return The length of the track in minutes.
     */
    public double getLength() {
        return length;
    }

    /**
     * Set the length of the music track.
     *
     * @param length The new length of the track in minutes.
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Get the rating of the music track.
     *
     * @return The rating of the track.
     */
    public int getRating() {
        return rating;
    }

    /**
     * Set the rating of the music track.
     *
     * @param rating The new rating of the track.
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Get the file location of the music track.
     *
     * @return The file location of the track.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Set the file location of the music track.
     *
     * @param location The new file location of the track.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Get the file size of the music track.
     *
     * @return The file size of the track in MB.
     */
    public double getSize() {
        return size;
    }

    /**
     * Set the file size of the music track.
     *
     * @param size The new file size of the track in MB.
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * Get the guest artist on the music track.
     *
     * @return The guest artist on the track, or null if there is no guest artist.
     */
    public Artist getGuestArtist() {
        return guestArtist;
    }

    /**
     * Set the guest artist on the music track.
     *
     * @param guestArtist The new guest artist on the track, or null if there is no guest artist.
     */
    public void setGuestArtist(Artist guestArtist) {
        this.guestArtist = guestArtist;
    }

    /**
     * Get the number of times the music track has been played.
     *
     * @return The play count of the track.
     */
    public int getPlayCount() {
        return playCount;
    }

    /**
     * Set the play count of the music track.
     *
     * @param playCount The new play count of the track.
     */
    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    /**
     * Increment the play count of the music track by one.
     */
    public void incrementPlayCount() {
        playCount++;
    }

    /**
     * Get a list of all individuals involved in the music track.
     *
     * @param track The music track.
     * @return A list of all individuals, including the main artist, guest artist (if any), and band members (if any).
     */
    public static List<Artist> getAllIndividualsOnTrack(MusicTrack track) {
        List<Artist> individuals = new ArrayList<>();

        // Add the main artist
        individuals.add(track.getArtist());

        // Add guest artist (if any)
        if (track.getGuestArtist() != null) {
            individuals.add(track.getGuestArtist());
        }

        // Add band members (if any)
        List<Artist> bandMembers = track.getArtist().getMembers();
        individuals.addAll(bandMembers);

        return individuals;
    }

    /**
     * Get a string representation of the music track.
     *
     * @return A string representing the music track, including title, main artist, date, and guest artist (if any).
     */
    @Override
    public String toString() {
        String trackInfo = title + " by " + artist.getName() + " (" + date + ")";
        if (guestArtist != null) {
            trackInfo += " with " + guestArtist.getName();
        }
        return trackInfo;
    }
}
