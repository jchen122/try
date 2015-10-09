package com.example.tabproj;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.view.Menu;

public class MainActivity extends Activity {
	ActionBar.Tab fragment1Tab,fragment2Tab,fragment3Tab;
	Fragment fragment1 = new Fragment1();
	Fragment fragment2 = new Fragment2();
	Fragment fragment3 = new Fragment3();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ActionBar ab = getActionBar();
		ab.setDisplayShowHomeEnabled(false);
		ab.setDisplayShowTitleEnabled(false);
		ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		fragment1Tab = ab.newTab().setIcon(R.drawable.ic_launcher);
		fragment2Tab = ab.newTab().setIcon(R.drawable.ic_launcher);
		fragment3Tab = ab.newTab().setIcon(R.drawable.ic_launcher);
		
		fragment1Tab.setTabListener(new TabListener(fragment1));
		fragment2Tab.setTabListener(new TabListener(fragment2));
		fragment3Tab.setTabListener(new TabListener(fragment3));
		
		ab.addTab(fragment1Tab);
		ab.addTab(fragment2Tab);
		ab.addTab(fragment3Tab);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
