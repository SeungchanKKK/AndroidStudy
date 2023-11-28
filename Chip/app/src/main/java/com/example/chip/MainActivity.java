package com.example.chip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import com.example.chip.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        ChipClickListener1 chipClickListener1 = new ChipClickListener1();
        activityMainBinding.chip4.setOnClickListener(chipClickListener1);

        ButtonClickListener1 buttonClickListener1 = new ButtonClickListener1();
        activityMainBinding.button.setOnClickListener(buttonClickListener1);

        ChipCheckedChangeListener chipCheckedChangeListener = new ChipCheckedChangeListener();
        activityMainBinding.chip5.setOnCheckedChangeListener(chipCheckedChangeListener);

        //Close 버튼을 눌렀을때
        ChipCLoseClickListener chipCLoseClickListener = new ChipCLoseClickListener();
        activityMainBinding.chip6.setOnCloseIconClickListener(chipCLoseClickListener);
    }

    // Style : Action
    class ChipClickListener1 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            activityMainBinding.textView.setText("첫 번째 Chip을 눌렀습니다\n");
            // Style : Choice
            //체크 상태를 가져온다.
            boolean chk5 = activityMainBinding.chip5.isChecked();

            if(chk5 == true){
                activityMainBinding.textView.append("두번째 Chip : true\n");
            }else {
                activityMainBinding.textView.append("두번째 Chip : false\n");
            }

            // style : Entry
            //체크 상태를 가져온다.
            boolean chk6 = activityMainBinding.chip6.isChecked();
            if (chk6 == true){
                activityMainBinding.textView.append("세번째 Chip : true\n");
            }else {
                activityMainBinding.textView.append("세번째 Chip : false\n");
            }

            // style : Filter
            boolean chk7 = activityMainBinding.chip7.isChecked();
            if (chk7 == true){
                activityMainBinding.textView.append("네번째 Chip : true\n");
            }else {
                activityMainBinding.textView.append("네번째 Chip : false\n");
            }

            //ChipGroup 내에서 체크되어있는 chip의 id를 가져온다
            int chipId = activityMainBinding.chipGroup1.getCheckedChipId();
            switch (chipId){
                case R.id.chip8:
                    activityMainBinding.textView.append("chip8이 선택되었습니다");
                    break;
                case R.id.chip9:
                    activityMainBinding.textView.append("chip9가 선택되었습니다");
                    break;
                case R.id.chip10:
                    activityMainBinding.textView.append("chip10이 선택되었습니다");
                    break;
            }
        }
    }

    class ButtonClickListener1 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //Chip 의 체크 상태를 설정한다
            activityMainBinding.chip5.setChecked(true);
            activityMainBinding.chip6.setChecked(true);
            activityMainBinding.chip7.setChecked(true);

            activityMainBinding.chip8.setChecked(true);
        }
    }

    //체크 상태가 변경됬을때
    class ChipCheckedChangeListener implements CompoundButton.OnCheckedChangeListener{

        @Override
        // 두번째 체크 상태 값
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(b==true){
                activityMainBinding.textView.setText("체크 되었습니다");
            }else {
                activityMainBinding.textView.setText("체크 해제되었습니다");
            }
        }
    }

    //close 버튼 이벤트
    class ChipCLoseClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            activityMainBinding.textView.setText("Close 버튼을 눌렀습니다");
        }
    }
}