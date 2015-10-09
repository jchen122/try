package com.example.jiaweichen.myproj;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Confirmation extends AppCompatActivity {

    public Button submit;
    public TextView confirmName;
    public TextView confirmPhone;
    public TextView confirmGender;
    public  TextView confirmAsset;
    public DBHelper dbHelper;
    public SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        confirmName=(TextView)findViewById(R.id.confirm_name);
        confirmPhone=(TextView)findViewById(R.id.confirm_phone);
        confirmGender=(TextView)findViewById(R.id.confirm_gender);
        confirmAsset=(TextView)findViewById(R.id.confirm_asset);

        final String a =getIntent().getExtras().getString("name");
        final String b =getIntent().getExtras().getString("phone");
        String c =getIntent().getExtras().getString("gender");
        String d=getIntent().getExtras().getString("asset");

        confirmName.setText(a);
        confirmPhone.setText(b);
        confirmGender.setText(c);
        confirmAsset.setText(d);

          dbHelper =new DBHelper(this,"mydb");

        submit=(Button)findViewById(R.id.confirm_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=dbHelper.getWritableDatabase();
                ContentValues cv =new ContentValues();
                cv.put("name",a);
                cv.put("phone", b);
                db.insert("mytable", null, cv);
                Toast.makeText(Confirmation.this,"Data Saved",Toast.LENGTH_LONG).show();
                Intent intent =new Intent(Confirmation.this,MainActivity.class);
                startActivity(intent);


            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
