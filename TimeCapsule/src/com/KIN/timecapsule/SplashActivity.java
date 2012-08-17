package com.KIN.timecapsule;


import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;
  
public class SplashActivity extends Activity {

   

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.splash, menu);
        return true;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
        Handler x = new Handler();
        x.postDelayed(new splashhandler(), 1500);
    }

    class splashhandler implements Runnable {
        @Override
        public void run() {
			Intent intent_menu = new Intent(SplashActivity.this, MenuActivity.class);
			startActivity(intent_menu);
            finish();
        }        
    }
}
