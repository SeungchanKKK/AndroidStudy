package com.example.button;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import com.example.button.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        // Button 문자열 변경
        activityMainBinding.button.setText("버튼 입니다");

        //버튼 이미지 변경
        //bitmap 객체 생성
        Resources res =getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.imgflag8);
        activityMainBinding.imageButton.setImageBitmap(bitmap);

        //버튼에 리스너 설정
        ButtonClickListener buttonClickListener = new ButtonClickListener();

        //이미지 버튼에 리스너 설정
        ImageButtonClickListener1 imageButtonClickListener1 = new ImageButtonClickListener1();
        activityMainBinding.imageButton.setOnClickListener(imageButtonClickListener1);

        //버튼2 버튼3 리스너 설정
        ButtonClickListener2 buttonClickListener2 = new ButtonClickListener2();
        activityMainBinding.button.setOnClickListener(buttonClickListener2);
        activityMainBinding.button2.setOnClickListener(buttonClickListener2);
        activityMainBinding.button3.setOnClickListener(buttonClickListener2);
    }
    //버튼 클릭 리스너
    class ButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            activityMainBinding.textView.setText("버튼을 눌렀습니다");
        }
    }

    //이미지버튼 클릭 리스너
    class ImageButtonClickListener1 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            activityMainBinding.textView.setText("이미지버튼을 눌렀습니다");
        }
    }

    //버튼2와 버튼3의 리스너
    class ButtonClickListener2 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            // 사용자가 누른 버튼의 id를 가져온다
            int id = view.getId();

            //id를 통해 분기한다.
            switch ((id)){
                case R.id.button:
                    activityMainBinding.textView.setText("버튼1을 눌렀습니다");
                    break;
                case R.id.button2:
                    activityMainBinding.textView.setText("버튼2를 눌렀습니다");
                    break;
                case R.id.button3:
                    activityMainBinding.textView.setText("버튼3을 눌렀습니다");
                    break;
            }
        }
    }
}