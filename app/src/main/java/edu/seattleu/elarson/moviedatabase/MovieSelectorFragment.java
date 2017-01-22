package edu.seattleu.elarson.moviedatabase;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MovieSelectorFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MovieSelectorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovieSelectorFragment extends Fragment {

    // private OnFragmentInteractionListener mListener;
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
     *
     * @return A new instance of fragment MovieSelectorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MovieSelectorFragment newInstance() {
        return new MovieSelectorFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

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

        // Hook up the buttons for prev and next
        Button prevButton;
        Button nextButton;

        prevButton = (Button) v.findViewById(R.id.prevButton);
        nextButton = (Button) v.findViewById(R.id.nextButton);

        prevButton.setOnClickListener(prevButtonHandler);
        nextButton.setOnClickListener(nextButtonHandler);

        return v;
    }



    /**
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    */

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    /**
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
     */

    // Set the text of the movie title and genre in the view based on the passed-in index in the
    // movie array
    private void updateMovie(int currentIndex) {
        Movie movie = mMovies.get(currentIndex);

        mTextMovieTitle.setText(movie.getTitle());
        mTextMovieGenre.setText(movie.getGenre());
    }

    // If the prev button is clicked, set the text of the movie title and genre to the previous
    // movie in the array
    private View.OnClickListener prevButtonHandler = new View.OnClickListener() {
        public void onClick(View v) {
            mCurrentIndex = mCurrentIndex == 0 ? mMovies.size() - 1 : mCurrentIndex - 1;
            updateMovie(mCurrentIndex);
        }
    };

    // If the next button is clicked, set the text of the movie title and genre to the next movie
    // in the array
    private View.OnClickListener nextButtonHandler = new View.OnClickListener() {
        public void onClick(View v) {
            mCurrentIndex = mCurrentIndex == mMovies.size() - 1 ? 0 : mCurrentIndex + 1;
            updateMovie(mCurrentIndex);
        }
    };

}
