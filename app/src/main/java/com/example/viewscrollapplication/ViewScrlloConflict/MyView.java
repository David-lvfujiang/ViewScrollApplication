package com.example.viewscrollapplication.ViewScrlloConflict;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.Nullable;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/11/7
 * @Describe:
 */
public class MyView extends ListView {
    int startX, startY;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("子view", "dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("子view", "onInterceptTouchEvent");

        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("子view点击", "onTouchEvent");
                Log.e("子view点击", "" + this.getCount());
                startX = (int) ev.getX();
                startY = (int) ev.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("子view移动", "" + getHeight());
                Log.e("子view移动", "" + this.getLastVisiblePosition());
                int up = (int) (ev.getY() - startY);
                Log.e("子view移动", "" + up);
                View view = (View) getChildAt(getChildCount() - 1);
                //获取textView的高度
                int childViewHight = view.getBottom();
                childViewHight -= (getMeasuredHeight() + getScrollY());
                if (childViewHight == 0) {
                    Log.e("底部", "" + this.getLastVisiblePosition());
                    getParent().requestDisallowInterceptTouchEvent(false);
                    break;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
        }
        return super.onTouchEvent(ev);
    }


}
