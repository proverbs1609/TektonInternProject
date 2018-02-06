package com.app.hamang.tektonproject.EducationActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.app.hamang.tektonproject.R;

public class KennelEducation extends Dialog {

    private TextView titleView;
    private Button closeButton;
    private Button menu1Button;
    private Button menu2Button;
    private Button menu3Button;
    private Button menu4Button;
    private String title;

    private View.OnClickListener closeClickListener;
    private View.OnClickListener menu1ClickListener;
    private View.OnClickListener menu2ClickListener;
    private View.OnClickListener menu3ClickListener;
    private View.OnClickListener menu4ClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //다이얼로그 외부화면 흐리기
        WindowManager.LayoutParams IpWindow = new WindowManager.LayoutParams();
        IpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        IpWindow.dimAmount = 0.5f;
        getWindow().setAttributes(IpWindow);

        setContentView(R.layout.activity_kennel_education);
        titleView = (TextView) findViewById(R.id.kennel_title);
        closeButton = (Button) findViewById(R.id.kennel_close);
        menu1Button = (Button) findViewById(R.id.kennel_menu1);
        menu2Button = (Button) findViewById(R.id.kennel_menu2);
        menu3Button = (Button) findViewById(R.id.kennel_menu3);
        menu4Button = (Button) findViewById(R.id.kennel_menu4);

        titleView.setText(title);
        menu1Button.setOnClickListener(menu1ClickListener);
        menu2Button.setOnClickListener(menu2ClickListener);
        menu3Button.setOnClickListener(menu3ClickListener);
        menu4Button.setOnClickListener(menu4ClickListener);
        closeButton.setOnClickListener(closeClickListener);
    }

    // 클릭버튼이 확인과 취소 두개일때 생성자 함수로 이벤트를 받는다
    public KennelEducation(Context context, String title, View.OnClickListener closeListener,
                           View.OnClickListener menu1Listener, View.OnClickListener menu2Listener,
                           View.OnClickListener menu3Listener, View.OnClickListener menu4Listener) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.title = title;
        this.closeClickListener = closeListener;
        this.menu1ClickListener = menu1Listener;
        this.menu2ClickListener = menu2Listener;
        this.menu3ClickListener = menu3Listener;
        this.menu4ClickListener = menu4Listener;
    }
}
