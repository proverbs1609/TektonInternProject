package com.app.hamang.tektonproject.PlayActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.app.hamang.tektonproject.R;

public class NecessityPlay extends Dialog {

    private TextView titleView;
    private Button closeButton;
    private Button menu1Button;
    private Button menu2Button;
    private String title;

    private View.OnClickListener closeClickListener;
    private View.OnClickListener menu1ClickListener;
    private View.OnClickListener menu2ClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //다이얼로그 외부화면 흐리기
        WindowManager.LayoutParams IpWindow = new WindowManager.LayoutParams();
        IpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        IpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(IpWindow);

        setContentView(R.layout.play_necessity);
        titleView = (TextView) findViewById(R.id.p_necessity_title);
        closeButton = (Button) findViewById(R.id.p_necessity_close);
        menu1Button = (Button) findViewById(R.id.p_necessity_menu1);
        menu2Button = (Button) findViewById(R.id.p_necessity_menu2);

        titleView.setText(title);
        menu1Button.setOnClickListener(menu1ClickListener);
        menu2Button.setOnClickListener(menu2ClickListener);
        closeButton.setOnClickListener(closeClickListener);
    }

    // 클릭버튼이 확인과 취소 두개일때 생성자 함수로 이벤트를 받는다
    public NecessityPlay(Context context, String title, View.OnClickListener closeListener,
                         View.OnClickListener menu1Listener, View.OnClickListener menu2Listener) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.title = title;
        this.closeClickListener = closeListener;
        this.menu1ClickListener = menu1Listener;
        this.menu2ClickListener = menu2Listener;
    }
}
