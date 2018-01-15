package com.app.hamang.tektonproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
                Toast.makeText(getApplicationContext(), "환경설정 버튼 클릭됨", Toast.LENGTH_SHORT).show();
                return true;
            case android.R.id.home: // 마이 페이지 버튼 반응
                Toast.makeText(getApplicationContext(), "마이페이지", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}