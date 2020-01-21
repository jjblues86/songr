package com.jjblues86.songr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlbumTest {

   Album album;

   @Test public void testConstructor(){
       album = new Album("Beautiful Soul", "Kay", 150, 10, "www.kayjay.com");
       assertEquals(false, album.getArtist().isEmpty());
   }
   @Test public void testConstructorArtist(){
       Album album = new Album("Beautiful Soul", "Kay", 150, 10, "www.kayjay.com");
       assertEquals(  "Beautiful Soul", album.getTitle());

   }
   @Test public void testContructorGetSongCount(){
       album = new Album("Beautiful Soul", "Kay", 150, 10, "www.kayjay.com");
       assertEquals(150, album.getSongCount());
   }
   @Test public void testContructorGetSongLength(){
       Album album = new Album("Beautiful Soul", "Kay", 150, 10, "www.kayjay.com");
       assertEquals(10, album.getLength());
   }
    @Test public void testContructorGetImageUrl(){
        Album album = new Album("Beautiful Soul", "Kay", 150, 10, "www.kayjay.com");
        assertEquals("www.kayjay.com", album.getImageUrl());
    }
    @Test public void testContructorGetArtist(){
        Album album = new Album("Beautiful Soul", "Kay", 150, 10, "www.kayjay.com");
        assertEquals("Kay", album.getArtist());
    }
}