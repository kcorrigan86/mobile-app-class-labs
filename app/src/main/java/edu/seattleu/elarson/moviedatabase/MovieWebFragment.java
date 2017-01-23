package edu.seattleu.elarson.moviedatabase;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MovieWebFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovieWebFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_URL = "mUrl";

    // TODO: Rename and change types of parameters
    private String mUrl;


    public MovieWebFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mUrl URL parameter.
     * @return A new instance of fragment MovieWebFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MovieWebFragment newInstance(String mUrl) {
        MovieWebFragment fragment = new MovieWebFragment();
        Bundle args = new Bundle();
        args.putString(ARG_URL, mUrl);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUrl = getArguments().getString(ARG_URL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_movie_web, container,
                false);
        WebView webView = (WebView) v.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(mUrl);
        return v;
    }

}
