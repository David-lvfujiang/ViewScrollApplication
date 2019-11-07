package com.example.viewscrollapplication.ViewScrlloConflict;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import androidx.annotation.Nullable;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/11/7
 * @Describe:
 */
public class MyLayout2 extends RelativeLayout {
    public MyLayout2(Context context) {
        super(context);
    }

    public MyLayout2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLayout2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyLayout2(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("父布局","dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("父布局","onInterceptTouchEvent");
      return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("父布局","onTouchEvent");
        return super.onTouchEvent(event);
    }
}

