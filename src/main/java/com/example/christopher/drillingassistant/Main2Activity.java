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
import android.util.Log;
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

    DataObject dataObject = DataObject.getInstance();

    double length = dataObject.getLength();
    double width = dataObject.getWidth();
    double holes = dataObject.getHoles();
    double distance = dataObject.getDistance();
    double diameter = dataObject.getDiameter();
    double distanceToLength = dataObject.getDistanceToLength();
    double distanceToWidth = dataObject.getDistanceToWidth();
    int modeCase;

    TextView result_holes;
    TextView result_distance;
    TextView result_diameter;
    TextView saysRemaining;
    TextView remaining;

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
        text_length.setText("length of your board (edge: " + (int)distanceToLength + "): ");

        TextView user_length = (TextView) findViewById(R.id.user_length);
        user_length.setText("" + (int) length);

        width = intent.getIntExtra(MainActivity.EXTRA_NUMBER1, 0);
        TextView text_width = (TextView) findViewById(R.id.text_width);
        text_width.setText("width of your board (edge: "  + (int)distanceToWidth + "): ");

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

        saysRemaining = (TextView) findViewById(R.id.saysRemaining);
        remaining = (TextView) findViewById(R.id.remaining_text);

        userRestriction();
    }

    public void userRestriction(){
        if(modeCase == 1){
            result_holes.setText("" + (int) maxHoles(length, width, distance, diameter));

            result_distance.setText("" + (int) distance);

            result_diameter.setText("" + (int) diameter);

            dataObject.setModeCase(1);
        }

        if(modeCase == 2){
            result_holes.setText("" + (int) holes);

            result_distance.setText("" + (int) maxDistance(length, width, diameter, holes));

            result_diameter.setText("" + (int) diameter);

            dataObject.setModeCase(2);
        }

        if(modeCase == 3){
            result_holes.setText("" + (int) holes);

            result_distance.setText("" + (int) distance);

            result_diameter.setText("" + (int) maxDiameter(length, width, distance, holes));

            dataObject.setModeCase(3);
        }
    }

    public double maxHoles(double length, double width, double distance, double diameter) {
        double i;
        i = ((length - (2 * distanceToLength)) / (diameter + distance));

        double VK = (int) i;
        double NK = i - VK;
        double NK_rounded = Math.round(100.0 * NK) / 100.0;
       if(NK != 0){
           saysRemaining.setVisibility(View.VISIBLE);
           remaining.setText("" + NK_rounded);
           remaining.setVisibility(View.VISIBLE);
       }

        dataObject.setHoles(i);
        return i;
    }
    public double maxDistance(double length, double width, double diameter, double holes) {
        double j;

        j = (((length - (distanceToLength * 2)) - (holes * diameter))) / (holes - 1);
        dataObject.setDistance(j);
        Log.d("DRAW","calculated distance: "+dataObject.getDistance());
        return j;
    }
    public double maxDiameter(double length, double width, double distance, double holes) {
        double i;
        i = (((length - (2 * distanceToLength)) - ((holes - 1) * distance)) / holes);

        dataObject.setDiameter(i);
        return i;
    }

}
