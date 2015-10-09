package com.example.jiaweichen.broadcastproj;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;


public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Bundle bd =intent.getExtras();
        if(bd!=null){
            Object [] pdus= (Object[]) bd.get("pdus");
            for (int i=0;i<pdus.length;i++){
                SmsMessage sg = SmsMessage.createFromPdu((byte[]) pdus[i]);
                String msg =sg.getDisplayMessageBody();
                String phoneNumber=sg.getDisplayOriginatingAddress();
                Toast.makeText(context,"Msg is" +msg+ "   Number:"+phoneNumber,Toast.LENGTH_LONG);

            }
        }


    }
}
