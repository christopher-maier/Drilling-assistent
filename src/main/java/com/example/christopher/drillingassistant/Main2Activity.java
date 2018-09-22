package com.example.christopher.drillingassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        length = intent.getIntExtra(MainActivity.EXTRA_NUMBER0, 0);
        TextView text_length = (TextView) findViewById(R.id.text_length);
        text_length.setText("length of your board: " + (int)length);

        width = intent.getIntExtra(MainActivity.EXTRA_NUMBER1, 0);
        TextView text_width = (TextView) findViewById(R.id.text_width);
        text_width.setText("width of your board: " + (int)width);

        holes = intent.getIntExtra(MainActivity.EXTRA_NUMBER2, 0);
        TextView text_holes = (TextView) findViewById(R.id.text_holes);
        text_holes.setText("max number of holes: " + (int)holes);

        distance = intent.getIntExtra(MainActivity.EXTRA_NUMBER3, 0);
        TextView text_distance = (TextView) findViewById(R.id.text_distance);
        text_distance.setText("max distance between holes: " + (int)distance);

        diameter = intent.getIntExtra(MainActivity.EXTRA_NUMBER4, 0);
            TextView text_diameter = (TextView) findViewById(R.id.text_diameter);
            text_diameter.setText("max diameter: " + (int)diameter);

        double endresult_holes = maxHoles(length, width, distance, diameter);
        TextView result_holes = findViewById(R.id.result_holes);
        result_holes.setText("" + (int) endresult_holes);

        /*double endresult_distance = maxDistance(length,width,distance,holes);
        TextView result_distance = findViewById(R.id.result_distance);
        result_distance.setText("" + endresult_distance);

        double endresult_diameter = maxDiameter(length,width,distance, holes);
        TextView result_diameter = findViewById(R.id.result_diameter);
        result_diameter.setText("" + (int) endresult_diameter);*/
    }

    public double maxHoles(double length, double width, double distance, double diameter) {
        double i;
        if(length < diameter || width < diameter) {
            System.out.println("Invalid");
            i = 0;
        }else {
            i = ((length - (2 * distance))/ (diameter + distance));
        }
        /*double VK = (int) i;
        double NK = i - VK;
        if(NK != 0) {
            Toast.makeText(this, NK + "mm müssen gleichmäßig auf die Abstände verteilt werden!", Toast.LENGTH_SHORT).show();
        }*/
        return i;
    }

  /*  public double maxDistance(double length, double width, double diameter, double holes) {
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
    }*/
}
