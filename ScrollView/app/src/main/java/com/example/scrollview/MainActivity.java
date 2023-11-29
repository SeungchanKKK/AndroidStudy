package com.example.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.scrollview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        ButtonClickListener1 buttonClickListener1 = new ButtonClickListener1();
        activityMainBinding.button17.setOnClickListener(buttonClickListener1);

        ButtonClickListener2 buttonClickListener2 = new ButtonClickListener2();
        activityMainBinding.button18.setOnClickListener(buttonClickListener2);

        // 스크롤이 발생 하였을때
        ScrollViewChangeListener1 scrollViewChangeListener1 = new ScrollViewChangeListener1();
        activityMainBinding.scroll1.setOnScrollChangeListener(scrollViewChangeListener1);
        activityMainBinding.scroll2.setOnScrollChangeListener(scrollViewChangeListener1);
    }

    class ButtonClickListener1 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            // ScrollView의 Y 좌표 값을 가져온다.
            int y = activityMainBinding.scroll1.getScrollY();
            //HorizontalScrollView의 X 좌표 값을 가져온다.
            int x = activityMainBinding.scroll2.getScrollX();

            activityMainBinding.textView.setText("X : " + x);
            activityMainBinding.textView2.setText("Y : " + y);
        }
    }

    class ButtonClickListener2 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //지정된 위치로 이동
//            activityMainBinding.scroll1.scrollTo(0,1000);
//            activityMainBinding.scroll2.scrollTo(1000,0);

            //현재 위치에서 지정된 만큼 이동한다
//            activityMainBinding.scroll1.scrollBy(0,1000);
//            activityMainBinding.scroll2.scrollBy(1000,0);

            //지정된 위치로 이동한다(애니메이션)
//            activityMainBinding.scroll1.smoothScrollTo(0,1000);
//            activityMainBinding.scroll2.smoothScrollTo(1000,0);

            //현재 위치에서 지정된 만큼 이동한다(애니메이션)
            activityMainBinding.scroll1.smoothScrollBy(0,1000);
            activityMainBinding.scroll2.smoothScrollBy(1000,0);
        }
    }

    // 스크롤 되었을때
    class ScrollViewChangeListener1 implements View.OnScrollChangeListener{

        // 첫 번째 : 스크롤이 발생한 스크롤 뷰
        // 두 번째 : 이동된 X 좌표
        // 세 번째 : 이동된 Y 좌표
        // 네 번쨰 : 이동되기전 X 좌표
        // 다섯 번째 : 이동 되기전 Y 좌표표
       @Override
        public void onScrollChange(View view, int i, int i1, int i2, int i3) {
            int id = view.getId();

            switch (id){
                case R.id.scroll1:
                    activityMainBinding.textView.setText("Y : "+ i3 + "->" + i1);
                    break;
                case R.id.scroll2:
                    activityMainBinding.textView2.setText("X : "+ i2 + "->" + i);
                    break;
            }
        }
    }
}