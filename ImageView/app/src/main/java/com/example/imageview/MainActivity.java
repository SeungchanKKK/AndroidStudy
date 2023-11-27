package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.imageview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        ButtonClickListener buttonClickListener = new ButtonClickListener();
        activityMainBinding.button.setOnClickListener(buttonClickListener);
    }

    class ButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //이미지 뷰에 이미지 설정.
            activityMainBinding.imageView3.setImageResource(R.drawable.img_android);
        }
    }
}