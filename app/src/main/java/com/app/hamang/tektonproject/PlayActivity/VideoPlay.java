package com.app.hamang.tektonproject.PlayActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.app.hamang.tektonproject.R;

public class VideoPlay extends Dialog {

    private TextView titleView;
    private Button closeButton;
    private Button menu1Button;
    private Button menu2Button;
    private Button menu3Button;
    private Button menu4Button;
    private Button menu5Button;
    private Button menu6Button;
    private String title;

    private View.OnClickListener closeClickListener;
    private View.OnClickListener menu1ClickListener;
    private View.OnClickListener menu2ClickListener;
    private View.OnClickListener menu3ClickListener;
    private View.OnClickListener menu4ClickListener;
    private View.OnClickListener menu5ClickListener;
    private View.OnClickListener menu6ClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //다이얼로그 외부화면 흐리기
        WindowManager.LayoutParams IpWindow = new WindowManager.LayoutParams();
        IpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        IpWindow.dimAmount = 0.5f;
        getWindow().setAttributes(IpWindow);

        setContentView(R.layout.play_video);
        titleView = (TextView) findViewById(R.id.p_video_title);
        closeButton = (Button) findViewById(R.id.p_video_close);
        menu1Button = (Button) findViewById(R.id.p_video_menu1);
        menu2Button = (Button) findViewById(R.id.p_video_menu2);
        menu3Button = (Button) findViewById(R.id.p_video_menu3);
        menu4Button = (Button) findViewById(R.id.p_video_menu4);
        menu5Button = (Button) findViewById(R.id.p_video_menu5);
        menu6Button = (Button) findViewById(R.id.p_video_menu6);

        titleView.setText(title);
        menu1Button.setOnClickListener(menu1ClickListener);
        menu2Button.setOnClickListener(menu2ClickListener);
        menu3Button.setOnClickListener(menu3ClickListener);
        menu4Button.setOnClickListener(menu4ClickListener);
        menu5Button.setOnClickListener(menu5ClickListener);
        menu6Button.setOnClickListener(menu6ClickListener);
        closeButton.setOnClickListener(closeClickListener);
    }

    // 클릭버튼이 확인과 취소 두개일때 생성자 함수로 이벤트를 받는다
    public VideoPlay(Context context, String title, View.OnClickListener closeListener,
                          View.OnClickListener menu1Listener, View.OnClickListener menu2Listener,
                          View.OnClickListener menu3Listener, View.OnClickListener menu4Listener,
                          View.OnClickListener menu5Listener, View.OnClickListener menu6Listener) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.title = title;
        this.closeClickListener = closeListener;
        this.menu1ClickListener = menu1Listener;
        this.menu2ClickListener = menu2Listener;
        this.menu3ClickListener = menu3Listener;
        this.menu4ClickListener = menu4Listener;
        this.menu5ClickListener = menu5Listener;
        this.menu6ClickListener = menu6Listener;
    }
}