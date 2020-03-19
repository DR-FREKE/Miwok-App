package com.example.android.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goto);

        Bundle extra = getIntent().getExtras();

        if(extra == null){
            return;
        }else {
            String data = extra.getString("myText").toString();
            TextView textView = (TextView) findViewById(R.id.mytext);
            textView.setText(data);
        }
    }
}
