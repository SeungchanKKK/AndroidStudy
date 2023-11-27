package com.example.checkedtextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.example.checkedtextview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        //체크박스 구현을 위한 리스너 설정
        CheckboxClickListener1 checkboxClickListener1 = new CheckboxClickListener1();
        activityMainBinding.checkbox.setOnClickListener(checkboxClickListener1);
        activityMainBinding.checkbox2.setOnClickListener(checkboxClickListener1);
        activityMainBinding.checkbox3.setOnClickListener(checkboxClickListener1);

        // 라디오 구현을 위한 리스너 설정
        RadioClickListener1 radioClickListener1 = new RadioClickListener1();
        activityMainBinding.radio1.setOnClickListener(radioClickListener1);
        activityMainBinding.radio2.setOnClickListener(radioClickListener1);
        activityMainBinding.radio3.setOnClickListener(radioClickListener1);

        //체크박스 상태확인
        ButtonClickListener1 buttonClickListener1 = new ButtonClickListener1();
        activityMainBinding.button.setOnClickListener(buttonClickListener1);

        //라디오 상태확인
        ButtonClickListener2 buttonClickListener2 = new ButtonClickListener2();
        activityMainBinding.button2.setOnClickListener(buttonClickListener2);

        ButtonClickListener3 buttonClickListener3 = new ButtonClickListener3();
        activityMainBinding.button3.setOnClickListener(buttonClickListener3);

        ButtonClickListener4 buttonClickListener4 = new ButtonClickListener4();
        activityMainBinding.button4.setOnClickListener(buttonClickListener4);


    }

    class CheckboxClickListener1 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            // 형변환
            CheckedTextView checkedTextView = (CheckedTextView)view;
            checkedTextView.toggle();
        }
    }

    //라디오 구현을 위한 리스너
    class RadioClickListener1 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            // 모든 radio를 off로 설정한다.
            activityMainBinding.radio1.setChecked(false);
            activityMainBinding.radio2.setChecked(false);
            activityMainBinding.radio3.setChecked(false);

            // 사용자가 터치한 radio를 true 로 설정한다
            CheckedTextView checkedTextView = (CheckedTextView) view;
            checkedTextView.setChecked(true);
        }
    }

    class ButtonClickListener1 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //체크 상태 값을 모두 가져온다.
            boolean chk1 =activityMainBinding.checkbox.isChecked();
            boolean chk2 =activityMainBinding.checkbox2.isChecked();
            boolean chk3 =activityMainBinding.checkbox3.isChecked();

            activityMainBinding.textView.setText("");

            if (chk1 == true){
                activityMainBinding.textView.append("첫번째 체크박스가 체크되어있습니다\n");
           }else {
                activityMainBinding.textView.append("첫번째 체크 박스가 체크되어 있지 않습니다\n");
            }
            if (chk2 == true){
                activityMainBinding.textView.append("두번째 체크박스가 체크되어있습니다\n");
            }else {
                activityMainBinding.textView.append("두번째 체크 박스가 체크되어 있지 않습니다\n");
            }
            if (chk3 == true){
                activityMainBinding.textView.append("세번째 체크박스가 체크되어있습니다\n");
            }else {
                activityMainBinding.textView.append("세번째 체크 박스가 체크되어 있지 않습니다\n");
            }
        }
    }

    class ButtonClickListener2 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //체크 상태 값을 모두 가져온다.
            boolean chk1 =activityMainBinding.radio1.isChecked();
            boolean chk2 =activityMainBinding.radio2.isChecked();
            boolean chk3 =activityMainBinding.radio3.isChecked();

            if (chk1 == true){
                activityMainBinding.textView.setText("첫번째 라디오가 선택되어 있습니다");
            }else if(chk2 == true){
                activityMainBinding.textView.setText("두번째 라디오가 선택되어 있습니다");
            }else if(chk3 == true){
                activityMainBinding.textView.setText("세번째 라디오가 선택되어 있습니다");
            }
        }
    }

    class ButtonClickListener3 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            activityMainBinding.checkbox.setChecked(true);
            activityMainBinding.checkbox2.setChecked(false);
            activityMainBinding.checkbox3.setChecked(true);
        }
    }

    class ButtonClickListener4 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //라디오인 경우 원하는것 하나만 true로 설정 나머지는 false로 설정한다.
            activityMainBinding.radio1.setChecked(false);
            activityMainBinding.radio2.setChecked(false);
            activityMainBinding.radio3.setChecked(true);
        }
    }
}