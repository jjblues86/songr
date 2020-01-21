package com.jjblues86.songr;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

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
        Album[] albums = new Album[] {new Album("Dreams and NightMares", "Meek Mill", 20, 240, "www.meekmill.com")};
//        Albums[] albumsTwo = new Albums[] {new Albums("I am the best", "Jabin Joof", 5, 100, "www.jabin.com")};
//        Albums[] albumsThree = new Albums[] {new Albums("Rescue", "Jay Ottom", 10, 440, "www.jay.com")};

        m.addAttribute("rapAlbums", albums);
        return "albums";
    }
}
