package com.example.calenderview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import com.example.calenderview.databinding.ActivityMainBinding;

import java.util.Calendar;

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

        CalendarListener1 calendarListener1 = new CalendarListener1();
        activityMainBinding.calendarView.setOnDateChangeListener(calendarListener1);
    }

    class ButtonClickListener1 implements View.OnClickListener{

        @Override
        public void onClick(View view) {

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, 2022);
            calendar.set(Calendar.MONTH, 6);
            calendar.set(Calendar.DAY_OF_MONTH, 20);

            long date = calendar.getTimeInMillis();

            // 날짜를 설정한다.
            activityMainBinding.calendarView.setDate(date);
        }
    }

    class ButtonClickListener2 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            // setDate 매서드로 설정된 날짜를 사져온다.
            long date = activityMainBinding.calendarView.getDate();

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(date);

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            activityMainBinding.textView.setText(year + "/" + month + "/" +day);
        }
    }

    //사용자가 날짜를 선택했을때
    class CalendarListener1 implements CalendarView.OnDateChangeListener{

        @Override
        // 두 번째 : 설정된 날짜의 년도
        // 세 번째 : 설정된 날짜의 월
        // 네 번째 : 설정된 날짜의 일
        public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
            // 사용자가 선택한 날짜를 setDate 매서드로 설정해준다.
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, i);
            calendar.set(Calendar.MONTH, i1);
            calendar.set(Calendar.DAY_OF_MONTH, i2);

            long date = calendar.getTimeInMillis();
            activityMainBinding.calendarView.setDate(date);

            activityMainBinding.textView2.setText(i + "/" + (i1+1) + "/" +i2);
        }
    }
}