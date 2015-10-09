package com.example.secondandroid_db;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	public Button save;
	public Button show;
	public EditText mainName;
	public EditText mainPhoneNumber;
	public EditText mainSubject;
	public ListView mainListView;
	public DBHelper dbHelper;
	public SQLiteDatabase db;
	public ArrayList<String> list= new ArrayList<String>();
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mainName=(EditText)findViewById(R.id.main_name_text);
        mainPhoneNumber=(EditText)findViewById(R.id.main_phone_number_text);
        mainSubject=(EditText)findViewById(R.id.main_subject_text);
        
        save=(Button) findViewById(R.id.main_save);
        show=(Button) findViewById(R.id.main_show);
        mainListView=(ListView)findViewById(R.id.main_list_show);
        
        dbHelper=new DBHelper(this);
        
        save.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				db=dbHelper.getWritableDatabase();
				ContentValues cv =new ContentValues();
				cv.put(dbHelper.NAME, mainName.getText().toString());
				cv.put(dbHelper.PHONE, mainPhoneNumber.getText().toString());
				cv.put(dbHelper.SUBJECT, mainSubject.getText().toString());
				db.insert(dbHelper.TABLE_NAME, null, cv);
				
				Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_LONG).show();
				
				//clean the input values
				mainName.setText("");
				mainPhoneNumber.setText("");
				mainSubject.setText("");
				
			}
		});
        
        show.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				list.clear();
				db=dbHelper.getReadableDatabase();
				String [] cols={dbHelper.NAME,DBHelper.PHONE,dbHelper.SUBJECT};
				Cursor c =db.query(dbHelper.TABLE_NAME,cols,null,null,null,null,null,null);
				c.moveToFirst();
				ArrayAdapter <String> aa= new ArrayAdapter<String>(MainActivity.this,
						R.layout.row_arrangement,R.id.row_arrangement_text_view,list);
				mainListView.setAdapter(aa);
				do{
					String name =c.getString(c.getColumnIndex(dbHelper.NAME));
					String phone =c.getString(c.getColumnIndex(dbHelper.PHONE));
					String subject =c.getString(c.getColumnIndex(dbHelper.SUBJECT));
					list.add(name+"\n"+phone+"\n"+subject);
					aa.notifyDataSetChanged();
				}while(c.moveToNext());
				
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
