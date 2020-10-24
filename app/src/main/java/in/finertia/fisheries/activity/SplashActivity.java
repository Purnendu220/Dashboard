package in.finertia.fisheries.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import in.finertia.fisheries.R;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i;
                if(getSharedPreferences(getPackageName(), Context.MODE_PRIVATE).
                        getBoolean("isOneTime", true)) {
                    i = new Intent(SplashActivity.this, LanguageSelectionActivity.class);
                }else{
                    i = new Intent(SplashActivity.this, LoginActivity.class);
                }
                startActivity(i);
                finish();
            }
        }, 4000);
    }

}
