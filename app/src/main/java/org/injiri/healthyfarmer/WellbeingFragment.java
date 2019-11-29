package org.injiri.healthyfarmer;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class WellbeingFragment extends Fragment {


    private View currentView;

    public WellbeingFragment() {
        // Required empty public constructor
    }

    public WellbeingFragment(View view) {

        this.currentView = view;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return this.currentView;
    }


}
