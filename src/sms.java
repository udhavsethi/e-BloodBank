package com.example.e_bloodbank;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.BroadcastReceiver;
import android.telephony.SmsMessage;
import android.util.Log;
import android.content.Context;
import android.telephony.SmsMessage;
 
public class SMS extends Activity 
{
    Button btnSendSMS;
    EditText txtPhoneNo;
    EditText txtMessage;
 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms);        
 
        btnSendSMS = (Button) findViewById(R.id.btnSendSMS);
        txtPhoneNo = (EditText) findViewById(R.id.txtPhoneNo);
 
        btnSendSMS.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {                
                String phoneNo = txtPhoneNo.getText().toString();                 
                if (phoneNo.length()>0)                
                    sendSMS(phoneNo, phoneNo);               
                else
                    Toast.makeText(getBaseContext(), 
                        "Please enter a valid Phone Number.", 
                        Toast.LENGTH_SHORT).show();
            }
        });        
    }
    private void sendSMS(String phoneNumber, String message)
    {        
        PendingIntent pi = PendingIntent.getActivity(this, 0,
            new Intent(this, SMS.class), 0);                
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, pi, null);        
    }
}

class SMSBroadcastReceiver extends BroadcastReceiver {

    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    private static final String TAG = "SMSBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
         Log.i(TAG, "Intent recieved: " + intent.getAction());
         Toast.makeText(context, "Message recieved", 7000).show();
            if (intent.getAction().equals(SMS_RECEIVED)) {
                Bundle bundle = intent.getExtras();
                if (bundle != null) {
                    Object[] pdus = (Object[])bundle.get("pdus");
                    final SmsMessage[] messages = new SmsMessage[pdus.length];
                    for (int i = 0; i < pdus.length; i++) {
                        messages[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                    }
                    if (messages.length > -1) {
                        Toast.makeText(context, "Message recieved: " + messages[0].getMessageBody(), 7000).show();
                    }
                }
            }
       }
}
