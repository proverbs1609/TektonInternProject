package com.app.hamang.tektonproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JKPC on 2018-02-06.
 */

public class DogListAdapter extends ArrayAdapter<DogItem> {
    ArrayList<DogItem> animalList = new ArrayList<>();

    public DogListAdapter(Context context, int textViewResourceId, ArrayList<DogItem> objects) {
        super(context, textViewResourceId, objects);
        animalList = objects;
    }
    @Override
    public int getCount() {
        return super.getCount();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position ;
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.dog_list_layout_row, null);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        ImageView textView1 = (ImageView) v.findViewById(R.id.imageView3);
        textView.setText(animalList.get(position).getAnimalName());
        textView1.setImageResource(animalList.get(position).getAnimalImage());
        return v;
    }
}