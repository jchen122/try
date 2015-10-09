package com.example.jiaweichen.myproj;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {
    public ListView lv;
    public SQLiteDatabase db;
    public DBHelper dbHelper;
    public ArrayList list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lv=(ListView)findViewById(R.id.third_list_view);
        dbHelper=new DBHelper(this,"mydb");
        db=dbHelper.getReadableDatabase();
        String [] clos={"name","phone"};
        Cursor c=db.query("mytable",clos,null,null,null,null,null);
        c.moveToFirst();
        list=new ArrayList();

        ArrayAdapter<String> aa=new ArrayAdapter<String>
                (ThirdActivity.this,R.layout.list_view_arrangement,R.id.list_view_text_view,list);
        lv.setAdapter(aa);
        do{
            String name=c.getString(c.getColumnIndex("name"));
            String phone=c.getString(c.getColumnIndex("phone"));
            list.add(name + "\n" + phone);
            aa.notifyDataSetChanged();


        }while (c.moveToNext());

        registerForContextMenu(lv);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.add(0, 1, Menu.NONE, "Send Message");
        menu.add(0, 2, Menu.NONE, "Call");

    }
    public boolean onContextItemSelected(MenuItem item){
        if (item.getTitle()=="Send Message"){
            Intent intent =new Intent(ThirdActivity.this,SendMessage.class);
            int a =lv.getFirstVisiblePosition();
            String b= (String) lv.getItemAtPosition(a);
            intent.putExtra("phone",b);
            startActivity(intent);
        }
        return true;
    }
}
