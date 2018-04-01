package com.varunarl.myapplication.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.varunarl.myapplication.R;

public class RegisterActivity extends AppCompatActivity {

    private Button btn_create;
    private Button btn_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btn_create = (Button)findViewById(R.id.btn_create);
        btn_list = (Button)findViewById(R.id.btn_list);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changingToInsert();
            }
        });

        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changingToList();
            }
        });
    }

    /**
     * redirecting to the list page
     */
    public void changingToList(){
        Intent listView = new Intent(this, MainActivity.class);
        startActivity(listView);
    }

    /**
     * redirecting to the insert page
     */
    public void changingToInsert(){
        Intent listView = new Intent(this, PinCreateActivity.class);
        startActivity(listView);
    }
}
