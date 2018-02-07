package com.app.hamang.tektonproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import static android.provider.Settings.Global.getString;

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
        //SharedPreferences shardPref =  getSharedPreferences("dogInfo", Context.MODE_PRIVATE);

        //SharedPreferences.Editor  editor = shardPref.edit() ;
        final int pos = position ;
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.dog_list_layout_row, null);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        ImageView textView1 = (ImageView) v.findViewById(R.id.imageView3);
        TextView textView2 = (TextView) v.findViewById(R.id.textGender) ;
        textView.setText(animalList.get(position).getAnimalName());
        textView1.setImageResource(animalList.get(position).getAnimalImage());
        textView2.setText(animalList.get(position).getAnimalGender());
        //editor.putString("dogName", textView.getText().toString()) ;
        //editor.putString("dogGender", textView2.getText().toString()) ;
        //editor.putInt("dogImage", textView1.geti);
        return v;
    }


}