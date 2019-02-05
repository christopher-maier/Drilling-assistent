package com.example.christopher.drillingassistant;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Canvas extends View{

    DataObject dataObject = DataObject.getInstance();
    DataObjectV2 dataObjectV2 = DataObjectV2.getInstance();

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

        double holesV2 = dataObjectV2.getHoles();
        double distanceV2 = dataObjectV2.getDistance();
        double diameterV2 = dataObjectV2.getDiameter();


        canvas.drawColor(Color.parseColor("#43516c"));

        //double ratio = width / length;
        //length = 900;
        //width = length * ratio;
        int abstandToLength = (int) ((canvas.getWidth() - length) / 2);
        int abstandToWidth = (int) ((canvas.getHeight() - width) / 2);
        dataObject.setDl(abstandToLength);
        dataObject.setDw(abstandToWidth);


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
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#3B66B8"));
        paint.setTextSize(35);

        //cirles horizontal
        for(int i = 0; i < holes; i++) {
            canvas.drawCircle((float) ((abstandToLength + edge_length + (diameter/2) + (i * (distance + diameter)))), (float) (abstandToWidth + edge_width + (diameter/ 2)), (float) diameter, paint_circle);
        }

        //circles vertical
        for(int i = 0; i < holesV2; i++) {
            canvas.drawCircle((float) (abstandToLength + edge_length + (diameter/ 2)), (float) ((abstandToWidth + edge_width + (diameter/2) + (i * (distance + diameter)))), (float) diameter, paint_circle);
        }
        /*
        //labels horizontal
        for(int i = 0; i < holes - 1; i++) {
            canvas.drawText("" + (int) distance, (float) ((abstandToLength + edge_length + (diameter * 1.5) + (i * (distance + diameter)))), (float) (abstandToWidth + edge_width + (diameter/1.3)), paint);
        }

        //circles vertical
        for(int i = 0; i < holesV2 - 1; i++) {
            canvas.drawText("" + (int) distance, (float) (abstandToLength + edge_length * 0.8), (float) ((abstandToWidth + edge_width + (diameter * 2.5) + (i * (distance + diameter)))), paint);
        }*/

    }
}
