package com.app.hamang.tektonproject;

import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class BucketMain extends AppCompatActivity {
    private String listtitle;
    private String listmessage;
    private String str1,str2,str3,str4,str5,str6,str7,str8,str9,str10;
    private String str11,str12,str13,str14,str15,str16,str17,str18,str19,str20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_bucket);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textviewClick();
        switchChecked();
    }
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
    public void textviewClick() {
        final AlertDialog.Builder bucketdialog = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.BucketAlertDialogStyle));
        bucketdialog.setNegativeButton("x", null);
        TextView.OnClickListener onClickListener = new TextView.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.bucket1title:
                        listtitle = "가족사진 찍기";
                        listmessage = "우리사랑 영원히\n우리는 식구니까!! 반려견과 함께 가족사진 찍기";
                        break;
                    case R.id.bucket2title:
                        listtitle = "짝꿍샷 찍기";
                        listmessage = "둘다 잘나와야 인정\n둘 모두 예쁘고 멋지게 나올 때까지 사진 찍기";
                        break;
                    case R.id.bucket3title:
                        listtitle = "뚱견 탈출하기";
                        listmessage = "강아지도 삼겹살이?\n뚱견 탈출기! 다이어트는 오늘부터!";
                        break;
                    case R.id.bucket4title:
                        listtitle = "반려동물 등록증 만들기";
                        listmessage = "반려견의 주민등록증\n만약의 경우를 위해 등록번호(15자리)를 발급받기.\n"+
                                "등록 가능한 동물병원은 \"동물보호관리시스템 홈페이지(www.animal.go.kr)\"에서 확인";
                        break;
                    case R.id.bucket5title:
                        listtitle = "물놀이 함께하기";
                        listmessage = "물개?\n반려견의 멋진 개헤엄을 사진이나 동영상으로 남기기";
                        break;
                    case R.id.bucket6title:
                        listtitle = "러브 하우스";
                        listmessage = "반려견은 건물주\n여름에는 시원하게, 겨울에는 따뜻한 집을 만들어 주기";
                        break;
                    case R.id.bucket7title:
                        listtitle = "개생샷 찍기";
                        listmessage = "강아지의 인생샷\n유난히 예뻐 보일 때, 꼭 사진으로 남기기!";
                        break;
                    case R.id.bucket8title:
                        listtitle = "건강검진하기";
                        listmessage = "예방이 최고\n아파도 말 못하는 댕댕이를 위해 최소 2번은 종합 건강검진을 하기";
                        break;
                    case R.id.bucket9title:
                        listtitle = "친구 만들기";
                        listmessage = "인싸이드 댕댕이\n사회성을 위해 더 많은 친구를 만나게 해주기";
                        break;
                    case R.id.bucket10title:
                        listtitle = "반려견 전용 캠핑장 가기";
                        listmessage = "강아지 동반 금지?\n반려견과 함께 전용 캠핑장에서 추억만들기";
                        break;
                    case R.id.bucket11title:
                        listtitle = "동네 산책하기";
                        listmessage = "함께 산책하며 시간을\n똥봉투 꼭 챙기고 함께 산책하기";
                        break;
                    case R.id.bucket12title:
                        listtitle = "만약을 위해 전신사진 찍기";
                        listmessage = "만약을 위해\n반려견이 사라졌을 때를 대비한 전신사진- 앞, 옆, 뒷태, 전신 사진 자주 찍어두기" ;
                        break;
                    case R.id.bucket13title:
                        listtitle = "댕댕이 적금통장 만들기";
                        listmessage = "나보다 부자\n반려견이 아플 때 등 위급한 순간을 위해 적금통장을 만들기";
                        break;
                    case R.id.bucket14title:
                        listtitle = "펫카페 놀러 가기";
                        listmessage = "반갑다 친구야\n펫카페에 함께가서 친구 사귀기";
                        break;
                    case R.id.bucket15title:
                        listtitle = "발도장 액자 만들기";
                        listmessage = "영원히 간직하기\n유아 물감을 이용해서 반려견 발도장을 액자로 만들어보기";
                        break;
                    case R.id.bucket16title:
                        listtitle = "반려견 전용 운동장 가기";
                        listmessage = "마음껏 뛰놀게\n그동안 못뛰놀은 반려견을 위해, 탁 트인 개 운동장에 함께 가기";
                        break;
                    case R.id.bucket17title:
                        listtitle = "함께 여행가기";
                        listmessage = "동네에만?\n동네에만 있을 수 없는 우리 댕댕이! 대한민국 구석구석 함께 하기";
                        break;
                    case R.id.bucket18title:
                        listtitle = "패셔니스타 도전하기";
                        listmessage = "패션, 헤어 빠짐없이\n댕댕이를 패셔니스타로 만들어주기";
                        break;
                    case R.id.bucket19title:
                        listtitle = "이름표 달기";
                        listmessage = "이름표 필수\n강아지 보호를 위해 해시태그 #강아지이름표 와 사진을 SNS에 올리기";
                        break;
                    case R.id.bucket20title:
                        listtitle = "특별식 만들어주기";
                        listmessage = "지루한 사료\n뻔한 간식, 사료 말고 특별식 직접 만들어주기";
                        break;
                }
                bucketdialog.setTitle(listtitle);
                bucketdialog.setMessage(listmessage);
                bucketdialog.show();
            }
        };
        TextView bucketList1 = (TextView) findViewById(R.id.bucket1title);
        bucketList1.setOnClickListener(onClickListener);
        TextView bucketList2 = (TextView) findViewById(R.id.bucket2title);
        bucketList2.setOnClickListener(onClickListener);
        TextView bucketList3 = (TextView) findViewById(R.id.bucket3title);
        bucketList3.setOnClickListener(onClickListener);
        TextView bucketList4 = (TextView) findViewById(R.id.bucket4title);
        bucketList4.setOnClickListener(onClickListener);
        TextView bucketList5 = (TextView) findViewById(R.id.bucket5title);
        bucketList5.setOnClickListener(onClickListener);
        TextView bucketList6 = (TextView) findViewById(R.id.bucket6title);
        bucketList6.setOnClickListener(onClickListener);
        TextView bucketList7 = (TextView) findViewById(R.id.bucket7title);
        bucketList7.setOnClickListener(onClickListener);
        TextView bucketList8 = (TextView) findViewById(R.id.bucket8title);
        bucketList8.setOnClickListener(onClickListener);
        TextView bucketList9 = (TextView) findViewById(R.id.bucket9title);
        bucketList9.setOnClickListener(onClickListener);
        TextView bucketList10 = (TextView) findViewById(R.id.bucket10title);
        bucketList10.setOnClickListener(onClickListener);
        TextView bucketList11 = (TextView) findViewById(R.id.bucket11title);
        bucketList11.setOnClickListener(onClickListener);
        TextView bucketList12 = (TextView) findViewById(R.id.bucket12title);
        bucketList12.setOnClickListener(onClickListener);
        TextView bucketList13 = (TextView) findViewById(R.id.bucket13title);
        bucketList13.setOnClickListener(onClickListener);
        TextView bucketList14 = (TextView) findViewById(R.id.bucket14title);
        bucketList14.setOnClickListener(onClickListener);
        TextView bucketList15 = (TextView) findViewById(R.id.bucket15title);
        bucketList15.setOnClickListener(onClickListener);
        TextView bucketList16 = (TextView) findViewById(R.id.bucket16title);
        bucketList16.setOnClickListener(onClickListener);
        TextView bucketList17 = (TextView) findViewById(R.id.bucket17title);
        bucketList17.setOnClickListener(onClickListener);
        TextView bucketList18 = (TextView) findViewById(R.id.bucket18title);
        bucketList18.setOnClickListener(onClickListener);
        TextView bucketList19 = (TextView) findViewById(R.id.bucket19title);
        bucketList19.setOnClickListener(onClickListener);
        TextView bucketList20 = (TextView) findViewById(R.id.bucket20title);
        bucketList20.setOnClickListener(onClickListener);
    }
    public void switchChecked() {
        SharedPreferences listStatus = getSharedPreferences("listStatus", MODE_PRIVATE);
        final SharedPreferences.Editor editor = listStatus.edit();

        Switch sw1 = (Switch)findViewById(R.id.bucketswitch1);
        Switch sw2 = (Switch)findViewById(R.id.bucketswitch2);
        Switch sw3 = (Switch)findViewById(R.id.bucketswitch3);
        Switch sw4 = (Switch)findViewById(R.id.bucketswitch4);
        Switch sw5 = (Switch)findViewById(R.id.bucketswitch5);
        Switch sw6 = (Switch)findViewById(R.id.bucketswitch6);
        Switch sw7 = (Switch)findViewById(R.id.bucketswitch7);
        Switch sw8 = (Switch)findViewById(R.id.bucketswitch8);
        Switch sw9 = (Switch)findViewById(R.id.bucketswitch9);
        Switch sw10 = (Switch)findViewById(R.id.bucketswitch10);
        Switch sw11 = (Switch)findViewById(R.id.bucketswitch11);
        Switch sw12 = (Switch)findViewById(R.id.bucketswitch12);
        Switch sw13 = (Switch)findViewById(R.id.bucketswitch13);
        Switch sw14 = (Switch)findViewById(R.id.bucketswitch14);
        Switch sw15 = (Switch)findViewById(R.id.bucketswitch15);
        Switch sw16 = (Switch)findViewById(R.id.bucketswitch16);
        Switch sw17 = (Switch)findViewById(R.id.bucketswitch17);
        Switch sw18 = (Switch)findViewById(R.id.bucketswitch18);
        Switch sw19 = (Switch)findViewById(R.id.bucketswitch19);
        Switch sw20 = (Switch)findViewById(R.id.bucketswitch20);
        // 스위치 버튼 리스너를 통해 켰을때 On의 str을 넣어주고 꺼줌이면 지워버리기
        sw1.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton cb, boolean isChecking) {
                if(isChecking) editor.putString("list1","On");
                else editor.remove("list1");
                editor.commit();
            }
        });
        sw2.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton cb, boolean isChecking) {
                if(isChecking) editor.putString("list2","On");
                else editor.remove("list2");
                editor.commit();
            }
        });
        sw3.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton cb, boolean isChecking) {
                if(isChecking) editor.putString("list3","On");
                else editor.remove("list3");
                editor.commit();
            }
        });
        sw4.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton cb, boolean isChecking) {
                if(isChecking) editor.putString("list4","On");
                else editor.remove("list4");
                editor.commit();
            }
        });
        sw5.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton cb, boolean isChecking) {
                if(isChecking) editor.putString("list5","On");
                else editor.remove("list5");
                editor.commit();
            }
        });
        sw6.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton cb, boolean isChecking) {
                if(isChecking) editor.putString("list6","On");
                else editor.remove("list6");
                editor.commit();
            }
        });
        sw7.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton cb, boolean isChecking) {
                if(isChecking) editor.putString("list7","On");
                else editor.remove("list7");
                editor.commit();
            }
        });
        sw8.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton cb, boolean isChecking) {
                if(isChecking) editor.putString("list8","On");
                else editor.remove("list8");
                editor.commit();
            }
        });
        sw9.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton cb, boolean isChecking) {
                if(isChecking) editor.putString("list9","On");
                else editor.remove("list9");
                editor.commit();
            }
        });
        sw10.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton cb, boolean isChecking) {
                if(isChecking) editor.putString("list10","On");
                else editor.remove("list10");
                editor.commit();
            }
        });
        sw11.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton cb, boolean isChecking) {
                if(isChecking) editor.putString("list11","On");
                else editor.remove("list11");
                editor.commit();
            }
        });
        sw12.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton cb, boolean isChecking) {
                if(isChecking) editor.putString("list12","On");
                else editor.remove("list12");
                editor.commit();
            }
        });
        sw13.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton cb, boolean isChecking) {
                if(isChecking) editor.putString("list13","On");
                else editor.remove("list13");
                editor.commit();
            }
        });
        sw14.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton cb, boolean isChecking) {
                if(isChecking) editor.putString("list14","On");
                else editor.remove("list14");
                editor.commit();
            }
        });
        sw15.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton cb, boolean isChecking) {
                if(isChecking) editor.putString("list15","On");
                else editor.remove("list15");
                editor.commit();
            }
        });
        sw16.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton cb, boolean isChecking) {
                if(isChecking) editor.putString("list16","On");
                else editor.remove("list16");
                editor.commit();
            }
        });
        sw17.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton cb, boolean isChecking) {
                if(isChecking) editor.putString("list17","On");
                else editor.remove("list17");
                editor.commit();
            }
        });
        sw18.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton cb, boolean isChecking) {
                if(isChecking) editor.putString("list18","On");
                else editor.remove("list18");
                editor.commit();
            }
        });
        sw19.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton cb, boolean isChecking) {
                if(isChecking) editor.putString("list19","On");
                else editor.remove("list19");
                editor.commit();
            }
        });
        sw20.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton cb, boolean isChecking) {
                if(isChecking) editor.putString("list20","On");
                else editor.remove("list20");
                editor.commit();
            }
        });
        // 최종 상태를 확인하기 위해 스트링으로 가져오기
        str1 = listStatus.getString("list1","");
        str2 = listStatus.getString("list2","");
        str3 = listStatus.getString("list3","");
        str4 = listStatus.getString("list4","");
        str5 = listStatus.getString("list5","");
        str6 = listStatus.getString("list6","");
        str7 = listStatus.getString("list7","");
        str8 = listStatus.getString("list8","");
        str9 = listStatus.getString("list9","");
        str10 = listStatus.getString("list10","");
        str11 = listStatus.getString("list11","");
        str12 = listStatus.getString("list12","");
        str13 = listStatus.getString("list13","");
        str14 = listStatus.getString("list14","");
        str15 = listStatus.getString("list15","");
        str16 = listStatus.getString("list16","");
        str17 = listStatus.getString("list17","");
        str18 = listStatus.getString("list18","");
        str19 = listStatus.getString("list19","");
        str20 = listStatus.getString("list20","");
        // 최종 종료전에 어떤 상태였는지 확인하고 동일한 상태로 만들기
        if(str1.equals("On")) sw1.setChecked(true);
        if(str2.equals("On")) sw2.setChecked(true);
        if(str3.equals("On")) sw3.setChecked(true);
        if(str4.equals("On")) sw4.setChecked(true);
        if(str5.equals("On")) sw5.setChecked(true);
        if(str6.equals("On")) sw6.setChecked(true);
        if(str7.equals("On")) sw7.setChecked(true);
        if(str8.equals("On")) sw8.setChecked(true);
        if(str9.equals("On")) sw9.setChecked(true);
        if(str10.equals("On")) sw10.setChecked(true);
        if(str11.equals("On")) sw11.setChecked(true);
        if(str12.equals("On")) sw12.setChecked(true);
        if(str13.equals("On")) sw13.setChecked(true);
        if(str14.equals("On")) sw14.setChecked(true);
        if(str15.equals("On")) sw15.setChecked(true);
        if(str16.equals("On")) sw16.setChecked(true);
        if(str17.equals("On")) sw17.setChecked(true);
        if(str18.equals("On")) sw18.setChecked(true);
        if(str19.equals("On")) sw19.setChecked(true);
        if(str20.equals("On")) sw20.setChecked(true);
    }
}
