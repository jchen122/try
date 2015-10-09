package com.example.jiaweichen.myproj;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class SecondActivity extends AppCompatActivity {

    public Button save;
    public EditText secondName;
    public EditText secondPhone;
    public CheckBox secondCar;
    public CheckBox secondHouse;
    String gender,asset="";
    public RadioGroup secondGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        save=(Button)findViewById(R.id.second_save);
        secondName=(EditText)findViewById(R.id.second_edit_name);
        secondPhone=(EditText)findViewById(R.id.second_edit_phone);
        secondCar =(CheckBox)findViewById(R.id.second_car);
        secondHouse=(CheckBox)findViewById(R.id.second_house);
        secondGender=(RadioGroup)findViewById(R.id.second_radio_group);

        secondGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.second_male) {
                    gender = "Male";
                } else if (checkedId == R.id.second_female) {
                    gender = "Female";
                }
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (secondCar.isChecked()) {
                    asset += "car";
                }
                if (secondHouse.isChecked()) {
                    asset += "house";
                }
                String inputName=secondName.getText().toString();
                String inputPhone=secondPhone.getText().toString();
                String inputGender=gender;
                String inputAsset=asset;

                Intent intent=new Intent(SecondActivity.this, Confirmation.class);
                intent.putExtra("name",inputName);
                intent.putExtra("phone",inputPhone);
                intent.putExtra("gender",gender);
                intent.putExtra("asset",asset);
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
