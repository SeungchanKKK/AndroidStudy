package com.example.aswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import com.example.aswitch.databinding.ActivityMainBinding;

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

        SwitchCheckedChangeListener1 switchCheckedChangeListener1 = new SwitchCheckedChangeListener1();
        activityMainBinding.switch1.setOnCheckedChangeListener(switchCheckedChangeListener1);
        activityMainBinding.switch2.setOnCheckedChangeListener(switchCheckedChangeListener1);
    }

    class ButtonClickListener1 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //스위치의 상태값을 가져오기.
            boolean chk1 = activityMainBinding.switch1.isChecked();

            if (chk1 == true){
                activityMainBinding.textView.setText("ON 상태입니다");
            } else {
                activityMainBinding.textView.setText("OFF 상태입니다");
            }
        }
    }

    class ButtonClickListener2 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //ON 상태로 설정한다.
            activityMainBinding.switch1.setChecked(true);
        }
    }

    class ButtonClickListener3 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //OFF 상태로 설정한다.
            activityMainBinding.switch1.setChecked(false);
        }
    }

    //스위치의 ON/OFF 상태가 변경될때..
    class SwitchCheckedChangeListener1 implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            //상태가 변경된 스위치의 ID를 추출한다.
            int switchId = compoundButton.getId();

            switch(switchId){
                case R.id.switch1:
                    //ON/OFF 에 따른 분기
                    if (b==true){
                        activityMainBinding.textView.setText("스위치 1 : ON");
                    }else {
                        activityMainBinding.textView.setText("스위치 1 : OFF");
                    }
                    break;
                case R.id.switch2:
                    //ON/OFF 에 따른 분기
                    if (b==true){
                        activityMainBinding.textView2.setText("스위치 2 : ON");
                    }else {
                        activityMainBinding.textView2.setText("스위치 2 : OFF");
                    }
                    break;
            }
        }
    }
}