package com.app.hamang.tektonproject.EducationActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.app.hamang.tektonproject.R;

public class SoundEducation extends Dialog {

    private TextView titleView;
    private TextView clickerTitle;
    private TextView clickerInfo;
    private TextView frequencyTitle;
    private TextView frequencyInfo;
    private Button closeButton;
    private Button clickerButton;
    private Button KHz8Button;
    private Button KHz10Button;
    private Button KHz12Button;
    private Button KHz14Button;
    private Button KHz16Button;

    private String title;

    private View.OnClickListener closeClickListener;
    private View.OnClickListener clickerClickListener;
    private View.OnTouchListener KHz8ClickListener;
    private View.OnTouchListener KHz10ClickListener;
    private View.OnTouchListener KHz12ClickListener;
    private View.OnTouchListener KHz14ClickListener;
    private View.OnTouchListener KHz16ClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //다이얼로그 외부화면 흐리기
        WindowManager.LayoutParams IpWindow = new WindowManager.LayoutParams();
        IpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        IpWindow.dimAmount = 0.5f;
        getWindow().setAttributes(IpWindow);

        setContentView(R.layout.education_sound);
        titleView = (TextView) findViewById(R.id.sound_title);
        closeButton = (Button) findViewById(R.id.sound_close);
        clickerButton = (Button) findViewById(R.id.sound_clicker);
        KHz8Button = (Button) findViewById(R.id.sound_8);
        KHz10Button = (Button) findViewById(R.id.sound_10);
        KHz12Button = (Button) findViewById(R.id.sound_12);
        KHz14Button = (Button) findViewById(R.id.sound_14);
        KHz16Button = (Button) findViewById(R.id.sound_16);

        titleView.setText(title);
        clickerButton.setOnClickListener(clickerClickListener);
        KHz8Button.setOnTouchListener(KHz8ClickListener);
        KHz10Button.setOnTouchListener(KHz10ClickListener);
        KHz12Button.setOnTouchListener(KHz12ClickListener);
        KHz14Button.setOnTouchListener(KHz14ClickListener);
        KHz16Button.setOnTouchListener(KHz16ClickListener);
        closeButton.setOnClickListener(closeClickListener);
    }

    // 클릭버튼이 확인과 취소 두개일때 생성자 함수로 이벤트를 받는다
    public SoundEducation(Context context, String title, View.OnClickListener closeListener,
                           View.OnClickListener clickerListener, View.OnTouchListener khz8Listener,
                           View.OnTouchListener khz10Listener, View.OnTouchListener khz12Listener,
                           View.OnTouchListener khz14Listener, View.OnTouchListener khz16Listener) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.title = title;
        this.closeClickListener = closeListener;
        this.clickerClickListener = clickerListener;
        this.KHz8ClickListener = khz8Listener;
        this.KHz10ClickListener = khz10Listener;
        this.KHz12ClickListener = khz12Listener;
        this.KHz14ClickListener = khz14Listener;
        this.KHz16ClickListener = khz16Listener;
    }
}
