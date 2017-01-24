// Kelly Corrigan
// SEGR 5910 - Lab 2
// 1/15/2017

package edu.seattleu.elarson.moviedatabase;

import android.app.Fragment;
import android.content.Intent;

public class MovieSelectorActivity extends SingleFragmentActivity
    implements MovieSelectorFragment.OnMovieViewListener {

    @Override
    protected Fragment createFragment() {
        return MovieSelectorFragment.newInstance();
    }

    @Override
    public void onMovieView(String url) {
        Intent intent = new Intent();
        intent.setClass(this, MovieWebActivity.class);
        intent.putExtra("Bob", url);
        startActivity(intent);
    }
}
