package edu.seattleu.elarson.moviedatabase;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

public class MovieDetailActivity extends MovieSelectorActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createFragment();
    }

    /**
     * Extract the intent and pass the url into a new instance
     */
    @Override
    protected Fragment createFragment() {
        Intent intent = getIntent();
        int movieIndex = intent.getIntExtra(MovieDetailFragment.INDEX_KEY, 0);
        return MovieDetailFragment.newInstance(movieIndex);
    }
}
