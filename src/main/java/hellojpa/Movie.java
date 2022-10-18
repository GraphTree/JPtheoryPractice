package hellojpa;

import javax.persistence.Entity;
import javax.swing.*;

@Entity
public class Movie extends Item{
    private String director;
    private String artist;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
