package com.example.fireball;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements ShakeDetector.OnShakeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShakeDetector shakeDetector = new ShakeDetector(this);
        shakeDetector.setOnShakeListener(this);
    }

    int tapCounter = 0;

    public void tap(View view) {

       // if (tapCounter == 1) {
        //    finish();
        //    Toast.makeText(this,"Too many questions", Toast.LENGTH_SHORT).show();
        //}


        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        FrameLayout fl = (FrameLayout) this.findViewById(R.id.window);
        fl.startAnimation(shake);


        TextView text = (TextView) this.findViewById(R.id.message);

        Animation in = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in);
        text.startAnimation(in);

        int res = (int) (Math.random() * 4);

        switch (res) {
            case 0:
                text.setText(R.string.lusck);
                break;
            case 1:
                text.setText(R.string.luck);
                break;
            case 2:
                text.setText(R.string.bad);
                break;
            case 3:
                text.setText(R.string.luck);
                break;
        }
        tapCounter++;
    }

    @Override
    public void onShake() {
        tap(null);
    }
}