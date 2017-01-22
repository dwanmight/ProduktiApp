package com.junior.dwan.produktiapp.ui.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.junior.dwan.produktiapp.R;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import static android.R.attr.key;

public class SplashActivity extends AppCompatActivity{
    Shimmer shimmer;
    ShimmerTextView tvDownload;
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Typeface typeface = Typeface.createFromAsset(getAssets(),getString(R.string.digit_keyboard_font_tatiana));


        mHandler=new Handler();
        tvDownload = (ShimmerTextView) findViewById(R.id.splash_download);
        tvDownload.setTypeface(typeface);
        shimmer = new Shimmer();
        toggleAnimation(tvDownload);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                openTabActivity();
            }
        },3000);
    }

    public void toggleAnimation(View target) {
        if (shimmer != null && shimmer.isAnimating()) {
            shimmer.cancel();
        } else {
            shimmer = new Shimmer();
            shimmer.start(tvDownload);
        }
    }

    private void openTabActivity(){
        Intent intent=new Intent(this,TabActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        toggleAnimation(tvDownload);
        finish();
    }
}
