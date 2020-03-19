package com.example.android.test;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView1, textView2, textView3, textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        PagerAdapter adapter = new FixedPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabSlider);
        tabLayout.setupWithViewPager(viewPager);
//        textView1 = (TextView) findViewById(R.id.numbers);
//        textView2 = (TextView) findViewById(R.id.members);
//        textView3 = (TextView) findViewById(R.id.colors);
//        textView4 = (TextView) findViewById(R.id.phrases);
//
//        if(textView1 != null){
//            textView1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(MainActivity.this, NumbersActivity.class);
//                    if(intent.resolveActivity(getPackageManager()) != null){
//                        startActivity(intent);
//                    }else{
//                        Toast.makeText(getApplicationContext(), "Can't find page", Toast.LENGTH_SHORT).show();
//
//                    }
//                }
//            });
//        }
//        if(textView2 != null){
//            textView2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(MainActivity.this, FamilyActivity.class);
//                    if(intent.resolveActivity(getPackageManager()) != null){
//                        startActivity(intent);
//                    }else{
//                        Toast.makeText(getApplicationContext(), "Can't find page", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//        }
//        if(textView3 != null){
//            textView3.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(MainActivity.this, ColorsActivity.class);
//                    if(intent.resolveActivity(getPackageManager()) != null){
//                        startActivity(intent);
//                    }else{
//                        Toast.makeText(getApplicationContext(), "Can't find page", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//        }
//
//        if(textView4 != null){
//            textView4.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(MainActivity.this, PhrasesActivity.class);
//                    if(intent.resolveActivity(getPackageManager()) != null){
//                        startActivity(intent);
//                    }else{
//                        Toast.makeText(getApplicationContext(), "Can't find page", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//        }
    }

}
