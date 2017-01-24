// Kelly Corrigan
// SEGR 5910 - Lab 3
// 1/23/2017

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
    @Override
    protected Fragment createFragment() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("Bob");
        return MovieWebFragment.newInstance(url);
    }
}
