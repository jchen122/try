package com.example.register;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;


public class SecondActivity extends Activity {
	
	public Button secondSubmit;
	public EditText secondName;
	public EditText secondAge;
	
	String gender="Male";
	public RadioGroup secondGender;
	
	public CheckBox secondCar;
	public CheckBox secondHouse;
	
	String asset="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		secondSubmit=(Button)findViewById(R.id.second_submit);
		secondName=(EditText) findViewById(R.id.second_edit_name);
		secondAge=(EditText) findViewById(R.id.second_edit_age);
		
		
		
		secondGender=(RadioGroup)findViewById(R.id.radioGroup1);
		
		secondGender.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if(checkedId==R.id.second_male){
					gender="Male";
				}
				else gender="Female";
			}
		});
	
		secondCar=(CheckBox)findViewById(R.id.second_car);
		secondHouse=(CheckBox)findViewById(R.id.second_house);
		
		
		
		secondSubmit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (secondCar.isChecked()){
					asset+="car";
				}
				if (secondHouse.isChecked()){
					asset+="house";
				}
				
				String inputName=secondName.getText().toString();
				String inputAge=secondAge.getText().toString();
				String inputGender=gender;
				String inputAsset=asset;
				
				Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
				
				intent.putExtra("name", inputName);
				intent.putExtra("age", inputAge);
				intent.putExtra("gender", inputGender);
				intent.putExtra("asset", inputAsset);
				startActivity(intent);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

}
