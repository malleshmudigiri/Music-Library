/*

 * You can use the following import statements
  
 * import org.springframework.http.HttpStatus;
 * import org.springframework.web.server.ResponseStatusException;

 */

package com.example.song;

import java.util.*;

import com.example.song.Song;
import com.example.song.SongRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

// Don't modify the below code
public class SongService implements SongRepository {
    private static HashMap<Integer, Song> playlist = new HashMap<>();
    int uniqueId = 6;

    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

    // Don't modify the above code

    // Write your code here
    @Override
    public ArrayList<Song> getsongs() {
        Collection<Song> list = playlist.values();
        ArrayList<Song> songs = new ArrayList<>(list);
        return songs;

    }

    @Override
    public Song addSong(Song song) {
        song.setsongId(uniqueId);
        playlist.put(uniqueId, song);
        uniqueId += 1;
        return song;

    }

    @Override
    public Song getbyId(int songId) {
        Song song1 = playlist.get(songId);
        if (song1 == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return song1;
    }

    @Override
    public Song updatesong(int songId, Song song) {
        Song song2 = playlist.get(songId);
        if (song2 == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (song.getsongName() != null) {
            song2.setsongName(song.getsongName());

        }
        if (song.getlyricist() != null) {
            song2.setlyricist(song.getlyricist());
        }
        if (song.getsinger() != null) {
            song2.setsinger(song.getsinger());
        }
        if (song.getmusicDirector() != null) {
            song2.setmusicDirector(song.getmusicDirector());
        }
        return song2;

    }

    @Override
    public void deleteSong(int songId) {
        Song song3 = playlist.get(songId);
        if (song3 == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            playlist.remove(songId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}