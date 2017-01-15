package edu.seattleu.elarson.moviedatabase;

import java.util.ArrayList;

/**
 * Created by kellycorrigan on 1/15/17.
 */

public class MovieList {
    private static MovieList sMovieList = null;
    private ArrayList<Movie> mMovies;
    private MovieList() {
        mMovies = new ArrayList<Movie>();
        mMovies.add(new Movie("Frozen", "animated"));
        mMovies.add(new Movie("Star Wars", "sci-fi"));
        mMovies.add(new Movie("The Sound of Music", "musical"));
        mMovies.add(new Movie("Back to the Future", "comedy"));
        mMovies.add(new Movie("The Shining", "horror"));
    }
    public static MovieList get(){
        if (sMovieList == null) {
            sMovieList = new MovieList();
        }
        return sMovieList;
    }
    public ArrayList<Movie> getMovies() {
        return mMovies;
    } }