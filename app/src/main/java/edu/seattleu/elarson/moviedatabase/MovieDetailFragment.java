// Kelly Corrigan
// SEGR 5910 - Lab 4
// 1/29/2017

package edu.seattleu.elarson.moviedatabase;

import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RatingBar;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MovieDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovieDetailFragment extends Fragment {
    public static final String INDEX_KEY = "movieIndex";
    private int mMovieIndex;
    private Movie mMovie;

    public MovieDetailFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static MovieDetailFragment newInstance(int movieIndex) {
        MovieDetailFragment fragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putInt(INDEX_KEY, movieIndex);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMovieIndex = getArguments().getInt(INDEX_KEY);
        }
    }

    /**
     * Set up the view
     */
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        EditText mMovieTitleEditText;
        EditText mMovieGenreEditText;
        EditText mMovieUrlEditText;
        CheckBox mMovieWatchedCheckBox;
        RatingBar mMovieRatingBar;

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_movie_detail, container, false);

        // Get the current movie from the model
        ArrayList<Movie> movies = MovieList.get().getMovies();
        mMovie = movies.get(mMovieIndex);

        // Hook up the controls
        mMovieTitleEditText = (EditText) v.findViewById(R.id.movieTitleEditText);
        mMovieGenreEditText = (EditText) v.findViewById(R.id.movieGenreEditText);
        mMovieUrlEditText = (EditText) v.findViewById(R.id.movieUrlEditText);
        mMovieWatchedCheckBox = (CheckBox) v.findViewById(R.id.movieWatchedCheckBox);
        mMovieRatingBar = (RatingBar) v.findViewById(R.id.movieRatingBar);

        // Set the starting values for the controls
        mMovieTitleEditText.setText(mMovie.getTitle());
        mMovieGenreEditText.setText(mMovie.getGenre());
        mMovieUrlEditText.setText(mMovie.getUrl());
        mMovieWatchedCheckBox.setChecked(mMovie.getWatched());
        mMovieRatingBar.setRating(mMovie.getRating());

        // Listen for changes on the controls
        mMovieTitleEditText.addTextChangedListener(titleChangedHandler);
        mMovieGenreEditText.addTextChangedListener(genreChangedHandler);
        mMovieUrlEditText.addTextChangedListener(urlChangedHandler);
        mMovieWatchedCheckBox.setOnCheckedChangeListener(watchedChangedHandler);
        mMovieRatingBar.setOnRatingBarChangeListener(ratingChangedHandler);

        return v;
    }


    /**
     * Handle changes to the movie title
     */
    private final TextWatcher titleChangedHandler = new TextWatcher() {
        public void onTextChanged(CharSequence c, int start, int before, int count) {
            mMovie.setTitle(c.toString());
        }
        public void beforeTextChanged(CharSequence c, int start, int before, int after) {}
        public void afterTextChanged(Editable c) {}
    };


    /**
     * Handle changes to the movie genre
     */
    private final TextWatcher genreChangedHandler = new TextWatcher() {
        public void onTextChanged(CharSequence c, int start, int before, int count) {
            mMovie.setGenre(c.toString());
        }
        public void beforeTextChanged(CharSequence c, int start, int before, int after) {}
        public void afterTextChanged(Editable c) {}
    };


    /**
     * Handle changes to the movie URL
     */
    private final TextWatcher urlChangedHandler = new TextWatcher() {
        public void onTextChanged(CharSequence c, int start, int before, int count) {
            mMovie.setUrl(c.toString());
        }
        public void beforeTextChanged(CharSequence c, int start, int before, int after) {}
        public void afterTextChanged(Editable c) {}
    };


    /**
     * Handle changes to the movie watched checkbox
     */
    private final CompoundButton.OnCheckedChangeListener watchedChangedHandler =
            new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mMovie.setWatched(isChecked);
                }
            };

    /**
     * Handle changes to the movie rating bar
     */
    private final RatingBar.OnRatingBarChangeListener ratingChangedHandler =
            new RatingBar.OnRatingBarChangeListener() {
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    mMovie.setRating(rating);
                }
            };
}
