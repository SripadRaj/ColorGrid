package com.opteamix.colorgrid;

import android.app.AlertDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> colors;
    GridView g;
//    Spinner spinner;
//    Button b;
//    private CardView cardView;
//    private ImageView heart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        g = (GridView) findViewById(R.id.colorGrid);


        colors = new ArrayList<>();

        colors.add("#3F51B5");
        colors.add("#03A9F4");
        colors.add("#009688");
        colors.add("#4CAF50");
        colors.add("#8BC34A");
        colors.add("#CDDC39");
        colors.add("#FFEB3B");
        colors.add("#FFC107");
        colors.add("#FF9800");
        colors.add("#FF5722");
        colors.add("#795548");
        colors.add("#9E9E9E");
        colors.add("#607D8B");
        colors.add("#9C27B0");
        colors.add("#E91E63");
        colors.add("#f44336");

        final ColorAdapter colorAdapter = new ColorAdapter(MainActivity.this,colors);
        g.setAdapter(colorAdapter);
        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                colorAdapter.mSelectedPosition = position;
                colorAdapter.notifyDataSetChanged();

                for(int i = 0; i < colors.size(); i++) {
                    ViewGroup gridChild = (ViewGroup) g.getChildAt(position);
                    gridChild.setBackgroundColor(Color.parseColor("#000000"));
                }
            }
        });

        /*final HintAdapter hintAdapter = new HintAdapter(getApplicationContext(),colors,android.R.layout.simple_spinner_item);
        hintAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(hintAdapter);
        spinner.setSelection(hintAdapter.getCount());
        spinner.setTag(R.id.pos,hintAdapter.getCount());

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if((int)spinner.getTag(R.id.pos)!=position){
                    Log.e("Item selected","called");
                }else{
                    Log.e("Item selected","called 2");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog("THIS IS TEST","TEST").show();
                *//*if(spinner.getSelectedItemPosition() == hintAdapter.getCount()){
                    Toast.makeText(MainActivity.this, "Select a color", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, ""+spinner.getSelectedItem(), Toast.LENGTH_SHORT).show();
                }*//*
            }
        });*/
    }


    private AlertDialog createDialog(String title, String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //AlertDialog dialog = builder.create();
        builder.setMessage("THIS IS TEST MESSAGE");
        final AlertDialog dialog = builder.create();
        return dialog;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
