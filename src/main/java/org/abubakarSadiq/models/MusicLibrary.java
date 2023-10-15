package org.abubakarSadiq.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a music library that stores music tracks and albums.
 *
 * @author Abubakar Sadiq
 * @version 1.0
 */
public class MusicLibrary {
    private final List<MusicTrack> tracks;
    private final List<Album> albums;

    /**
     * Constructs a new MusicLibrary with empty lists for tracks and albums.
     */
    public MusicLibrary() {
        this.tracks = new ArrayList<>();
        this.albums = new ArrayList<>();
    }

    /**
     * Get the list of music tracks in the library.
     *
     * @return The list of music tracks.
     */
    public List<MusicTrack> getTracks() {
        return tracks;
    }

    /**
     * Get the list of albums in the library.
     *
     * @return The list of albums.
     */
    public List<Album> getAlbums() {
        return albums;
    }

    /**
     * Add a music track to the library.
     *
     * @param track The music track to be added.
     */
    public void addTrack(MusicTrack track) {
        tracks.add(track);
    }

    /**
     * Add an album to the library.
     *
     * @param album The album to be added.
     */
    public void addAlbum(Album album) {
        albums.add(album);
    }

    /**
     * Get a list of music tracks with the lowest rating in the library.
     *
     * @return A list of music tracks with the lowest rating.
     */
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

    /**
     * Backup music tracks to discs based on disc capacity.
     *
     * @param discCapacity The maximum capacity of a disc in terms of file size.
     * @return A list of discs where each disc is a list of music tracks.
     */
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

    /**
     * Get a string representation of the music library.
     *
     * @return A string representing the music library.
     */
    @Override
    public String toString() {
        return "Music Library";
    }
}

