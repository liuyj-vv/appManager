package com.changhong.appmanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    ViewFlipper mainFlipper;
    List<Button> buttonArrayList = new ArrayList<Button>(); //所有分类按钮
    List<ViewFlipper> flipperArrayList = new ArrayList<ViewFlipper>(); //所有分类应用滑动窗口
    boolean firstInit = true; //是否是onCreate调用的显示初始化
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void init() {
        if (firstInit) {
            //第一次初始化，获取控件
            mainFlipper = findViewById(R.id.flipperMain);

            buttonArrayList.clear();
            buttonArrayList.add((Button) findViewById(R.id.btn_all));
            buttonArrayList.add((Button) findViewById(R.id.btnGame));
            buttonArrayList.add((Button) findViewById(R.id.btnEntertainment));
            buttonArrayList.add((Button) findViewById(R.id.btnLife));
            buttonArrayList.add((Button) findViewById(R.id.btnEducation));
            buttonArrayList.add((Button) findViewById(R.id.btnInfomation));

            flipperArrayList.clear();
            flipperArrayList.add((ViewFlipper) mainFlipper.findViewById(R.id.flipperAll));
            flipperArrayList.add((ViewFlipper) mainFlipper.findViewById(R.id.flipperGame));
            flipperArrayList.add((ViewFlipper) mainFlipper.findViewById(R.id.flipperEntertainment));
            flipperArrayList.add((ViewFlipper) mainFlipper.findViewById(R.id.flipperLife));
            flipperArrayList.add((ViewFlipper) mainFlipper.findViewById(R.id.flipperEducation));
            flipperArrayList.add((ViewFlipper) mainFlipper.findViewById(R.id.flipperEntertainment));

            firstInit = false;
        }

        LayoutInflater inflater = getLayoutInflater();
        RelativeLayout appContenLayouot = (RelativeLayout)inflater.inflate(R.layout.layout_app_content, null);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    mainFlipper.showNext();
                    break;
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    mainFlipper.showPrevious();
                    break;
            }
        }

        return super.onKeyDown(keyCode, event);
    }
}
