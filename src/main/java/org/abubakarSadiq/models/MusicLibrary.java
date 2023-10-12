package org.abubakarSadiq.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MusicLibrary {
    private final List<MusicTrack> tracks;
    private final List<Album> albums;


    public MusicLibrary() {
        this.tracks = new ArrayList<>();
        this.albums = new ArrayList<>();
    }

    public List<MusicTrack> getTracks() {
        return tracks;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void addTrack(MusicTrack track) {
        tracks.add(track);
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }


    public List<MusicTrack> getTracksWithLowestRating() {
        if (tracks.isEmpty()) {
            return new ArrayList<>();
        }

        int lowestRating = tracks.stream()
                .mapToInt(MusicTrack::getRating)
                .min()
                .orElse(0);

        return tracks.stream()
                .filter(track -> track.getRating() == lowestRating)
                .collect(Collectors.toList());
    }


    public List<List<MusicTrack>> backupMusicTracks(double discCapacity) {
        // Sort the tracks by size in decreasing order
        List<MusicTrack> sortedTracks = new ArrayList<>(tracks);
        Collections.sort(sortedTracks, (track1, track2) -> Double.compare(track2.getSize(), track1.getSize()));

        List<List<MusicTrack>> backupDiscs = new ArrayList<>();
        double currentDiscSpace = 0.0;
        int currentDiscIndex = 0;

        for (MusicTrack track : sortedTracks) {
            if (currentDiscSpace + track.getSize() <= discCapacity) {
                // Add the track to the current disc
                if (backupDiscs.size() <= currentDiscIndex) {
                    backupDiscs.add(new ArrayList<>());
                }
                backupDiscs.get(currentDiscIndex).add(track);
                currentDiscSpace += track.getSize();
            } else {
                // Create a new disc and add the track to it
                currentDiscIndex++;
                currentDiscSpace = track.getSize();
                backupDiscs.add(new ArrayList<>());
                backupDiscs.get(currentDiscIndex).add(track);
            }
        }

        return backupDiscs;
    }


    @Override
    public String toString() {
        return "Music Library";
    }
}

