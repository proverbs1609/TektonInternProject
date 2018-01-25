package com.app.hamang.tektonproject.ActionActivity;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.app.hamang.tektonproject.R;

public class ActionMypage extends AppCompatActivity {
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_mypage);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }
    public void onButtonClick(View view) {
        AlertDialog.Builder action_button = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.MyAlertDialogStyle));
        action_button.setNegativeButton("x", null);
        switch (view.getId()) {
            case R.id.toilet_button1:
                action_button.setTitle("아무데나 배설한다");
                action_button.setMessage("\n\n화장실 교육이 잘 되어 있는 경우에도 반려인의 부재에 따른 불안이나 불만 때문에 일부러 화장실이 아닌 곳에 배설하는 경우도 있다.\n\n" +
                        "소취제로 배설한 장소를 깨끗하게 청소하고, 혼자 있어도 불안해 하지 않을 환경을 만들어 줘야 한다.\n\n" +
                        "반려인이 외출할 때 콩 장난감 등을 주면, 혼자있는 시간이 덜 심심하고 덜 불안할 수 있다.");
                action_button.show();
                break;
            case R.id.toilet_button2:
                action_button.setTitle("실내에서는 배설을 참는다");
                action_button.setMessage("\n\n실내에서는 참고 야외에서만 배설을 하는 반려견들이 있다.\n\n" +
                        "날씨가 나빠 산책을 나가지 못하거나 반려견이 아프다면 억지로 참기도 하는데, 이런 행동은 몸에 무리를 줄 수 있기 때문에 교정하는 것이 좋다.\n\n" +
                        "산책을 하기전에 배설을 하고 나가는 것이 좋다.\n\n" +
                        "먼 곳으로 산책을 나가기 전에 집 앞에 머물면서 근처에 배설을 하도록 유도하고, 배설을 했을 때 간식으로 보상하면 도움이 된다.\n\n" +
                        "산책 전에 배설하는 것을 긍정적인 상황으로 만들어 줌으로써 산책 전 집 앞에다가 배설을 할 수 있게 유도하다, 점차 집 안에서 배설을 하게끔 해 준다.");
                action_button.show();
                break;
            case R.id.toilet_button3:
                action_button.setTitle("소량의 소변을 여기저기 본다");
                action_button.setMessage("\n\n실내 여기저기에 영역표시를 위해 찔끔찔끔 소변을 보는 것을 '마킹한다'고 한다.\n\n" +
                        "낯선 사람이나 동물이 집에 방문했을 때 마킹이 유난히 심하다면 경계 본능으로 인한 표식의 목적인 경우가 대부분이다.\n\n"+
                        "'마킹'은 지나치게 흥분하면서 소변을 흘리는 '흥분성 배뇨'와 질병으로 인한 '요실금'과는 구별되어야 한다.\n\n" +
                        "마킹한 장소에 냄새가 남아있다면 화장실로 인식해 사용할 가능성도 있으니 깨끗이 청소해야 한다.\n\n" +
                        "낯선 사람과 동물이 왔을 때 유난히 마킹을 한다면 방문하는 상황을 익숙하게 만들어서, 영역을 지키려는 행위를 하지 않아도 괜찮다는 생각을 하게 만들어 주는 것이 중요하다.\n\n" +
                        "수컷의 경우 중성화를 하면 횟수가 줄어드는 경향이 있는데, 이미 습관이 된 경우라면 효과가 미약할 수 있어서 너무 늦지 않은 시기에 중성화 수술을 할 것을 추천한다.\n\n" +
                        "지나치게 반가워하면서 소변을 보는 '흥분성 배뇨'의 경우에는 무시하기를 이용한 연습을 해야하며, 요실금은 병적인 상태이므로 치료해야 한다.");
                action_button.show();
                break;
            case R.id.notice_button1:
                action_button.setTitle("충분한 산책");
                action_button.setMessage("\n\n에너지는 넘치는데 충분한 산책과 놀이를 할 수 없다면, 물건을 뜯거나 쉴새없이 짖는 행동을 할 수도 있다.\n\n" +
                        "만약 문제행동을 보인다고 가둬두게 되면 스트레스까지 더해, 울타리 밖에 나왔을 때 통제할 수 없게 된다.\n\n" +
                        "가장 좋은 해결 방법은 매일매일 산책으로 에너지를 소진할 수 있게 하는 것이다.\n\n" +
                        "아침 저녁으로 구준히 산책을 하고 집 안에서도 충분히 놀아주면 모든 에너지가 소진되어, 잉여 에너지로 인한 문제행동이 사라질 가능성이 높다.\n\n");
                action_button.show();
                break;
            case R.id.notice_button2:
                action_button.setTitle("은신처 마련");
                action_button.setMessage("\n\n안심하고 쉴 수 있는 공간이 없다면, 불안함이 원인이 되어 문제행동을 보일 수 있다.\n\n" +
                        "휴식 공간이 체격에 비해 너무 넓어도 안락함을 느낄 수 없기 때문에, 출입구를 제외한 사방이 막혀있고 고개를 들고 서 있을 때 편하게 고개를 돌릴 수 있는 정도의 작은 공간을 마련해 주는 것이 좋은데" +
                        "크레이트(켄넬)가 그런공간으로 적합하다.\n\n");
                action_button.show();
                break;
            case R.id.notice_button3:
                action_button.setTitle("질병이 원인인지 파악하기");
                action_button.setMessage("\n\n에너지를 충분히 발산시켜줬는데도 문제행동이 지속된다면 질병이 원인일 수 있다.\n\n" +
                        "같은 자리를 빙빙도는 문제 행동을 보이고 있다고 생각했는데, 알고보니 전정기관의 이상이 원인인 경우처럼 문제행동을 보일 수 있다.\n\n" +
                        "질병이 원인이 되어 이상 행동을 보인다면 질병에 대한 치료가 필요하다.\n\n" +
                        "또한 단순 교정으로 교정되지 않는 행동을 보인다면 약물복용을 병행하기도 해야 한다.");
                action_button.show();
                break;
            case R.id.notice_button4:
                action_button.setTitle("의사소통");
                action_button.setMessage("\n\n의사소통이 원할하지 못할 경우에 문제행동을 보일 수 있다.\n\n" +
                        "반려견은 말을 하지 못하기 때문에 말하고 싶은게 있을 때 행동으로 표현하게 되는데 불만 또는 불안 요소가 해결되지 않을 때 문제행동을 보인다.\n\n" +
                        "반려인은 지금 반려견이 불안해하지는 않는지, 화가 나지는 않았는지, 불만이 있는지를 파악할 피룡가 있다.\n\n" +
                        "문제행동을 보일 때 그저 윽박지르고 혼만 낸다면 상황은 더 악화될 것이 뻔하므로, 문제행동의 교정 전에 반드시 문제행동의 원인을 파악하고 이를 해소해 주기 위해 노력해야 한다." +
                        "더불어 반려견의 기본 교육이 잘 되어 잇다면 반려견과 반려인의 의사소통이 어느정도 가능해지며 반려견의 문제행동이 발생할 확률은 낮아진다.");
                action_button.show();
                break;
            case R.id.notice_button5:
                action_button.setTitle("일관적 기준");
                action_button.setMessage("\n\n과거에는 복종의 원리를 적용한 교육법이 주로 이루어 졌으나, 현재는 칭찬과 간식을 통한 보상 교육법이 주목받고 있다.\n\n" +
                        "보상과 벌에 대한 일관된 기준을 가져야 하고, 반려견이 칭찬받을 행동을 했을 때 즉각적인 보상을 하며, 두려운 요소로부터 반려견을 지켜낸다는 느낌을 줘야한다.\n\n" +
                        "아무런 이유 없이 간식을 주는 등 반려인이 일관된 기준 없이 보상 또는 벌을 가한다면, 반려견에게 혼란을 줄 수 있다.\n\n" +
                        "벌을 주는 방식으로 교육할 때도 일관적인 기준으로 문제 발생 시 즉시 벌을 가해야 한다.\n\n" +
                        "문제발생 후 시간이 지난 후 벌을 준다면 이유도 모른 채 공포심과 두려움을 느끼게 된다.\n\n" +
                        "벌은 즉시성을 가지고 행하기 어렵지만 칭찬과 보상은 즉시 행하기 쉽기 때문에 칭찬과 간식을 통한 보상 교육법을 추천한다.");
                action_button.show();
                break;
            case R.id.notice_button6:
                action_button.setTitle("원인 찾기");
                action_button.setMessage("\n\n개의 문제행동에는 다양한 원인이 숨어있다.\n\n" +
                        "대부분이 넘치는 에너지를 발산하지 못해서 일어나지만 그렇지 않은 경우도 있다.\n\n" +
                        "원인은 반려인이 찾아내야 한다. 하지만 해당 상황이 문제의 원인이 되는 것인지 파악하기 어려울 수 있으므로, 그런 경우에는 전문가의 상담을 받는 것을 추천한다.\n\n" +
                        "과거 교육이 잘 되었던 부분인데도 갑자기 잘 지켜지지 않는다면 반려견의 주변 환경 중 달라진 부분이 없는지 꼼꼼히 살펴봐야 한다.");
                action_button.show();
                break;
            case R.id.bng_button1:
                action_button.setTitle("계속 운다");
                action_button.setMessage("\n\n일반적으로 반려견이 반복해서 우는 이유는 자신의 의사를 관철시키고 싶기 때문일 수도 있는데, 지속적으로 우는 행동에는 이유가 있는 경우가 많다.\n\n" +
                        "예로, 입양된 지 얼마 안된 반려견은 새로운 환경에 적응하지 못해 외로워서 계속 울기도 한다.\n\n" +
                        "반려견의 상황을 차근차근 관찰해 이유를 찾아내는 것이 중요하다. 이유를 해소해 주면 우는 현상도 해소가 되기 때문이다.\n\n" +
                        "새로운 환경에서 적응하지 못해 우는 경우라면, 반려견의 잠자리를 반려인의 방으로 옮겨주는 것이 좋은 방법이 될 수도 있다.");
                action_button.show();
                break;
            case R.id.bng_button2:
                action_button.setTitle("너무 자주 짖거나 운다");
                action_button.setMessage("\n\n반려견이 반려인에게 특정한 요구사항이 있을 때 보이는 행동으로 잘 관찰하고 확인할 필요가 있다.\n\n" +
                        "무엇을 원하는지 먼저 파악하고, 반려견이 원하는 것이 타협 가능한 것이면 요구사항을 들어주는 것이 좋다. 만약 들어줄 수 없는 것이라면 '무시하기'작전을 사용한다.\n\n" +
                        "반려견이 시끄럽게 짖으면 당장의 시끄러움을 해소하기 위해 요구사항을 들어주는데, 이런 행동이 문제를 강화할 수도 있다.\n\n" +
                        "상황의 악순환을 방지하기 위해서, 안 되는 것은 안 된다는 것을 알려줄 필요가 있다.\n\n" +
                        "아무리 봐도 문제가 무엇인지 모르겠다면, 넘치는 에너지를 충분히 발산하지 못한 스트레스 때문에 짖는 것일 수도 있으니, 아침 저녁으로 충분한 산책과 놀이로 해소할 수도 있다.\n\n" +
                        "산책과 놀이로 피곤한 상태가 된다면 울거나 짖을 기운 없이 행복한 상태로 잠에 빠져들 수 있다.");
                action_button.show();
                break;
            case R.id.bng_button3:
                action_button.setTitle("반려인 외출 시 계속 짖거나 운다");
                action_button.setMessage("\n\n혼자 집에 있을 때 짓는 행동은 분리불안의 일종으로, 외로움의 표현이다.\n\n" +
                        "공동주택에서 짖는 것은 이웃에게 피해를 주는 것이기 때문에 적절한 산책과 교육으로 스트레스를 분산시키고 신뢰관계를 유지하는 것이 중요하다.\n\n" +
                        "분리불안을 예방할 수 있는 방법으로는, 우선 자신의 집에서 편안함을 느낄 수 있게 해줘야 한다.\n\n" +
                        "반려인이 문을 닫고 나갈 때도 얌전하게 있을 수 있도록 반복행동과 적절한 보상을 통해 훈련해야 한다.\n\n" +
                        "반려인의 부재 여부와 상관없이 집중할 수 있는 장난감과 같은 놀잇감을 두는 것도 해소 방법이 될 수 있다.");
                action_button.show();
                break;
            case R.id.bng_button4:
                action_button.setTitle("산책 시 계속 짖는다");
                action_button.setMessage("\n\n집 밖을 나서자마자 짓는 것은 밖이 익숙하지 않은 반려견이 보이는 전형적인 문제행동이다.\n\n" +
                        "바깥에 나가본 경험이 부족하면 집 밖 환경이 겁이 나서 흥분을 하고 짖게 된다.\n\n" +
                        "매일 조금씩 산책을 지속적으로 시켜 주면 위와 같은 문제행동이 개선될 수 있다.\n\n" +
                        "성견의 교육은 강아지의 교육보다 오래걸리지만 지속적이고 점진적인 교육을 통해 개선될 수 있으므로 반려견이 적정한 사회화 경험을 할 수 있도록 해야 한다.\n\n" +
                        "매일매일 집 근처에 잠깐 나가는 것부터 산책까지 늘려나가면 된다. 산책하러 나갔을 때의 소량의 간식을 이용해 효과적인 교육을 할 수 있다.");
                action_button.show();
                break;
            case R.id.bng_button5:
                action_button.setTitle("특정 소리에 심하게 짖는다");
                action_button.setMessage("\n불꽃놀이, 비행기, 천둥소리 등 특정 소리에 놀라면 불안함을 느끼고 패닉상태가 될 수 있다. 이때 두려움을 짖는것으로 표현하는 경우도 있다.\n\n" +
                        "이 소리들은 너무 갑작스럽고 익숙하지 않은 소리기 때문에 이런 행동을 보이게 된다.\n\n" +
                        "무서워하는 소리를 지속적으로 들려줌으로써 익숙해지게 할 필요가 있다.\n\n" +
                        "다만 처음부터 크게 들려주느 것이 아닌 작은 소리부터 놀라지 않는다면 점차 크게 들려주는 것이 좋다.\n\n" +
                        "소리가 나더라도 아무 일이 없다는 것을 알려주는 것이 목표이나 소리를 듣는 연습에 스트레스를 받아 한다면 강아지가 상황을 피해 몸을 숨길 수 있는 안심할만한 공간을 제공해 주는 것이 좋다.");
                action_button.show();
                break;
            case R.id.bng_button6:
                action_button.setTitle("낯선 사람에게 계속 짖는다");
                action_button.setMessage("\n\n가족 외의 사람에게 계속 짖는 행동을 보인다면, 가족 외의 사람에 대한 사회화가 되어 있지 않기 때문일 가능성이 높다.\n\n" +
                        "반려견이 낯선 사람에게 짖고 공격성을 보이는 것은 사람에 대한 사회ㅗ하 경험이 부족한 반려견이 보이는 전형적인 문제행동이다.\n\n" +
                        "반려견이 어릴 때 적합환 사회화 경험을 다양하게 해 보지 못한 것이 원인이 되어 낯선 사람을 두려움의 대상으로 인식하게 되었음을 생각해 볼 수 있다.\n\n" +
                        "성견도 꾸준한 사회화 교육이 필요하다. 이런 경우는 특히 낯선 사람에 대한 사회적 경험이 필요하다.\n\n" +
                        "성견의 교육은 강아지보다 느릴 수는 있지만 지속적으로 교육을 실시하면 개선될 수 있으므로 도와줘야 한다.\n\n" +
                        "반려견과 다양한 연령대, 여러 성별, 다양한 성향의 사람들과 점차적으로 만나게 해줄 필요가 있다. 이때 낯선 사람은 반려견이 겁을 먹을 수 있는 행동을 '절대' 해서는 안된다.");
                action_button.show();
                break;
            case R.id.bng_button7:
                action_button.setTitle("낯선 개에게 계속 짖는다");
                action_button.setMessage("\n\n반려견이 낯선 개를 보고 계속 진는 문제행동을 반복한다면 사회화가 되어있지 않을 가능성이 크다.\n\n" +
                        "사회화 경험이 부족한 반려견이 보이는 전형적인 문제행동이다.\n\n" +
                        "어린나이에 분양된 경우, 개들과 소통하는 법을 배우지 못하고 어미개와 바로 헤어지기 때문에 문제가 발생하며, 그 이후에도 사회화 경험을 다양하게 하지 못했을 때 문제가 발생할 수 있다.\n\n" +
                        "반려견과 다양한 연령대, 여러 성별, 다양한 성향의 개들과 만나개 해줄 필요가 있다.\n\n" +
                        "처음에는 사회성이 좋은 얌전한 개 1마리를 짧게 만나보는 것을 추천하며 이후 점차적으로 늘려가는 방법을 추천한다.\n\n" +
                        "처음부터 너무 많은 친구들을 만나게 되거나 사회성이 좋지 않은 친구와 만나게 되면 부정적인 결과를 야기하므로 주의해야 한다!");
                action_button.show();
                break;
            case R.id.bng_button8:
                action_button.setTitle("알수없이 심하게 계속 짖는다");
                action_button.setMessage("\n\n알수 없는 이유로 너무 심하게 짖을 때에는 몇가지 경우를 생각해 볼 수 있다.\n\n" +
                        "보통은 낯선 사람, 낯선 소리를 들으면 무서운 마음이 생겨서 짖는 경우가 많다.\n\n" +
                        "특정한 소리가 날 때 짖든지, 특정한 상황에서 짖는지, 또는 반려견이 무언가를 요구하는 의미로 짖는 것은 아닌지 관찰할 필요가 있다.\n\n" +
                        "낯섦이 원인이 되어 생기는 문제라면 익숙해 지도록 반복연습을 시켜주면 문제해결에 도움이 된다.\n\n" +
                        "문제상황의 해결을 위해서는\n첫째, 반려견을 유심히 관찰해서 어떤 원인 때문에 짖는지 확인한다.\n\n" +
                        "둘째, 원인을 찾았다면 꾸준히 점차적으로 반복 연습을 실시햇 상황에 익숙해지도록 한다.\n똑같은 상황이 생겨도 아무 문제가 생기지 않는다는것을 알게 해 줄 필요가 있다.\n\n" +
                        "셋째, 반복 연습과 더불어 켄넬이나 굴 형태의 집을 준비해서 반려견이 스트레스 상황을 피해 안심하고 숨을 수 있는 공간으 마련해 줘야 한다.\n\n" +
                        "만약 요구사항을 들어달라는 짖음이라면 가능한 범위 내에서 들어주되 과한 요구에 대해서는 '무시하기'로 대응하고 늘 일관된 기준을 적용한다.");
                action_button.show();
                break;
            case R.id.attack_button1:
                action_button.setTitle("반려인을 공격한다");
                action_button.setMessage("\n\n과도한 스트레스가 공격성을 유발할 수 있으므로, 혼자있는 시간이 긴 반려견이라면 스트레스가 쌓인 것은 아닌지 살펴볼 필요가 있다.\n\n" +
                        "과도한 스트레스가 원인인 경우 놀이와 산책을 통해 반려견이 집중할 수 있는 것을 마련해 주는 것이 좋다.\n\n" +
                        "지나치게 겁이 많고 예민해도 공격성을 띄게 되는데 충분한 교감시간을 통해 믿을 수 있는 존재라는 것을 인지할 수 있도록 한다.\n\n" +
                        "물리게 된다면 즉시 '아야!' 소리를 내면서 아프다는 행동을 보이고 30초 정도 자리를 떠나 반려견을 무시하는 태도를 보여준다.\n" +"무시하는 시간이 너무 길어지면 스트레스를 유발할 수도 있다.");
                action_button.show();
                break;
            case R.id.attack_button2:
                action_button.setTitle("가족 외에 공격성을 보인다");
                action_button.setMessage("\n\n사회성 부족으로 인해 낯선 사람이나 개를 보고서는 잔뜩 겁이 나서 공격하는 경우일 수 있다.\n\n" +
                        "사회화 교육이 제대로 되지 않았을 때 일어날 수 있는 일이다.\n\n" +
                        "반려견이 14주령이 지났다면 사회화 최적기는 지난 상태다. 하지만 교육이 불가능한 것은 아니므로 시간이 걸리더라도 사회성을 기를 수 있도록 도와줘야 한다." +
                        "사회성이 없는 개에게 갑작스럽게 많은 사람이나 개를 만나게 하면 스트레스를 많이 받을 수 있기 때문에 점진적으로 늘려주는 것이 좋다.\n\n" +
                        "반려견의 성격상 너무 활발한 개를 어려워하고 힘들어한다면 차분한 성격의 개를 먼저 만나게 해 주는 것이 좋고, 특히 교육 초반에는 사회성이 좋은 개를 만나게 해 주는 것이 좋다.\n\n" +
                        "낯선 사람을 만날 때도 사람들이 너에게 해를 입히려는 게 아니라는 것을 깨달을 수 있게 해 줘야 한다.\n\n" +
                        "교육을 위해 소량의 간식을 보상으로 줄 수 있다.");
                action_button.show();
                break;
            case R.id.attack_button3:
                action_button.setTitle("밥을먹을때 공격성을 보인다");
                action_button.setMessage("\n\n밥을 먹을 때 주변에 불안함을 느끼게 하는 요소가 있다면 그것 때문에 본능적으로 위협적인 태도를 취할 수 있다.\n\n" +
                        "반려인의 행동이 식사를 방해하거나 밥을 뺏으려고 하는 것임이 아님을 알려줄 필요가 있고 반려견이 혼자 조용히 식사를 할 수 있도록 하는 것이 좋다.\n\n" +
                        "이 상황에서 체벌은 상황을 악화시킬 뿐이므로 하지 말아야 한다.\n\n" +
                        "만약 가까이 접근했을 때 물려고 한다면, 약간 먼 거리에서 맛있는 간식을 조금씩 던져주면서 방해하는 의도가 아니라는 것을 알려주는 것이 중요하다.");
                action_button.show();
                break;
            case R.id.attack_button4:
                action_button.setTitle("입에 문것을 뺏을 때 공격성을 보인다");
                action_button.setMessage("\n\n어린 강아지라면 특히 더 본능적으로 물건을 입 안에 넣으려는 경향이 있다.\n\n" +
                        "입 안에 들어간 물건은 자신의 것이라고 생각하기 때문에 억지로 뺏으려고 하면 오히려 물려고 하거나 삼키는 수가 있다.\n\n" +
                        "반려견이 좋아하는 간식을 주면서 입에 문 것과 교환하는 방법을 이용해 볼 수 있다.\n\n" +
                        "하지만 반복되면 다음 교환 때는 더 좋은것을 요구하는 상황이 생길 수 있으므로 매번 이용하는 것은 좋지 않다.\n\n" +
                        "이런 상황을 방지하기 위해서 평소에 '주세요'를 교육하는 것이 좋은데, 이때는 입에 물고 있는 것을 반려인에게 건네주면 즉시 보상하는 방법으로 교육해야 한다.");
                action_button.show();
                break;
            case R.id.attack_button5:
                action_button.setTitle("다른 개와 공격적으로 싸운다");
                action_button.setMessage("\n\n어린 강아지 시절에 다른 개와의 사회화가 충분히 되지 않았을 때 보일 수 있는 특성이다.\n\n" +
                        "반려견이 겁이 많은 성격이라면 너무 무서운 나머지 먼저 공격하는 경우일 수도 있다.\n\n" +
                        "사회성이 부족한 경우라면 성견이더라도 점진적인 사회화 교육을 진행해 주어야 한다. 낯선 개에 대한 사회성을 길러주면 덜 공격적일 수 있다.\n\n" +
                        "평소 겁이 지나치게 많은 성격이라면 자극이 많은 장소에는 데려가지 않는 편이 좋다.\n\n" +
                        "겁이 많더라도 사회성이 길러지면 문제가 될것 같은 상황은 스스로 피하게 된다.\n\n"+
                        "산책 중에 마주치는 돌발적인 만남에 공격성을 보인다면 자극하지 말고 최대한 빠르게 자리를 피해야 한다.");
                action_button.show();
                break;
            case R.id.action_button1:
                action_button.setTitle("반려인을 잘근잘근 깨문다");
                action_button.setMessage("\n\n잘근잘근 깨무는 행동은 반려인을 공격하기 위한 행동이 아니라 어릴 때부터 장난으로 깨무는 것을 방치했을 때 보이는 행동이다.\n\n" +
                        "어릴 때부터 사람의 손과 발이 아닌, 장난감을 가지고 노는 것이 익숙하게 해 줘야 한다.\n\n" +
                        "사람의 손이나 발을 물면 아프다는 표시로 '아야!' 소리를 내고 30초 정도 자리를 떠나 자신이 물면 반려인과 노는 즐거움이 사라진 다는 것을 훈련한다.");
                action_button.show();
                break;
            case R.id.action_button2:
                action_button.setTitle("빈 집에서 난장판을 친다");
                action_button.setMessage("\n\n불안함과 심심함이 원인이 되어 어지럽히는 행동을 보일 수가 있다.\n\n" +
                        "'갔다올께', '잘 있어~' 등의 인사말은 반려인의 부재를 강조하는 것이므로 하지 않도록 한다." +
                        "외출하기 전에는 반려견을 무시하는 태도로 일관하며, 특별히 외출 한다는 느낌을 내지 않고 자연스럽게 나가는 것이 좋다.\n\n" +
                        "외출 시 장난감 등을 주면 혼자 있는 시간에 집중할 수 있는 것이 생겨 덜 심심해 할 수 있다.");
                action_button.show();
                break;
            case R.id.action_button3:
                action_button.setTitle("특정 소리를 무서워한다");
                action_button.setMessage("\n\n불꽃놀이, 비행기, 천둥소리 등 특정 소리에 놀라면 불안함을 느끼고 패닉상태가 될 수 있다. 이때 두려움을 짖는것으로 표현하는 경우도 있다.\n\n" +
                        "이 소리들은 너무 갑작스럽고 익숙하지 않은 소리기 때문에 이런 행동을 보이게 된다.\n\n" +
                        "무서워하는 소리를 지속적으로 들려줌으로써 익숙해지게 할 필요가 있다.\n\n" +
                        "다만 처음부터 크게 들려주느 것이 아닌 작은 소리부터 놀라지 않는다면 점차 크게 들려주는 것이 좋다.\n\n" +
                        "소리가 나더라도 아무 일이 없다는 것을 알려주는 것이 목표이나 소리를 듣는 연습에 스트레스를 받아 한다면 강아지가 상황을 피해 몸을 숨길 수 있는 안심할만한 공간을 제공해 주는 것이 좋다.");
                action_button.show();
                break;
            case R.id.action_button4:
                action_button.setTitle("자주 가출한다");
                action_button.setMessage("\n\n스트레스로 인한 원인일 경우가 상당히 많으며, 중성화 수술을 하지 않은 반려견이라면 발정기에 본능적으로 상대를 찾기 위해 도주를 하기도 한다.\n\n" +
                        "자주 산책을 하지 못한 스트레스로 도주하는 행동을 보인다면, 좀 더 자주 산책을 하고 집에서도 같이 놀아 주면서 사랑 받는 느낌을 주는 것이 중요하다.\n\n" +
                        "넘치는 에너지를 주체하지 못 하고 밖으로 나갈 기회를 엿보다가 뛰처나가는 경우도 있다. 보통 매우 빠르게 도주하므로 현관문을 열고 닫을 때는 항상 주의를 기울여야 한다.\n\n" +
                        "외에 성적 본능에 의한 것이라면, 중성화 수술을 해주는 것이 좋은 해결법이다.");
                action_button.show();
                break;
            case R.id.action_button5:
                action_button.setTitle("땅파기에 집착한다");
                action_button.setMessage("\n\n잠시 파는거라면 놀이의 일종이고 본능적인 행동이지만 하루종일 집착한다면 '강박행동'에 해당된다.\n\n" +
                        "반려견이 극심한 스트레스 상황에 빠져 강박행동을 하는 것은 아닌지 살펴봐야 한다.\n\n" +
                        "스트레스의 원인을 제거하는 것이 최고의 대처법으로 원인을 개선하면 변화를 확인할 수 있다.\n\n" +
                        "집의 위치를 바꿔 평소에 보는 풍경을 바꿔 주는 것도 기분전환 방법이며, 땅 파기 외에 다른 놀이를 할 수 있도록 장난감을 충분히 주고, 함께 놀아주는 것도 매우 좋은 방법이다.\n\n" +
                        "하지만 나아지지 않는다면 약물치료가 필요하게 된다.");
                action_button.show();
                break;
            case R.id.action_button6:
                action_button.setTitle("목적없이 같은 행동을 반복한다");
                action_button.setMessage("\n\n목적없는 반복 행동은 강박 행동의 일종일 수 있는데 혼자있는 시간이 지나치게 길거나 반려인이 상대해 주지 안흔 것에 대한 스트레수이가 원인일 수 있다.\n\n" +
                        "반려견과 적극적으로 놀아 주는 시간을 늘리고 충분한 애정 표현을 해 줘야 한다. \n\n" +
                        "이러한 노력에도 개선되지 않는다면 병원을 방문해 상담을 해야 한다.");
                action_button.show();
                break;
            case R.id.action_button7:
                action_button.setTitle("반려인에게 달려든다");
                action_button.setMessage("\n\n대부분은 반가움의 표시로 달려드는데, 이러한 행동을 주체할 수 없는 흥분으로 인한 경우가 많다.\n\n" +
                        "소형견인 경우에는 큰 문제가 되지 않을수도 있지만 중대형견이라면 반려인이 다칠 수도 있기 때문에 교정이 필요하다.\n\n" +
                        "만약, 좋아서 달려드는게 아니라 공격을 위해서 달려드는 것이라면 사회화 경험의 부족이나 반려견의 불안감에 기인한 공격성일 수 있다.\n\n" +
                        "달려들때 소리를 지르면 관심으로 파악하고 더욱 좋아하게 된다. 그러므로 눈길을 주지 말고 30초 정도는 등을 돌려 무시하는 행동을 보여주면 좋다.\n\n" +
                        "무시하는 행동으로 반려견이 어리둥절해 하며 주춤할 때 '앉아' 지시를 하고, 뛰어들지 않고 앉아를 잘 수행하면 칭찬하면서 간식을 보상을 해준다.\n\n" +
                        "이 교육의 목표는 달려들지 않고 알아서 기다리게 만드는 것이다.");
                action_button.show();
                break;
            case R.id.action_button8:
                action_button.setTitle("바닥에 덜어진 물건을 삼킨다");
                action_button.setMessage("\n\n바닥에 떨어진 것을 주워 먹는 행위는 반려견이 갖고 있는 본능적 습관이다.\n\n" +
                        "이러한 행동 자체가 큰 문제는 아니지만 사람음식 중 개가 먹으면 안되는 음식이 많기 때문에 개선해야 할 필요가 있다.\n\n" +
                        "특히 어린 반려견일 수록 더 자주 이런 행동을 보이며, 나이를 먹을수록 먹지 말아야 하는 것에대한 분별력이 생기지만, 나이가 들어도 행동이 줄어들지 않을 수도 있다.\n\n" +
                        "삼키거나 물어 뜯을 수 있는 물건은 반려견이 접근하지 못하는 곳에 두는 것이 최선의 방법이다.\n\n" +
                        "평소 정리정돈을 철저히 하고, 산책시 이런 행동을 보일 땐 리드줄을 당겨 제지해 주어야 한다.");
                action_button.show();
                break;
            case R.id.action_button9:
                action_button.setTitle("변을 먹는다");
                action_button.setMessage("\n\n변을 먹는 증상을 식분증이라고 하는데, 그 원인은 다양하다,\n\n" +
                        "솨화가 잘 되지 않은 변에서 먹이의 냄새로 인해 먹게 되었는데 그때 받은 반려인의 관심을 위해 벅는 경우도 있다.\n\n" +
                        "혹은 배변훈련 동안 꾸증을 들은 경험을 통해 배변 자체가 잘못된 행동이라고 생각하고 흔적을 없애기 위해 먹어버리기도 한다.\n\n" +
                        "때때로 어미개가 강아지의 변을 먹기도 하는데 이는 본능적으로 적에게 흔적을 남기지 않기 위함으로 정도가 심하지 않다면 크게 걱정하지 않아도 된다.\n\n" +
                        "반려견이 배변했을 때 바로바로 치워주며 소화가 제대로 되지 않아 식분증이 생긴 경우에는, 사료를 바꿔 변의 특성을 바꿔주면 먹지 않게 되기도 한다.\n\n" +
                        "관심받고 싶어 먹는 경우라면, 변을 먹을 때 관심을 주지 않으며 평소에 놀아주는 시간을 늘려준다면 증상이 개선되기도 한다.\n\n" +
                        "배변실수때 혼난 기억으로 인해 생긴 거라면 앞으로 배변실수를 할 때 무시하기로 일관하고 실수에 대한 꾸중은 하지 않는 게 좋다.\n" +"식분증은 하나의 습관이기 때문에 고치는데 오랜기간이 걸릴 수 있다.");
                action_button.show();
                break;
            case R.id.action_button10:
                action_button.setTitle("쓰레기통을 뒤진다");
                action_button.setMessage("\n\n반려견은 넘치는 호기심 때문에 쓰레기통을 뒤지는 경우가 있다. 이를 신나는 놀이로 느끼기도 하므로 잘못된 쓰레기를 삼키지 않도록 특별히 주의해 줘야 한다.\n\n" +
                        "내용물을 먹어버릴 수도 있기 때문에 쓰레기통은 뚜껑이 달린 것으로 바꾸거나 키가 닿지 않는 곳에 올리는 등의 방법으로 접근 자체를 차단해야 한다.\n\n" +
                        "반려견이 산책 중 쓰레기에 접근하려고 하면 리드줄을 위로 당겨 접근을 박고 무시한 채로 산책을 계속 해야한다.");
                action_button.show();
                break;
            case R.id.action_button11:
                action_button.setTitle("목욕하는 것을 싫어한다");
                action_button.setMessage("\n\n사회화기에 '물'에 적응하는 경험이 축적되지 않았거나, 반려인이 자신의 온 몸을 만지는 경험이 적었던 것 등이 원인일 수 있고, 목욕의 나쁜 기억으로 인해 싫어하는 것일 수도 있다.\n\n" +
                        "물을 끼얹는 자체르 너무 싫어한다면, 젖은 수건으로 몸을 닦아주는 것부터 시작한 후, 점차 몸에 물을 몇 방울 떨어뜨리면서 서서히 익숙해질 수 있게 해 준다.\n\n" +
                        "몸을 만지는 것을 싫어한다면 평소 스킨십을 충분히 해줘야 하는데 매일 전신 빗질을 해 주는 방법이 좋은 수단이 될 수 있다.\n\n" +
                        "목욕에 대한 나쁜 기억으로 인해 싫어한다면 잘 참을 때마다 간식을 조금씩 먹을 수 있게 해 주면서 훈련한다.");
                action_button.show();
                break;
            case R.id.action_button12:
                action_button.setTitle("부르면 도망간다");
                action_button.setMessage("\n\n'이리와'에 대한 연습이 부족했을 수 있다. 또는 말을 듣지 않았을 때 반응이 즐거워서 그럴 수도 있다.\n\n" +
                        "'이리와'에 대한 연습이 부족한 경우라면 차근차근 연습을 반복해야 한다. 원하지 않는 방향으로 행동했을 때에는 보상이라고 인식할 수 있는 행동을 하지 않는 것이 중요하다.\n\n" +
                        "단순히 눈을 맞추는 것만으로도 반려견에게는 충분한 보상이 될 수 있으니 교육 시 주의해야 한다.");
                action_button.show();
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_action_mypage, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_close) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        public PlaceholderFragment() {
        }
        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }
    }
    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            if (position == 0)
                return new ActionNotice();
            else if (position == 1)
                return new ActionAttack();
            else if (position == 2)
                return new ActionToilet();
            else if (position == 3)
                return new ActionAction();
            else
                return new ActionBng();
        }
        @Override
        public int getCount() {
            // Show 5 total pages.
            return 5;
        }
    }
}
