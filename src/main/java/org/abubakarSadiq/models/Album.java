package org.abubakarSadiq.models;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private String type;
    private Artist artist;
    private List<MusicTrack> tracks;

    public Album(String name, String type, Artist artist) {
        this.name = name;
        this.type = type;
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void addTrack(MusicTrack track) {
        tracks.add(track);
    }

    public List<MusicTrack> getTracks() {
        return tracks;
    }

    public double getOverallRunningTime() {
        double totalTime = 0.0;
        for (MusicTrack track : tracks) {
            totalTime += track.getLength();
        }
        return totalTime;
    }

    public double getOverallFileSize() {
        double totalSize = 0.0;
        for (MusicTrack track : tracks) {
            totalSize += track.getSize();
        }
        return totalSize;
    }

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

    @Override
    public String toString() {
        return name + " by " + artist.getName();
    }
}

