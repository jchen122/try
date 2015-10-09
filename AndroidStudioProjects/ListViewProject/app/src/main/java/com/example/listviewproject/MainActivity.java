package com.example.listviewproject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	String[] items = {"India", "China", "USA","Japan", "Mexico","India",
			"China", "USA","Japan", "Mexico","India", "China", "USA","Japan", "Mexico"};
	ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv= (ListView) findViewById(R.id.listView1);
		/*
		ArrayAdapter<String> aa = new ArrayAdapter<String>
		(MainActivity.this, android.R.layout.simple_list_item_1, items);*/
		
		//ArrayAdapter<String> aa = new ArrayAdapter<String>(MainActivity.this, R.layout.myitem,R.id.textViewlist, items);
		ArrayAdapter<String> aa = new ArrayAdapter<String>
		(MainActivity.this, R.layout.myitem,R.id.textViewlist, items);
		lv.setAdapter(aa);
		
	
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long id) {
				// TODO Auto-generated method stub
				String val = (String) lv.getItemAtPosition(position);
				Toast.makeText(MainActivity.this,
		"The country clicked is " + val + "  , id is   "+ id + "  , postion is " + position, Toast.LENGTH_LONG).show();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
