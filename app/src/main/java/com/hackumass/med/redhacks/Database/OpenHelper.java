package com.hackumass.med.redhacks.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aryan Singh on 10/19/2018.
 */

public class OpenHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "med_db";
    public static final int VERSION = 1;

    private static OpenHelper instance;
    public OpenHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public static OpenHelper getInstance(Context context) {
        if(instance == null)
            instance = new OpenHelper(context.getApplicationContext());
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String user_table = "CREATE TABLE " + Contract.Alarms.TABLE_NAME +  " ( " +
                Contract.Alarms.TIME_MILLIS + " LONG DEFAULT 0, " +
                " )";

        String caller = "CREATE TABLE " + Contract.Caller.TABLE_NAME +  " ( " +
                Contract.Caller.COLUMN_NAME + " TEXT, " +
                Contract.Caller.COLUMN_PHONE + " INTEGER DEFAULT 0, " +
                " )";

        String messenger = "CREATE TABLE " + Contract.Messenger.TABLE_NAME +  " ( " +
                Contract.Messenger.COLUMN_NAME + " TEXT, " +
                Contract.Messenger.COLUMN_PHONE + " INTEGER DEFAULT 0, " +
                " )";

        db.execSQL(user_table);
        db.execSQL(caller);
        db.execSQL(messenger);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
