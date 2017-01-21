// Kelly Corrigan
// SEGR 5910 - Lab 2
// 1/15/2017

package edu.seattleu.elarson.moviedatabase;

import java.util.ArrayList;

// Singleton class--only allows for one instance of itself to be created but permits global
// access using the get method
class MovieList {
    private static MovieList sMovieList = null;
    private ArrayList<Movie> mMovies;

    // Create an ArrayList of movies with title and genre
    // Constructor is private to prevent instantiation
    private MovieList() {
        mMovies = new ArrayList<>();
        mMovies.add(new Movie(
                "Frozen",
                "animated",
                "http://frozen.disney.com/"));
        mMovies.add(new Movie(
                "Star Wars",
                "sci-fi",
                "http://www.starwars.com/"));
        mMovies.add(new Movie(
                "The Sound of Music",
                "musical",
                "http://www.imdb.com/title/tt0059742/"));
        mMovies.add(new Movie(
                "Back to the Future",
                "comedy",
                "http://www.imdb.com/title/tt0088763/"));
        mMovies.add(new Movie(
                "The Shining",
                "horror",
                "http://www.imdb.com/title/tt0081505/"));
    }

    // Allow lazy instantiation of a MovieList - object is not created until get() is called
    static MovieList get(){
        if (sMovieList == null) {
            sMovieList = new MovieList();
        }
        return sMovieList;
    }

    // Retrieve the ArrayList of movies (access using MovieList.get().getMovies())
    ArrayList<Movie> getMovies() {
        return mMovies;
    } }