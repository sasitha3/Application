package com.varunarl.myapplication.core;

/**
 * Created by USER on 3/26/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper{

    private static final String TAG = "DBManager";
    private static final String DB_NAME = "mydatabase.db";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "accounts";
    private static final String col1 = "id";
    private static final String col2 = "account_name";
    private static final String col3 = "pin";
    private static final String col4 = "description";

    public DBManager(Context context) {

        super(context.getApplicationContext(), "accounts", null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String createTable = "CREATE TABLE"+TABLE_NAME+"(_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
//                col2+"TEXT,"+
//                col3+"TEXT,"+
//                col4+"TEXT)";
        String createTable = "CREATE TABLE accounts (id integer PRIMARY KEY AUTOINCREMENT, account_name text, pin text,description text )";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean saveData(String account_name,String pin,String description){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(col2,account_name);
        contentvalues.put(col3,pin);
        contentvalues.put(col4,description);

        long results = db.insert(TABLE_NAME,null,contentvalues);

        if(results == -1){
            return false;
        }else {
            return  true;
        }
    }

    public Cursor readAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM accounts", null);
        return cur;
    }
}
