package com.example.christopher.drillingassistant;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    double length;
    double width;
    double holes;
    double distance;
    double diameter;
    int modeCase;

    TextView result_holes;
    TextView result_distance;
    TextView result_diameter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        length = intent.getIntExtra(MainActivity.EXTRA_NUMBER0, 0);
        TextView text_length = (TextView) findViewById(R.id.text_length);
        text_length.setText("length of your board: ");

        TextView user_length = (TextView) findViewById(R.id.user_length);
        user_length.setText("" + (int) length);

        width = intent.getIntExtra(MainActivity.EXTRA_NUMBER1, 0);
        TextView text_width = (TextView) findViewById(R.id.text_width);
        text_width.setText("width of your board: ");

        TextView user_width = (TextView) findViewById(R.id.user_width);
        user_width.setText("" + (int) width);

        holes = intent.getIntExtra(MainActivity.EXTRA_NUMBER2, 0);
        TextView text_holes = (TextView) findViewById(R.id.text_holes);
        text_holes.setText("number of holes: ");

        distance = intent.getIntExtra(MainActivity.EXTRA_NUMBER3, 0);
        TextView text_distance = (TextView) findViewById(R.id.text_distance);
        text_distance.setText("distance between holes: ");

        diameter = intent.getIntExtra(MainActivity.EXTRA_NUMBER4, 0);
        TextView text_diameter = (TextView) findViewById(R.id.text_diameter);
        text_diameter.setText("diameter of holes: ");

        result_holes = (TextView) findViewById(R.id.result_holes);
        result_distance = (TextView) findViewById(R.id.result_distance);
        result_diameter = (TextView) findViewById(R.id.result_diameter);

        modeCase = intent.getIntExtra(MainActivity.EXTRA_NUMBER5, 0);

        userRestriction();
    }

    public void userRestriction(){
        if(modeCase == 1){
            result_holes.setText("" + (int) maxHoles(length, width, distance, diameter));

            result_distance.setText("" + (int) distance);

            result_diameter.setText("" + (int) diameter);
        }

        if(modeCase == 2){
            result_holes.setText("" + (int) holes);

            result_distance.setText("" + (int) maxDistance(length, width, diameter, holes));

            result_diameter.setText("" + (int) diameter);
        }

        if(modeCase == 3){
            result_holes.setText("" + (int) holes);

            result_distance.setText("" + (int) distance);

            result_diameter.setText("" + (int) maxDiameter(length, width, distance, holes));
        }
    }

    public double maxHoles(double length, double width, double distance, double diameter) {
        double i;
        if(length < diameter || width < diameter) {
            System.out.println("Invalid");
            i = 0;
        }else {
            i = ((length - (2 * distance))/ (diameter + distance));
        }
        double VK = (int) i;
        double NK = i - VK;
        if(NK != 0) {
            Toast.makeText(this, NK + "mm müssen gleichmäßig auf die Abstände verteilt werden!", Toast.LENGTH_SHORT).show();
        }
        return i;
    }
    public double maxDistance(double length, double width, double diameter, double holes) {
        double j;
        if(length < (holes * diameter) || width < diameter) {
            System.out.println("Invalid");
            j = 0;
        }else {
            j = ((length - (holes * diameter)) / (holes +2));
        }
        return j;
    }
    public double maxDiameter(double length, double width, double distance, double holes) {
        double i;
        if(length < distance || width < distance) {
            System.out.println("Invalid");
            i = 0;
        }else {
            i = ((distance * (holes + 2) - length)/ (-holes));
        }
        return i;
    }

}
