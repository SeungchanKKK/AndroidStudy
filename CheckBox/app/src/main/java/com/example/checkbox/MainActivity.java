package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import com.example.checkbox.databinding.ActivityMainBinding;

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

        CheckedChangeListener checkedChangeListener = new CheckedChangeListener();
        activityMainBinding.checkBox.setOnCheckedChangeListener(checkedChangeListener);
        activityMainBinding.checkBox2.setOnCheckedChangeListener(checkedChangeListener);
        activityMainBinding.checkBox3.setOnCheckedChangeListener(checkedChangeListener);
    }

    class ButtonClickListener1 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //체크박스들의 체크 상태를 가져온다.
            boolean check1 = activityMainBinding.checkBox.isChecked();
            boolean check2 = activityMainBinding.checkBox2.isChecked();
            boolean check3 = activityMainBinding.checkBox3.isChecked();

            activityMainBinding.textView.setText("");

            if (check1==true){
                activityMainBinding.textView.append("첫번째 체크 박스는 체크되어있습니다\n");
            }else {
                activityMainBinding.textView.append("첫번째 체크 박스는 체크되어 있지 않습니다\n");
            }

            if (check2 == true){
                activityMainBinding.textView.append("두 번째 체크 박스는 체크 되어 있습니다\n");
            }else {
                activityMainBinding.textView.append("두 번째 체크 박스는 체크되어 있지 않습니다\n");
            }

            if (check3==true){
                activityMainBinding.textView.append("세번째 체크 박스는 체크되어있습니다");
            }else {
                activityMainBinding.textView.append("세 번째 체크 박스는 체크되어 있지 않습니다");
            }
        }
    }

    class ButtonClickListener2 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //체크 상태를 true 로 설정한다.
            activityMainBinding.checkBox.setChecked(true);
            activityMainBinding.checkBox2.setChecked(true);
            activityMainBinding.checkBox3.setChecked(true);
        }
    }

    class ButtonClickListener3 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //체크 상태를 false 로 설정한다.
            activityMainBinding.checkBox.setChecked(false);
            activityMainBinding.checkBox2.setChecked(false);
            activityMainBinding.checkBox3.setChecked(false);
        }
    }

    class ButtonClickListener4 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            // 체크 상태를 반전시킨다.
            activityMainBinding.checkBox.toggle();
            activityMainBinding.checkBox2.toggle();
            activityMainBinding.checkBox3.toggle();
        }
    }

    class CheckedChangeListener implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            // 체크 상태가 변경된 checkbox의 id를 추출한다.
            int checkboxId = compoundButton.getId();

            //id로 분기한다
            switch (checkboxId){
                case R.id.checkBox:
                    if (b == true){
                        activityMainBinding.textView.setText("첫 번째 체크박스가 체크되었습니다");
                    } else {
                        activityMainBinding.textView.setText("첫 번째 체크박스가 해제되었습니다");
                    }
                    break;
                case R.id.checkBox2:
                    if (b == true){
                        activityMainBinding.textView.setText("두번째 체크박스가 체크되었습니다");
                    } else {
                        activityMainBinding.textView.setText("두번째 체크박스가 해제되었습니다");
                    }
                    break;
                case R.id.checkBox3:
                    if (b == true){
                        activityMainBinding.textView.setText("세 번째 체크박스가 체크되었습니다");
                    } else {
                        activityMainBinding.textView.setText("세 번째 체크바그가 해제되었습니다");
                    }
                    break;
            }
        }
    }
}