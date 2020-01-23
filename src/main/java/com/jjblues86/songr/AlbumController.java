package com.jjblues86.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String getAlbums(Model m){
        List<Album> albums = albumRepository.findAll();
        m.addAttribute("rapAlbums", albums);
        return "albums";
    }

//    @GetMapping("/album/{id}")
//    public String getAnAlbum(@PathVariable long id, Model b){
//        Album oneAlbum = albumRepository.findAllById(id).get();
//        b.addAttribute("album", oneAlbum);
////        List<Song> songs =
//    }



    @PostMapping("/albums")
    public RedirectView postAllAlbums(String title, String artist, int songCount, int length, String imageUrl, Model j){
        Album newAlbum = new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(newAlbum);
//        return "albums";
        return new RedirectView("/albums");
    }

    @PutMapping("/albums")
    public RedirectView postAllAlbums(Long id){
        Album newAlbum = albumRepository.getOne(id);
        newAlbum.setArtist("jjblues");
        albumRepository.save(newAlbum);
        System.out.println("albumRepository.save(newAlbum); = " + albumRepository.save(newAlbum));
//        return "albums";
        return new RedirectView("/albums");
    }

    @PostMapping("/albums/delete/{id}")
    public RedirectView deleteAlbum(@PathVariable Long id){
//        Album newAlbum = albumRepository.findById(id);
//        newAlbum.setArtist("jjblues");
        albumRepository.deleteById(id);
//        System.out.println("albumRepository.save(newAlbum); = " + albumRepository.save(newAlbum));
//        return "albums";
        return new RedirectView("/albums");
    }


}
