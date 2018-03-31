package com.varunarl.myapplication.core;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;

import com.varunarl.myapplication.data.PinDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by varunarl on 3/16/18.
 */

public class Pins extends AppCompatActivity {

    DBManager databaseHelper ;

    public List<PinDetails> getAllBrands() {

        PinDetails b = new PinDetails();
//        b.setRating(2);
//        b.setTitle("Sample Title");
        databaseHelper = new DBManager(this);
        Cursor data = databaseHelper.readAll();
        List<PinDetails> list = new ArrayList<>();
        while (data.moveToNext()) {
//            b = new PinDetails();
//            b.setId(data.getInt(0));
//            b.setAccountName(data.getString(1));
            b.setPin(data.getString(2));
            b.setDescription(data.getString(3));
            list.add(b);
        }
        return list;
    }

    public PinDetails getBrand(int id) {
        PinDetails b = new PinDetails();
//        b.setRating(2);
//        b.setTitle("Sample title");
        return b;
    }

    public int addBrand(PinDetails pinDetails) {
        //TODO: Add functionality here
        return -1;
    }

    public boolean updateBrand(PinDetails pinDetails) {
        //TODO: Add functionality here
        return false;
    }

    public boolean deleteBrand(PinDetails pinDetails) {
        //TODO: Add functionality here
        return false;
    }


}
