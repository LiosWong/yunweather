package com.yunweather.android.activity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import com.yunweather.android.R;
public class BeginActivity extends Activity{
	private static final int LOAD_DISPLAY_TIME = 1500;
	public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.RGBA_8888);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.begin);

        new Handler().postDelayed(new Runnable() {
            public void run() {
           /* Create an Intent that will start the Main WordPress Activity. */
                Intent mainIntent = new Intent(BeginActivity.this,WeatherActivity.class);
                BeginActivity.this.startActivity(mainIntent);
                BeginActivity.this.finish();
            }
        }, LOAD_DISPLAY_TIME); //1500 for release
    }
}