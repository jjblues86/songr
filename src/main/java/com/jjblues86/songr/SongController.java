package com.jjblues86.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {

    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/songs")
    public String getSongs(Model m){
        List<Song> songs = songRepository.findAll();
        m.addAttribute("songs", songs);
        return "songs";
    }

    @PostMapping("/albums/{id}/songs")
    public RedirectView addSong(@PathVariable Long id, String title, int length, int trackNumber){
        Album myAlbum = albumRepository.getOne(id);
        Song song = new Song(title,length, trackNumber);
        song.album = myAlbum;
        songRepository.save(song);
//        ManySongs newSongs = new ManySongs(title, artist, );
//        myAlbum
        return new RedirectView("/albums");
    }
}
