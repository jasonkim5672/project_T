package com.pr.T;


import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;

public class SplashActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	 requestWindowFeature(Window.FEATURE_NO_TITLE);
         super.onCreate(savedInstanceState);
         setContentView(R.layout.splash);
         
         Handler x = new Handler();
         x.postDelayed(new splashhandler(), 2000); //1.5초뒤에 다른 엑티비티로...
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.splash, menu);
        return true;
    }
    
    class splashhandler implements Runnable {
        @Override
        public void run() {
			Intent intent_start = new Intent(SplashActivity.this, MainActivity.class);
			startActivity(intent_start);

            finish();
        }        
    }
}
