package com.varunarl.myapplication.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.varunarl.myapplication.R;
import com.varunarl.myapplication.core.DBManager;

public class PinCreateActivity extends AppCompatActivity {

    DBManager dbManager;
    private Button bt_save;
    private Button btn_list;
    private EditText account_name;
    private EditText pin;
    private EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_create);

        bt_save = (Button)findViewById(R.id.bt_save);
        btn_list = (Button)findViewById(R.id.btn_list);
        account_name = (EditText)findViewById(R.id.account_name);
        pin = (EditText)findViewById(R.id.pin1);
        description = (EditText)findViewById(R.id.description);
        dbManager = new DBManager(this);

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account_name1 = account_name.getText().toString();
                String pin1 = pin.getText().toString();
                String description1 = description.getText().toString();
                if(account_name.length() != 0 && pin.length() != 0) {
                    addData(account_name1, pin1, description1);
                    account_name.setText("");
                    pin.setText("");
                    description.setText("");
                }else{
                    showMessage("You must enter Account name and Pin!");
                }
            }
        });

        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                changingUI();
//                Intent intent = new Intent(this, MainActivity.class);
//                PinCreateActivity.this.startActivity(intent);
//                Log.d("Button list","inside button click");
            }
        });
    }

    /**
     * change the UI to List View
     */
    public void changingUI(){
        Intent listView = new Intent(this, MainActivity.class);
        startActivity(listView);
    }
    public void addData(String account_name, String pin, String description){
        boolean result = dbManager.saveData(account_name,pin,description);

        if(result){
            showMessage("Successfully saved!");
        }else {
            showMessage("Error saving data!");
        }

    }
    private void showMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT);
    }
}
