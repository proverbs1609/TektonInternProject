package com.app.hamang.tektonproject.EmotionActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.hamang.tektonproject.R;

/**
 * Created by k on 2018-01-18.
 */

public class EmotionBark extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emotion_bark, container, false);
        return view;
    }
}
