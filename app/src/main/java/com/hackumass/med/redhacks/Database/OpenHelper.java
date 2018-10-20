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
        String user_table = "CREATE TABLE " + Contract.User.TABLE_NAME +  " ( " +
                Contract.User.COLUMN_ID +  " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Contract.User.COLUMN_MEDICATIONS + " TEXT, " +
                Contract.User.COLUMN_SYMPTOMS + " TEXT, " +
                Contract.User.COLUMN_PAIN + " INTEGER DEFAULT 0, " +
                Contract.User.COLUMN_ALCOHOL + " INTEGER DEFAULT 0, " +
                Contract.User.COLUMN_DATE + " TEXT, " +
                Contract.User.COLUMN_SMOKING + " INTEGER DEFAULT 0 " +
                " )";

        db.execSQL(user_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
