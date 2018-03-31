package com.varunarl.myapplication.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.varunarl.myapplication.core.DBManager;
import com.varunarl.myapplication.data.PinDetails;
import com.varunarl.myapplication.core.Pins;
import com.varunarl.myapplication.data.MyListAdapter;
import com.varunarl.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<PinDetails> rawData = new ArrayList<>();
    private MyListAdapter simpleAdapter;
    DBManager databaseHelper ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PinDetails pin = null;

        ListView lv = findViewById(R.id.listView);
        databaseHelper = new DBManager(this);

        Cursor data = databaseHelper.readAll();
        while (data.moveToNext()){
            pin = new PinDetails();
            pin.setId(data.getInt(0));
            pin.setAccountName(data.getString(1));
            pin.setPin(data.getString(2));
            pin.setDescription(data.getString(3));
            rawData.add(pin);
        }
        lv.setOnItemClickListener(this);

        simpleAdapter = new MyListAdapter( this, rawData);
        lv.setAdapter(simpleAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, DescriptionActivity.class);
        intent.putExtra("data", rawData.get(i).getId());
        MainActivity.this.startActivity(intent);
    }
}
