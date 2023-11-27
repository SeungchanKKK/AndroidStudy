package com.example.textinputlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.textinputlayout.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(activityMainBinding.getRoot());

        ButtonClickListener1 buttonClickListener1 = new ButtonClickListener1();
        activityMainBinding.button.setOnClickListener(buttonClickListener1);

        EditTextWatcher editTextWatcher = new EditTextWatcher();
        EditText editText = activityMainBinding.text1.getEditText();
        editText.addTextChangedListener(editTextWatcher);
    }

    class ButtonClickListener1 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //textinput 의 에딧텍스트를 추출
            EditText editText = activityMainBinding.text1.getEditText();
            String str1 = editText.getText().toString();
            activityMainBinding.textView.setText(str1);

            InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(editText.getWindowToken(),0);

            editText.clearFocus();
        }
    }

    class EditTextWatcher implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (editable.length() >10 ){
                activityMainBinding.text1.setError("10글자 이하로 입력해주세요");
            }else {
                activityMainBinding.text1.setError(null);
            }
        }
    }
}