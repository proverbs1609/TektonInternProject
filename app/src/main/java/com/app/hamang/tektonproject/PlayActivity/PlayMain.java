package com.app.hamang.tektonproject.PlayActivity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextThemeWrapper;
import android.view.View;

import com.app.hamang.tektonproject.R;

public class PlayMain extends AppCompatActivity {
    private VideoPlay videodialog;
    private NecessityPlay necessitydialog;
    private RulePlay ruledialog;
    private ToyPlay toydialog;

    AlertDialog.Builder ButtonInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButtonInfo = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.MyAlertDialogStyle));
        ButtonInfo.setNegativeButton("x", null);
    }
    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.play_video:
                videodialog = new VideoPlay(this, "영 상",
                        videoClose, videoMenu1, videoMenu2, videoMenu3,
                        videoMenu4, videoMenu5, videoMenu6);
                videodialog.show();
                break;
            case R.id.play_necessity:
                necessitydialog = new NecessityPlay(this,"놀이의 필요성",
                        necessityClose, necessityMenu1, necessityMenu2);
                necessitydialog.show();
                break;
            case R.id.play_rule:
                ruledialog = new RulePlay(this,"놀이 규칙",
                        ruleClose, ruleMenu1, ruleMenu2, ruleMenu3);
                ruledialog.show();
                break;
            case R.id.play_toy:
                toydialog = new ToyPlay(this,"장난감",
                        toyClose, toyMenu1, toyMenu2, toyMenu3);
                toydialog.show();
                break;
        }
    }

    private View.OnClickListener videoClose = new View.OnClickListener() {
        public void onClick(View v) {
            videodialog.dismiss();
        }
    };
    private View.OnClickListener videoMenu1 = new View.OnClickListener() {
        public void onClick(View v) {
            Intent video1 = new Intent(Intent.ACTION_VIEW) ;
            video1.setData(Uri.parse("https://youtu.be/z2LlmKC2giY"));
            startActivity(video1);
        }
    };
    private View.OnClickListener videoMenu2 = new View.OnClickListener() {
        public void onClick(View v) {
            Intent video2 = new Intent(Intent.ACTION_VIEW) ;
            video2.setData(Uri.parse("https://youtu.be/z2LlmKC2giY"));
            startActivity(video2) ;
        }
    };
    private View.OnClickListener videoMenu3 = new View.OnClickListener() {
        public void onClick(View v) {
            Intent video3 = new Intent(Intent.ACTION_VIEW) ;
            video3.setData(Uri.parse("https://youtu.be/z2LlmKC2giY"));
            startActivity(video3) ;
        }
    };
    private View.OnClickListener videoMenu4 = new View.OnClickListener() {
        public void onClick(View v) {
            Intent video4 = new Intent(Intent.ACTION_VIEW) ;
            video4.setData(Uri.parse("https://youtu.be/z2LlmKC2giY"));
            startActivity(video4) ;
        }
    };
    private View.OnClickListener videoMenu5 = new View.OnClickListener() {
        public void onClick(View v) {
            Intent video5 = new Intent(Intent.ACTION_VIEW) ;
            video5.setData(Uri.parse("https://youtu.be/z2LlmKC2giY"));
            startActivity(video5) ;
        }
    };
    private View.OnClickListener videoMenu6 = new View.OnClickListener() {
        public void onClick(View v) {
            Intent video6 = new Intent(Intent.ACTION_VIEW) ;
            video6.setData(Uri.parse("https://youtu.be/z2LlmKC2giY"));
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
            ButtonInfo.setTitle("놀이가 필요한 이유");
            ButtonInfo.setMessage("\n\n야생에서의 개는 먹을거리를 얻기 위해 사냥 활동을 했지만, 사람과 함께 지내게 되면서 사람으로부터 얻게 되었고 개는 더 이상 사냥을 할 필요가 없어졌다.\n\n"+
                    "하지만 사냥을 할 때의 넘치는 본능적인 에너지는 여전히 지니고 있다. 그렇기 때문에 매일 매일을 놀이나 산책 등을 통해 넘쳐나는 에너지를 해소하지 않는 다면 물건을 물고 뜯고 찢는 행동을 보이게 되고 반려인은 이를 반려견의 문제 행동으로 인식한다.\n\n"+
                    "실제로 산책이나 놀이를 통해 꾸준히 에너지를 분출한 한 반려견의 경우에는 문제행동이 개선되는 사례가 많아요\n\n"+
                    "행복한 반려동물은 잔뜩 놀아서 피곤한 반려동물이라는 이야기가 있는 만큼, 산책이나 놀이로 에너지를 해소해 주는 것이 중요하다.");
            ButtonInfo.show();
        }
    };
    private View.OnClickListener necessityMenu2 = new View.OnClickListener() {
        public void onClick(View v) {
            ButtonInfo.setTitle("놀이의 원리");
            ButtonInfo.setMessage("\n\n놀이는 사냥의 축소판이라는 점을 유념해야 한다. 놀이는 과거 야생에서의 개의 사냥 과정과 비슷한다. 사냥감을 발견하고, 쫒아가고, 잡아서 물어 뜯는 것을 재연하는 과정이 곧 반려견의 놀이다.\n\n"+
                    "소리가 나는 장난감은 소리를 내는 작은 사냥감의 대체안이 될 수 있어, 소리가 나지 않는 장난감보다 훨씬 더 흥미로워한다.\n\n"+
                    "사냥시 후각을 이용하는 것 처럼, 어딘가에 먹을 것을 숨겨 놓고 찾게 하는 방법도 좋은 놀이가 될 수 있다. 이런 원리를 이용한 것이 노즈워킹이다. 반려견이 놀이의 원리를 이해하면, 반려견의 놀이 시간은 더욱 풍부하고 재미있을 수 있다.");
            ButtonInfo.show();
        }
    };
    private View.OnClickListener ruleClose = new View.OnClickListener() {
        public void onClick(View v) {
            ruledialog.dismiss();
        }
    };
    private View.OnClickListener ruleMenu1 = new View.OnClickListener() {
        public void onClick(View v) {
            ButtonInfo.setTitle("놀이규칙 1");
            ButtonInfo.setMessage("\n\n반려견과 함께 놀이를 할 때는 반려인의 놀이의 주도자가 되어야 한다.\n\n" +
                    "놀이의 시작과 끝을 반려인이 결정하는 것이 가장 중요하다. 반려견이 보채서 놀이를 시작하거나, 반려견이 지겨워져서 놀이를 끝내는 것, 이런 경험이 반복되면 평소 생활에서도 주도권이 반려견에게로 넘어가, 반려견이 반려인을 따르지 않는 경우가 발생할 수 있어요");
            ButtonInfo.show();
        }
    };
    private View.OnClickListener ruleMenu2 = new View.OnClickListener() {
        public void onClick(View v) {
            ButtonInfo.setTitle("놀이규칙 2");
            ButtonInfo.setMessage("\n\n반려인은 놀이를 통해 반려견의 감정 조절을 교육해야 한다.\n\n" +
                    "놀이를 하다보면 반려견이 쉽게 흥분하는 경우가 많은데, 흥분한 반려견은 순간적으로 공격성을 보일 수 있기 때문에 이런 상황은 유도하지 않는 것이 좋다.\n\n"+
                    "놀이 중 과하게 흥분하는 모습을 보인다면, 기본적인 지시어인 '앉아'를 지시하고, 이를 따르며 흥분히 가라앉았다면 다시 놀이를 이어가도록 해야 한다.");
            ButtonInfo.show();
        }
    };
    private View.OnClickListener ruleMenu3 = new View.OnClickListener() {
        public void onClick(View v) {
            ButtonInfo.setTitle("놀이규칙 3");
            ButtonInfo.setMessage("\n\n 반려견의 교육과 연습의 보상으로 놀이를 하는 것도 좋다. 반려견이 놀이를 좋아한다면 놀이 또한 교육과 연습 시의 보상 수단이 될 수 있다. \n\n" +
                    "지시어를 배우는 과정 중에 음식으로만 보상을 하게 된다면 음식이 없을 때는 지시어를 따르지 않을 수 있다.\n\n" +
                    "그렇기 때문에 음식이 없어도 지시어에 따를 수 있도록 차츰 보상으로서의 음식물 제공을 줄이고 칭찬과 놀이로 보상을 해줄 것을 추천한다.");
            ButtonInfo.show();
        }
    };
    private View.OnClickListener toyClose = new View.OnClickListener() {
        public void onClick(View v) {
            toydialog.dismiss();
        }
    };
    private View.OnClickListener toyMenu1 = new View.OnClickListener() {
        public void onClick(View v) {
            ButtonInfo.setTitle("장난감의 종류");
            ButtonInfo.setMessage("\n\n공, 소리나는 장난감\n" +
                    "반려인이 던지고, 반려견이 물어오는 놀이에 적합하다. 물어서 터트릴 수 있거나 작은 장난감은 삼킬 수 있으므로 주의해야 한다.\n\n"+
                    "봉제인형\n" +
                    "사냥감 삼아 물고 뜯으면서 놀기에 적합함 안고 자거나 베고 자기도 한다.\n"+
                    "반려견 혼자 갖고 놀게 할 수도 있지만, 반려인이 인형을 움직이면서 놀이의 재미를 더해 주면 반려견은 더욱 기뻐하면서 놀 수 있을 것이다.\n"+
                    "다만, 뜯어낼 수 있는 장식물이 달린 경우 삼킬 위험이 있기 때문에 주의해야 한다.\n\n" +
                    "밧줄 \n" +
                    "물고 흔들고 잡아 당기며 놀기에 적합하다. 견종의 크기에 따라 다양한 사이즈를 선택할 수 있다.\n\n" +
                    "콩\n" +
                    "장난감 안에 먹을거리를 넣고 건들이면 조금씩 빠져나오게 하는 오뚝이 모양의 고무 장난감으로, 먹을 것이라는 훌륭한 보상이 있기 때문에 반려견 혼자도 집중력 있게 놀 수 있다. \n" +
                    "그렇기 때문에 반려인이 장시간 자리를 비울 때 덜 외로워 하게 하거나 덜 지루해 하도록 하는 좋은 수단이 될 수 있다.\n" +
                    "울룩불룩한 외형 때문에 바닥에 던지면 이리저리 튀어서, 이를 잡는 재미도 있다.\n" +
                    "어떻게 가지고 놀아야할 지 어리둥절해 한다며, 따라할 수 있도록 몇 번 시범을 보여 주세요. ");
            ButtonInfo.show();
        }
    };
    private View.OnClickListener toyMenu2 = new View.OnClickListener() {
        public void onClick(View v) {
            ButtonInfo.setTitle("적절치 못한 장난감");
            ButtonInfo.setMessage("\n\n반려인이 이용하던 물건이 낡으면 장난감으로 가지고 놀라며 반려견에게 주는 경우가 있다. 하지만 이러한 방법은 반려견에게 호선을 줄 수 있어 그다지 좋지 않다.\n\n" +
                    "장난감 대신 낡은 슬리퍼를 장난감 삼아 반려견에게 준다면, 반려견은 슬리퍼를 가지고 놀아도 되는 물건으로 인식하고, 집 안의 모든 슬리퍼를 물어 뜯을 수 있다.\n\n" +
                    "그렇기 때문에 장난감과 장난감이 아닌 것의 구븐을 명확히 해줘야 한다.\n\n" +
                    "또한 구슬 등의 장식물이 붙어 있는 장난감도 삼킬 위험이 있으므로 주지 않도록 해야 한다.");
            ButtonInfo.show();
        }
    };
    private View.OnClickListener toyMenu3 = new View.OnClickListener() {
        public void onClick(View v) {
            ButtonInfo.setTitle("장난감에 흥미를 가지지 않을 때");
            ButtonInfo.setMessage("\n\n 아무리 재미있는 장난감이라도 계속 같은 것을 가지고 놀다보면 질리는 것이 당연해요\n\n" +
                    "만약 집에 쌓여가는 장난감이 많다면, 모든 장난감을 한 번에 꺼내 두지는 말고 매일 다른 것으로 선택하여 몇 가지씩만 꺼내 주세요\n\n" +
                    "이렇게 하면, 어제 가지고 놀던 장난감과 오늘 가지고 노는 장난감의 종류가 달라지고, 늘 새로운 느낌을 받을 수 있어요. 요일마다 다른 장난감을 꺼내 주는 것도 좋은 방법 중 하나이다.");
            ButtonInfo.show();
        }
    };
}
