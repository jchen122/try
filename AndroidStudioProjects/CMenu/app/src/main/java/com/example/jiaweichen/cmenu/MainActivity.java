package com.example.jiaweichen.cmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.CharacterPickerDialog;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "TESTINGSS", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final Button b = (Button) findViewById(R.id.button);

        Button c = (Button) findViewById(R.id.main_content_menu);

        this.registerForContextMenu(c);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });



        /*b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });*/
        b.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                PopupMenu pm = new PopupMenu(MainActivity.this, b);

                pm.getMenuInflater().inflate(R.menu.my_menu, pm.getMenu());

                pm.show();


                pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.my_menu_one:
                                Toast.makeText(MainActivity.this, "this is item one", Toast.LENGTH_LONG).show();
                                break;
                            case R.id.my_menu_two:
                                Toast.makeText(MainActivity.this, "this is item two", Toast.LENGTH_LONG).show();
                                break;
                            default:
                                break;
                        }

                        return false;
                    }
                });

                Toast.makeText(MainActivity.this, "test", Toast.LENGTH_LONG).show();
                Snackbar.make(v, "TESTINGSS", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Hello");
        menu.add(0, 1, Menu.NONE, "Item1");
        menu.add(0, 2, Menu.NONE, "Item2");
        menu.add(0, 3, Menu.NONE, "Item3");

    }

}
