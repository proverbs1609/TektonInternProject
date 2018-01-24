package com.app.hamang.tektonproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.app.hamang.tektonproject.ActionActivity.ActionMypage;
import com.app.hamang.tektonproject.EmotionActivity.EmotionMypage;

public class MainActivity extends AppCompatActivity {
    private MypageMain mCustomDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //툴바의 홈버튼을 활성화 하고 아이콘을 바꿈
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_mypets);

        //툴바 제목을 편집하기 위해 지정된 제목을 바꾸기 위해 null 값 부여
        getSupportActionBar().setTitle(null);

        // 카메라 버튼에 대한 액션 값 부여
        FloatingActionButton QRcode = (FloatingActionButton) findViewById(R.id.menu_qrcode);
        QRcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 카메라 버튼 눌렀을때 동작
                Toast.makeText(getApplicationContext(), "qrcodebutton", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.menu_play: // 놀아주기 버튼 반응
                Toast.makeText(getApplicationContext(), "playbutton", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_education: // 교육하기 버튼 반응
                Toast.makeText(getApplicationContext(), "edubutton", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_bucketlist: // 버킷리스트 버튼 반응
                Toast.makeText(getApplicationContext(), "bucketlist", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_hospital: // 병원 찾기 버튼 반응
                Toast.makeText(getApplicationContext(), "hospital", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_shop: // 샵 찾기 버튼 반응
                Toast.makeText(getApplicationContext(), "shop", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_community: // 커뮤니티 버튼 반응
                Toast.makeText(getApplicationContext(), "community", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.action_settings: // info 버튼 반응
                startActivity(new Intent(getApplicationContext(),InfoActivity.class));
                return true;
            case android.R.id.home: // 마이 페이지 버튼 반응
                mCustomDialog = new MypageMain(this,
                        "[ 나의 댕댕이 ]",
                        "[ 강아지 이름 변화 ]",
                        saveListener, closeListener, menu1Listener, menu2Listener, menu3Listener); // 오른쪽 버튼 이벤트
                mCustomDialog.show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    // 커스텀 다이얼로그 내 버튼 생성 및 등록
    private View.OnClickListener saveListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "등록", Toast.LENGTH_SHORT).show();
        }
    };
    private View.OnClickListener closeListener = new View.OnClickListener() {
        public void onClick(View v) {
            //닫기
            mCustomDialog.dismiss();
        }
    };
    private View.OnClickListener menu1Listener = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(),EmotionMypage.class)); // 감정 분석 페이지 이동
        }
    };
    private View.OnClickListener menu2Listener = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), ActionMypage.class)); // 문제 행동 페이지 이동
        }
    };
    private View.OnClickListener menu3Listener = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), SpeciesMypage.class)); // 종별 특성 페이지 이동과 특수값 전달 해야하는데 데이터베이스를 활용한 문제해결을 해야함.
        }
    };
}