package com.app.hamang.tektonproject;

/**
 * Created by JKPC on 2018-02-06.
 */

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.app.hamang.tektonproject.ActionActivity.ActionMypage;
import com.app.hamang.tektonproject.EmotionActivity.EmotionMypage;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by JKPC on 2018-02-06.
 */


public class DogList extends Dialog {
    private MypageMain mCustomDialog,newDialog;
    private Activity activity;
    private String title;
    private View.OnClickListener checkBtListener;

    DogListAdapter listAdapter;
    private Button closeBt;
    private TextView dialogTitle;
    private EditText edit_name ;
    private RadioGroup rg ;
    private RadioButton rb ;
    private RadioButton rb_female ;
    private RadioButton rb_male ;
    public ListView listView;
    public SharedPreferences sharedPreferences = MainActivity.sharedPreferences ;
    public SharedPreferences.Editor editor = MainActivity.editor ;
    public Gson gson = MainActivity.gson ;
    public String json = MainActivity.json ;

    ArrayList<DogItem> animalList = MainActivity.animalList ;
    AlertDialog.Builder click ;
    AlertDialog.Builder check ;
    int position ;
    String dogName ;
    String dogGender ;
    int dogImage ;
    String dogSpe ;
    String dogSpeNum ;
    int xPos ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        editor = sharedPreferences.edit() ;
        gson = new Gson() ;
        // 메인 layout
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.7f;
        getWindow().setAttributes(lpWindow);
        setContentView(R.layout.dog_list_layout);


        closeBt = (Button) findViewById(R.id.listview_bt);
        dialogTitle = (TextView) findViewById(R.id.list_title);
        listView = (ListView) findViewById(R.id.listview);

        // 제목 설정
        dialogTitle.setText(title);
        // 리스트뷰 설정
        listView.setAdapter(listAdapter);
        // 버튼 리스너 설정
        closeBt.setOnClickListener(checkBtListener);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                position = i ;
                Object o = listView.getItemAtPosition(i);
                DogItem item = (DogItem)o ;
                dialog(item.animalName, item.animalGender, item.animalImage);
                dogName = item.animalName ;
                dogImage = item.animalImage ;
                dogGender = item.animalGender ;
                dogSpe = item.dogSpe ;
                dogSpeNum = item.dogSpeNum ;
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                xPos = i ;
                click = new AlertDialog.Builder(new ContextThemeWrapper(getContext(), R.style.CheckDialog));
                click.setMessage("삭제하시겠습니까?") ;
                click.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        check = new AlertDialog.Builder(new ContextThemeWrapper(getContext(), R.style.CheckDialog));
                        check.setMessage("삭제되었습니다.");
                        check.setNegativeButton("확인",null);
                        Object o = listView.getItemAtPosition(xPos) ;
                        DogItem item = (DogItem) o ;
                        animalList.remove(xPos) ;
                        listView.clearChoices();
                        MainActivity.listviewadapter.notifyDataSetChanged();
                        json = gson.toJson(animalList) ;
                        editor.putString("task list", json) ;
                        editor.apply() ;
                        check.show();
                    }
                }) ;
                click.setNegativeButton("취소", null);
                click.show() ;
                return false;
            }
        });
    }

    public DogList(Activity activity, String title, DogListAdapter listAdapter, View.OnClickListener checkBtListener) {
        super(activity, android.R.style.Theme_Translucent_NoTitleBar);
        this.activity = activity;
        this.title = title;
        this.listAdapter = listAdapter;
        this.checkBtListener = checkBtListener;

    }
    public void dialog(String name, String gender, int image){
        mCustomDialog = new MypageMain(getContext(),
                "[ 나의 댕댕이 ]", name, image, gender, saveListener,
                closeListener, menu1Listener, menu2Listener, menu3Listener); // 오른쪽 버튼 이벤트
        mCustomDialog.show();

    }
    public void edit(String name, String gender, int image){
        animalList.set(position, new DogItem(name, gender, image, dogSpe, dogSpeNum)) ;
        MainActivity.listviewadapter.notifyDataSetChanged();
        json = gson.toJson(animalList) ;
        editor.putString("task list", json) ;
        editor.apply() ;
    }
    private View.OnClickListener saveListener = new View.OnClickListener() {
        @SuppressLint("ResourceType")
        public void onClick(View v) {
            mCustomDialog.dismiss() ;
            LayoutInflater inflater = getLayoutInflater();
            final View dialogView = inflater.inflate(R.layout.sign_up_layout, null);
            edit_name = (EditText) dialogView.findViewById(R.id.dialog_edit);
            rg = (RadioGroup)dialogView.findViewById(R.id.signup_genderGroup) ;
            rb_female = (RadioButton)dialogView.findViewById((R.id.dialog_rb_female)) ;
            rb_male = (RadioButton)dialogView.findViewById(R.id.dialog_rb_male) ;
            edit_name.setText(dogName) ;

            if(dogGender.equals("남아")){ rg.check(rb_male.getId()) ; }
            else if(dogGender.equals("여아")){ rg.check(rb_female.getId()) ; }

            final AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext()) ;
            builder1.setTitle("[댕댕이]");
            builder1.setView(dialogView);

            builder1.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    AlertDialog.Builder check = new AlertDialog.Builder(getContext(), R.style.CheckDialog);
                    check.setMessage("수정되었습니다.");
                    check.setNegativeButton("확인",null);
                    // TODO Auto-generated method stub
                    String s = dogName ;
                    dogName = edit_name.getText().toString();
                    int id = rg.getCheckedRadioButtonId() ;
                    rb = (RadioButton) dialogView.findViewById(id) ;
                    if(dogName.equals("")) dogName = s ;
                    if(id==-1) dogGender = "" ;
                    else dogGender = rb.getText().toString() ;
                    edit(dogName, dogGender, dogImage) ;
                    check.show() ;
                }
            });
            builder1.setNegativeButton("취소", null) ;
            builder1.show() ;
        }
    };
    private View.OnClickListener closeListener = new View.OnClickListener() {
        public void onClick(View v) {
            mCustomDialog.dismiss() ;
        }
    };
    private View.OnClickListener mCloseListener = new View.OnClickListener() {
        public void onClick(View v) {
            newDialog.dismiss();
        }
    };
    private View.OnClickListener menu1Listener = new View.OnClickListener() {
        public void onClick(View v) {
            activity.startActivity(new Intent(getContext(),EmotionMypage.class)); // 감정 분석 페이지 이동
        }
    };
    private View.OnClickListener menu2Listener = new View.OnClickListener() {
        public void onClick(View v) {
            activity.startActivity(new Intent(getContext(),EmotionMypage.class)); // 문제 행동 페이지 이동
        }
    };
    private View.OnClickListener menu3Listener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent species = new Intent(getContext(), SpeciesMypage.class);
            species.putExtra("QRcode", dogSpeNum);
            species.putExtra("QRname", dogSpe);
            activity.startActivity(species); // 종별 특성 페이지 이동과 특수값 전달 해야하는데 데이터베이스를 활용한 문제해결을 해야함.
        }
    };
}