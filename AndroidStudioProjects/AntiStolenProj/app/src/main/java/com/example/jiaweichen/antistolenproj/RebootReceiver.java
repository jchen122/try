package com.example.jiaweichen.antistolenproj;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class RebootReceiver extends BroadcastReceiver {
    public RebootReceiver() {
    }
    String currentSim;
    TelephonyManager tm;
    SharedPreferences sp;
    SmsManager sm;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        tm=(TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        currentSim=tm.getSimSerialNumber();
        Toast.makeText(context,"SIM :"+currentSim,Toast.LENGTH_LONG).show();
        Log.i("Look at here:", currentSim);

        sp=context.getSharedPreferences("MY_SP",context.MODE_PRIVATE);
        String preSim=sp.getString("simNum","");

        sm = SmsManager.getDefault();

        if(currentSim.equals(preSim)){
            sm.sendTextMessage("3124474096",null,"Safe,Current SIM is "+currentSim,null,null);

            Toast.makeText(context,"Same SIM",Toast.LENGTH_LONG).show();
        } else {
            //Log.d("SIM Changed", "!!!");
            sm.sendTextMessage("3124474096",null,"SIM Changed, Current SIM is "+currentSim,null,null);

            SharedPreferences.Editor editor=sp.edit();
            editor.putString("simNum",currentSim);
            editor.commit();
            Toast.makeText(context,"Changed SIM",Toast.LENGTH_LONG).show();

        }





    }
}
