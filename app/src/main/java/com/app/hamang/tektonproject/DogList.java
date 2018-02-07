package com.app.hamang.tektonproject;

/**
 * Created by JKPC on 2018-02-06.
 */

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
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

/**
 * Created by JKPC on 2018-02-06.
 */


public class DogList extends Dialog {
    private MypageMain mCustomDialog,newDialog;
    private Activity activity;
    private String title;
    private View.OnClickListener checkBtListener;

    //private View.OnClickListener xButtonClick ;
    DogListAdapter listAdapter;
    private Button closeBt;
    private TextView dialogTitle;
    private EditText edit_name ;
    private RadioGroup rg ;
    private RadioButton rb ;
    private RadioButton rb_female ;
    private RadioButton rb_male ;
    //private TextView xButton ;
    public ListView listView;
    AlertDialog.Builder click ;
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
        // 메인 layout
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.7f;
        getWindow().setAttributes(lpWindow);
        setContentView(R.layout.dog_list_layout);
        LayoutInflater inflater1=getLayoutInflater();
        final View xButtonView = inflater1.inflate(R.layout.dog_list_layout_row, null);
        closeBt = (Button) findViewById(R.id.listview_bt);
        dialogTitle = (TextView) findViewById(R.id.list_title);
        listView = (ListView) findViewById(R.id.listview);
        //xButton=(TextView)xButtonView.findViewById(R.id.Xbutton) ;
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
                //select(item.animalName) ;
                Toast.makeText(getContext(), item.animalName, Toast.LENGTH_LONG).show() ;
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
                click = new AlertDialog.Builder(new ContextThemeWrapper(getContext(), R.style.CheckDialogStyle));
                click.setMessage("삭제하시겠습니까?") ;
                click.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Object o = listView.getItemAtPosition(xPos) ;
                        DogItem item = (DogItem) o ;
                        MainActivity.animalList.remove(xPos) ;
                        listView.clearChoices();
                        MainActivity.listviewadapter.notifyDataSetChanged();
                    }
                }) ;
                click.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        Toast.makeText(getContext(), "취소", Toast.LENGTH_SHORT).show();
                    }
                });
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
        MainActivity.animalList.set(position, new DogItem(name, gender, image, dogSpe, dogSpeNum)) ;
        MainActivity.listviewadapter.notifyDataSetChanged();
    }
    private View.OnClickListener saveListener = new View.OnClickListener() {
        @SuppressLint("ResourceType")
        public void onClick(View v) {
            mCustomDialog.dismiss() ;
            Toast.makeText(getContext(), "등록", Toast.LENGTH_SHORT).show();
            LayoutInflater inflater = getLayoutInflater();
            final View dialogView = inflater.inflate(R.layout.signup_layout, null);
            edit_name = (EditText) dialogView.findViewById(R.id.dialog_edit);
            rg = (RadioGroup)dialogView.findViewById(R.id.signup_genderGroup) ;
            rb_female = (RadioButton)dialogView.findViewById((R.id.dialog_rb_female)) ;
            rb_male = (RadioButton)dialogView.findViewById(R.id.dialog_rb_male) ;
            edit_name.setText(dogName) ;
            if(dogGender=="남아"){
                rg.check(rb_male.getId());
            }
            else if(dogGender=="여아"){
                rg.check(rb_female.getId()) ;
            }
            final AlertDialog.Builder buider1 = new AlertDialog.Builder(getContext()) ;
            //final AlertDialog.Builder buider1 = new AlertDialog.Builder(new ContextThemeWrapper(getContext(), R.style.CheckDialog));
            buider1.setTitle("[댕댕이]");
            buider1.setView(dialogView);
            buider1.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub
                    //edit_name.setHint(editName);
                    dogName = edit_name.getText().toString();
                    int id = rg.getCheckedRadioButtonId() ;
                    rb = (RadioButton) dialogView.findViewById(id) ;
                    if(id==-1){
                        dogGender = "" ;
                    }
                    else{
                        dogGender = rb.getText().toString() ;
                    }
                    edit(dogName, dogGender, dogImage) ;
                    //setDialog(dogName, dogGender, dogImage) ;
                }
            });
            buider1.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub
                    Toast.makeText(getContext(), "취소", Toast.LENGTH_SHORT).show();
                }
            });
            AlertDialog dialog=buider1.create();
            dialog.setCanceledOnTouchOutside(false);//없어지지 않도록 설정
            dialog.show();
        }
    };
    public void setDialog(String setName, String setGender, int setImage){
        newDialog = new MypageMain(getContext(),
                "[ 나의 댕댕이 ]", setName, setImage, setGender, saveListener,
                mCloseListener, menu1Listener, menu2Listener, menu3Listener); // 오른쪽 버튼 이벤트
        newDialog.show();
    }
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