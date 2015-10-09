package com.example.register;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends Activity {
	public EditText thirdName;
	public EditText thirdAge;
	public EditText thirdGender;
	public EditText thirdAsset;
	String nameAtThird;
	String ageAtThird;
	String genderAtThird;
	String assetAtThird;
	public Button thirdBack;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		
		thirdName=(EditText) findViewById(R.id.third_edit_name);
		nameAtThird=getIntent().getExtras().getString("name");
		thirdName.setText(nameAtThird);
		
		thirdAge=(EditText) findViewById(R.id.third_edit_age);
		ageAtThird=getIntent().getExtras().getString("age");
		thirdAge.setText(ageAtThird);
		
		thirdGender=(EditText) findViewById(R.id.third_edit_gender);
		genderAtThird=getIntent().getExtras().getString("gender");
		thirdGender.setText(genderAtThird);
		
		thirdAsset=(EditText) findViewById(R.id.third_edit_asset);
		assetAtThird=getIntent().getExtras().getString("asset");
		thirdAsset.setText(assetAtThird);
		
		thirdBack=(Button) findViewById(R.id.third_back);
		
		thirdBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(ThirdActivity.this,MainActivity.class);
				startActivity(intent);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.third, menu);
		return true;
	}

}
