package edu.seattleu.elarson.moviedatabase;

/**
 * Created by kellycorrigan on 1/14/17.
 */

public class Movie {
    private String mTitle;
    private String mGenre;

    // Initialize title & genre
    public Movie(String title, String genre) {
        mTitle = title;
        mGenre = genre;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getGenre() {
        return mGenre;
    }
}
