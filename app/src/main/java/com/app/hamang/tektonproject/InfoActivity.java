package com.app.hamang.tektonproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends AppCompatActivity {
    // 공지사항
    private ListView noticeListView;
    private NoticeListAdapter adapter;
    private List<NoticeInfo> noticeInfoList;
    OAuthLogin mOAuthLoginModule;
    OAuthLoginButton mauthLoginButton;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        noticeListView = (ListView) findViewById(R.id.noticeListView);
        noticeInfoList = new ArrayList<NoticeInfo>();
        noticeInfoList.add(new NoticeInfo("공지사항입니다.", "예찬","2018-2-24"));
        noticeInfoList.add(new NoticeInfo("공지사항입니다.", "예찬","2018-2-24"));
        noticeInfoList.add(new NoticeInfo("공지사항입니다.", "예찬","2018-2-24"));
        noticeInfoList.add(new NoticeInfo("공지사항입니다.", "예찬","2018-2-24"));
        noticeInfoList.add(new NoticeInfo("공지사항입니다.", "예찬","2018-2-24"));
        noticeInfoList.add(new NoticeInfo("공지사항입니다.", "예찬","2018-2-24"));
        noticeInfoList.add(new NoticeInfo("공지사항입니다.", "예찬","2018-2-24"));
        noticeInfoList.add(new NoticeInfo("공지사항입니다.", "예찬","2018-2-24"));
        adapter = new NoticeListAdapter(getApplicationContext(), noticeInfoList);
        noticeListView.setAdapter(adapter);

        mauthLoginButton = (OAuthLoginButton) findViewById(R.id.buttonOAuthLoginImg);
        mOAuthLoginModule = OAuthLogin.getInstance();
        mOAuthLoginModule.init(
                InfoActivity.this
                ,"부여받은 Client Id"
                ,"부여받은 Client Secret"
                ,"Client Name"
                //,OAUTH_CALLBACK_INTENT
                // SDK 4.1.4 버전부터는 OAUTH_CALLBACK_INTENT변수를 사용하지 않습니다.

        );
    }

    private OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
        @Override
        public void run(boolean success) {
            if (success) {
                String accessToken = mOAuthLoginModule.getAccessToken(mContext);
                String refreshToken = mOAuthLoginModule.getRefreshToken(mContext);
                long expiresAt = mOAuthLoginModule.getExpiresAt(mContext);
                String tokenType = mOAuthLoginModule.getTokenType(mContext);
            } else {
                String errorCode = mOAuthLoginModule.getLastErrorCode(mContext).getCode();
                String errorDesc = mOAuthLoginModule.getLastErrorDesc(mContext);
                Toast.makeText(mContext, "errorCode:" + errorCode
                        + ", errorDesc:" + errorDesc, Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}