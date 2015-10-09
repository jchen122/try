package com.example.jiaweichen.telephonyproj;

import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{

    public TextView phoneNumber,IEMI,sim,phoneType,softwareVersion;
    TelephonyManager tm;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        phoneNumber=(TextView)findViewById(R.id.main_phone_number);
        IEMI=(TextView)findViewById(R.id.main_IEMI);
        sim=(TextView)findViewById(R.id.main_sim);
        phoneType=(TextView)findViewById(R.id.main_phone_type);
        softwareVersion=(TextView)findViewById(R.id.main_software_version);

        tm= (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        String ph =tm.getLine1Number();
        phoneNumber.setText("Phone Number: "+ph);

        String iemi=tm.getDeviceId();
        IEMI.setText("IMEI ID: "+iemi);

        String simNumber=tm.getSimSerialNumber();
        sim.setText("Sim ID: "+simNumber);

        int phType=tm.getPhoneType();
        switch (phType){
            case TelephonyManager.PHONE_TYPE_CDMA:
                phoneType.setText("This is a CDMA Phone" );
                break;
            case TelephonyManager.PHONE_TYPE_GSM:
                phoneType.setText("This is a GSM Phone");
                break;
                default:
                    break;
        }

        String sv=tm.getDeviceSoftwareVersion();
        softwareVersion.setText("Software Version: " + sv);




        tts=new TextToSpeech(this,this);


        PhoneStateListener psl =new PhoneStateListener(){
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                super.onCallStateChanged(state, incomingNumber);
                if (state == TelephonyManager.CALL_STATE_RINGING){
                    Toast.makeText(MainActivity.this,"It From "+incomingNumber,Toast.LENGTH_LONG).show();
                    tts.speak("hello Jason"+incomingNumber, TextToSpeech.QUEUE_FLUSH, null);


                }
                if(state==TelephonyManager.CALL_STATE_IDLE){
                    Toast.makeText(MainActivity.this,"No Call",Toast.LENGTH_LONG).show();
                }
                if (state==TelephonyManager.CALL_STATE_OFFHOOK){
                    Toast.makeText(MainActivity.this,"Call Finished/ Disconnected",Toast.LENGTH_LONG).show();
                }
            }
        };
        tm.listen(psl, PhoneStateListener.LISTEN_CALL_STATE);




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

    @Override
    public void onInit(int status) {

        if (status==TextToSpeech.SUCCESS){
           int res=tts.setLanguage(Locale.US);

        if(res==TextToSpeech.LANG_MISSING_DATA || res==TextToSpeech.LANG_NOT_SUPPORTED){
Toast.makeText(MainActivity.this,"Data Missing or language not support",Toast.LENGTH_LONG).show();
        }}
    }



}
