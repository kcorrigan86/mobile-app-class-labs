// Kelly Corrigan
// SEGR 5910 - Lab 3
// 1/23/2017

package edu.seattleu.elarson.moviedatabase;

/**
 * Holds a title, genre, and URL for a movie
 */
class Movie {
    private String mTitle;
    private String mGenre;
    private String mUrl;

    /**
     * Initialize title, genre, and url
     */
    Movie(String title, String genre, String url) {
        mTitle = title;
        mGenre = genre;
        mUrl = url;
    }

    String getTitle() {
        return mTitle;
    }

    String getGenre() {
        return mGenre;
    }

    String getUrl() {
        return mUrl;
    }
}
