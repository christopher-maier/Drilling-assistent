package com.example.christopher.drillingassistant;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.shapes.RectShape;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class Canvas extends View{

    DataObject dataObject = DataObject.getInstance();

    double length = dataObject.getLength();
    double width = dataObject.getWidth();
    double holes = dataObject.getHoles();
    double distance = dataObject.getDistance();
    double diameter = dataObject.getDiameter();

    private Rect rectangle;
    private Paint paint;

    public Canvas(Context context) {
        super(context);
        init(null);

        int x = 50;
        int y = 50;

        // create a rectangle that we'll draw later
        rectangle = new Rect(x, y, (int) length,(int) width);

        // create the Paint and set its color
        paint = new Paint();
        paint.setColor(Color.GRAY);
    }

    public Canvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public Canvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public Canvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void init(@Nullable AttributeSet set){

    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        canvas.drawColor(Color.RED);
        //canvas.drawRect(rectangle, paint);
    }
}
