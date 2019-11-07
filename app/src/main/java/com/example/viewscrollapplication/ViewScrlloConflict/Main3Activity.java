package com.example.viewscrollapplication.ViewScrlloConflict;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.example.viewscrollapplication.R;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("activity","dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("activity","onTouchEvent");
        return super.onTouchEvent(event);
    }
}
