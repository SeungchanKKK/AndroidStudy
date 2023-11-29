package com.example.ratingbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;

import com.example.ratingbar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        ButtonClcikListener1 buttonClcikListener1 = new ButtonClcikListener1();
        activityMainBinding.button.setOnClickListener(buttonClcikListener1);

        ButtonClickLiestener2 buttonClickLiestener2 = new ButtonClickLiestener2();
        activityMainBinding.button2.setOnClickListener(buttonClickLiestener2);

        //RatingBar 값이 변경되었을때
        RatingBarChangedListener ratingBarChangedListener = new RatingBarChangedListener();
        activityMainBinding.ratingBar.setOnRatingBarChangeListener(ratingBarChangedListener);
        activityMainBinding.ratingBar2.setOnRatingBarChangeListener(ratingBarChangedListener);
        activityMainBinding.ratingBar3.setOnRatingBarChangeListener(ratingBarChangedListener);
        activityMainBinding.ratingBar4.setOnRatingBarChangeListener(ratingBarChangedListener);
    }

    class ButtonClcikListener1 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //rating 바의 값을 가져온다.
            float rating =activityMainBinding.ratingBar.getRating();
            float rating2 =activityMainBinding.ratingBar2.getRating();
            float rating3 =activityMainBinding.ratingBar3.getRating();
            float rating4 =activityMainBinding.ratingBar4.getRating();

            activityMainBinding.textView.setText("Rating1 : "+ rating + "\n");
            activityMainBinding.textView.append("Rating2 : "+ rating2 + "\n");
            activityMainBinding.textView.append("Rating3 : "+ rating3 + "\n");
            activityMainBinding.textView.append("Rating4 : "+ rating4 + "\n");
        }
    }

    class ButtonClickLiestener2 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            // RatingBar 에 값을 설정한다.
            activityMainBinding.ratingBar.setRating(1.0f);
            activityMainBinding.ratingBar2.setRating(2.0f);
            activityMainBinding.ratingBar3.setRating(3.5f);
            activityMainBinding.ratingBar4.setRating(4.0f);
        }
    }

    // RatingBar 의 값을 설정했을 때
    class RatingBarChangedListener implements RatingBar.OnRatingBarChangeListener{

        @Override
        // 첫 번쨰 : 값이 변경된 RatingBar
        // 두 번째 : 설정된 값
        // 세 번째 : 사용자 설정 여부(true : 사용자가 설정한것)
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            int ratingBarId = ratingBar.getId();

            switch (ratingBarId){
                case R.id.ratingBar:
                    activityMainBinding.textView.setText("Rating 1");
                    break;
                case R.id.ratingBar2:
                    activityMainBinding.textView.setText("Rating 2");
                    break;
                case R.id.ratingBar3:
                    activityMainBinding.textView.setText("Rating 3");
                    break;
                case R.id.ratingBar4:
                    activityMainBinding.textView.setText("Rating 4");
                    break;
            }

            //현재 설정된 값
            activityMainBinding.textView2.setText("value : "+ v);

            //사용자 설정 여부
            if (b == true){
                activityMainBinding.textView3.setText("사용자에 의해 설정 되었습니다");
            } else {
                activityMainBinding.textView3.setText("코드를 통해 설정 되었습니다다");
            }
       }
    }
}