package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.example.seekbar.databinding.ActivityMainBinding;

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

        SeekBarChangeListener seekBarChangeListener = new SeekBarChangeListener();
        activityMainBinding.seekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        activityMainBinding.seekBar2.setOnSeekBarChangeListener(seekBarChangeListener);
    }

    class ButtonClickListener1 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            // SeekBar에 설정된 값을 가져온다.
            int value1 = activityMainBinding.seekBar.getProgress();
            int value2 = activityMainBinding.seekBar2.getProgress();

            activityMainBinding.textView.setText("seekbar1 : " + value1);
            activityMainBinding.textView2.setText("seekbar2 : " + value2);
        }
    }

    class ButtonClickListener2 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //값을 설정한다
            activityMainBinding.seekBar.setProgress(1);

            //안드로이드 누가 버전이상인 경우
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N){
                activityMainBinding.seekBar2.setProgress(9, true);
            } else {
                activityMainBinding.seekBar.setProgress(9);
            }
        }
    }

    class ButtonClickListener3 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //1 증가
            activityMainBinding.seekBar.incrementProgressBy(1);
            activityMainBinding.seekBar2.incrementProgressBy(1);
        }
    }

    class ButtonClickListener4 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //1 감소
            activityMainBinding.seekBar.incrementProgressBy(-1);
            activityMainBinding.seekBar2.incrementProgressBy(-1);
        }
    }

    // Seekbar의 값이 변경되었을 때
    class SeekBarChangeListener implements SeekBar.OnSeekBarChangeListener{
        // 값이 변경된 후
        @Override
        //첫 번쨰 : 값이 설정된 seekbar
        //두 번째 : 설정된값
        //세 번째 : 사용자 변경 여부
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            //값이 변경된 seekbar의 아이디
            int seekBarId = seekBar.getId();

            switch (seekBarId){
                case R.id.seekBar:
                    activityMainBinding.textView.setText("첫 번째 SeekBar : " + i + "\n");
                    break;
                case R.id.seekBar2:
                    activityMainBinding.textView.setText("두 번째 SeekBar : " + i + "\n");
                    break;
            }

            //사용자가 설정했는지
            if (b == true){
                activityMainBinding.textView.append("사용자에의한 설정");
            }else {
                activityMainBinding.textView.append("코드에의한 설정");
            }
        }
        // 사용자가 값 설정을 위해 터치 했을 때
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // 사용자가 터치한 seekbar 의 id를 가져온다.
            int seekBarId = seekBar.getId();
            switch (seekBarId){
                case R.id.seekBar:
                    activityMainBinding.textView2.setText("첫 번째 seekbar 터치");
                break;
                case R.id.seekBar2:
                    activityMainBinding.textView2.setText("두 번째 seekbar 터치");
                break;
            }
        }
        // 사용자가 값 설정을 위해 터치 한 후 떼었을 때
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            int seekBarId = seekBar.getId();
            switch (seekBarId){
                case R.id.seekBar:
                    activityMainBinding.textView2.setText("첫 번째 seekbar 터치 종료");
                    break;
                case R.id.seekBar2:
                    activityMainBinding.textView2.setText("두 번째 seekbar 터치 종료");
                    break;
            }
        }
    }
}