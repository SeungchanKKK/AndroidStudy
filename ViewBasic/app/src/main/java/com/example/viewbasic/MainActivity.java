package com.example.viewbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1;

    TextView text1;

    class BtnListner implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            text1.setText("버튼을 눌렀습니다");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button);
        text1 = findViewById(R.id.textView);

        BtnListner listner1 = new BtnListner();
        btn1.setOnClickListener(listner1);
    }
}