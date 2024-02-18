/*
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.song;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import com.example.song.SongService;
import com.example.song.Song;

@RestController
public class SongController {
    SongService songservice = new SongService();

    @GetMapping("/songs/{songId}")
    public Song getbyId(@PathVariable("songId") int songId) {
        return songservice.getbyId(songId);
    }

    @GetMapping("/songs")
    ArrayList<Song> getsongs() {
        return songservice.getsongs();
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song) {
        return songservice.addSong(song);
    }

    @PutMapping("/songs/{songId}")
    public Song updatesong(@PathVariable("songId") int songId, @RequestBody Song song) {

        return songservice.updatesong(songId, song);

    }

    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable("songId") int songId) {
        songservice.deleteSong(songId);

    }

}
