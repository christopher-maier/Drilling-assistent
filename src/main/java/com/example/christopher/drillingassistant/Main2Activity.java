package com.example.christopher.drillingassistant;

import android.content.Intent;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    ImageView imageView;
    Matrix matrix = new Matrix();
    Float scale = 1f;
    ScaleGestureDetector SGD;

    double length;
    double width;
    double holes;
    double distance;
    double diameter;

    TextView result_holes;
    TextView result_distance;
    TextView result_diameter;

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private RadioButton radio_holes;
    private RadioButton radio_distance;
    private RadioButton radio_diameter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = findViewById(R.id.imageView);
        ViewGroup.LayoutParams params = imageView.getLayoutParams();

        SGD = new ScaleGestureDetector(this, new ScaleListener());

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
        text_holes.setText("max number of holes: ");

        distance = intent.getIntExtra(MainActivity.EXTRA_NUMBER3, 0);
        TextView text_distance = (TextView) findViewById(R.id.text_distance);
        text_distance.setText("max distance between holes: ");

        diameter = intent.getIntExtra(MainActivity.EXTRA_NUMBER4, 0);
        TextView text_diameter = (TextView) findViewById(R.id.text_diameter);
        text_diameter.setText("max diameter: ");

        params.width = (int) length;
        params.height = (int) width;

        radioGroup = findViewById(R.id.radioGroup);

        radio_holes = findViewById(R.id.radioButtonHoles);
        radio_distance = findViewById(R.id.radioButtonDistance);
        radio_diameter = findViewById(R.id.radioButtonDiameter);

        TextView result_holes = (TextView) findViewById(R.id.result_holes);
        result_holes.setText("I LOVE");

        TextView result_distance = (TextView) findViewById(R.id.result_distance);
        result_distance.setText("ANDROID");

        TextView result_diameter = (TextView) findViewById(R.id.result_diameter);
        result_diameter.setText("DEVELOPMENT");

    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        @Override
        public boolean onScale(ScaleGestureDetector detector){
            scale = scale * detector.getScaleFactor();
            scale = Math.max(0.1f, Math.min(scale, 5f));
            matrix.setScale(scale, scale);
            imageView.setImageMatrix(matrix);
            return true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        SGD.onTouchEvent(event);
        return true;
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