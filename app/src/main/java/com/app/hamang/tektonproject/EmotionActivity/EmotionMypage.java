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
        switch (view.getId()) {
            case R.id.look_button1:
                AlertDialog.Builder look_button1 = new AlertDialog.Builder(EmotionMypage.this);
                look_button1.setTitle("눈을 치뜬다");
                look_button1.setMessage("눈을 치뜨는 이유 설명");
                look_button1.show();
                break;
            case R.id.look_button2:
                AlertDialog.Builder look_button2 = new AlertDialog.Builder(EmotionMypage.this);
                look_button2.setTitle("눈을 동그랗게 뜬다");
                look_button2.setMessage("이유 설명");
                look_button2.show();
                break;
            case R.id.look_button3: // 버킷리스트 버튼 반응
                AlertDialog.Builder look_button3 = new AlertDialog.Builder(EmotionMypage.this);
                look_button3.setTitle("눈을 치뜬다");
                look_button3.setMessage("눈을 치뜨는 이유 설명");
                look_button3.show();
                break;
            case R.id.look_button4: // 병원 찾기 버튼 반응
                AlertDialog.Builder look_button4 = new AlertDialog.Builder(EmotionMypage.this);
                look_button4.setTitle("눈을 치뜬다");
                look_button4.setMessage("눈을 치뜨는 이유 설명");
                look_button4.show();
                break;
            case R.id.look_button5: // 샵 찾기 버튼 반응
                AlertDialog.Builder look_button5 = new AlertDialog.Builder(EmotionMypage.this);
                look_button5.setTitle("눈을 치뜬다");
                look_button5.setMessage("눈을 치뜨는 이유 설명");
                look_button5.show();
                break;
            case R.id.look_button6: // 커뮤니티 버튼 반응
                AlertDialog.Builder look_button6 = new AlertDialog.Builder(EmotionMypage.this);
                look_button6.setTitle("눈을 치뜬다");
                look_button6.setMessage("눈을 치뜨는 이유 설명");
                look_button6.show();
                break;
            case R.id.look_button7:
                AlertDialog.Builder look_button7 = new AlertDialog.Builder(EmotionMypage.this);
                look_button7.setTitle("눈을 치뜬다");
                look_button7.setMessage("눈을 치뜨는 이유 설명");
                look_button7.show();
                break;
            case R.id.look_button8:
                AlertDialog.Builder look_button8 = new AlertDialog.Builder(EmotionMypage.this);
                look_button8.setTitle("눈을 치뜬다");
                look_button8.setMessage("눈을 치뜨는 이유 설명");
                look_button8.show();
                break;
            case R.id.look_button9:
                AlertDialog.Builder look_button9 = new AlertDialog.Builder(EmotionMypage.this);
                look_button9.setTitle("눈을 치뜬다");
                look_button9.setMessage("눈을 치뜨는 이유 설명");
                look_button9.show();
                break;
            case R.id.look_button10:
                AlertDialog.Builder look_button10 = new AlertDialog.Builder(EmotionMypage.this);
                look_button10.setTitle("눈을 치뜬다");
                look_button10.setMessage("눈을 치뜨는 이유 설명");
                look_button10.show();
                break;
            case R.id.look_button11:
                AlertDialog.Builder look_button11 = new AlertDialog.Builder(EmotionMypage.this);
                look_button11.setTitle("눈을 치뜬다");
                look_button11.setMessage("눈을 치뜨는 이유 설명");
                look_button11.show();
                break;
            case R.id.look_button12:
                AlertDialog.Builder look_button12 = new AlertDialog.Builder(EmotionMypage.this);
                look_button12.setTitle("눈을 치뜬다");
                look_button12.setMessage("눈을 치뜨는 이유 설명");
                look_button12.show();
                break;
            case R.id.groan_button1:
                AlertDialog.Builder groan_button1 = new AlertDialog.Builder(EmotionMypage.this);
                groan_button1.setTitle("눈을 치뜬다");
                groan_button1.setMessage("눈을 치뜨는 이유 설명");
                groan_button1.show();
                break;
            case R.id.groan_button2:
                AlertDialog.Builder groan_button2 = new AlertDialog.Builder(EmotionMypage.this);
                groan_button2.setTitle("눈을 치뜬다");
                groan_button2.setMessage("눈을 치뜨는 이유 설명");
                groan_button2.show();
                break;
            case R.id.groan_button3:
                AlertDialog.Builder groan_button3 = new AlertDialog.Builder(EmotionMypage.this);
                groan_button3.setTitle("눈을 치뜬다");
                groan_button3.setMessage("눈을 치뜨는 이유 설명");
                groan_button3.show();
                break;
            case R.id.groan_button4:
                AlertDialog.Builder groan_button4 = new AlertDialog.Builder(EmotionMypage.this);
                groan_button4.setTitle("눈을 치뜬다");
                groan_button4.setMessage("눈을 치뜨는 이유 설명");
                groan_button4.show();
                break;
            case R.id.groan_button5:
                AlertDialog.Builder groan_button5 = new AlertDialog.Builder(EmotionMypage.this);
                groan_button5.setTitle("눈을 치뜬다");
                groan_button5.setMessage("눈을 치뜨는 이유 설명");
                groan_button5.show();
                break;
            case R.id.groan_button6:
                AlertDialog.Builder groan_button6 = new AlertDialog.Builder(EmotionMypage.this);
                groan_button6.setTitle("눈을 치뜬다");
                groan_button6.setMessage("눈을 치뜨는 이유 설명");
                groan_button6.show();
                break;
            case R.id.bio_button1:
                AlertDialog.Builder bio_button1 = new AlertDialog.Builder(EmotionMypage.this);
                bio_button1.setTitle("눈을 치뜬다");
                bio_button1.setMessage("눈을 치뜨는 이유 설명");
                bio_button1.show();
                break;
            case R.id.bio_button2:
                AlertDialog.Builder bio_button2 = new AlertDialog.Builder(EmotionMypage.this);
                bio_button2.setTitle("눈을 치뜬다");
                bio_button2.setMessage("눈을 치뜨는 이유 설명");
                bio_button2.show();
                break;
            case R.id.bio_button3:
                AlertDialog.Builder bio_button3 = new AlertDialog.Builder(EmotionMypage.this);
                bio_button3.setTitle("눈을 치뜬다");
                bio_button3.setMessage("눈을 치뜨는 이유 설명");
                bio_button3.show();
                break;
            case R.id.bio_button4:
                AlertDialog.Builder bio_button4 = new AlertDialog.Builder(EmotionMypage.this);
                bio_button4.setTitle("눈을 치뜬다");
                bio_button4.setMessage("눈을 치뜨는 이유 설명");
                bio_button4.show();
                break;
            case R.id.bio_button5:
                AlertDialog.Builder bio_button5 = new AlertDialog.Builder(EmotionMypage.this);
                bio_button5.setTitle("눈을 치뜬다");
                bio_button5.setMessage("눈을 치뜨는 이유 설명");
                bio_button5.show();
                break;
            case R.id.bio_button6:
                AlertDialog.Builder bio_button6 = new AlertDialog.Builder(EmotionMypage.this);
                bio_button6.setTitle("눈을 치뜬다");
                bio_button6.setMessage("눈을 치뜨는 이유 설명");
                bio_button6.show();
                break;
            case R.id.bio_button7:
                AlertDialog.Builder bio_button7 = new AlertDialog.Builder(EmotionMypage.this);
                bio_button7.setTitle("눈을 치뜬다");
                bio_button7.setMessage("눈을 치뜨는 이유 설명");
                bio_button7.show();
                break;
            case R.id.bio_button8:
                AlertDialog.Builder bio_button8 = new AlertDialog.Builder(EmotionMypage.this);
                bio_button8.setTitle("눈을 치뜬다");
                bio_button8.setMessage("눈을 치뜨는 이유 설명");
                bio_button8.show();
                break;
            case R.id.bio_button9:
                AlertDialog.Builder bio_button9 = new AlertDialog.Builder(EmotionMypage.this);
                bio_button9.setTitle("눈을 치뜬다");
                bio_button9.setMessage("눈을 치뜨는 이유 설명");
                bio_button9.show();
                break;
            case R.id.bark_button1:
                AlertDialog.Builder bark_button1 = new AlertDialog.Builder(EmotionMypage.this);
                bark_button1.setTitle("눈을 치뜬다");
                bark_button1.setMessage("눈을 치뜨는 이유 설명");
                bark_button1.show();
                break;
            case R.id.bark_button2:
                AlertDialog.Builder bark_button2 = new AlertDialog.Builder(EmotionMypage.this);
                bark_button2.setTitle("눈을 치뜬다");
                bark_button2.setMessage("눈을 치뜨는 이유 설명");
                bark_button2.show();
                break;
            case R.id.bark_button3:
                AlertDialog.Builder bark_button3 = new AlertDialog.Builder(EmotionMypage.this);
                bark_button3.setTitle("눈을 치뜬다");
                bark_button3.setMessage("눈을 치뜨는 이유 설명");
                bark_button3.show();
                break;
            case R.id.bark_button4:
                AlertDialog.Builder bark_button4 = new AlertDialog.Builder(EmotionMypage.this);
                bark_button4.setTitle("눈을 치뜬다");
                bark_button4.setMessage("눈을 치뜨는 이유 설명");
                bark_button4.show();
                break;
            case R.id.bark_button5:
                AlertDialog.Builder bark_button5 = new AlertDialog.Builder(EmotionMypage.this);
                bark_button5.setTitle("눈을 치뜬다");
                bark_button5.setMessage("눈을 치뜨는 이유 설명");
                bark_button5.show();
                break;
            case R.id.bark_button6:
                AlertDialog.Builder bark_button6 = new AlertDialog.Builder(EmotionMypage.this);
                bark_button6.setTitle("눈을 치뜬다");
                bark_button6.setMessage("눈을 치뜨는 이유 설명");
                bark_button6.show();
                break;
            case R.id.bark_button7:
                AlertDialog.Builder bark_button7 = new AlertDialog.Builder(EmotionMypage.this);
                bark_button7.setTitle("눈을 치뜬다");
                bark_button7.setMessage("눈을 치뜨는 이유 설명");
                bark_button7.show();
                break;
            case R.id.bark_button8:
                AlertDialog.Builder bark_button8 = new AlertDialog.Builder(EmotionMypage.this);
                bark_button8.setTitle("눈을 치뜬다");
                bark_button8.setMessage("눈을 치뜨는 이유 설명");
                bark_button8.show();
                break;
            case R.id.bark_button9:
                AlertDialog.Builder bark_button9 = new AlertDialog.Builder(EmotionMypage.this);
                bark_button9.setTitle("눈을 치뜬다");
                bark_button9.setMessage("눈을 치뜨는 이유 설명");
                bark_button9.show();
                break;
            case R.id.act_button1:
                AlertDialog.Builder act_button1 = new AlertDialog.Builder(EmotionMypage.this);
                act_button1.setTitle("눈을 치뜬다");
                act_button1.setMessage("눈을 치뜨는 이유 설명");
                act_button1.show();
                break;
            case R.id.act_button2:
                AlertDialog.Builder act_button2 = new AlertDialog.Builder(EmotionMypage.this);
                act_button2.setTitle("눈을 치뜬다");
                act_button2.setMessage("눈을 치뜨는 이유 설명");
                act_button2.show();
                break;
            case R.id.act_button3:
                AlertDialog.Builder act_button3 = new AlertDialog.Builder(EmotionMypage.this);
                act_button3.setTitle("눈을 치뜬다");
                act_button3.setMessage("눈을 치뜨는 이유 설명");
                act_button3.show();
                break;
            case R.id.act_button4:
                AlertDialog.Builder act_button4 = new AlertDialog.Builder(EmotionMypage.this);
                act_button4.setTitle("눈을 치뜬다");
                act_button4.setMessage("눈을 치뜨는 이유 설명");
                act_button4.show();
                break;
            case R.id.act_button5:
                AlertDialog.Builder act_button5 = new AlertDialog.Builder(EmotionMypage.this);
                act_button5.setTitle("눈을 치뜬다");
                act_button5.setMessage("눈을 치뜨는 이유 설명");
                act_button5.show();
                break;
            case R.id.act_button6:
                AlertDialog.Builder act_button6 = new AlertDialog.Builder(EmotionMypage.this);
                act_button6.setTitle("눈을 치뜬다");
                act_button6.setMessage("눈을 치뜨는 이유 설명");
                act_button6.show();
                break;
            case R.id.act_button7:
                AlertDialog.Builder act_button7 = new AlertDialog.Builder(EmotionMypage.this);
                act_button7.setTitle("눈을 치뜬다");
                act_button7.setMessage("눈을 치뜨는 이유 설명");
                act_button7.show();
                break;
            case R.id.act_button8:
                AlertDialog.Builder act_button8 = new AlertDialog.Builder(EmotionMypage.this);
                act_button8.setTitle("눈을 치뜬다");
                act_button8.setMessage("눈을 치뜨는 이유 설명");
                act_button8.show();
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
