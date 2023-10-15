package org.abubakarSadiq.models;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a special type of album known as a Compilation Album.
 * Compilation Albums may or may not have a single artist and can contain tracks from various original albums.
 * Each track on a Compilation Album stores the information about the original album it came from.
 *
 * @author Abubakar Sadiq
 * @version 1.0
 */
public class CompilationAlbum extends Album {
    private final List<OriginalAlbum> originalAlbums;
    private final List<MusicTrack> tracksWithOriginalAlbumInfo;  // New field to store tracks with original album information

    /**
     * Constructs a CompilationAlbum with the given name, type, and artist (if applicable).
     *
     * @param name   The name of the Compilation Album.
     * @param type   The type of the Compilation Album.
     * @param artist The primary artist or group associated with the Compilation Album.
     */
    public CompilationAlbum(String name, String type, Artist artist) {
        super(name, type, artist);
        this.originalAlbums = new ArrayList<>();
        this.tracksWithOriginalAlbumInfo = new ArrayList<>();
    }

    /**
     * Add an OriginalAlbum to the list of albums included in this Compilation Album.
     *
     * @param originalAlbum The OriginalAlbum to be added to this Compilation Album.
     */
    public void addOriginalAlbum(OriginalAlbum originalAlbum) {
        originalAlbums.add(originalAlbum);
    }

    /**
     * Get the list of OriginalAlbums included in this Compilation Album.
     *
     * @return The list of OriginalAlbums associated with this Compilation Album.
     */
    public List<OriginalAlbum> getOriginalAlbums() {
        return originalAlbums;
    }
    /**
     * Add a track to the Compilation Album with information about the original album.
     *
     * @param track          The track to be added to this Compilation Album.
     * @param originalAlbum  The original album information for the track.
     */
    public void addTrackWithOriginalAlbum(MusicTrack track, OriginalAlbum originalAlbum) {
        tracksWithOriginalAlbumInfo.add(track);  // Store tracks with original album information
        originalAlbums.add(originalAlbum);  // Store original albums
    }

    /**
     * Get the list of tracks that contain information about their original albums.
     *
     * @return The list of tracks with original album information.
     */
    public List<MusicTrack> getTracksWithOriginalAlbumInfo() {
        return tracksWithOriginalAlbumInfo;
    }

    /**
     * Get a string representation of the Compilation Album, including its name and type.
     *
     * @return A string representing the Compilation Album.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(" (Compilation)\n");

        for (int i = 0; i < tracksWithOriginalAlbumInfo.size(); i++) {
            sb.append("Track: ").append(tracksWithOriginalAlbumInfo.get(i).getTitle())
                    .append(" (Original Album: ").append(originalAlbums.get(i).getName())
                    .append(" by ").append(originalAlbums.get(i).getArtist().getName()).append(")\n");
        }

        return sb.toString();
    }
}
