// LinkedList Example for Playlist
// Manage songs in a playlist using LinkedList and show add/remove operations.


import java.util.LinkedList;

public class PlaylistLinkedList {
    public static void main(String[] args) {
        LinkedList<String> playlist = new LinkedList<>();

        playlist.add("Song A");
        playlist.add("Song B");
        playlist.add("Song C");
        System.out.println("Playlist: " + playlist);

        playlist.remove("Song B");
        System.out.println("After removing Song B: " + playlist);
    }
}

