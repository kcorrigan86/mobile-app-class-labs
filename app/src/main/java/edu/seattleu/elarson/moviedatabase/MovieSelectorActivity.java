// Kelly Corrigan
// SEGR 5910 - Lab 2
// 1/15/2017

package edu.seattleu.elarson.moviedatabase;

import android.app.Fragment;

public class MovieSelectorActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return MovieSelectorFragment.newInstance();
    }
}
