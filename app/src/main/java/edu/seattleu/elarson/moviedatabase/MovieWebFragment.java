// Kelly Corrigan
// SEGR 5910 - Lab 4
// 1/29/2017

package edu.seattleu.elarson.moviedatabase;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MovieWebFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovieWebFragment extends Fragment {
    public static final String URL_KEY = "urlKey";
    private String mUrl;


    public MovieWebFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static MovieWebFragment newInstance(String url) {
        MovieWebFragment fragment = new MovieWebFragment();
        Bundle args = new Bundle();
        args.putString(URL_KEY, url);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUrl = getArguments().getString(URL_KEY);
        }
    }


    /**
     * Set up the view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_movie_web, container, false);
        WebView webView = (WebView) v.findViewById(R.id.webView);

        // Avoid having the back button take the user to a blank page from certain URLs
        webView.setWebViewClient(new WebViewClient());

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(mUrl);
        return v;
    }

}
