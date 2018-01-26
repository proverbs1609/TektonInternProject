package com.app.hamang.tektonproject;

import android.app.Activity;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.app.hamang.tektonproject.ActionActivity.ActionMypage;
import com.app.hamang.tektonproject.EmotionActivity.EmotionMypage;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    private final long FINISH_INTERVAL_TIME = 2000; // 두번 클릭 종료를 위한 시간
    private long   backPressedTime = 0;
    private MypageMain mCustomDialog;
    TextView text, text2, text3;
    String str = "";
    String str1 = "";//빈 문자열 String 객체
    String str2 = "";
    Intent dogcommunity = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.cafe.naver.com/dogpalza.cafe")); // 네이버 카페 연동 선언
    Intent doghospital = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.map.naver.com/search2/search.nhn?query=%EB%8F%99%EB%AC%BC%EB%B3%91%EC%9B%90&sm=hty"));
    Intent dogshop = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.map.naver.com/search2/search.nhn?query=%EC%95%A0%EA%B2%AC%EC%83%B5&sm=hty"));
    LocationManager locationManager;
    public static final int ran[]={
            R.mipmap.ic_maltese_round, R.mipmap.ic_poodle_round, R.mipmap.ic_welshcorgi_round, R.mipmap.ic_siberianhusky_round, R.mipmap.ic_goldenretriever_round
    };
    String dogname[] = {"말티즈", "푸들", "웰시 코기","시베리안 허스키","골든 리트리버"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Activity activity = this;
        LayoutInflater inflater1=getLayoutInflater();
        final View view= inflater1.inflate(R.layout.mypage_main, null);;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //툴바의 홈버튼을 활성화 하고 아이콘을 바꿈
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_mypets);

        //툴바 제목을 편집하기 위해 지정된 제목을 바꾸기 위해 null 값 부여
        getSupportActionBar().setTitle(null);
        locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);

        // 카메라 버튼에 대한 액션 값 부여
        FloatingActionButton QRcode = (FloatingActionButton) findViewById(R.id.menu_qrcode);
        QRcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 카메라 버튼 눌렀을때 동작
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("QR Code를 인식시켜주세요");
                integrator.setCameraId(0);
                integrator.initiateScan(); //바코드 스캐너 호출
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                scanResult(result.getContents());
            } else {
                scanResult("스캔 취소");
             }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void scanResult(String msg) {
        if(msg == "스캔 취소") { // 종료
        } else {
            mCustomDialog = new MypageMain (this,
                    "[ 댕 댕 이 ]", dogname[Integer.parseInt(msg)],
                    ran[Integer.parseInt(msg)],
                    saveListener, closeListener,
                    menu1Listener, menu2Listener, menu3Listener); // 오른쪽 버튼 이벤트
            mCustomDialog.show();
        }
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
                if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    location();
                } else {
                    startActivity(doghospital);
                    Toast.makeText(getApplicationContext(), "검색 중입니다. 잠시만 기다려주세요.", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.menu_shop: // 샵 찾기 버튼 반응
                if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    location();
                } else {
                    startActivity(dogshop);
                    Toast.makeText(getApplicationContext(), "검색 중입니다. 잠시만 기다려주세요.", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.menu_community: // 커뮤니티 버튼 반응
                startActivity(dogcommunity);
                Toast.makeText(getApplicationContext(), "연결 중입니다. 잠시만 기다려주세요.", Toast.LENGTH_LONG).show();
                break;
        }
    }
    // 뒤로가기 두번 클릭으로 앱 종료 만들기
    @Override
    public void onBackPressed() {
        long tempTime       = System.currentTimeMillis();
        long intervalTime   = tempTime - backPressedTime;
        if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime) {
            super.onBackPressed();
        } else {
            backPressedTime = tempTime;
            Toast.makeText(getApplicationContext(), "한 번 더 누르면 앱이 종료됩니다.", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings: // info 버튼 반응
                startActivity(new Intent(getApplicationContext(),InfoActivity.class));
                return true;
            case android.R.id.home: // 마이 페이지 버튼 반응
                mCustomDialog = new MypageMain(this,
                        "[ 나의 댕댕이 ]", "", 0, saveListener,
                    closeListener, menu1Listener, menu2Listener, menu3Listener); // 오른쪽 버튼 이벤트
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
    private void location() {
        Toast.makeText(getApplicationContext(), "위치 정보를 알수 없습니다.\n위치정보설정을 ON으로 변경해주세요.", Toast.LENGTH_SHORT).show();
        //GPS 설정화면으로 이동
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        startActivity(intent);
    }


}