// Kelly Corrigan
// SEGR 5910 - Lab 4
// 1/29/2017

package edu.seattleu.elarson.moviedatabase;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

public class MovieWebActivity extends MovieSelectorActivity {

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
        String url = intent.getStringExtra(MovieWebFragment.URL_KEY);
        return MovieWebFragment.newInstance(url);
    }
}
