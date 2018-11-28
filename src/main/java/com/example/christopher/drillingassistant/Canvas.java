package com.example.christopher.drillingassistant;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.shapes.RectShape;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Canvas extends View{

    DataObject dataObject = DataObject.getInstance();

    double length = dataObject.getLength();
    double width = dataObject.getWidth();
    double holes = dataObject.getHoles();
    double distance = dataObject.getDistance();
    double diameter = dataObject.getDiameter();

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

    public Canvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void init(@Nullable AttributeSet set){

    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        canvas.drawColor(Color.parseColor("#43516c"));

        double ratio = width / length;
        length = 900;
        width = length * ratio;


        Rect rect = new Rect();
        rect.left = (int) ((canvas.getWidth() - length) / 2);
        rect.top = (int) ((canvas.getHeight() - width) / 2);
        rect.right = (int) (rect.left + length);
        rect.bottom = (int) (rect.top + width);

        Log.d("DRAW","Rect: LEFT="+rect.left+" TOP="+rect.top+" RIGHT="+rect.right+" BOTTOM="+rect.bottom);


        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        //paint.setColor(Color.parseColor("#cc6699"));
        canvas.drawRect(rect, paint);

    }
}
