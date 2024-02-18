// Write your code here
package com.example.song;

import java.util.*;

public interface SongRepository {
    ArrayList<Song> getsongs();

    Song addSong(Song song);

    Song getbyId(int songId);

    Song updatesong(int songId, Song song);

    void deleteSong(int songId);

}