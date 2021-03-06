// Kelly Corrigan
// SEGR 5910 - Lab 4
// 1/29/2017

package edu.seattleu.elarson.moviedatabase;

import android.app.Fragment;
import android.content.Intent;

public class MovieSelectorActivity extends SingleFragmentActivity
    implements MovieSelectorFragment.OnMovieViewListener {

    @Override
    protected Fragment createFragment() {
        return MovieSelectorFragment.newInstance();
    }

    /**
     * Start MovieWebActivity using an Intent, passing the url as an
     * Intent extra.
     */
    @Override
    public void onMovieView(String url) {
        Intent intent = new Intent();

        intent.setClass(this, MovieWebActivity.class);
        intent.putExtra(MovieWebFragment.URL_KEY, url);
        startActivity(intent);
    }

    /**
     * Start MovieDetailActivity using an Intent, passing the movie index
     * as an Intent extra.
     */
    @Override
    public void onMovieEdit(int movieIndex) {
        Intent intent = new Intent();

        intent.setClass(this, MovieDetailActivity.class);
        intent.putExtra(MovieDetailFragment.INDEX_KEY, movieIndex);
        startActivity(intent);
    }
}
