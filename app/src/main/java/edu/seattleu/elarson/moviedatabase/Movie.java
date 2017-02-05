// Kelly Corrigan
// SEGR 5910 - Lab 4
// 1/29/2017

package edu.seattleu.elarson.moviedatabase;

/**
 * Holds information about a movie
 */
class Movie {
    private String mTitle;
    private String mGenre;
    private String mUrl;
    private float mRating;
    private boolean mWatched;

    /**
     * Initialize a Movie
     */
    Movie(String title, String genre, String url) {
        mTitle = title;
        mGenre = genre;
        mUrl = url;
        mRating = 0.0f;
        mWatched = false;
    }

    /**
     * Getters for private variables
     */

    String getTitle() {
        return mTitle;
    }

    String getGenre() {
        return mGenre;
    }

    String getUrl() {
        return mUrl;
    }

    float getRating() {
        return mRating;
    }

    boolean getWatched() {
        return mWatched;
    }

    /**
     * Setters for the private variables
     */

    void setTitle(String title) {
        mTitle = title;
    }

    void setGenre(String genre) {
        mGenre = genre;
    }

    void setUrl(String url) {
        mUrl = url;
    }

    void setRating(float rating) {
        mRating = rating;
    }

    void setWatched(boolean watched) {
        mWatched = watched;
    }

}
