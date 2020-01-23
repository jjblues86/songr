package com.jjblues86.songr;

import javax.persistence.*;
import java.util.List;

@Entity//this enables us to make a table
public class Album {


    public Long getId() {
        return id;
    }

    @Id//id makes it the primary key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY)//serial id
    Long id;

    @OneToMany(mappedBy = "album")
    public List<Song> songList;

    private String title;
    private String artist;
    private int songCount;
    private int length;
    private String imageUrl;

    public Album(String title, String artist, int songCount, int length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

    //add a default constructor
    public Album(){

    }

    public String toString(){
        return  this.title + " " + this.artist + " " + this.songCount + " " + this.length + " " + this.imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
