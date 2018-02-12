package com.app.hamang.tektonproject.EducationActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.app.hamang.tektonproject.R;

public class EducationMain extends AppCompatActivity {
    private VideoEducation videodialog;
    private NecessityEducation necessitydialog;
    private ToiletEducation toiletdialog;
    private KennelEducation kenneldialog;
    private SoundEducation sounddialog;

    // 주파수, 클리커
    private MediaPlayer clickersound;
    private MediaPlayer hz1;
    private MediaPlayer hz2;
    private MediaPlayer hz3;
    private MediaPlayer hz4;
    private MediaPlayer hz5;

    AlertDialog.Builder ButtonInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_education);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButtonInfo = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.MyAlertDialogStyle));
        ButtonInfo.setNegativeButton("x", null);

        clickersound = MediaPlayer.create(this, R.raw.sound1);
        hz1 = MediaPlayer.create(this, R.raw.sound2);
        hz2 = MediaPlayer.create(this, R.raw.sound3);
        hz3 = MediaPlayer.create(this, R.raw.sound4);
        hz4 = MediaPlayer.create(this, R.raw.sound5);
        hz5 = MediaPlayer.create(this, R.raw.sound6);
    }

    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.education_video:
                if(isNetworkConnected()) {
                    videodialog = new VideoEducation(this, "영 상",
                            videoClose, videoMenu1, videoMenu2, videoMenu3,
                            videoMenu4, videoMenu5, videoMenu6);
                    videodialog.show();
                } else internetDialog();
                break;
            case R.id.education_necessity:
                necessitydialog = new NecessityEducation(this, "교육의 필요성",
                        necessityClose, necessityMenu1, necessityMenu2);
                necessitydialog.show();
                break;
            case R.id.education_toilet:
                toiletdialog = new ToiletEducation(this, "화장실 교육하기",
                        toiletClose, toiletMenu1, toiletMenu2, toiletMenu3, toiletMenu4);
                toiletdialog.show();
                break;
            case R.id.education_kennel:
                kenneldialog = new KennelEducation(this, "켄넬 교육하기",
                        kennelClose, kennelMenu1, kennelMenu2, kennelMenu3, kennelMenu4);
                kenneldialog.show();
                break;
            case R.id.education_sound:
                sounddialog = new SoundEducation(this, "소리로 교육하기",
                        soundClose, clickerButton, khzButton8, khzButton10,
                        khzButton12, khzButton14, khzButton16);
                sounddialog.show();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private View.OnClickListener videoClose = new View.OnClickListener() {
        public void onClick(View v) {
            videodialog.dismiss();
        }
    };
    private View.OnClickListener videoMenu1 = new View.OnClickListener() {
        public void onClick(View v) {
            Intent video1 = new Intent(Intent.ACTION_VIEW) ;
            video1.setData(Uri.parse("https://youtu.be/9VB5qDk5BrM"));
            startActivity(video1);
        }
    };
    private View.OnClickListener videoMenu2 = new View.OnClickListener() {
        public void onClick(View v) {
            Intent video2 = new Intent(Intent.ACTION_VIEW) ;
            video2.setData(Uri.parse("https://youtu.be/6IHmUgQJAME"));
            startActivity(video2) ;
        }
    };
    private View.OnClickListener videoMenu3 = new View.OnClickListener() {
        public void onClick(View v) {
            Intent video3 = new Intent(Intent.ACTION_VIEW) ;
            video3.setData(Uri.parse("https://youtu.be/sH5b7FoYgXo"));
            startActivity(video3) ;
        }
    };
    private View.OnClickListener videoMenu4 = new View.OnClickListener() {
        public void onClick(View v) {
            Intent video4 = new Intent(Intent.ACTION_VIEW) ;
            video4.setData(Uri.parse("https://youtu.be/39rRW652hQE"));
            startActivity(video4) ;
        }
    };
    private View.OnClickListener videoMenu5 = new View.OnClickListener() {
        public void onClick(View v) {
            Intent video5 = new Intent(Intent.ACTION_VIEW) ;
            video5.setData(Uri.parse("https://youtu.be/6rI6KEauC-4"));
            startActivity(video5) ;
        }
    };
    private View.OnClickListener videoMenu6 = new View.OnClickListener() {
        public void onClick(View v) {
            Intent video6 = new Intent(Intent.ACTION_VIEW) ;
            video6.setData(Uri.parse("https://youtu.be/Mo69m_kRZl4"));
            startActivity(video6) ;
        }
    };
    private View.OnClickListener necessityClose = new View.OnClickListener() {
        public void onClick(View v) {
            necessitydialog.dismiss();
        }
    };
    private View.OnClickListener necessityMenu1 = new View.OnClickListener() {
        public void onClick(View v) {
            ButtonInfo.setTitle("교육이 필요한 이유");
            ButtonInfo.setMessage("\n\n반려인과 반려견은 언어가 통하지 않는다. 그렇기 때문에 서로가 하는 말을 이해할 수 없고 이는 서로 생활하는 데 있어서 크고 작은 문제를 일으킬 수 밖에 없다. \n\n" +
                    "이러한 문제를 최소화하고 서로 원활하게 지내기 위해서는 몇 가지 의사소통 방식을 선택할 수 있는데, 이 수단이 바로 기본 교육이다.\n\n" +
                    "반려인이 하는 모든 말을 알아듣지는 못하더라도 몇 가지의 필수 지시어를 통해 반려인의 의도를 알게 하고 반려견에게 상황을 인식하게 하는 것이 반려견 교육의 목표이다.");
            ButtonInfo.show();
        }
    };
    private View.OnClickListener necessityMenu2 = new View.OnClickListener() {
        public void onClick(View v) {
            ButtonInfo.setTitle("교육의 원칙");
            ButtonInfo.setMessage("\n\n1. 교육의 시작은 학습 습득력이 뛰어난 2~3개월령 부터가 적당하다.\n\n" +
                    "2. 반려견은 사람이 아니기 때문에 집중할 수 있는 시간이 매우 짧다. 교육은 1회에 1~2분 정도씩, 10회에 나누어 하루 총 20분 정도가 적당하다.\n\n" +
                    "3. 교육의 과정은 즐거워야 한다. 쉬운 지시어부터 시작해서 계속 성공을 유도해주면 반려견은 즐거움을 느끼고, 즐거운 기분은 반려견의 더 적극적인 연습 태도를 가지게 되고 이는 좋은 교육의 효과로 이어질 것이다.\n\n"+
                    "4. 교육은 단계적으로 진행되어야 한다. '앉아'를 배우고 '손'을 배우고 '엎드려'를 배우는 식으로 점차 다음 행동을 할 수 있게 가르칠 필요가 있다.\n\n"+
                    "5. 교육에는 일관성이 있어야 한다. 지시어에 대해 맞는 행동을 했는데 어떤 때는 보상이 있고, 어떤 때는 보상이 없다면, 반려견의 입장에서는 혼란스러울 수 있다. 지시어에 따라 맞는 행동을 한다면 반드시 즉시 보상을 해야 한다.\n\n" +
                    "6. 지시어는 간략하고 명확해야 한다. 길게 말해도 반려견은 반려인의 말을 이해할 수 없을 뿐더러 이는 연습 시 훈련만 더해져야 한다. \n\n" +
                    "특정 행동에는 특정 손동작과 함께 보여주는 것이 반려견이 이해하기가 더 쉬울 것이다. \n");
            ButtonInfo.show();
        }
    };
    private View.OnClickListener toiletClose  = new View.OnClickListener() {
        public void onClick(View v) {
            toiletdialog.dismiss();
        }
    };
    private View.OnClickListener toiletMenu1 = new View.OnClickListener() {
        public void onClick(View v) {
            ButtonInfo.setTitle("화장실 교육시 유념할 사항");
            ButtonInfo.setMessage("\n\n1. 화장실 교육을 할 때는 개의 본능을 이용하는 것이 중요.\n\n" +
                    "2. 개는 먹고 자는 장소에서 배설하지 않는다.\n\n" +
                    "3. 개는 소변 냄새가 있는 곳, 풀이나 흙이 있는 곳, 흡수성이 있는 곳에서 배설한다.\n\n" +
                    "4. 배설 전에는 다소 안절부절 못하면서 돌아다니다가, 냄새를 맡으며 같은 자리를 빙글빙글 도는 행동을 보인다.\n\n" +
                    "5. 화장실(패드)에서 배설하게 하여, 화장실과 배설을 연결할 수 있게 해야 한다.\n\n" +
                    "6. 화장실 교육 중에는 정확한 위치에 배설을 성공했을 때 즉시 간식으로 보상을 해줘야 한다. \n\n" +
                    "7. 반려견이 화장실에서 배설을 하고, 있으면, '쉬-'라는 지시어를 반복해서, 이후 '쉬-'라는 말에 배설할 수 있게 해야 한다.\n\n" +
                    "8. 화장실 교육은 2주 정도 반복하면 어느 정도 몸에 익고, 한 달 정도가 되면 습관으로 굳어져야 한다.\n\n" +
                    "9. 일반적으로 9주령에 화장실 습관이 굳어지므로, 그 전에 화장실 교육을 완료하는 것이 좋다.");
            ButtonInfo.show();
        }
    };
    private View.OnClickListener toiletMenu2 = new View.OnClickListener() {
        public void onClick(View v) {
            ButtonInfo.setTitle("기초 화장실 교육");
            ButtonInfo.setMessage("\n\n활동하는 공간을 너무 넓지 않게 울타리 등으로 제한하고, 그 공간 안에 배변 패드를 넓게 여러 곳에 깔아 줘야 한다.\n\n" +
                    "반려견이 배설 신호를 보이면 재빨리 패드 위로 옮겨서 배설을 하게 하고, 패드 위에서 배설을 한 후에는 즉시 간식으로 보상해줘야 한다. \n\n" +
                    "스스로 배설을 한 경우, 자주 배설을 하는 패드만 남겨두는 식으로 패드를 점차 치워줘야 한다. 최종적으로 패드 1개가 남을 때까지 패드의 수를 줄이면서 원하는 장소로 서서히 옮겨줘야 한다. \n\n" +
                    " 반려견이 지정된 장소에서 배설을 하고 있으면, '쉬-'라는 지시어를 반복해서, 이후 '쉬-'라는 말에 배설할 수 있게 해야 한다.\n\n" +
                    "만약 패드가 아닌 다른 곳에 배설한 흔적이 있다면 소취제로 냄새를 제거해 주는 것도 잊지 않는다. ");
            ButtonInfo.show();
        }
    };
    private View.OnClickListener toiletMenu3 = new View.OnClickListener() {
        public void onClick(View v) {
            ButtonInfo.setTitle("화장실 교육시 실패");
            ButtonInfo.setMessage("\n\n1. 화장실 실수를 혼냈다.\n" +
                    "화장실 실수를 하는 중에 혼을 내면, 반려견은 배설을 하는 행동 자체가 잘못된 거라고 오해할 수 있다. 이 경우 자신이 배설한 변을 먹어서 없애는 행동을 보이기도 한다.\n" +
                    "또한 화장실 실수를 한 지 한참이 지난 후에 혼을 내면 반려견은 이유도 모른체 혼나게 된다\n" +
                    "반려견이 화장실 실수를 했을 대는 혼내지 말고, 배설물을 바로 치우고 소취제를 뿌려 냄새를 제거해준다. \n\n" +
                    "2. 화장실 실수 후 , 화장실에 데려갔다.\n" +
                    "이미 배설을 끝낸 후라 더 이상 배설할 것이 없는데도 화장실에 데려가서 잔소리를 한다면, 화장실에 대한 부정적인 인식만 커질 것이다.\n\n" +
                    "3. 자는 곳, 먹는 곳에 화장실을 만들었거나 지붕이 있는 화장실을 만들었다.\n" +
                    "개의 본능을 고려했을 때, 화장실은 자는 곳, 먹는 곳과 떨어져 있어야 하고 지붕은 없어야 한다. 만약 울타리 안에 모든 공간이 있어야 하는 환경이라면 그 안에서 최대한 떨어뜨려 준다. \n\n" +
                    "4. 넓은 공간 한 구석에만 화장실을 만들었다. \n"+"활동하는 공간은 넓은데 화장실은 한 쪽에만 있다면, 화장실을 찾기 힘들어서 실수했을 확률이 높다. 이 경우 울타리 등으로 활동 공간의 제한을 두는 게 도움이 될 수 있다. \n\n" +
                    "5. 배설물 냄새를 확실히 제거하지 않았다.\n" +
                    "배설 실수한 곳에 냄새가 남아 있다면, 이후 그곳에서의 배설을 유도하는 요인이 될 수 있으므로 소취제를 뿌려 냄새를 완벽하게 제거해 줘야 한다.");
            ButtonInfo.show();
        }
    };
    private View.OnClickListener toiletMenu4 = new View.OnClickListener() {
        public void onClick(View v) {
            if(isNetworkConnected()) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://youtu.be/vRzkMWZ61Vs"));
                startActivity(intent);
            } else {
                internetDialog();
            }
        }
    };
    private View.OnClickListener kennelClose = new View.OnClickListener() {
        public void onClick(View v) {
            kenneldialog.dismiss();
        }
    };
    private View.OnClickListener kennelMenu1 = new View.OnClickListener() {
        public void onClick(View v) {
            ButtonInfo.setTitle("켄넬 연습의 필요성");
            ButtonInfo.setMessage("\n\n반려견에게도 마음 놓고 쉴 휴식 공간이 필요하다. 이를 위해서 '개는 원래 야생에서 굴 생활을 했다'는 습성을 고려하여, 반려견의 주거 공간에 켄넬을 마련해 줄 것을 추천한다. \n\n" +
                    "켄넬은 외부 자극에 예민하게 반응하는 반려견의 심신 안정을 위한 도피처가 되기에 적합하다. \n" +
                    "또한 장거리 이동을 할 때도 유용하게 이용될 수 있다. 이미 켄넬은 반려견에게 익숙한 곳이고, 작은 공간에서도 평온할 수 있는 연습이 되어 있기 때문에, 스트레스를 덜 받을 수 있다. 잠깐 동안 주변 환경관 반려견을 분리할 때도 켄넬은 유용하다. \n\n" +
                    "반려견마다 차이는 있지만, 켄넬 안에 들어가면 마음 편히 쉴 수 있다는 것을 알게 해주는 데에는 시간이 다소 소요될 수 있다.");
            ButtonInfo.show();
        }
    };
    private View.OnClickListener kennelMenu2 = new View.OnClickListener() {
        public void onClick(View v) {
            ButtonInfo.setTitle("바람직한 켄넬의 조건");
            ButtonInfo.setMessage("\n\n켄넬은 뚜껑과 바닥을 분리할 수 있는 플라스틱 이동장을 말한다.\n\n" +
                    "플라스틱 이동장은 컨넬 또는 크레이트라고 하는데, 켄넬에 들어가는 반복 연습을 할 때에는 하우스라고 부르기도 한다.\n\n" +
                    "반려견은 몸에 딱 맞는 공간 안에서 마음의 평온함을 느낀다. 종종 반련견이 몸에 딱 맞는 크기의 구석에 웅크리고 있는 것을 본 적이 있을 것이다. \n\n" +
                    "이와 같은 맥락으로 켄넬의 크기를 생각해 보면, 반려견이 켄넬에 들어가서 고개를 든 상태에서 여유있게 고개를 든 상태에서 여유있게 고개를 돌릴 수 있을 정도의 크기가 딱 알맞은 사이즈이다.\n\n" +
                    "여유 공간이 너무 많으면 반려견의 입장에서는 그다지 마음이 편하지 않을 수 있기 때문에, 여유 공간이 많은 켄넬은 선택하지 않도록 해야 한다. \n\n"+
                    "또한, 켄넬은 위 아래를 분리할 수 있는 것이 좋다. 위 아래가 분리되는 켄넬은 켄넬 연습을 할 때도 유용하고, 병원에서 진료를 받을 때도 유용할 수 있다. \n\n" +
                    "켄넬은 사람들이 자주 들락날락하는 현관이 정면으로 보이거나, 외부 자극에 노출되는 장소와는 거리가 있되, 가족들이 함께 있다는 것이 느껴질 정도의 공간에 두는 것이 좋다.");
            ButtonInfo.show();
        }
    };
    private View.OnClickListener kennelMenu3 = new View.OnClickListener() {
        public void onClick(View v) {
            ButtonInfo.setTitle("켄넬 연습하는 방법");
            ButtonInfo.setMessage("\n\n처음 켄넬을 마주할 때는 어색하고, 이상해서 반려견이 들어가지 않으려 할 수 있다. \n\n" +
                    "하지만 반복 학습을 하면 반려견이 켄넬을 편안한 곳으로 인식하게 할 수 있다. \n\n" +
                    "첫 번재 목표는 '켄넬에 대한 긍정적인 느낌 심어주기'이다. 켄넬 안에 반려견이 좋아하는 담요, 장난감, 먹을거리, 물 등을 넣어 놓으면 반려견은 켄넬에 차차 흥미를 가지게 된다. \n\n" +
                    "처음에 들어가기를 너무 꺼린다면 뚜껑을 열어두고, 차츰 뚜껑을 덮어준다.\n\n" +
                    "켄넬에 스스로 들어가는 장면을 종종 목격한다면 켄넬 안에서 밥을 먹을 수 있도록 사료를 넣어 주고, 그 시간 동안 잠시 문을 닫아 본다. \n\n" +
                    "잠시 문을 닫아 놓은 상태에 익숙해지기 전까지는 닫아 놓는 시간을  너무 길게하지 않는 것이 중요하다. \n\n" +
                    "잠시 문을 열고, 닫고 하는 동안에도 반려견이 켄넬 안에 잘 들어가 있는 다면, 반려인이 켄넬 곁에 함께 있는 상태로 문을 닫는 시간을 점차 늘여 본다. \n\n" +
                    "컨넬 안에 들어갈 때 '하우스'라는 지시어를 입히는 연습을 하고, 지시어에 따라 잘 들어갔다면 즉시 보상을 한다. \n\n" +
                    "그럭저럭 잘 들어가 있는 다고 생각이 된다면 반려견이 혼자 있을 때, 잠시 문 닫아보기를 한다. \n\n"+
                    "이 단계에서는 반려인이 잠시 자리를 비웠다가 반려견이 불안해지기 전에 돌아오는 것이 키 포인트이다. \n\n"+
                    "이와같은 방법으로, 켄넬이 반려견에게 자연스러운 휴식 공간이자 잠시 돌아가서 버틸 수도 있는 공간으로 인식될 수 있도록 한다. \n\n" +
                    "*TIP\n" +
                    "켄넬을 징벌적 의미로 이용하지는 않도록 주의한다. 벌을 주는 의미로서 하우스로 들어가라고 한다면, 하우스가 반려견에게 마음 편한 공간으로 인되기는 어려울 수 있다. ");
            ButtonInfo.show();
        }
    };
    private View.OnClickListener kennelMenu4 = new View.OnClickListener() {
        public void onClick(View v) {
            if(isNetworkConnected()) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://youtu.be/pJbFfrXr-qw"));
                startActivity(intent);
            } else {
                internetDialog();
            }
        }
    };
    private View.OnClickListener soundClose = new View.OnClickListener() {
        public void onClick(View v) {
            sounddialog.dismiss();
        }
    };
    private View.OnClickListener clickerButton = new View.OnClickListener() {
        public void onClick(View v) {
            clickersound.start() ;
        }
    };
    private View.OnTouchListener khzButton8 = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN) {
                hz1.start();
            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                hz1.start();
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                hz1.pause();
            }
            return true;
        }
    };
    private View.OnTouchListener khzButton10 = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN) {
                hz2.start();
            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                hz2.start();
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                hz2.pause();
            }
            return true;
        }
    };
    private View.OnTouchListener khzButton12 = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN) {
                hz3.start();
            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                hz3.start();
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                hz3.pause();
            }
            return true;
        }
    };
    private View.OnTouchListener khzButton14 = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN) {
                hz4.start();
            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                hz4.start();
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                hz4.pause();
            }
            return true;
        }
    };
    private View.OnTouchListener khzButton16 = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN) {
                hz5.start();
            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                hz5.start();
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                hz5.pause();
            }
            return true;
        }
    };
    private boolean isNetworkConnected() {
        ConnectivityManager internet = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetWork = internet.getActiveNetworkInfo();
        boolean isNetworkConnected = activeNetWork != null && activeNetWork.isConnectedOrConnecting();
        return isNetworkConnected;
    }
    private void internetDialog() {
        android.app.AlertDialog.Builder internetdialog = new android.app.AlertDialog.Builder(new ContextThemeWrapper(this, R.style.WarnningDialogStyle));
        internetdialog.setNegativeButton("확인",null);
        internetdialog.setTitle("인터넷 없음");
        internetdialog.setMessage("현재 인터넷을 찾을 수 없습니다. WiFi또는 데이터 네트워크를 확인해 주세요.");
        internetdialog.show();
    }
}