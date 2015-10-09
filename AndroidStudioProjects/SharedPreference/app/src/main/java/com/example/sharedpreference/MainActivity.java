package com.example.sharedpreference;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class MainActivity extends Activity {

	public Button bt;
	public EditText et;
	public SharedPreferences sp;
	public EditText et2;
	public CheckBox cb;
	boolean isChecked;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bt = (Button) findViewById(R.id.main_button1);
		et = (EditText) findViewById(R.id.main_text1);
		et2 = (EditText) findViewById(R.id.main_text2);
		cb = (CheckBox) findViewById(R.id.checkBox1);

		sp = getSharedPreferences("MY_PREF", MODE_PRIVATE);

		isChecked = sp.getBoolean("key3", false);
		cb.setChecked(isChecked);

		if (isChecked) {
			String s = sp.getString("key1", "");
			String s2 = sp.getString("key2", "");
			et.setText(s);
			et2.setText(s2);
		}

		cb.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				isChecked = cb.isChecked();

			}
		});

		bt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (cb.isChecked()) {
					Editor editor = sp.edit();
					editor.putString("key1", et.getText().toString());
					editor.putString("key2", et2.getText().toString());
					editor.putBoolean("key3", true);
					editor.commit();

				} else {
					Editor editor = sp.edit();
					editor.putBoolean("key3", false);
					editor.commit();
				}
				Intent intent = new Intent(MainActivity.this,
						SecondActivity.class);
				startActivity(intent);

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
