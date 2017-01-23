// Kelly Corrigan
// SEGR 5910 - Lab 3
// 1/23/2017

package edu.seattleu.elarson.moviedatabase;

import android.app.Fragment;

public class MovieWebActivity extends MovieSelectorActivity {

    @Override
    protected Fragment createFragment() {
        return MovieWebFragment.newInstance();
    }
}
