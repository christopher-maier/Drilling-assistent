package com.example.christopher.drillingassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        int length = intent.getIntExtra(MainActivity.EXTRA_NUMBER0, 0);
        TextView text_length = (TextView) findViewById(R.id.text_length);
        text_length.setText("length of your board: " + length);

        int width = intent.getIntExtra(MainActivity.EXTRA_NUMBER1, 0);
        TextView text_width = (TextView) findViewById(R.id.text_width);
        text_width.setText("width of your board: " + width);

        int holes = intent.getIntExtra(MainActivity.EXTRA_NUMBER2, 0);
        TextView text_holes = (TextView) findViewById(R.id.text_holes);
        text_holes.setText("max number of holes: " + holes);

        int distance = intent.getIntExtra(MainActivity.EXTRA_NUMBER3, 0);
        TextView text_distance = (TextView) findViewById(R.id.text_distance);
        text_distance.setText("max distance between holes: " + distance);

        int diameter = intent.getIntExtra(MainActivity.EXTRA_NUMBER4, 0);
            TextView text_diameter = (TextView) findViewById(R.id.text_diameter);
            text_diameter.setText("max diameter: " + diameter);
    }
}
