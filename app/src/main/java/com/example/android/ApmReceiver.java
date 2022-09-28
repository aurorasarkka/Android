package com.example.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ApmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        boolean state = intent.getBooleanExtra("state", false);
        Log.e("Toimii", String.valueOf(state));

      CharSequence text = "Lentokonetila päällä";
      int duration = Toast.LENGTH_LONG;

      Toast toast = Toast.makeText(context, text, duration);
      toast.show();
      if (state){
          state = true; //On
      }
      else{
          state = false; //OF
      }



    }
}