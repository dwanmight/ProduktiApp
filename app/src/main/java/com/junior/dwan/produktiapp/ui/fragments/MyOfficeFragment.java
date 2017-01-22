package com.junior.dwan.produktiapp.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.junior.dwan.produktiapp.R;

/**
 * Created by Might on 19.10.2016.
 */

public class MyOfficeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_office, container, false);


        return view;
    }
}