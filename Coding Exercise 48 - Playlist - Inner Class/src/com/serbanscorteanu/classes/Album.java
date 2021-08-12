package com.serbanscorteanu.classes;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	private String name;
	private String artist;
	private SongList songs;
//	private ArrayList<Song> songs;

	public Album(String name, String artist) {
		this.name = name;
		this.artist = artist;
		songs = new SongList();
		// SongList.songs = new ArrayList<>();
	}

	public boolean addSong(String title, double duration) {
		// return true if added successfully
//		if (songs.findSong(title) != null) {
//			System.out.println("Error - Song already in playlist");
//			return false;
//		}
//		Song song = new Song(title, duration);
//		songs.songs.add(song);
//		return true;
		
		return this.songs.add(new Song(title, duration));
	}

//	private Song findSong(String title) {
//		// return song if found else null
//		for (Song song : songs.songs) {
//			if (song.getTitle().equals(title)) {
//				return song;
//			}
//		}
//		return null;
//	}

	public boolean addToPlayList(int trackNo, LinkedList<Song> playlist) {
		// return true if it exists and successfully added else false
		// add the specific song from the album to this playlist
//		if (!this.songs.songs.isEmpty()) {
//			if (trackNo > 0 && trackNo <= songs.songs.size()) {
//				Song song = songs.songs.get(trackNo - 1);
//				playlist.add(song);
//				return true;
//			}
//		}
//		return false;
		
		Song checkedSong = this.songs.findSong(trackNo);
		if (checkedSong != null) {
			playlist.add(checkedSong);
			return true;
		} 
		return false;
	}

	public boolean addToPlayList(String title, LinkedList<Song> playlist) {
		// return true if it exists and successfully added using the title else false
//		if (!this.songs.songs.isEmpty()) {
//			Song song = songs.findSong(title);
//			if (song != null) {
//				playlist.add(song);
//				return true;
//			}
//		}
//		return false;
		
		Song checkedSong = this.songs.findSong(title);
		if (checkedSong != null) {
			playlist.add(checkedSong);
			return true;
		}
		return false;
	}

	// inner class variant
	public static class SongList {
		private ArrayList<Song> songs;

		private SongList() {
			this.songs = new ArrayList<>();
		}

		private boolean add(Song song) {
			// false if already in list
			// true if not and success
//			Song retrievedSong = findSong(song.getTitle());
//			if (retrievedSong != null) {	
			if (songs.contains(song)) {
				System.out.println("Song already in list");
				return false;
			}
			//songs.add(retrievedSong);
			songs.add(song);
			return true;
		}

		private Song findSong(String title) {
			// if found retrieve Song else null
			for (Song song : songs) {
				if (song.getTitle().equals(title)) {
					return song;
				}
			}
			return null;
		}

		private Song findSong(int trackNo) {
			// if found retrieve Song else null
			if (trackNo > 0 && trackNo <= songs.size()) {
				return songs.get(trackNo - 1);
			}
			return null;
		}
	}
}
