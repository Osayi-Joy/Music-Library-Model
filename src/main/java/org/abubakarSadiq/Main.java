package org.abubakarSadiq;

import org.abubakarSadiq.models.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("music_library_file.txt"));


            writer.write("TESTING THE PROBLEM BASIC I SOLUTIONS");
            writer.newLine();
            writer.write("--------------------------------------");
            writer.newLine();

            Artist artist1 = new Artist("Artist 1");
            Artist artist2 = new Artist("Artist 2");

            // Create a music track
            MusicTrack track1 = new MusicTrack("Track 1", artist1, LocalDate.of(2023, 10, 9), 4.5, 4, "location1", 10.0, null, 0);

            // Set and get attributes of the track
            track1.setGuestArtist(artist2);
            track1.setPlayCount(5);

            // Display track information
            String[] lines = {
                    "Track Information:",
                    "Title: " + track1.getTitle(),
                    "Artist: " + track1.getArtist().getName(),
                    "Date: " + track1.getDate(),
                    "Length: " + track1.getLength(),
                    "Rating: " + track1.getRating(),
                    "Location: " + track1.getLocation(),
                    "Size: " + track1.getSize(),
                    "Guest Artist: " + (track1.getGuestArtist() != null ? track1.getGuestArtist().getName() : "None"),
                    "Play Count: " + track1.getPlayCount()
            };

            for (String line : lines) {
                writer.write(line);
                writer.newLine(); // Add a new line after each string
            }



            // Increment play count
            track1.incrementPlayCount();
            writer.newLine();
            writer.write("Updated Play Count: " + track1.getPlayCount());
            writer.newLine();
            // Display all individuals on the track
            List<Artist> allIndividualsOnTrack = MusicTrack.getAllIndividualsOnTrack(track1);
            writer.newLine();
            writer.write("Individuals on the Track:");
            writer.newLine();
            for (Artist individual : allIndividualsOnTrack) {
                writer.write(individual.getName());
                writer.newLine();
            }
            writer.newLine();
            writer.write("TESTING THE PROBLEM BASIC II SOLUTIONS");
            writer.newLine();
            writer.write("-----------------------------------------");
            // Create an artist for the album
            Artist artist = new Artist("Artist Name");
            Artist guestArtist = new Artist("Guest Artist Name");

            // Create an album
            Album album = new Album("Album Title", "Type", artist);

            // Create some music tracks
            MusicTrack track2 = new MusicTrack("Track 1", artist, LocalDate.of(2023, 10, 9), 4.5, 4, "location1", 10.0, null, 0); // No guest artist
            MusicTrack track3 = new MusicTrack("Track 2", artist, LocalDate.of(2023, 10, 9), 3.5, 3, "location2", 8.0, guestArtist, 5); // With a guest artist and initial play count

            // Add tracks to the album
            album.addTrack(track2);
            album.addTrack(track3);

            // Get album information
            writer.newLine();
            writer.write("Album Information:");
            writer.newLine();
            writer.write("Name: " + album.getName());
            writer.newLine();
            writer.write("Type: " + album.getType());
            writer.newLine();
            writer.write("Artist: " + album.getArtist().getName());

            // Get and display tracks in the album
            List<MusicTrack> albumTracks = album.getTracks();
            writer.newLine();
            writer.write("Tracks in the Album:");
            for (MusicTrack track : albumTracks) {
                writer.newLine();
                writer.write(track.toString());
            }

            // Get overall running time of the album
            double overallRunningTime = album.getOverallRunningTime();
            writer.newLine();
            writer.write("Overall Running Time: " + overallRunningTime + " minutes");
            writer.newLine();
            // Get overall file size of the album
            double overallFileSize = album.getOverallFileSize();
            writer.write("Overall File Size: " + overallFileSize + " MB");
            writer.newLine();
            // Get average rating of tracks on the album
            double averageRating = album.getAverageRating();
            writer.write("Average Rating of Tracks: " + averageRating);
            writer.newLine();

            writer.write("\nTESTING THE PROBLEM BASIC III SOLUTIONS");
            writer.newLine();
            writer.write("-----------------------------------------");
            writer.newLine();
            // Create a music library
            MusicLibrary library = new MusicLibrary();

            // Create some artists for tracks and albums
            Artist newArtist = new Artist("Artist 1");
            Artist oldArtist = new Artist("Artist 2");

            // Create some tracks
            MusicTrack musicTrack = new MusicTrack("Track 1", newArtist, LocalDate.of(2023, 10, 9), 4.5, 4, "location1", 10.0, guestArtist, 7);
            MusicTrack musicTrack1 = new MusicTrack("Track 2", newArtist, LocalDate.of(2023, 10, 9), 3.5, 3, "location2", 8.0, guestArtist, 6);
            MusicTrack musicTrack2 = new MusicTrack("Track 3", oldArtist, LocalDate.of(2023, 10, 9), 3.0, 2, "location3", 7.0, guestArtist, 4);

            // Add tracks to the library
            library.addTrack(musicTrack);
            library.addTrack(musicTrack1);
            library.addTrack(musicTrack2);

            // Create an album
            Album album1 = new Album("Album 1", "Type", newArtist);

            // Add tracks to the album
            album1.addTrack(musicTrack);
            album1.addTrack(musicTrack1);

            // Add the album to the library
            library.addAlbum(album1);

            //Get tracks and albums in the music library
            writer.newLine();
            writer.write("Tracks in the Library:");writer.newLine();
            for (MusicTrack track : library.getTracks()) {
                writer.write(track.toString());writer.newLine();
            }
            writer.newLine();
            writer.write("Albums in the Library:");
            writer.newLine();
            for (Album retreivedAlbum : library.getAlbums()) {
                writer.write(retreivedAlbum.toString());
                writer.newLine();
            }


            // Create a list of tracks with the lowest rating from the library
            List<MusicTrack> tracksWithLowestRating = library.getTracksWithLowestRating();

            // Display tracks with the lowest rating
            writer.newLine();
            writer.write("Tracks with the Lowest Rating:");
            writer.newLine();
            for (MusicTrack track : tracksWithLowestRating) {
                writer.write(track.toString());
                writer.newLine();
            }

            writer.newLine();
            writer.write("TESTING THE PROBLEM EXTENSIONS I SOLUTIONS");
            writer.newLine();
            writer.write("--------------------------------------------");


            // Create an artist for the original album
            Artist queen = new Artist("Queen");
            Artist variousArtists = new Artist("Various Artists");

            // Create original albums
            OriginalAlbum nightAtTheOpera = new OriginalAlbum("A Night at the Opera", queen);
            OriginalAlbum anotherAlbum = new OriginalAlbum("Another Album", queen);

            // Create a compilation album with the artist (if applicable)
            CompilationAlbum compilationAlbum = new CompilationAlbum("Greatest Hits Vol I", "Compilation", variousArtists);

            // Add original albums to the compilation album
            compilationAlbum.addOriginalAlbum(nightAtTheOpera);
            compilationAlbum.addOriginalAlbum(anotherAlbum);

            // Create music tracks with information about the original album
            MusicTrack track8 = new MusicTrack("Bohemian Rhapsody", queen, LocalDate.now(), 5.0, 5, "location1", 20.0, null, 0);
            MusicTrack track9 = new MusicTrack("Fall", queen, LocalDate.now(), 4.0, 4, "location2", 15.0, null, 0);

            // Add tracks to the compilation album with original album information
            compilationAlbum.addTrackWithOriginalAlbum(track8, nightAtTheOpera);
            compilationAlbum.addTrackWithOriginalAlbum(track9, anotherAlbum);

            // Print information about the compilation album
            writer.newLine();
            writer.write(compilationAlbum.toString());
            System.out.println(compilationAlbum.toString());


            writer.newLine();
            writer.write("TESTING THE PROBLEM EXTENSIONS II SOLUTIONS");
            writer.newLine();
            writer.write("--------------------------------------------");
            writer.newLine();
            // Define the disc capacity
            double discCapacity = 15.0;

            // Backup the music tracks onto discs
            List<List<MusicTrack>> backupDiscs = library.backupMusicTracks(discCapacity);

            // Print the contents of each backup disc
            for (int i = 0; i < backupDiscs.size(); i++) {
                List<MusicTrack> backupDisc = backupDiscs.get(i);
                writer.write("Backup Disc " + (i + 1) + ":");
                writer.newLine();
                for (MusicTrack track : backupDisc) {
                    writer.write(track.toString());
                    writer.newLine();
                }
            }



            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}