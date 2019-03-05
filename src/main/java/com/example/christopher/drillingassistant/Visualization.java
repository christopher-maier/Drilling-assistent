package com.example.christopher.drillingassistant;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Visualization extends AppCompatActivity {

    DataObject dataObject = DataObject.getInstance();
    DataObjectV2 dataObjectV2 = DataObjectV2.getInstance();

    double length;
    double width;
    double holes;
    double distance;
    double diameter;
    double distanceToLength;
    double distanceToWidth;
    double dl;
    double dw;
    int modeCase;

    TextView result_holes;
    TextView result_distance;
    TextView result_diameter;

    TextView result_holes_V2;
    TextView result_distance_V2;
    TextView result_diameter_V2;

    private boolean trans=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        trans = false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();

        TextView text_user_dimension = (TextView) findViewById(R.id.user_dimension);
        text_user_dimension.setText("dimension:");

        length = intent.getIntExtra(UserInput.EXTRA_NUMBER0, 0);
        TextView user_length = (TextView) findViewById(R.id.user_length);
        user_length.setText("" + (int) length);

        width = intent.getIntExtra(UserInput.EXTRA_NUMBER1, 0);
        TextView user_width = (TextView) findViewById(R.id.user_width);
        user_width.setText("" + (int) width);

        TextView text_edge = (TextView) findViewById(R.id.user_edge);
        text_edge.setText("distance to edge:");

        distanceToLength = dataObject.getDistanceToLength();
        distanceToWidth = dataObject.getDistanceToWidth();

        TextView user_edge_length = (TextView) findViewById(R.id.edge_length);
        user_edge_length.setText("" + (int) distanceToLength);

        TextView user_edge_width = (TextView) findViewById(R.id.edge_width);
        user_edge_width.setText("" + (int) + distanceToWidth);

        holes = intent.getIntExtra(UserInput.EXTRA_NUMBER2, 0);
        holes = intent.getIntExtra(UserInput.EXTRA_NUMBER2, 0);
        TextView text_holes = (TextView) findViewById(R.id.text_holes);
        text_holes.setText("number of holes: ");

        distance = intent.getIntExtra(UserInput.EXTRA_NUMBER3, 0);
        TextView text_distance = (TextView) findViewById(R.id.text_distance);
        text_distance.setText("distance between holes: ");

        diameter = intent.getIntExtra(UserInput.EXTRA_NUMBER4, 0);
        TextView text_diameter = (TextView) findViewById(R.id.text_diameter);
        text_diameter.setText("diameter of holes: ");

        result_holes = (TextView) findViewById(R.id.result_holes);
        result_distance = (TextView) findViewById(R.id.result_distance);
        result_diameter = (TextView) findViewById(R.id.result_diameter);

        result_holes_V2 = (TextView) findViewById(R.id.result_holes_V2) ;
        result_distance_V2 = (TextView) findViewById(R.id.result_distance_V2) ;
        result_diameter_V2 = (TextView) findViewById(R.id.result_diameter_V2) ;

        modeCase = intent.getIntExtra(UserInput.EXTRA_NUMBER5, 0);

        userRestriction();

        length = dataObject.getLength();
        width = dataObject.getWidth();
        holes = dataObject.getHoles();
        distance = dataObject.getDistance();
        diameter = dataObject.getDiameter();
        dl = dataObject.getDl();
        dw = dataObject.getDw();

        //labels vertical
        LinearLayout l1 = findViewById(R.id.layout1);
        double result = distanceToWidth +  (diameter / 2);
        double result2 = distance + diameter;
        for(int i = 0; i < holes; i++) {
            TextView t1 = new TextView(this);
            t1.setText("" + (int) result );
            if(i > 0) {
                t1.setText("" + (int)result2);
            }
            t1.setTextSize(15);
            t1.setTextColor(Color.parseColor("#d6c218"));
            t1.setX((float) (dw));
            t1.setY((float) ((distanceToWidth + dw + diameter + 2.1 + (i * (distance)))));
            l1.addView(t1);

        }

        //labels horizontal
        LinearLayout l2 = findViewById(R.id.layout2);
        double result3 = distanceToWidth + (diameter / 2);
        double result4 = distance + diameter;
        for(int i = 0; i < holes; i++) {
            TextView t2 = new TextView(this);
            t2.setText("" + (int) result3);
            if(i > 0){
                t2.setText("" + (int) result4);
            }
            t2.setTextSize(15);
            t2.setTextColor(Color.parseColor("#d6c218"));
            t2.setX((float) (distanceToLength + dl + diameter + (i * (distance / 2.2) )));
            t2.setY((float) (distanceToWidth + dw + (diameter / 2.5)));
            l2.addView(t2);
        }
    }

    @Override
    public void finish(){
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void userRestriction(){
        if(modeCase == 1){
            result_holes.setText("" + (int) maxHoles(length, width, distance, diameter));
            result_holes.setTextColor(Color.parseColor("#d6c218"));
            result_holes_V2.setText("" + (int) maxHolesV2(width, length, distance, diameter));
            result_holes_V2.setTextColor(Color.parseColor("#d6c218"));

            result_distance.setText("" + (int) distance);
            result_distance_V2.setText("" + (int) distance);

            result_diameter.setText("" + (int) diameter);
            result_diameter_V2.setText("" + (int) diameter);

            dataObject.setModeCase(1);

        }

        if(modeCase == 2){
            result_holes.setText("" + (int) holes);
            result_holes_V2.setText("" + (int) holes);

            result_distance.setText("" + (int) maxDistance(length, width, diameter, holes));
            result_distance.setTextColor(Color.parseColor("#d6c218"));
            result_distance_V2.setText("" + (int) maxDistanceV2(width, length, diameter, holes));
            result_distance_V2.setTextColor(Color.parseColor("#d6c218"));

            result_diameter.setText("" + (int) diameter);
            result_diameter_V2.setText("" + (int) diameter);

            dataObject.setModeCase(2);
        }

        if(modeCase == 3){
            result_holes.setText("" + (int) holes);
            result_holes_V2.setText("" + (int) holes);


            result_distance.setText("" + (int) distance);
            result_distance_V2.setText("" + (int) distance);

            result_diameter.setText("" + (int) maxDiameter(length, width, distance, holes));
            result_diameter.setTextColor(Color.parseColor("#d6c218"));
            result_diameter_V2.setText("" + (int) maxDiameterV2(width, length, distance, holes));
            result_diameter_V2.setTextColor(Color.parseColor("#d6c218"));

            dataObject.setModeCase(3);
        }
    }

    public double maxHoles(double length, double width, double distance, double diameter) {
        double i;
        i = ((length - (2 * distanceToLength)) / (diameter + distance));

        long j = Math.round(i);
        if(((length - (2 * distanceToLength)) - ((j * (diameter + distance)))) >= diameter){
            j = j +1;
        }
        Log.d("DRAW","J =" + j);

        dataObject.setHoles(j);
           return j;
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

    public double maxHolesV2(double length, double width, double distance, double diameter) {
        double i;
        i = ((length - (2 * distanceToWidth)) / (diameter + distance));
        long j = Math.round(i);
        if(((length - (2 * distanceToWidth)) - ((j *  (diameter + distance)))) >= diameter){
        j = j +1;
        }
        Log.d("DRAW","J =" + j);
        dataObjectV2.setHoles(j);
        return j;
    }
    public double maxDistanceV2(double length, double width, double diameter, double holes) {
        double j;

        j = (((length - (distanceToLength * 2)) - (holes * diameter))) / (holes - 1);
        dataObjectV2.setDistance(j);
        Log.d("DRAW","calculated distance: "+dataObject.getDistance());
        return j;
    }
    public double maxDiameterV2(double length, double width, double distance, double holes) {
        double i;
        i = (((length - (2 * distanceToLength)) - ((holes - 1) * distance)) / holes);

        dataObjectV2.setDiameter(i);
        return i;
    }

    @Override
    protected void onPause() {
        if (trans) {
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        trans=true;
    }

}
