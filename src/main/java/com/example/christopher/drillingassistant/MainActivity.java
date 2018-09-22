package com.example.christopher.drillingassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    //create a constant
    public static final String EXTRA_NUMBER0 = "com.example.christopher.drillingassistent.EXTRA_TEXT";
    public static final String EXTRA_NUMBER1 = "com.example.christopher.drillingassistent.EXTRA_TEXT";
    public static final String EXTRA_NUMBER2 = "com.example.christopher.drillingassistent.EXTRA_TEXT";
    public static final String EXTRA_NUMBER3 = "com.example.christopher.drillingassistent.EXTRA_TEXT";
    public static final String EXTRA_NUMBER4 = "com.example.christopher.drillingassistent.EXTRA_TEXT";

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private RadioButton holes;
    private RadioButton distance;
    private RadioButton diameter;
    protected EditText input_holes;
    protected EditText input_distance;
    protected EditText input_diameter;
    protected EditText input_length;
    protected EditText input_width;
    private Button buttonApply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);

        holes = findViewById(R.id.radioButtonHoles);
        distance = findViewById(R.id.radioButtonDistance);
        diameter = findViewById(R.id.radioButtonDiameter);

        buttonApply = findViewById(R.id.buttonApply);
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        input_holes = findViewById(R.id.input_holes);

        input_distance = findViewById(R.id.input_distance);

        input_diameter = findViewById(R.id.input_diameter);

        input_length = findViewById(R.id.input_length);
        input_length.addTextChangedListener(boardInputTextWatcher);

        input_width = findViewById(R.id.input_width);
        input_width.addTextChangedListener(boardInputTextWatcher);
    }

      public void radioButtonClicked(View v){
        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioButtonId);
        Toast.makeText(this, "You selected: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
        userRestriction();
    }

    public void userRestriction(){
        if(radioButton.getId() == holes.getId()){
            input_distance.setEnabled(true);
            input_diameter.setEnabled(true);
            input_holes.setEnabled(false);
            input_holes.setText(null);
            input_distance.addTextChangedListener(inputHolesTextWatcher);
            input_diameter.addTextChangedListener(inputHolesTextWatcher);
        }

        if(radioButton.getId() == distance.getId()){
            input_holes.setEnabled(true);
            input_diameter.setEnabled(true);
            input_distance.setEnabled(false);
            input_distance.setText(null);
            input_holes.addTextChangedListener(inputDistanceTextWatcher);
            input_diameter.addTextChangedListener(inputDistanceTextWatcher);
        }

        if(radioButton.getId() == diameter.getId()){
            input_holes.setEnabled(true);
            input_distance.setEnabled(true);
            input_diameter.setEnabled(false);
            input_diameter.setText(null);
            input_holes.addTextChangedListener(inputDiameterTextWatcher);
            input_distance.addTextChangedListener(inputDiameterTextWatcher);
        }
    }

    public void openActivity2(){
        Intent intent = new Intent(this, Main2Activity.class);

        //saves the user input into variables

        int number_length = Integer.parseInt(input_length.getText().toString());
        intent.putExtra(EXTRA_NUMBER0, number_length);

        int number_width = Integer.parseInt(input_width.getText().toString());
        intent.putExtra(EXTRA_NUMBER1, number_width);

       /* int number_holes = Integer.parseInt(input_holes.getText().toString());
        intent.putExtra(EXTRA_NUMBER2, number_holes);

        int number_distance = Integer.parseInt(input_distance.getText().toString());
        intent.putExtra(EXTRA_NUMBER3, number_distance);

        int number_diameter = Integer.parseInt(input_diameter.getText().toString());
        intent.putExtra(EXTRA_NUMBER4, number_diameter);*/

        startActivity(intent);

    }

    private TextWatcher boardInputTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String string_length = input_length.getText().toString().trim();
            String string_width = input_width.getText().toString().trim();

            holes.setEnabled(!string_length.isEmpty() && !string_width.isEmpty());
            distance.setEnabled(!string_length.isEmpty() && !string_width.isEmpty());
            diameter.setEnabled(!string_length.isEmpty() && !string_width.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public TextWatcher inputHolesTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String string_distance = input_distance.getText().toString().trim();
            String string_diameter = input_diameter.getText().toString().trim();

            buttonApply.setEnabled(!string_distance.isEmpty() && !string_diameter.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public TextWatcher inputDistanceTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String string_holes = input_holes.getText().toString().trim();
            String string_diameter = input_diameter.getText().toString().trim();

            buttonApply.setEnabled(!string_holes.isEmpty() && !string_diameter.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public TextWatcher inputDiameterTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String string_holes = input_holes.getText().toString().trim();
            String string_distance = input_distance.getText().toString().trim();

            buttonApply.setEnabled(!string_holes.isEmpty() && !string_distance.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
