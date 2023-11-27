package com.example.includeotherlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.includeotherlayout.databinding.ActivityMainBinding;
import com.example.includeotherlayout.databinding.SecondBinding;
import com.example.includeotherlayout.databinding.ThirdBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    SecondBinding secondBinding;
    ThirdBinding thirdBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        secondBinding = SecondBinding.inflate(getLayoutInflater());
        thirdBinding = ThirdBinding.inflate(getLayoutInflater());

        setContentView(activityMainBinding.getRoot());
        activityMainBinding.textView2.setText("첫번쨰문자");
//        secondBinding.textView.setText("두번째문자");
//        thirdBinding.textView3.setText("세번째문자");
        activityMainBinding.secondLayout.textView2.setText("두번째문자");
        activityMainBinding.thirdLayout.textView3.setText("세번째문자");
    }
}