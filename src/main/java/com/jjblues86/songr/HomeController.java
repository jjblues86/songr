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
public class HomeController {

    //Instance variable to hold repository
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/")
    public String getHome(){
        return "home";
    }


    @GetMapping("/hello")
    public String greeting(){
        return "hello";
    }

    @GetMapping("/capitalize/{words}")
    public String capitalizeWords(@PathVariable String words, Model m){
        System.out.println((words));
        m.addAttribute("Words", words);
        return "capitalize";
    }

    @GetMapping("/albums")
    public String getAlbums(Model m){
        List<Album> albums = albumRepository.findAll();
//        Album[] albums = new Album[] {new Album("Dreams and NightMares", "Meek Mill", 20, 240, "www.meekmill.com")};
//        Albums[] albumsTwo = new Albums[] {new Albums("I am the best", "Jabin Joof", 5, 100, "www.jabin.com")};
//        Albums[] albumsThree = new Albums[] {new Albums("Rescue", "Jay Ottom", 10, 440, "www.jay.com")};

        m.addAttribute("rapAlbums", albums);
        return "albums";
    }
    @PostMapping("/albums")
    public RedirectView postAllAlbums(String title, String artist, int songCount, int length, String imageUrl, Model j){
        Album newAlbum = new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(newAlbum);
//        return "albums";
        return new RedirectView("/albums");
    }
//    @PutMapping("/{albumsId}")
//    public  Album updateAlbums(@PathVariable String albumsId, String title, String artist, int songCount, int length, String imageUrl, Model u){
//        Album updateAlbum = new Album(title, artist, songCount, length, imageUrl);
//        albumRepository.getOne(updateAlbum.id);
//        return updateAlbum;
//    }

}
