package com.varunarl.myapplication.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.varunarl.myapplication.R;
import com.varunarl.myapplication.core.Pins;
import com.varunarl.myapplication.data.PinDetails;

public class DescriptionActivity extends AppCompatActivity {

    private TextView mTextView1;
    private TextView mTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        int id = getIntent().getExtras().getInt("data");

        Pins pins = new Pins();
        PinDetails pinDetails = pins.getBrand(id);

        mTextView1 = findViewById(R.id.text1);
        mTextView2 = findViewById(R.id.text2);

        mTextView1.setText(pinDetails.getDescription());
        mTextView2.setText("Rating : " + pinDetails.getId());
    }
}
