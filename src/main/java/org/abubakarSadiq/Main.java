package org.abubakarSadiq;

import org.abubakarSadiq.models.*;

import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        System.out.println("TESTING THE PROBLEM BASIC I SOLUTIONS");
        System.out.println("-------------------------------------");
        Artist artist1 = new Artist("Artist 1");
        Artist artist2 = new Artist("Artist 2");

        // Create a music track
        MusicTrack track1 = new MusicTrack("Track 1", artist1, LocalDate.of(2023, 10, 9), 4.5, 4, "location1", 10.0, null, 0);

        // Set and get attributes of the track
        track1.setGuestArtist(artist2);
        track1.setPlayCount(5);

        // Display track information
        System.out.println("Track Information:");
        System.out.println("Title: " + track1.getTitle());
        System.out.println("Artist: " + track1.getArtist().getName());
        System.out.println("Date: " + track1.getDate());
        System.out.println("Length: " + track1.getLength());
        System.out.println("Rating: " + track1.getRating());
        System.out.println("Location: " + track1.getLocation());
        System.out.println("Size: " + track1.getSize());
        System.out.println("Guest Artist: " + (track1.getGuestArtist() != null ? track1.getGuestArtist().getName() : "None"));
        System.out.println("Play Count: " + track1.getPlayCount());

        // Increment play count
        track1.incrementPlayCount();
        System.out.println("\nUpdated Play Count: " + track1.getPlayCount());

        // Display all individuals on the track
        List<Artist> allIndividualsOnTrack = MusicTrack.getAllIndividualsOnTrack(track1);
        System.out.println("\nIndividuals on the Track:");
        for (Artist individual : allIndividualsOnTrack) {
            System.out.println(individual.getName());
        }

        System.out.println("\nTESTING THE PROBLEM BASIC II SOLUTIONS");
        System.out.println("-----------------------------------------");
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
        System.out.println("\nAlbum Information:");
        System.out.println("Name: " + album.getName());
        System.out.println("Type: " + album.getType());
        System.out.println("Artist: " + album.getArtist().getName());

        // Get and display tracks in the album
        List<MusicTrack> albumTracks = album.getTracks();
        System.out.println("\nTracks in the Album:");
        for (MusicTrack track : albumTracks) {
            System.out.println(track);
        }

        // Get overall running time of the album
        double overallRunningTime = album.getOverallRunningTime();
        System.out.println("\nOverall Running Time: " + overallRunningTime + " minutes");

        // Get overall file size of the album
        double overallFileSize = album.getOverallFileSize();
        System.out.println("Overall File Size: " + overallFileSize + " MB");

        // Get average rating of tracks on the album
        double averageRating = album.getAverageRating();
        System.out.println("Average Rating of Tracks: " + averageRating);


        System.out.println("\nTESTING THE PROBLEM BASIC III SOLUTIONS");
        System.out.println("-----------------------------------------");
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
        System.out.println("Tracks in the Library:");
        for (MusicTrack track : library.getTracks()) {
            System.out.println(track);
        }
        System.out.println("\nAlbums in the Library:");
        for (Album retreivedAlbum : library.getAlbums()) {
            System.out.println(retreivedAlbum);
        }


        // Create a list of tracks with the lowest rating from the library
        List<MusicTrack> tracksWithLowestRating = library.getTracksWithLowestRating();

        // Display tracks with the lowest rating
        System.out.println("\nTracks with the Lowest Rating:");
        for (MusicTrack track : tracksWithLowestRating) {
            System.out.println(track);
        }

        System.out.println("\nTESTING THE PROBLEM EXTENSIONS I SOLUTIONS");
        System.out.println("--------------------------------------------");
        // Create artists
        Artist queen = new Artist("Queen");
        Artist variousArtists = new Artist("Various Artists");

        // Create original albums
        OriginalAlbum nightAtTheOpera = new OriginalAlbum("A Night at the Opera", queen);
        OriginalAlbum anotherAlbum = new OriginalAlbum("Another Album", queen);

        // Create a compilation album
        CompilationAlbum compilationAlbum = new CompilationAlbum("Greatest Hits Vol I", "Compilation", variousArtists);

        // Add original albums to the compilation album
        compilationAlbum.addOriginalAlbum(nightAtTheOpera);
        compilationAlbum.addOriginalAlbum(anotherAlbum);

        // Print information about the compilation album
        System.out.println(compilationAlbum.toString());

        // Get the original albums from the compilation album and print their information
        List<OriginalAlbum> originalAlbums = compilationAlbum.getOriginalAlbums();
        for (OriginalAlbum originalAlbum : originalAlbums) {
            System.out.println("Original Album: " + originalAlbum.toString());
        }


        System.out.println("\nTESTING THE PROBLEM EXTENSIONS II SOLUTIONS");
        System.out.println("--------------------------------------------");
        // Define the disc capacity
        double discCapacity = 15.0;

        // Backup the music tracks onto discs
        List<List<MusicTrack>> backupDiscs = library.backupMusicTracks(discCapacity);

        // Print the contents of each backup disc
        for (int i = 0; i < backupDiscs.size(); i++) {
            List<MusicTrack> backupDisc = backupDiscs.get(i);
            System.out.println("Backup Disc " + (i + 1) + ":");
            for (MusicTrack track : backupDisc) {
                System.out.println(track.toString());
            }
        }


    }

}