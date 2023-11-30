package com.example.searchview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import com.example.searchview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        ButtonClickListener1 buttonClickListener1 = new ButtonClickListener1();
        activityMainBinding.button.setOnClickListener(buttonClickListener1);

        SearchViewTextQueryListener1 searchViewTextQueryListener1 = new SearchViewTextQueryListener1();
        activityMainBinding.searchView.setOnQueryTextListener(searchViewTextQueryListener1);
    }

    class ButtonClickListener1 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            // 입력한 검색어를 가져온다
            String str1 = activityMainBinding.searchView.getQuery().toString();
            activityMainBinding.textView.setText(str1);
        }
    }

    //검색어를 입력했거나 엔터 버튼을 눌렀을때
    class SearchViewTextQueryListener1 implements SearchView.OnQueryTextListener{

        //엔터 버튼을 누르면
        @Override
        public boolean onQueryTextSubmit(String s) {
            activityMainBinding.textView.setText(s);
            //false 면 키보드가 내려가고 true 면 엔터후 유지된다
            return true;
        }

        @Override
        public boolean onQueryTextChange(String s) {
            activityMainBinding.textView2.setText(s);
            return false;
        }
    }
}