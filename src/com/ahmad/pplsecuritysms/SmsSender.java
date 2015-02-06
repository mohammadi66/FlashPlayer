package com.ahmad.pplsecuritysms;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsSender extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sms_sender);
		
		final EditText txt_number = (EditText) findViewById(R.id.editTextPhoneNo);
        final EditText txt_text = (EditText) findViewById(R.id.editTextSMS);
        Button btn_send = (Button) findViewById(R.id.buttonSend);
        btn_send.setOnClickListener(new View.OnClickListener() {
 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
 
                String phoneNo = txt_number.getText().toString();
                String sms = txt_text.getText().toString();
                try {
                    SmsManager smsmanager = SmsManager.getDefault();
                    smsmanager.sendTextMessage(phoneNo, null, sms, null, null);
                    Toast.makeText(getApplicationContext(), "SMS Sent", 1)
                            .show();
                 
 
                } catch (Exception e) {
                    // TODO: handle exception
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again later!",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
 
            }
        });
		
	}

}
