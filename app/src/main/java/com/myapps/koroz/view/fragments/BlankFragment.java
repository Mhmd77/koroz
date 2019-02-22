package com.myapps.koroz.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class BlankFragment extends Fragment {
    public static BlankFragment newInstance() {
        
        Bundle args = new Bundle();
        
        BlankFragment fragment = new BlankFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
