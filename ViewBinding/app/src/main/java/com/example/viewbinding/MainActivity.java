package com.example.viewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.TagLostException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.viewbinding.databinding.ActivityMainBinding;
import com.example.viewbinding.databinding.ActivitySecondBinding;

public class MainActivity extends AppCompatActivity {

    // View의 주소 값

//    Button button1;
//    TextView textView1;

    //ViewBing 객체를 담을 변수
    ActivityMainBinding activityMainBinding;
    ActivitySecondBinding activitySecondBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //ViewBinding 객체를 추출한다.
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

       // activitySecondBinding = ActivitySecondBinding.inflate(getLayoutInflater());
       // setContentView(activitySecondBinding.getRoot());

        //view 주소값 가져오기
//        button1 = findViewById(R.id.button3);
//        textView1 = findViewById(R.id.textView);
//
       ButtonClickListener1 buttonClickListener1 = new ButtonClickListener1();
//        button1.setOnClickListener(buttonClickListener1);
        activityMainBinding.button.setOnClickListener(buttonClickListener1);
    }

    class ButtonClickListener1 implements View.OnClickListener{

        @Override
        public void onClick(View v) {
        //    textView1.setText("버튼을 눌렀습니다.");
            activityMainBinding.textView.setText("버튼을 눌렀습니다");
        }
    }
}