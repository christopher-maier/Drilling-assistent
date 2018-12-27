package com.example.christopher.drillingassistant;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Canvas extends View{

    DataObject dataObject = DataObject.getInstance();

    public Canvas(Context context) {
        super(context);
        init(null);
    }

    public Canvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public Canvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Canvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void init(@Nullable AttributeSet set){

    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {

        double length = dataObject.getLength();
        double width = dataObject.getWidth();
        double edge_length = dataObject.getDistanceToLength();
        double edge_width = dataObject.getDistanceToWidth();
        double holes = dataObject.getHoles();
        double distance = dataObject.getDistance();
        double diameter = dataObject.getDiameter();
        int modeCase = (int) dataObject.getModeCase();

        canvas.drawColor(Color.parseColor("#43516c"));

        //double ratio = width / length;
        //length = 900;
        //width = length * ratio;
        int abstandToLength = (int) ((canvas.getWidth() - length) / 2);
        int abstandToWidth = (int) ((canvas.getHeight() - width) / 2);


        Rect rect = new Rect();
        rect.left = abstandToLength;
        rect.top = abstandToWidth;
        rect.right = (int) (rect.left + length);
        rect.bottom = (int) (rect.top + width);

        //Log.d("DRAW","Rect: LEFT="+rect.left+" TOP="+rect.top+" RIGHT="+rect.right+" BOTTOM="+rect.bottom);


        Paint paint_rect = new Paint();
        paint_rect.setColor(Color.WHITE);
        Paint paint_circle = new Paint();
        paint_circle.setColor(Color.parseColor("#43516c"));
        //paint.setColor(Color.parseColor("#cc6699"));
        // paint_circle.setColor(Color.GREEN);

        canvas.drawRect(rect, paint_rect);

       // double ratioLength = length * ratio;
       // double ratioWidth = width * ratio;
       // double ratioEdgeLength = edge_length * ratio;
       // double ratioEdgeWidth = edge_width * ratio;
       // double ratioDistance = distance * ratio;
       // double ratioDiameter = diameter * ratio;

       // Log.d("DRAW","ratio: "+ratio+" length: "+ratioLength+" width: ="+ratioWidth);
       // Log.d("DRAW","abstandLength: "+abstandToLength+" abstandWidth: "+abstandToWidth);
       // Log.d("DRAW","edgeLength: "+ratioEdgeLength+" edgeWidth: "+ratioEdgeWidth+" distance: ="+ratioDiameter + "diameter: " + ratioDiameter);

        if(modeCase == 1){
            for(int i = 0; i < holes; i++){
                canvas.drawCircle((float) ((float) (abstandToLength + edge_length + diameter/2) + (i * (distance + diameter))), (float) (abstandToWidth + edge_width + diameter/2), (float) diameter/2, paint_circle );
            }
        }

        if(modeCase == 2){
            for(int i = 0; i < holes; i++){
                canvas.drawCircle((float) ((float) (abstandToLength + edge_length + diameter/2) + (i * (distance + diameter))), (float) (abstandToWidth + edge_width + diameter/2), (float) diameter/2, paint_circle );
            }
        }

        if(modeCase == 3){
            for(int i = 0; i < holes; i++){
                canvas.drawCircle((float) ((float) (abstandToLength + edge_length + diameter/2) + (i * (distance + diameter))), (float) (abstandToWidth + edge_width + diameter/2), (float) diameter/2, paint_circle );
            }
        }
    }
}
