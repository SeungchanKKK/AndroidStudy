package com.example.floatingactionbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.floatingactionbutton.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        FloatingClickListener floatingClickListener = new FloatingClickListener();
        activityMainBinding.floatingActionButton.setOnClickListener(floatingClickListener);
    }

    // FloatingActionButton을 눌렀을 때
    class FloatingClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            activityMainBinding.textView.setText("FloatingActionButton을 눌렀습니다");
        }
    }
}