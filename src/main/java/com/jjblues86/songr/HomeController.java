package com.jjblues86.songr;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class HomeController {

    //Instance variable to hold repository
    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;

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

//    @GetMapping("/albumUpdate")
//    public  String updateAlbums(Model u){
////        Album updateAlbum = new Album(title, artist, songCount, length, imageUrl);
//         Album a = albumRepository.getOne((long) 1);
//        System.out.println(" = " + a);
////        return updateAlbum;
//        return "working";
//    }

}
