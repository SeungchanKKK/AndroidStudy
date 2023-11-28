package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.progressbar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        ButtonClickListener1 buttonClickListener1 = new ButtonClickListener1();
        activityMainBinding.button.setOnClickListener(buttonClickListener1);

        ButtonClickListener2 buttonClickListener2 = new ButtonClickListener2();
        activityMainBinding.button2.setOnClickListener(buttonClickListener2);

        ButtonClickListener3 buttonClickListener3 = new ButtonClickListener3();
        activityMainBinding.button3.setOnClickListener(buttonClickListener3);

        ButtonClickListener4 buttonClickListener4 = new ButtonClickListener4();
        activityMainBinding.button4.setOnClickListener(buttonClickListener4);
    }

    class ButtonClickListener1 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            // 현재 값을 가져온다.
            int value = activityMainBinding.progressBar4.getProgress();
            activityMainBinding.textView.setText("value : "+ value);
        }
    }

    class ButtonClickListener2 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //현재 값을 설정한다.
            activityMainBinding.progressBar4.setProgress(140);
        }
    }

    class ButtonClickListener3 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //10만큼 증가
            activityMainBinding.progressBar4.incrementProgressBy(10);
        }
    }

    class ButtonClickListener4 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //10만큼 감소
            activityMainBinding.progressBar4.incrementProgressBy(-10);
        }
    }
}