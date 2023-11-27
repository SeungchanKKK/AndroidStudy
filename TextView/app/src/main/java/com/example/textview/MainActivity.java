package com.example.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.textview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        //문자열 설정
        activityMainBinding.textView2.setText("안녕하세여");

        // 문자열 가져오기
        String str =activityMainBinding.textView2.getText().toString();
        System.out.println(str);

        //배경색상 설정
        //activityMainBinding.textView2.setBackgroundColor(Color.RED);
        activityMainBinding.textView2.setBackgroundColor(Color.rgb(0,255,191));
   }
}