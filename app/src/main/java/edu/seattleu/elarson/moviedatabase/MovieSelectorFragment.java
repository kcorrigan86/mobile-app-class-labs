// Kelly Corrigan
// SEGR 5910 - Lab 3
// 1/23/2017

package edu.seattleu.elarson.moviedatabase;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnMovieViewListener} interface
 * to handle interaction events.
 * Use the {@link MovieSelectorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovieSelectorFragment extends Fragment {

    private OnMovieViewListener mListener;
    private ArrayList<Movie> mMovies;
    private int mCurrentIndex = 0;
    private TextView mTextMovieTitle;
    private TextView mTextMovieGenre;


    public MovieSelectorFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static MovieSelectorFragment newInstance() {
        return new MovieSelectorFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }


    /**
     * Set everything up when the homescreen view is created
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_movie_selector, container, false);

        // Get the list of movies from the model
        mMovies = MovieList.get().getMovies();

        // Hook up the TextViews for the movie title and genre
        mTextMovieTitle = (TextView) v.findViewById(R.id.textMovieTitle);
        mTextMovieGenre = (TextView) v.findViewById(R.id.textMovieGenre);

        // Set the text of the movie title and genre in the view
        updateMovie(mCurrentIndex);

        // Hook up the buttons for prev, next, and view
        Button prevButton;
        Button nextButton;
        Button viewButton;

        prevButton = (Button) v.findViewById(R.id.prevButton);
        nextButton = (Button) v.findViewById(R.id.nextButton);
        viewButton = (Button) v.findViewById(R.id.viewButton);

        prevButton.setOnClickListener(prevButtonHandler);
        nextButton.setOnClickListener(nextButtonHandler);
        viewButton.setOnClickListener(viewButtonHandler);

        return v;
    }


    /**
     * Inflate the menu
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }


    /**
     * Process menu action choices
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_edit:
                return true;
            case R.id.menu_item_web:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMovieViewListener) {
            mListener = (OnMovieViewListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnMovieViewListener");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnMovieViewListener {
        void onMovieView(String url);
    }


    // Set the text of the movie title and genre in the view based on the passed-in index in the
    // movie array
    private void updateMovie(int currentIndex) {
        Movie movie = mMovies.get(currentIndex);

        mTextMovieTitle.setText(movie.getTitle());
        mTextMovieGenre.setText(movie.getGenre());
    }


    /**
     * If the prev button is clicked, set the text of the movie title and genre to the previous
     * movie in the array
     */
    private View.OnClickListener prevButtonHandler = new View.OnClickListener() {
        public void onClick(View v) {
            mCurrentIndex = mCurrentIndex == 0 ? mMovies.size() - 1 : mCurrentIndex - 1;
            updateMovie(mCurrentIndex);
        }
    };


    /**
     * If the next button is clicked, set the text of the movie title and genre to the next movie
     * in the array
     */
    private View.OnClickListener nextButtonHandler = new View.OnClickListener() {
        public void onClick(View v) {
            mCurrentIndex = mCurrentIndex == mMovies.size() - 1 ? 0 : mCurrentIndex + 1;
            updateMovie(mCurrentIndex);
        }
    };


    /**
     * If the view button is clicked, get the movie's url, and open it in the web browser
     */
    private View.OnClickListener viewButtonHandler = new View.OnClickListener() {
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onMovieView(mMovies.get(mCurrentIndex).getUrl()); }
        }
    };

}
