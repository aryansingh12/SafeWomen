package com.hackumass.med.redhacks;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MessagingActivity extends AppCompatActivity {

    ListView list;
    ArrayList<HashMap<String, String>> al = new ArrayList<HashMap<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging);
        getSupportActionBar().setTitle("Select your messenger");

        list = (ListView) findViewById(R.id.list);

        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");

        while(phones.moveToNext())
        {
            HashMap<String, String> nameNumberMap = new HashMap<String, String>();
            String contactName = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String contactNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            nameNumberMap.put("Name",contactName);
            nameNumberMap.put("Number",contactNumber);
            al.add(nameNumberMap);

        }

        Log.e("check","as2");
        customAdapter adapter = new customAdapter(this, al);
        list.setAdapter(adapter);
        Log.e("check","as2"+al.size());



    }
}
