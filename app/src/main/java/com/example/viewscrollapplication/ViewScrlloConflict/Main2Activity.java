package com.example.viewscrollapplication.ViewScrlloConflict;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.viewscrollapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView listView = findViewById(R.id.list_item);
        List<String> mDatas;
        mDatas = new ArrayList<String>();
        mDatas.add("哈哈哈哈哈");
        mDatas.add("哈哈哈哈哈");
        mDatas.add("哈哈哈哈哈");
        mDatas.add("哈哈哈哈哈");
        mDatas.add("哈哈哈哈哈");
        mDatas.add("哈哈哈哈哈");
        mDatas.add("哈哈哈哈哈");
        mDatas.add("哈哈哈哈哈");
        mDatas.add("哈哈哈哈哈");
        mDatas.add("哈哈哈哈哈");
        mDatas.add("哈哈哈哈哈");
        mDatas.add("哈哈哈哈哈");



        CommonAdapter adapter =  new CommonAdapter<String>(
                this, mDatas, R.layout.list_item) {
            @Override
            public void convert(ViewHolder c, String item) {
                TextView view = c.getView(R.id.text);
                ImageView imageView = c.getView(R.id.img);
                imageView.setImageResource(R.mipmap.ic_launcher);
                view.setText(item);
            }
        };
        listView.setAdapter(adapter);
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
