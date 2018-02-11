package com.app.hamang.tektonproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.app.hamang.tektonproject.ActionActivity.ActionMypage;
import com.app.hamang.tektonproject.EducationActivity.EducationMain;
import com.app.hamang.tektonproject.EmotionActivity.EmotionMypage;
import com.app.hamang.tektonproject.PlayActivity.PlayMain;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final long FINISH_INTERVAL_TIME = 2000; // 두번 클릭 종료를 위한 시간
    private long backPressedTime = 0;
    private MypageMain mCustomDialog ;
    private Activity activity ;
    private EditText edit_name ;
    private RadioGroup rg ;
    private RadioButton rb ;
    int dogImage;
    String dogName, dogSpe, dogSpeNum, QRvalue ;
    String dogGender = "" ;
    Intent dogcommunity = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.cafe.naver.com/dogpalza.cafe")); // 네이버 카페 연동 선언
    Intent doghospital = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.map.naver.com/search2/search.nhn?query=%EB%8F%99%EB%AC%BC%EB%B3%91%EC%9B%90&sm=hty"));
    Intent dogshop = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.map.naver.com/search2/search.nhn?query=%EC%95%A0%EA%B2%AC%EC%83%B5&sm=hty"));
    public static SharedPreferences sharedPreferences ;
    public static SharedPreferences.Editor editor ;
    public static Gson gson ;
    public static String json ;
    LocationManager locationManager ;
    public static DogList cumtomdialog;
    public static ArrayList<DogItem> animalList;
    public static DogListAdapter listviewadapter ;
    public static final int ran[] = {
            R.mipmap.ic_maltese_round, R.mipmap.ic_poodle_round, R.mipmap.ic_welshcorgi_round, R.mipmap.ic_siberianhusky_round, R.mipmap.ic_goldenretriever_round
    };
    String dogname[] = {"말티즈", "푸들", "웰시 코기", "시베리안 허스키", "골든 리트리버"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        gson = new Gson();
        activity = this;
        loadDate();
//        LayoutInflater inflater1=getLayoutInflater();
//        final View view= inflater1.inflate(R.layout.main_mypage, null);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //툴바의 홈버튼을 활성화 하고 아이콘을 바꿈
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_mypets);

        //툴바 제목을 편집하기 위해 지정된 제목을 바꾸기 위해 null 값 부여
        getSupportActionBar().setTitle(null);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

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
                // 값을 넘겨주기 위해 저장.
                QRvalue = result.getContents();
                scanResult(QRvalue);
            } else scanResult("스캔 취소");
        } else super.onActivityResult(requestCode, resultCode, data);
    }

    private void scanResult(String msg) {
        if (msg == "스캔 취소") { // 종료
        } else {
            mCustomDialog = new MypageMain(this,
                    "[ 댕 댕 이 ]", dogname[Integer.parseInt(msg)],
                    ran[Integer.parseInt(msg)], "",
                    saveListener, closeListener,
                    menu1Listener, menu2Listener, menu3Listener); // 오른쪽 버튼 이벤트
            mCustomDialog.show();
            dogImage = ran[Integer.parseInt(msg)];
            dogSpe = dogname[Integer.parseInt(msg)];
        }
    }

    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.menu_play: // 놀아주기 버튼 반응
                startActivity(new Intent(getApplicationContext(), PlayMain.class));
                break;
            case R.id.menu_education: // 교육하기 버튼 반응
                startActivity(new Intent(getApplicationContext(), EducationMain.class));
                break;
            case R.id.menu_bucketlist: // 버킷리스트 버튼 반응
                startActivity(new Intent(getApplicationContext(), BucketMain.class));
                break;
            case R.id.menu_hospital: // 병원 찾기 버튼 반응
                if (isNetworkConnected()) {
                    if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
                        location();
                    else {
                        startActivity(doghospital);
                        Toast.makeText(getApplicationContext(), "검색 중입니다. 잠시만 기다려주세요.", Toast.LENGTH_LONG).show();
                    }
                } else internetDialog();
                break;
            case R.id.menu_shop: // 샵 찾기 버튼 반응
                if (isNetworkConnected()) {
                    if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
                        location();
                    else {
                        startActivity(dogshop);
                        Toast.makeText(getApplicationContext(), "검색 중입니다. 잠시만 기다려주세요.", Toast.LENGTH_LONG).show();
                    }
                } else internetDialog();
                break;
            case R.id.menu_community: // 커뮤니티 버튼 반응
                if (isNetworkConnected()) {
                    startActivity(dogcommunity);
                    Toast.makeText(getApplicationContext(), "연결 중입니다. 잠시만 기다려주세요.", Toast.LENGTH_LONG).show();
                    break;
                } else internetDialog();
        }
    }

    // 뒤로가기 두번 클릭으로 앱 종료
    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;
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
                startActivity(new Intent(getApplicationContext(), InfoActivity.class));
                return true;
            case android.R.id.home: // 마이 페이지 버튼 반응
                listviewadapter = new DogListAdapter(this, R.layout.dog_list_layout_row, animalList);
                json = gson.toJson(animalList) ;
                editor.putString("task list", json) ;
                editor.commit() ;
                Toast.makeText(getApplicationContext(), "비어있다", Toast.LENGTH_SHORT) ;
                cumtomdialog = new DogList(activity, "[나의 댕댕이들]", listviewadapter, mClickCloseListener) ;
                cumtomdialog.show() ;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    Button.OnClickListener mClickCloseListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            cumtomdialog.dismiss();
        }
    };
    // 커스텀 다이얼로그 내 버튼 생성 및 등록
    private View.OnClickListener saveListener = new View.OnClickListener() {
        public void onClick(View v) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            LayoutInflater inflater = getLayoutInflater();
            final View dialogView = inflater.inflate(R.layout.sign_up_layout, null);
            edit_name = (EditText) dialogView.findViewById(R.id.dialog_edit);
            rg = (RadioGroup) dialogView.findViewById(R.id.signup_genderGroup);
            edit_name.setText(dogname[Integer.parseInt(QRvalue)]);
            builder.setTitle("[댕댕이]");
            builder.setView(dialogView);
            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dogName = edit_name.getText().toString();
                    int id = rg.getCheckedRadioButtonId();
                    rb = (RadioButton) dialogView.findViewById(id);
                    if (id == -1) dogGender = "";
                    else dogGender = rb.getText().toString();
                    signup(dogName, dogGender, dogImage);

                    json = gson.toJson(animalList);
                    editor.putString("task list", json);
                    editor.apply();
                }
            });
            builder.setNegativeButton("취소", null);
            AlertDialog dialog = builder.create();
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        }
    };
    private View.OnClickListener closeListener = new View.OnClickListener() {
        public void onClick(View v) {
            mCustomDialog.dismiss();
        }
    };
    private View.OnClickListener menu1Listener = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), EmotionMypage.class)); // 감정 분석 페이지 이동
        }
    };
    private View.OnClickListener menu2Listener = new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), ActionMypage.class)); // 문제 행동 페이지 이동
        }
    };
    private View.OnClickListener menu3Listener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent species = new Intent(getApplicationContext(), SpeciesMypage.class);
            species.putExtra("QRcode", QRvalue);
            species.putExtra("QRname", dogname[Integer.parseInt(QRvalue)]);
            startActivity(species); // 종별 특성 페이지 이동
        }
    };

    private void location() {
        Toast.makeText(getApplicationContext(), "위치 정보를 알수 없습니다.\n위치정보설정을 ON으로 변경해주세요.", Toast.LENGTH_SHORT).show();
        //GPS 설정화면으로 이동
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        startActivity(intent);
    }

    private boolean isNetworkConnected() {
        ConnectivityManager internet = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetWork = internet.getActiveNetworkInfo();
        boolean isNetworkConnected = activeNetWork != null && activeNetWork.isConnectedOrConnecting();
        return isNetworkConnected;
    }

    private void internetDialog() {
        AlertDialog.Builder internetdialog = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogStyle));
        internetdialog.setNegativeButton("확인", null);
        internetdialog.setTitle("인터넷 없음");
        internetdialog.setMessage("현재 인터넷을 찾을 수 없습니다. WiFi또는 데이터 네트워크를 확인해 주세요.");
        internetdialog.show();
    }

    public void loadDate() {
        json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<DogItem>>() {
        }.getType();
        animalList = gson.fromJson(json, type);

        if (animalList == null) {
            animalList = new ArrayList<>();
        }
    }

    public void signup(String nameDog, String genderDog, int imageDog) {
        animalList.add(new DogItem(nameDog, genderDog, imageDog, dogname[Integer.parseInt(QRvalue)], QRvalue));
        listviewadapter = new DogListAdapter(this, R.layout.dog_list_layout_row, animalList);
        listviewadapter.notifyDataSetChanged();
    }
}