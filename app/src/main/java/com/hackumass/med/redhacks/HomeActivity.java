package com.hackumass.med.redhacks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {

    Button save;
    EditText name,age,address,message,shake;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("Enter your details...");

        save = findViewById(R.id.save);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        address = findViewById(R.id.address);
        message = findViewById(R.id.message);
        shake = findViewById(R.id.shake);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this,MainActivity.class);
                i.putExtra("name",name.getText().toString());
                i.putExtra("age",age.getText().toString());
                i.putExtra("address",address.getText().toString());
                i.putExtra("message",message.getText().toString());
                i.putExtra("shake",shake.getText().toString());
                startActivity(i);
            }
        });

    }
}
