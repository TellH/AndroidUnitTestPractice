package com.tellh.unittestpractice;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnDialog;
    Button btnToast;
    LinearLayout activitySecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }

    private void initView() {
        btnDialog = (Button) findViewById(R.id.btn_dialog);
        btnToast = (Button) findViewById(R.id.btn_toast);
        activitySecond = (LinearLayout) findViewById(R.id.activity_second);

        btnDialog.setOnClickListener(this);
        btnToast.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_dialog:
                new AlertDialog.Builder(this).setTitle("Test Dialog")
                        .setMessage("Hello World!").show();
                break;
            case R.id.btn_toast:
                Toast.makeText(this, "Hello World!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
