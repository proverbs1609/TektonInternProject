package com.app.hamang.tektonproject.EmotionActivity;

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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.app.hamang.tektonproject.R;

public class EmotionMypage extends AppCompatActivity {
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
        setContentView(R.layout.activity_emotion_mypage);

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
        AlertDialog.Builder emotion_button = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.MyAlertDialogStyle));
        emotion_button.setNegativeButton("x",null);
        switch (view.getId()) {
            case R.id.look_button1:
                emotion_button.setTitle("눈을 치뜬다");
                emotion_button.setMessage("\n\n반려견이 눈을 치뜨는 행동을 보인다면, 자신만의 공간이 필요하다는 의미다.\n\n" +
                        "편하게 느끼는 공간이 좁다는 것을 의미하거나 혼자 있고 싶다는 심리 표현이다.");
                emotion_button.show();
                break;
            case R.id.look_button2:
                emotion_button.setTitle("눈을 동그랗게 뜬다");
                emotion_button.setMessage("\n\n일반적으로 놀라거나 긴장되는 상황에서 경계심을 표현할 때 눈을 동그랗게 뜨는 행동을 보인다.\n\n" +
                        "낯선 상황에서 공포심을 느꼈을 때, 호기심이 있을 때도 이러한 표정을 지을 수 있다.");
                emotion_button.show();
                break;
            case R.id.look_button3:
                emotion_button.setTitle("눈을 깜빡인다");
                emotion_button.setMessage("\n\n눈을 빠르게 깜빡이는 것은 놀라거나 긴장되는 상황이라는 의미다.\n\n" +
                        "또한 낯선 사람이나 개를 만났을 때 적의가 없음을 표현하고 진정시키려는 표현일 수도 있다.\n\n" +
                        "반려견이 입을 살짝 벌리고 편안한 표정을 지으면서 눈을 천천히 깜빡이는 것은 반가움과 기쁨의 의미로 해석될 수도 있다.\n\n" +
                        "만약 한쪽눈만 지나치게 깜빡이거나 눈이 빨갛고 눈곱이 많이 낀다면 안과 진료를 받을 필요가 있다.");
                emotion_button.show();
                break;
            case R.id.look_button4:
                emotion_button.setTitle("눈을 가늘게 뜬다");
                emotion_button.setMessage("\n\n행복하다는 표현이다.\n\n" +
                        "강아지는 편안하거나 기쁠 때, 눈을 가늘게 뜨고 입을 가볍게 벌리고 혀를 내밀면서 반려인에게 애교를 부린다.\n\n" +
                        "산책을 하다가 집에 가려고 하면 우울한 표정과 함께 실눈을 뜨는 경우가 있는데 아쉽다는 의미이다.\n\n" +
                        "조금만 더 놀아줘도 기쁜 표정을 지을 것이다.");
                emotion_button.show();
                break;
            case R.id.look_button5:
                emotion_button.setTitle("시선을 고정한다");
                emotion_button.setMessage("\n\n가까운 사람에게 시선을 고정한다면, 애정을 표현하고 호감을 표시하는 행동이다.\n\n" +
                        "하지만 낯선사람에게 같은 행동을 취한다면 경계하고 있다는 의미이다.");
                emotion_button.show();
                break;
            case R.id.look_button6: // 커뮤니티 버튼 반응
                emotion_button.setTitle("눈을 피한다");
                emotion_button.setMessage("\n\n눈을 피하는 행동은 상대방의 기분을 나쁘게 하고 싶지 않다는 배려의 의미이다.\n\n" +
                        "다른 사람이나 개가 갑자기 다가올 때, 불안하지만 적의감이 없다는 의사표시로 눈을 피하기도 하는데 상대방과 자신을 진정시키는 행동이다.");
                emotion_button.show();
                break;
            case R.id.look_button7:
                emotion_button.setTitle("코를 핥는다");
                emotion_button.setMessage("\n\n반려견이 자신의 코를 핥는 것은 스스로를 진정시키기 위한 일종의 몸짓 신호로, 긴장하고 있거나 스트레스 받는 상황임을 의미한다.\n\n" +
                        "반면 반려인이나 다른개의 코를 핥는 행동은 인사와 애정표현이거나 우열을 가리기 위한 행동이다.");
                emotion_button.show();
                break;
            case R.id.look_button8:
                emotion_button.setTitle("입꼬리를 올린다");
                emotion_button.setMessage("\n\n애정을 표현하고 행복하다는 의미로 반려인의 표정을 따라하면서 웃는 표정을 짓기도 한다.\n\n" +
                        "집에서 사랑을 받고 있는 반려견은 풍부한 감수성으로 반려인의 표정을 읽고 흉내내면서 다른 반려견들보다 더 다양한 표정을 가지게 된다.");
                emotion_button.show();
                break;
            case R.id.look_button9:
                emotion_button.setTitle("입을 가볍게 벌린다");
                emotion_button.setMessage("\n\n입을 가볍게 벌리는 행동은 지금 반려견이 기분이 좋고 마음이 편안한 상태라는 것을 의미한다.\n\n" +
                        "개는 보통 기쁜상태에서 고개를 뒤로 젖히고 입을 살짝 벌리며 눈을 천천히 깜빡이는 행동을 보인다.");
                emotion_button.show();
                break;
            case R.id.look_button10:
                emotion_button.setTitle("귀를 쫑긋하게 세운다");
                emotion_button.setMessage("\n\n귀를 쫑긋하게 세우는 것은 현재 불안한 상태이며 경계심을 보이고 있음을 의미한다.\n\n" +
                        "혹은 현재의 상황에 대한 관심이나 호기심을 나타내는 것일 수도 있다.");
                emotion_button.show();
                break;
            case R.id.look_button11:
                emotion_button.setTitle("귀를 뒤로 젖힌다");
                emotion_button.setMessage("\n\n귀를 뒤로 젖히는 행동은 상대방에 대한 복종을 의미하며, 상황에 따라서 무언가에 대한 간절함이나 두려움의 표현일 수도 있다.");
                emotion_button.show();
                break;
            case R.id.look_button12:
                emotion_button.setTitle("송곳니를 드러낸다");
                emotion_button.setMessage("\n\n송곳니를 드러내는 행동은 지금 반려견이 매우 화가 났고 주변 경계를 하고 있다는 의미다.\n\n" +
                        "개는 공격성이 높아졌을 때 으르렁 거리거나 연달아 짧게 짖으며 이빨을 드러내는 행동을 보인다.");
                emotion_button.show();
                break;
            case R.id.groan_button1:
                emotion_button.setTitle("끙~ 끙~ 운다");
                emotion_button.setMessage("\n\n'끙~ 끄응' 소리를 내거나 우는 것은 반려견이 불안함과 불만을 표현하기 위해 상대방을 부르는 소리이다.\n\n" +
                        "원하는 것이 있거나 분리불안을 보일 때, 컨디션이 좋지 않을 때에도 '끄응 ~' 소리를 내면서 앓는 경우가 있는데, 반려견의 컨디션이 평소와 다르다고 판단이 될 때에는 동물병원에 방문하는 것이 좋다.");
                emotion_button.show();
                break;
            case R.id.groan_button2:
                emotion_button.setTitle("하울링을 한다");
                emotion_button.setMessage("\n\n동료를 부를 때 짖던 늑대, 개들의 본능적인 습성이다.\n\n" +
                        "밤에 다른 개들이 하울링하는 것을 들으면 더 흥분해서 '워우우~~'하는 것을 볼 수 있는데 야생의 습성이 남아있는 것으로 생각하면 된다.\n\n" +
                        "하울링은 자신의 정체성을 표현하고 자신의 뜻을 전달하는 행동으로, 반려인이 집을 떠났을 때 하울링하는 것은 심심함과 외로움을 표출하고 반려인을 부르는 행동으로 해석할 수 있다.\n\n" +
                        "반려견이 평소 하울링을 많이 한다면, 스트레스를 줄이기 위해 산책이나 놀이등을 하며 시간을 함께 보내며 신뢰 관계를 맺는 것이 중요하다.");
                emotion_button.show();
                break;
            case R.id.groan_button3:
                emotion_button.setTitle("끙끙거리고 아우~ 운다");
                emotion_button.setMessage("\n\n불안함과 외로움의 표현이다. 반려인이 외출하려고 할 때, 원하는 것을 달라고 조를 때 주로 이렇게 운다.");
                emotion_button.show();
                break;
            case R.id.groan_button4:
                emotion_button.setTitle("껭 ! 소리를 낸다");
                emotion_button.setMessage("\n\n'껭!!' 하고 크게 소리지르는 것은 통증이 있거나 두려움을 느낄 때 소리를 낸다.\n\n" +
                        "잘 놀다가 갑자기 '껭!' 하고 소리를 낸다면, 다쳤거나 척추디스크 등이 발생한 경우일 수도 있다.\n\n +" +
                        "이 때는 잘 관찰하여 이상이 발견되면 병원을 방문하는것이 좋다.");
                emotion_button.show();
                break;
            case R.id.groan_button5:
                emotion_button.setTitle("으르렁~ 소리를 낸다");
                emotion_button.setMessage("\n\n경계심과 불안함의 표현이다. 반려견이 낯선 사람을 만난 경우, 귀를 눕히고 몸을 웅크리며 이빨을 보이고 '으르렁~'하게 된다.\n\n" +
                        "이런 행동을 보이고 있는 개는 진정될 대까지 시간이 필요하므로, 자극하는 것보다 어느정도 시간을 갖는 것이 좋다.");
                emotion_button.show();
                break;
            case R.id.groan_button6:
                emotion_button.setTitle("워우우~ 워우우~ 운다");
                emotion_button.setMessage("\n\n멀리있는 개를 부를 때 짖던 개들의 본능적 습성이다.");
                emotion_button.show();
                break;
            case R.id.bio_button1:
                emotion_button.setTitle("얼음처럼 굳는다");
                emotion_button.setMessage("\n\n익숙하지 않은 상황에서 긴장과 불안을 느끼고 있다는 의미다.\n\n" +
                        "보통, 병원이나 낯선 장소에 갔을 때 움직이지 않는데 이때는 심리적인 안정을 취할 수 있도록 달래준다.\n\n" +
                        "평소에도 서로간의 신뢰를 쌓아, 두려운 상황에서도 반려인을 믿고 의지할 수 있또록 하는 것이 중요하다.");
                emotion_button.show();
                break;
            case R.id.bio_button2:
                emotion_button.setTitle("덜덜 떤다");
                emotion_button.setMessage("\n\n심리적으로 공포와 두려움, 경계씸을 느끼고 있다는 의미이다.\n\n" +
                        "가족 구성원이 큰 소리로 싸우거나 추위를 느낄 때 등 극도록 예민해진 상태에서 떠는 경우가 많다.\n\n" +
                        "목욕후에 떨고있다면, 감기에 걸리지 않도록 축축한 몸을 헤어 드라이어로 말려준다.\n\n" +
                        "통증으로 인해 몸을 떠는 경우도 있으므로, 평서와 달리 덜덜 떨면서도 컨디션도 나빠보인다면 동물병원에 방문해 보는 것이 좋다.");
                emotion_button.show();
                break;
            case R.id.bio_button3:
                emotion_button.setTitle("털을 곤두세운다");
                emotion_button.setMessage("\n\n두려움이나 극도록 예민할 때 털을 곤두세운다.\n\n" +
                        "이는 반려견이 화가 나서 그럴 수도 있고 상대방에게 다가오지 말라는 경고를 하기 위함일 수도 있다.\n\n" +
                        "이 경우 이빨을 드러내고 귀를 쫑긋하게 세우고 노려보면서 공포와 두려움을 표시해야 한다.");
                emotion_button.show();
                break;
            case R.id.bio_button4:
                emotion_button.setTitle("호흡이 빨라진다");
                emotion_button.setMessage("\n\n놀이 과정 중에 덥지 않은데 헥헥거리면서 호흡이 빨라지는 것은 현재 기분이 좋고 흥분했다는 것을 의미하며 적절한 휴식을 취해주는 것도 필요하다.\n\n" +
                        "불안한 상황에서 호흡이 거칠어 지는 것은 두렵고 예민한 상태라는 것을 의미한다.\n\n" +
                        "여름에 산책하다가 호흡이 거칠어졌다면 더위 때문일 수 있으므로, 모을 식힐 수 있게 약간의 물을 뿌려주거나 털을 짧게 유지하는 미용이 필요하다.\n\n" +
                        "여름 더운 낮에는 열사병에 걸리지 않도록 운동을 자제하고 새벽이나 밤에 산책하는 것이 좋다.\n\n" +
                        "질병이 있는 경우에도 호흡이 어려워서 거칠게 숨을 쉬기도 하는데 이때는 혀가 핑크색인지 확인해야 한다.\n\n" +
                        "만약 혀가 푸른색이라면 몸에 산소가 전달되고 있지 않은 아주 위험한 상황에 처한 것일 수 있으므로, 신속하게 병원에 데려가 응급처치를 받아야 한다.");
                emotion_button.show();
                break;
            case R.id.bio_button5:
                emotion_button.setTitle("하품을 한다");
                emotion_button.setMessage("\n\n하품을 하는 행동은 불안함이나 압박감, 스트레스를 느낄 대, 상대방을 진정시키거나 스스로를 진정시키기 위한 신호로 가족이 싸우거나 자신이 야단맞고 있을 때 하품하는 경우가 많다.\n\n" +
                        "흥분하거나 긴장한 개에게 하품을 하는 행동을 보여주면, 반려견의 마음이 조금 진정될 수 있다.");
                emotion_button.show();
                break;
            case R.id.bio_button6:
                emotion_button.setTitle("땀을 흘린다");
                emotion_button.setMessage("\n\n개는 사람처럼 땀을 흘리지 않는 것처럼 보인다. 대신 혀를 길게 빼고 체온조절을 한다.\n\n" +
                        "체온조절을 하는 땀샘은 발바닥에만 분포되어 있어서, 긴장하거나 더운 경우 발바닥 패드가 젖어있는 것을 확인할 수 있다.\n\n" +
                        "채취와 관계있는 땀샘도 있는데, 이 때문에 몸에서 냄새가 나거나 몸이 축축하게 느껴지기도 한다.");
                emotion_button.show();
                break;
            case R.id.bio_button7:
                emotion_button.setTitle("침을 흘린다");
                emotion_button.setMessage("\n\n개가 침을 흘리는 원인은 여러가지가 있는데, 긴장하고 낯선 상황을 맞닥뜨렸을 때가 그 중 하나이며, 지나치게 흥분을 했을 때도 침을 흘린다.\n\n" +
                        "반려견이 예민한 편이라면 조금만 차를 타도 침을 질질 흘릴 수 있다. 이를 '멀미'라고 하는데, 이런 경우에 장시간의 이동이 필요한 경우라면 멀미약이 필요할 수 있다.\n\n" +
                        "또한 입 안쪽에 이물질,상처,염증,혹이 있는 경우에도 침을 흘리는데, 침을 흘릴 때 피가 나거나, 침을 지나치게 많이 흘리거나, 음식물을 제대로 씹지 못하는 경우라면 병원을 방문해 치료를 받아야 한다.");
                emotion_button.show();
                break;
            case R.id.bio_button8:
                emotion_button.setTitle("비듬이 날린다");
                emotion_button.setMessage("\n\n피부가 건조하거나 피부병이 있을 때 비듬이 날리는 경우가 많다.\n\n" +
                        "피부가 건성이거나 지나치게 잦은 목욕으로 인해 피부가 건조해서 각질이 생긴 경우라면, 피모 컨디셔너나 보습제 등을 이용해 문제를 해결할 수 있다.\n\n" +
                        "피부병이 있어도 비듬이 생길 수 있는데, 반려견이 많이 가려워하거나 각질과 상처가 함께 동반된 경우라면, 병원에 데려가서 적절한 치료를 받아야 한다.");
                emotion_button.show();
                break;
            case R.id.bio_button9:
                emotion_button.setTitle("털이 날린다");
                emotion_button.setMessage("\n\n견종에 따라 털 날림의 정도는 다양한데, 털 날림이 심한 경우에는 매일 여러번의 집 청소가 필요할 수 있다.\n\n" +
                        "털갈이 시기에는 특히 털 날림이 더 심해질 수 있기 때문에, 부지런한 빗질과 청결한 피모 관리가 필요하다.\n\n" +
                        "낯선 장소로 인한 스트레스가 원인이 되어 털이 더 빠지는 경우도 있는데, 병원 등 긴장되는 장소에 가면, 소위 말하는 '털을 뿜기'도 한다.");
                emotion_button.show();
                break;
            case R.id.bark_button1:
                emotion_button.setTitle("멍 !");
                emotion_button.setMessage("\n\n반려인을 향해 '멍!' 하고 경쾌하게 짖는 것은 같이 놀자고 응석부리는 행동이다. 이때는 주로 꼬리를 좌우로 흔들고 밝은 표정을 하고 있다.\n\n" +
                        "하지만 낯선 사람에게 짧고 무겁게 '멍!' 하고 짖는 것은 그 사람에 대한 경계나 흥분 등을 의미하는데, 주로 집에 손님이 방문했을 때 위협적으로 보이기 위해서 이렇게 짖는다.");
                emotion_button.show();
                break;
            case R.id.bark_button2:
                emotion_button.setTitle("멍 멍 멍 멍 멍 !");
                emotion_button.setMessage("\n\n개가 초인종 소리에 반응한다면 자극에 대한 두려움으로 경계씸을 느끼고 있다는 의미이다. 이 경우 짧고 굵게 '멍! 멍!' 하고 짖는다.\n\n" +
                        "반면 낯선 사람이 초인종을 누르는 것 말고, 반려인의 발걸음 소리를 들었을 때는 꼬리를 치면서 발랄하게 '멍멍멍멍멍!' 하고 짖는 경우가 많다.");
                emotion_button.show();
                break;
            case R.id.bark_button3:
                emotion_button.setTitle("아이를 보면 짖는다");
                emotion_button.setMessage("\n\n아이를 보면 짖는 개는 낯선 사람을 보면 짖는 것과 같은 의미로 경계중이며, 흥분된 상태이다.\n\n" +
                        "반려인의 애정을 독차지하고 싶은 반려견이 아이에게 질투를 하면 예민하게 짖거나 심한 경우 물기도 한다.\n\n" +
                        "이러한 이유로 반려견이 어릴때부터 적절한 사회화 교육을 통해서 자신과 자신이 아닌 사람 동물과의 건강하고 올바른 관계를 정립할 수 있는 능력을 키워주는 것이 중요하다.");
                emotion_button.show();
                break;
            case R.id.bark_button4:
                emotion_button.setTitle("반려인이 귀가하면 짖는다");
                emotion_button.setMessage("\n\n반려견이 반려인을 맞이하면서 야단스럽게 짖는 것은 반가움의 표현임과 동시에 안부를 묻는 의미이다.\n\n" +
                        "동거견이 있는 경우라면 사랑을 독차지하고 싶어서 더욱 짖기도 한다.");
                emotion_button.show();
                break;
            case R.id.bark_button5:
                emotion_button.setTitle("통화 중에 짖는다");
                emotion_button.setMessage("\n\n통화중인데 짖는다면? 자신에게 관심을 가져달라는 표현일 수도 있다.");
                emotion_button.show();
                break;
            case R.id.bark_button6:
                emotion_button.setTitle("혼자일 때 짖는다");
                emotion_button.setMessage("\n\n혼자 집에 있을 때 짖는 행동은 분리불안의 일종으로 외로움의 표현이다. 이 때 짖는 것은 외출한 반려인에게 빨리 돌아와 달라는 의미일 수도 있다.\n\n" +
                        "공동주택이라면 짖는소리로 이웃간 불화가 생길 수 있으므로 반려겨늬 스트레스를 경감시키고 적절한 산책과 교육을 통해 관계를 유지하는 노력이 필요하다.\n\n" +
                        "분리불안을 예방하기 위해서는 반려견이 집에 대해 편안함을 느낄 수 있도록 해야 한다.\n\n" +
                        "반려인이 문을 닫고 밖에 나갔을 때도 얌전하게 집에 머무를 수 있도록, 반복적인 행동을 통해 적절한 보상을 하면서 교육한다.");
                emotion_button.show();
                break;
            case R.id.bark_button7:
                emotion_button.setTitle("쫒아가며 짖는다");
                emotion_button.setMessage("\n\n쫒아가면서 짖는 행동을 보이는 반려견은 본능적인 사냥 습성이 남아 있는 것으로, 움직이는 물체에 대해 민감아게 반응하는 것이며 호기심이나 흥분, 경계심을 나타낸다.\n\n" +
                        "이 경우에는 반려견의 시선을 분산시키고, 반려인과 함께 있다는 것을 인지시켜 반려견이 심리적인 안정을 느낄 수 있도록 해야 한다.");
                emotion_button.show();
                break;
            case R.id.bark_button8:
                emotion_button.setTitle("새벽에 짖는다");
                emotion_button.setMessage("\n\n심심함과 외로움, 두려움의 표현일 수 있다. 새벽에 짖는다면 스스로 집중하여 가지고 놀 수 있는 장난감을 주거나 반려견이 있는 공간이 편안한 곳임을 인지할 수 있도록 꾸며줘야 한다. " +
                        "반려인의 채취가 묻은 옷을 준다면 심리적인 안정감을 느끼는데 도움을 줄 수 있다.\n\n" +
                        "또한 낮 시간에 산책 등의 충분한 운동으로 에너지를 발산시키면 꿀잠을 자느라 새벽에 짖지 않을 것이다.\n\n" +
                        "관심을 끌기 위해 새벽에 짖는 상황이라면 무시로 일관하는 것이 필요하다.");
                emotion_button.show();
                break;
            case R.id.bark_button9:
                emotion_button.setTitle("멍멍! 짖는 원인을 모른다");
                emotion_button.setMessage("\n\n갑자기 짖는 이유는 다양하다. 먼저 관심을 끌기 위한 행동일 수도 있다.\n\n" +
                        "특정 사물을 보거나 특정 자극이 있을때 짖기도 하는데, 이는 사물에 대한 불안함과 두려움 때문에 생기는 행동이다.\n\n" +
                        "스트레스를 받고 컨디션이 좋지 않을 때도 짖을 수 있다. " +
                        "이 경우라면 반려인이 특정 사물이나 자극에 대한 방응을 철저히 무시함으로서 신경쓸 일이 아니라는 것을 충분히 인지시켜주고, 내가 지켜줄 것이라는 믿음을 심어줘야 한다.");
                emotion_button.show();
                break;
            case R.id.act_button1:
                emotion_button.setTitle("배를 보인다");
                emotion_button.setMessage("\n\n익숙하지 않은 상황에서 긴장과 불안을 느끼고 있다는 의미이다.\n\n" +
                        "보통, 낯선 장소에 갔을 때 굳은 듯이 움직이지 않는데, 이때는 심리적인 안정을 취할 수 있도록 안고 다독여주며 달래주면 좋다.\n\n" +
                        "평소에도 서로간의 신뢰를 쌓아, 매우 두려운 상황에서도 반려견이 반려인을 믿고 의지할 수 있도록 하는 것이 중요하다.");
                emotion_button.show();
                break;
            case R.id.act_button2:
                emotion_button.setTitle("기지개를 켠다");
                emotion_button.setMessage("\n\n엉덩이를 위로 올리고 앞다리를 앞으로 쭉 펴서 기지개를 켜는 자세는, 반려인에게 함께 놀자고 조르는 표현이다.\n\n" +
                        "또한 적의가 없다는 것을 표현함으로써 상대방을 진정시키는 일종의 몸짓 신호이기도 하다.\n\n" +
                        "반려견이 불안해 할 때 기지개 켜는 자세를 흉내내면 반려견을 진정시키는데 도움이 된다.");
                emotion_button.show();
                break;
            case R.id.act_button3:
                emotion_button.setTitle("엉덩이를 바닥에 끈다");
                emotion_button.setMessage("\n\n엉덩이를 바닥에 대고 질질 끄는 자세는 항문낭이 차 있다는 것을 의미한다.\n\n" +
                        "주기적으로 짜주지 않으면 고름이 차서 냄새가 나거나 가려울 수 있다. 한달에 1~2번씩은 목욕 전에 항문낭을 짜는 것이 좋다.\n\n" +
                        "감염 때문에 가려워 하는 경우도 있는데, 이 경우라면 병원치료가 필요하다.\n\n" +
                        "또한, 항문 주위의 피부는 예민하고 얇은 편인데, 피부병으로 인해 가려워서 끄는 것일 수도 있다.\n\n" +
                        "항문 주위의 피부가 유난히 붉거나 딱지가 생겼다면, 병원에 데려가서 적절한 치료를 받아야 한다.");
                emotion_button.show();
                break;
            case R.id.act_button4:
                emotion_button.setTitle("앞발로 긁고 위아래로 움직인다");
                emotion_button.setMessage("\n\n앞발로 바닥을 긁는 것은, 앉을 자리를 따뜻하게 하고, 편하게 정리하고 싶어하는 행동이다.\n\n" +
                        "또한 발톱을 갈아서 청결하게 유지하기 위한 본능적인 습성이기도 하다.\n\n" +
                        "앞발을 위아래로 움직이는 행동은 기분이 좋고, 칭찬을 받고 싶거나, 무언가를 요구하는 행동이며, 때로는 분위기를 전환하고 싶어하는 반려견의 마음이기도 하다.");
                emotion_button.show();
                break;
            case R.id.act_button5:
                emotion_button.setTitle("고개를 갸우뚱 한다");
                emotion_button.setMessage("\n\n고개를 갸우뚱거리는 것은 상대방의 말을 알아듣고 기분을 파악하기 위해 집중하고 있다는 것을 의미한다.\n\n" +
                        "만약 이러한 행동을 보인다면, 뭐라고 말하는지 궁금해 하며 반려인의 의도를 파악하려고 노력하고 있는 중인 것이다.");
                emotion_button.show();
                break;
            case R.id.act_button6:
                emotion_button.setTitle("등을 보인다");
                emotion_button.setMessage("\n\n등을 보이는 것은 존중받고 싶다는 의미이기도 하고, 상대방과 자신을 진정시키기 위한 행동이기도 하다.\n\n" +
                        "자주 흥분하는 개에게 등을 보여주면 마음을 안정시키는 데 도움이 될 수 있다!");
                emotion_button.show();
                break;
            case R.id.act_button7:
                emotion_button.setTitle("꼬리를 친다");
                emotion_button.setMessage("\n\n꼬리치는 것은 다양한 감정을 의미한다. 수평으로 빠르게 치는 것은 반가움과 놀자는 표현이고, 천천히 수평으로 친다면 편안함과 안정감을 의미한다.\n\n" +
                        "꼬리를 수직으로 강하게 친다면 불안감과 경계심을 의미하는데 기쁨으로 오해하면 안된다!!");
                emotion_button.show();
                break;
            case R.id.act_button8:
                emotion_button.setTitle("몸을 부르르 떤다");
                emotion_button.setMessage("\n\n몸을 부르르 터는 것은 스트레스를 받거나 심리적으로 불안한 상황일 때 자신과 상대방을 진정시키기 위한 일종의 몸짓 신호다.\n\n" +
                        "이는 긴장은 되지만 상대방에게 적의가 없다는 것을 보여주는 것이므로, 갑자기 다가가지 말고 교감을 하며 천천히 가까워지는 것이 좋다.");
                emotion_button.show();
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_emotion_mypage, menu);
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
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            // return PlaceholderFragment.newInstance(position + 1);
            if (position == 0)
                return new EmotionLook();
            else if (position == 1)
                return new EmotionAct();
            else if (position == 2)
                return new EmotionBark();
            else if (position == 3)
                return new EmotionBio();
            else
                return new EmotionGroan();
        }
        @Override
        public int getCount() {
            // Show 3 total pages.
            return 5;
        }
    }
}
