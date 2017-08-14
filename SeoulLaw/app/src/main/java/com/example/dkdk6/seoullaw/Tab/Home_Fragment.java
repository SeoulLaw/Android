package com.example.dkdk6.seoullaw.Tab;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dkdk6.seoullaw.R;

/**
 * Created by dkdk6 on 2017-08-14.
 */

public class Home_Fragment extends Fragment {
    View view;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }
}
