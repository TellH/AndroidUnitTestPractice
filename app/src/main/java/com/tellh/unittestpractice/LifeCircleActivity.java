package com.tellh.unittestpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class LifeCircleActivity extends AppCompatActivity {

    public boolean isCreated;
    public boolean isStarted;
    public boolean isResumed;
    public boolean isPaused;
    public boolean isStopped;
    public boolean isDestroyed;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_circle);
        tvDisplay = (TextView) findViewById(R.id.tv_display);
        isCreated = true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        isStarted = true;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tvDisplay.setText(savedInstanceState.getString("display"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        isResumed = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isPaused = true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("display", String.valueOf(tvDisplay.getText()));
    }

    @Override
    protected void onStop() {
        super.onStop();
        isStopped = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isDestroyed = true;
    }
}
