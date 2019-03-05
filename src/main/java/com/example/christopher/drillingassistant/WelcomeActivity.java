package com.example.christopher.drillingassistant;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    private ViewPager slideViewPager;
    private LinearLayout dotLayout;

    private TextView[] dots;
    private SliderAdpater sliderAdpater;

    private Button nextBtn;
    private Button previouosBtn;

    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        slideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        dotLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        nextBtn = (Button) findViewById(R.id.nxt_button);
        previouosBtn = (Button) findViewById(R.id.prev_button);

        sliderAdpater = new SliderAdpater(this);
        slideViewPager.setAdapter(sliderAdpater);

        addDotsIndicator(0);
        slideViewPager.addOnPageChangeListener(viewListener);

        //OnClickListeners

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideViewPager.setCurrentItem(currentPage + 1);
            }
        });

        previouosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideViewPager.setCurrentItem(currentPage - 1);
            }
        });
    }

    public void addDotsIndicator(int position ){
        dots = new TextView[4];
        dotLayout.removeAllViews();
        for(int i = 0; i < dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(30);
            dots[i].setTextColor(getResources().getColor(R.color.transparentWhite));

            dotLayout.addView(dots[i]);
        }

        if(dots.length > 0){
            dots[position].setTextColor(getResources().getColor(R.color.pureWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);
            currentPage = position;

            if (position == 0){
                nextBtn.setEnabled(true);
                previouosBtn.setEnabled(false);
                previouosBtn.setVisibility(View.INVISIBLE);

                nextBtn.setText("Next");
                previouosBtn.setText("");
            }else if(position == dots.length - 1){
                nextBtn.setEnabled(true);
                previouosBtn.setEnabled(true);
                previouosBtn.setVisibility(View.VISIBLE);

                nextBtn.setText("Ready");
                previouosBtn.setText("Back");
                nextBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(WelcomeActivity.this, Home.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        finish();
                    }
                });
            }else{
                nextBtn.setEnabled(true);
                previouosBtn.setEnabled(true);
                previouosBtn.setVisibility(View.VISIBLE);
                nextBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        slideViewPager.setCurrentItem(currentPage + 1);
                    }
                });
                nextBtn.setText("Next");
                previouosBtn.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
