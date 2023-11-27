package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.radiobutton.databinding.ActivityMainBinding;

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

        ChekedChangeListener1 chekedChangeListener1 = new ChekedChangeListener1();
        activityMainBinding.radioGroup1.setOnCheckedChangeListener(chekedChangeListener1);
        activityMainBinding.radioGroup2.setOnCheckedChangeListener(chekedChangeListener1);

        ButtonClickListener3 buttonClickListener3 = new ButtonClickListener3();
        activityMainBinding.button3.setOnClickListener(buttonClickListener3);
    }

    class ButtonClickListener1 implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            //체크 되어 있는 라디오 버튼의 아이디를 추출한다.
            int checkId = activityMainBinding.radioGroup1.getCheckedRadioButtonId();

            switch (checkId){
                case R.id.radioButton:
                    activityMainBinding.textView.setText("라디오 1-1");
                    break;
                case R.id.radioButton2:
                    activityMainBinding.textView.setText("라디오 1-2");
                    break;
                case R.id.radioButton3:
                    activityMainBinding.textView.setText("라디오 1-3");
                    break;

            }
        }
    }

    class ButtonClickListener2 implements View.OnClickListener{

        @Override
        public void onClick(View view) {

            int checkId =activityMainBinding.radioGroup2.getCheckedRadioButtonId();
            switch (checkId){
                case R.id.radioButton4:
                    activityMainBinding.textView2.setText("라디오 2-1");
                    break;
                case R.id.radioButton6:
                    activityMainBinding.textView2.setText("라디오 2-2");
                    break;
                case R.id.radioButton7:
                    activityMainBinding.textView2.setText("라디오 2-3");
                    break;
            }
        }
    }

    class ChekedChangeListener1 implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            //체크상태가 변경된 라디오 그룹의 아이디를 가져온다.
            int groupId = radioGroup.getId();

            switch (groupId){
                case R.id.radioGroup1:
                    switch (i){
                        case R.id.radioButton:
                            activityMainBinding.textView3.setText("라디오 1-1");
                            break;
                        case R.id.radioButton2:
                            activityMainBinding.textView3.setText("라디오 1-2");
                            break;
                        case R.id.radioButton3:
                            activityMainBinding.textView3.setText("라디오 1-3");
                            break;
                    }
                    break;
                case R.id.radioGroup2:
                    switch (i){
                        case R.id.radioButton4:
                            activityMainBinding.textView3.setText("라디오 2-1");
                            break;
                        case R.id.radioButton6:
                            activityMainBinding.textView3.setText("라디오 2-2");
                            break;
                        case R.id.radioButton7:
                            activityMainBinding.textView3.setText("라디오 2-3");
                            break;
                    }
                    break;
            }
       }
    }

    class ButtonClickListener3 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //체크 상태를 설정한다.
            activityMainBinding.radioButton3.setChecked(true);
            activityMainBinding.radioButton4.setChecked(true);
        }
    }
}