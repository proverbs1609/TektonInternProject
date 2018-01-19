package com.app.hamang.tektonproject;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by k on 2018-01-17.
 */

public class MypageMain extends Dialog {
    private TextView mTitleView;
    private TextView mContentView;
    private Button mSaveButton;
    private Button mCloseButton;
    private Button mMenu1Button;
    private Button mMenu2Button;
    private Button mMenu3Button;
    private String mTitle = "[ 나의 댕댕이 ]";
    private String mContent = "";
    private View.OnClickListener mSaveClickListener;
    private View.OnClickListener mCloseClickListener;
    private View.OnClickListener mMenu1ClickListener;
    private View.OnClickListener mMenu2ClickListener;
    private View.OnClickListener mMenu3ClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 다이얼로그 외부 화면 흐리게 표현
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.7f;
        getWindow().setAttributes(lpWindow);

        setContentView(R.layout.mypage_main);

        mTitleView = (TextView) findViewById(R.id.mypage_title);
        mContentView = (TextView) findViewById(R.id.mypage_content);
        mSaveButton = (Button) findViewById(R.id.mypage_save);
        mCloseButton = (Button) findViewById(R.id.mypage_close);
        mMenu1Button = (Button) findViewById(R.id.mypage_menu1);
        mMenu2Button = (Button) findViewById(R.id.mypage_menu2);
        mMenu3Button = (Button) findViewById(R.id.mypage_menu3);

        // 제목과 내용을 생성자에서 셋팅한다.
        mTitleView.setText(mTitle);
        mContentView.setText(mContent);
        // 버튼 클릭 이벤트 설정
        mSaveButton.setOnClickListener(mSaveClickListener);
        mCloseButton.setOnClickListener(mCloseClickListener);
        mMenu1Button.setOnClickListener(mMenu1ClickListener);
        mMenu2Button.setOnClickListener(mMenu2ClickListener);
        mMenu3Button.setOnClickListener(mMenu3ClickListener);
    }

    // 클릭버튼이 확인과 취소 두개일때 생성자 함수로 이벤트를 받는다
    public MypageMain(Context context, String title,
                      String content, View.OnClickListener saveListener,
                      View.OnClickListener closeListener, View.OnClickListener menu1Listener,
                      View.OnClickListener menu2Listener, View.OnClickListener menu3Listener) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.mContent = content;
        this.mSaveClickListener = saveListener;
        this.mCloseClickListener = closeListener;
        this.mMenu1ClickListener = menu1Listener;
        this.mMenu2ClickListener = menu2Listener;
        this.mMenu3ClickListener = menu3Listener;
    }
}
