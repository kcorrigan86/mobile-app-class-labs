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

    private ArrayList<Movie> movies;
    private int movieIndex = 0;
    private TextView movieTitle;
    private TextView movieGenre;
    private Button prevButton;
    private Button nextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movies = MovieList.get().getMovies();
        Movie movie = movies.get(movieIndex);

        movieTitle = (TextView) findViewById(R.id.textMovieTitle);
        movieTitle.setText(movie.getTitle());

        movieGenre = (TextView) findViewById(R.id.textMovieGenre);
        movieGenre.setText(movie.getGenre());

        prevButton = (Button) findViewById(R.id.prevButton);
        prevButton.setOnClickListener(prevButtonHandler);

        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(nextButtonHandler);
    }

    View.OnClickListener prevButtonHandler = new View.OnClickListener() {
        public void onClick(View v) {
            movieIndex = movieIndex == 0 ? movies.size() - 1 : movieIndex - 1;
            Movie movie = movies.get(movieIndex);
            movieTitle.setText(movie.getTitle());
            movieGenre.setText(movie.getGenre());
        }
    };

    View.OnClickListener nextButtonHandler = new View.OnClickListener() {
        public void onClick(View v) {
            movieIndex = movieIndex == movies.size() - 1 ? 0 : movieIndex + 1;
            Movie movie = movies.get(movieIndex);
            movieTitle.setText(movie.getTitle());
            movieGenre.setText(movie.getGenre());
        }
    };

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
