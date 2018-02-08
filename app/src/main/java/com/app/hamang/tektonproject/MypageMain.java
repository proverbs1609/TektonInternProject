package com.app.hamang.tektonproject;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by k on 2018-01-17.
 */

public class MypageMain extends Dialog {
    private TextView mTitleView;
    private TextView mContentView;
    private TextView mSaveButton;
    private TextView mCloseButton;
    private TextView mGenderView;
    private Button mMenu1Button;
    private Button mMenu2Button;
    private Button mMenu3Button;
    private ImageView mImageView;
    private String mTitle = "";
    private String mContent = "";
    private String mGender = "";
    private int mImage;
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
        lpWindow.dimAmount = 0.5f;
        getWindow().setAttributes(lpWindow);
        setContentView(R.layout.main_mypage);
        // 마이페이지 버튼설정과 클릭 리스너
        mypageDialog();
    }
    // 클릭버튼에 따른 이벤트 생성
    public MypageMain(Context context, String title, String content, int dogImage, String gender,
                      View.OnClickListener saveListener, View.OnClickListener closeListener,
                      View.OnClickListener menu1Listener, View.OnClickListener menu2Listener,
                      View.OnClickListener menu3Listener) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.mTitle = title;
        this.mContent = content;
        this.mImage = dogImage;
        this.mGender = gender;
        this.mSaveClickListener = saveListener;
        this.mCloseClickListener = closeListener;
        this.mMenu1ClickListener = menu1Listener;
        this.mMenu2ClickListener = menu2Listener;
        this.mMenu3ClickListener = menu3Listener;
    }
    public void mypageDialog() {
        mTitleView = (TextView) findViewById(R.id.mypage_title);
        mContentView = (TextView) findViewById(R.id.mypage_content);
        mSaveButton = (TextView) findViewById(R.id.mypage_save);
        mCloseButton = (TextView) findViewById(R.id.mypage_close);
        mGenderView = (TextView) findViewById(R.id.mypage_gender);
        mMenu1Button = (Button) findViewById(R.id.mypage_menu1);
        mMenu2Button = (Button) findViewById(R.id.mypage_menu2);
        mMenu3Button = (Button) findViewById(R.id.mypage_menu3);
        mImageView = (ImageView) findViewById(R.id.dog_image);
        mTitleView.setText(mTitle);
        mContentView.setText(mContent);
        mImageView.setImageResource(mImage);
        mGenderView.setText(mGender);
        if(mTitle == "[ 나의 댕댕이 ]") {
            mSaveButton.setText("+ 수 정");
            mSaveButton.setOnClickListener(mSaveClickListener);
        } else {
            mSaveButton.setText("+ 저 장");
            mSaveButton.setOnClickListener(mSaveClickListener);
        }
        mCloseButton.setOnClickListener(mCloseClickListener);
        mMenu1Button.setOnClickListener(mMenu1ClickListener);
        mMenu2Button.setOnClickListener(mMenu2ClickListener);
        mMenu3Button.setOnClickListener(mMenu3ClickListener);
    }
}