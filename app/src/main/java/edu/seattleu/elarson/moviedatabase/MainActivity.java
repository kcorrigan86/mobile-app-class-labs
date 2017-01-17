// Kelly Corrigan
// SEGR 5910 - Lab 2
// 1/15/2017

package edu.seattleu.elarson.moviedatabase;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    private static final String INDEX_KEY = "index";
    private ArrayList<Movie> movies;
    private int movieIndex = 0;
    private TextView movieTitle;
    private TextView movieGenre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrieve the movieIndex from the instance state so that if the screen is rotated,
        // the displayed movie doesn't change
        if (savedInstanceState != null) {
            movieIndex = savedInstanceState.getInt(INDEX_KEY);
        }

        // Get the list of movies from the model
        movies = MovieList.get().getMovies();

        // Hook up the TextViews for the movie title and genre
        movieTitle = (TextView) findViewById(R.id.textMovieTitle);
        movieGenre = (TextView) findViewById(R.id.textMovieGenre);

        // Set the text of the movie title and genre in the view
        setMovieText(movieIndex);

        // Hook up the buttons for prev and next
        Button prevButton;
        Button nextButton;

        prevButton = (Button) findViewById(R.id.prevButton);
        nextButton = (Button) findViewById(R.id.nextButton);

        prevButton.setOnClickListener(prevButtonHandler);
        nextButton.setOnClickListener(nextButtonHandler);
    }

    // If the prev button is clicked, set the text of the movie title and genre to the previous
    // movie in the array
    View.OnClickListener prevButtonHandler = new View.OnClickListener() {
        public void onClick(View v) {
            movieIndex = movieIndex == 0 ? movies.size() - 1 : movieIndex - 1;
            setMovieText(movieIndex);
        }
    };

    // If the next button is clicked, set the text of the movie title and genre to the next movie
    // in the array
    View.OnClickListener nextButtonHandler = new View.OnClickListener() {
        public void onClick(View v) {
            movieIndex = movieIndex == movies.size() - 1 ? 0 : movieIndex + 1;
            setMovieText(movieIndex);
        }
    };

    // Set the text of the movie title and genre in the view based on the passed-in index in the
    // movie array
    private void setMovieText(int movieIndex) {
        Movie movie = movies.get(movieIndex);

        movieTitle.setText(movie.getTitle());
        movieGenre.setText(movie.getGenre());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(INDEX_KEY, movieIndex);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
