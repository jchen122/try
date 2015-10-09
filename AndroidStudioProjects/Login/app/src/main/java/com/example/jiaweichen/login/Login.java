package com.example.jiaweichen.login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    public TextView name;
    public  TextView password;
    public Button login;
    public DBHelper dbHelper;
    public SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name=(TextView)findViewById(R.id.login_name);
        password=(TextView)findViewById(R.id.login_password);
        login=(Button)findViewById(R.id.login_button);


        dbHelper=new DBHelper(this);
        db=dbHelper.getWritableDatabase();
        //db.delete("mytable",null,null);

        ContentValues cv =new ContentValues();

        cv.put("name","Jason");
        cv.put("password","123456");

        db.insert("mytable", null, cv);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* try {
                    Cursor c = db.query
                            ("mytable", new String[]{"name", "password"}, "name=?, password=?",
                            new String[]{nameLogin, passwordLogin}, null, null, null, null);
                    Intent intent=new Intent(Login.this,Menu.class);
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(Login.this,"No recore found",Toast.LENGTH_LONG).show();

                }*/
                String nameLogin=name.getText().toString();

                String passwordLogin=password.getText().toString();

                String query = "SELECT * FROM mytable WHERE name=? ";
                Cursor c = db.rawQuery(query, new String[]{nameLogin});

                if (c.getCount() <= 0) {
                    Toast.makeText(Login.this, "No record found", Toast.LENGTH_LONG).show();
                    c.close();
                } else {
                        c.moveToFirst();
                    String passw = c.getString(c.getColumnIndex("password"));
                    if (passw.equals(passwordLogin)) {
                        Toast.makeText(Login.this, "Login Successfully", Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(Login.this, com.example.jiaweichen.login.Menu.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Login.this, "User Name and Password are not match", Toast.LENGTH_LONG).show();
                    }

                }
                name.setText("");
                password.setText("");


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
