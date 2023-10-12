package org.abubakarSadiq.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Artist getGuestArtist() {
        return guestArtist;
    }

    public void setGuestArtist(Artist guestArtist) {
        this.guestArtist = guestArtist;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public void incrementPlayCount() {
        playCount++;
    }

    @Override
    public String toString() {
        String trackInfo = title + " by " + artist.getName() + " (" + date + ")";
        if (guestArtist != null) {
            trackInfo += " with " + guestArtist.getName();
        }
        return trackInfo;
    }
}
