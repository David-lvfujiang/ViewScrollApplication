package com.example.viewscrollapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Scroller;

import androidx.annotation.Nullable;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/11/6
 * @Describe:
 */
@SuppressLint("AppCompatCustomView")
public class MyView extends Button {
    int one = 0;
    Scroller mScroller;


    private int startX;
    private int startY;


    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);

    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            //通过不断的重绘不断的调用computeScroll方法
            invalidate();
        }
    }


    @Override


    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = (int) event.getX();
                startY = (int) event.getY();
                Log.e("tag1", ((View) getParent()).getScrollX() + "");
                if (((View) getParent()).getScrollX() > 0) {
                    ((View) getParent()).scrollTo(0,0);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                 int x = (int) event.getX();
                int y = (int) event.getY();
                int dx = x - startX;
                int dy = startY - y;

                int disX =  -dx;
               // Log.e("tag", ((View) getParent()).getScrollX() + "");
                Log.e("tag2", disX + "");
                if (disX >= 100) {
                    disX = 600;
                }
                if (disX <=-100)
                {
                    disX = 0;
                }
                ((View) getParent()).scrollTo( disX, 0);


                break;

            case MotionEvent.ACTION_UP:

//                if (((View) getParent()).getScrollX() < 200) {
//                    closeMenu();
//                } else {
//                    openMenu();
//                }

                break;

        }
        return true;

    }

    public final void openMenu() {
        Log.e("openMenu", ((View) getParent()).getScrollX() + "," + getScrollY() + "");

        mScroller.startScroll(((View) getParent()).getScrollX(), ((View) getParent()).getScrollY(), 600 - ((View) getParent()).getScrollX(), 0);
        invalidate();
    }

    public final void closeMenu() {
        Log.e("closeMenu", ((View) getParent()).getScrollX() + "," + getScrollY() + "");
        mScroller.startScroll(((View) getParent()).getScrollX(), ((View) getParent()).getScrollY(), 0 - ((View) getParent()).getScrollX(), 0, 500);
        invalidate();
    }


}
