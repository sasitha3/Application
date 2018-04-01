package com.varunarl.myapplication.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.varunarl.myapplication.R;

public class DescriptionActivity extends AppCompatActivity {

    private TextView mTextView1;
    private TextView mTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        String pin = getIntent().getExtras().getString("pin");
        String description = getIntent().getExtras().getString("description");

        mTextView1 = findViewById(R.id.text1);
        mTextView2 = findViewById(R.id.text2);

        mTextView1.setText("Pin : " + pin);
        mTextView2.setText(description);
    }
}
