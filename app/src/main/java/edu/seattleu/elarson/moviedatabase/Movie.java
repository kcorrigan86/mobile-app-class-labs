// Kelly Corrigan
// SEGR 5910 - Lab 2
// 1/15/2017

package edu.seattleu.elarson.moviedatabase;

// Holds a title and genre for a movie
class Movie {
    private String mTitle;
    private String mGenre;

    // Initialize title & genre
    Movie(String title, String genre) {
        mTitle = title;
        mGenre = genre;
    }

    String getTitle() {
        return mTitle;
    }

    String getGenre() {
        return mGenre;
    }
}
