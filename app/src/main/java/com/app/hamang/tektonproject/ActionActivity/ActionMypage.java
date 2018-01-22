package com.app.hamang.tektonproject.ActionActivity;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.app.hamang.tektonproject.EmotionActivity.EmotionMypage;
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
        switch (view.getId()) {
            case R.id.toilet_button1:
                AlertDialog.Builder toilet_button1 = new AlertDialog.Builder(ActionMypage.this);
                toilet_button1.setTitle("눈을 치뜬다");
                toilet_button1.setMessage("눈을 치뜨는 이유 설명");
                toilet_button1.show();
                break;
            case R.id.toilet_button2:
                AlertDialog.Builder toilet_button2 = new AlertDialog.Builder(ActionMypage.this);
                toilet_button2.setTitle("눈을 동그랗게 뜬다");
                toilet_button2.setMessage("이유 설명");
                toilet_button2.show();
                break;
            case R.id.toilet_button3: // 버킷리스트 버튼 반응
                AlertDialog.Builder toilet_button3 = new AlertDialog.Builder(ActionMypage.this);
                toilet_button3.setTitle("눈을 치뜬다");
                toilet_button3.setMessage("눈을 치뜨는 이유 설명");
                toilet_button3.show();
                break;
            case R.id.notice_button1:
                AlertDialog.Builder notice_button1 = new AlertDialog.Builder(ActionMypage.this);
                notice_button1.setTitle("눈을 치뜬다");
                notice_button1.setMessage("눈을 치뜨는 이유 설명");
                notice_button1.show();
                break;
            case R.id.notice_button2:
                AlertDialog.Builder notice_button2 = new AlertDialog.Builder(ActionMypage.this);
                notice_button2.setTitle("눈을 치뜬다");
                notice_button2.setMessage("눈을 치뜨는 이유 설명");
                notice_button2.show();
                break;
            case R.id.notice_button3:
                AlertDialog.Builder notice_button3 = new AlertDialog.Builder(ActionMypage.this);
                notice_button3.setTitle("눈을 치뜬다");
                notice_button3.setMessage("눈을 치뜨는 이유 설명");
                notice_button3.show();
                break;
            case R.id.notice_button4:
                AlertDialog.Builder notice_button4 = new AlertDialog.Builder(ActionMypage.this);
                notice_button4.setTitle("눈을 치뜬다");
                notice_button4.setMessage("눈을 치뜨는 이유 설명");
                notice_button4.show();
                break;
            case R.id.notice_button5:
                AlertDialog.Builder notice_button5 = new AlertDialog.Builder(ActionMypage.this);
                notice_button5.setTitle("눈을 치뜬다");
                notice_button5.setMessage("눈을 치뜨는 이유 설명");
                notice_button5.show();
                break;
            case R.id.notice_button6:
                AlertDialog.Builder notice_button6 = new AlertDialog.Builder(ActionMypage.this);
                notice_button6.setTitle("눈을 치뜬다");
                notice_button6.setMessage("눈을 치뜨는 이유 설명");
                notice_button6.show();
                break;
            case R.id.bng_button1:
                AlertDialog.Builder bng_button1 = new AlertDialog.Builder(ActionMypage.this);
                bng_button1.setTitle("눈을 치뜬다");
                bng_button1.setMessage("눈을 치뜨는 이유 설명");
                bng_button1.show();
                break;
            case R.id.bng_button2:
                AlertDialog.Builder bng_button2 = new AlertDialog.Builder(ActionMypage.this);
                bng_button2.setTitle("눈을 치뜬다");
                bng_button2.setMessage("눈을 치뜨는 이유 설명");
                bng_button2.show();
                break;
            case R.id.bng_button3:
                AlertDialog.Builder bng_button3 = new AlertDialog.Builder(ActionMypage.this);
                bng_button3.setTitle("눈을 치뜬다");
                bng_button3.setMessage("눈을 치뜨는 이유 설명");
                bng_button3.show();
                break;
            case R.id.bng_button4:
                AlertDialog.Builder bng_button4 = new AlertDialog.Builder(ActionMypage.this);
                bng_button4.setTitle("눈을 치뜬다");
                bng_button4.setMessage("눈을 치뜨는 이유 설명");
                bng_button4.show();
                break;
            case R.id.bng_button5:
                AlertDialog.Builder bng_button5 = new AlertDialog.Builder(ActionMypage.this);
                bng_button5.setTitle("눈을 치뜬다");
                bng_button5.setMessage("눈을 치뜨는 이유 설명");
                bng_button5.show();
                break;
            case R.id.bng_button6:
                AlertDialog.Builder bng_button6 = new AlertDialog.Builder(ActionMypage.this);
                bng_button6.setTitle("눈을 치뜬다");
                bng_button6.setMessage("눈을 치뜨는 이유 설명");
                bng_button6.show();
                break;
            case R.id.bng_button7:
                AlertDialog.Builder bng_button7 = new AlertDialog.Builder(ActionMypage.this);
                bng_button7.setTitle("눈을 치뜬다");
                bng_button7.setMessage("눈을 치뜨는 이유 설명");
                bng_button7.show();
                break;
            case R.id.bng_button8:
                AlertDialog.Builder bng_button8 = new AlertDialog.Builder(ActionMypage.this);
                bng_button8.setTitle("눈을 치뜬다");
                bng_button8.setMessage("눈을 치뜨는 이유 설명");
                bng_button8.show();
                break;
            case R.id.attack_button1:
                AlertDialog.Builder attack_button1 = new AlertDialog.Builder(ActionMypage.this);
                attack_button1.setTitle("눈을 치뜬다");
                attack_button1.setMessage("눈을 치뜨는 이유 설명");
                attack_button1.show();
                break;
            case R.id.attack_button2:
                AlertDialog.Builder attack_button2 = new AlertDialog.Builder(ActionMypage.this);
                attack_button2.setTitle("눈을 치뜬다");
                attack_button2.setMessage("눈을 치뜨는 이유 설명");
                attack_button2.show();
                break;
            case R.id.attack_button3:
                AlertDialog.Builder attack_button3 = new AlertDialog.Builder(ActionMypage.this);
                attack_button3.setTitle("눈을 치뜬다");
                attack_button3.setMessage("눈을 치뜨는 이유 설명");
                attack_button3.show();
                break;
            case R.id.attack_button4:
                AlertDialog.Builder attack_button4 = new AlertDialog.Builder(ActionMypage.this);
                attack_button4.setTitle("눈을 치뜬다");
                attack_button4.setMessage("눈을 치뜨는 이유 설명");
                attack_button4.show();
                break;
            case R.id.attack_button5:
                AlertDialog.Builder attack_button5 = new AlertDialog.Builder(ActionMypage.this);
                attack_button5.setTitle("눈을 치뜬다");
                attack_button5.setMessage("눈을 치뜨는 이유 설명");
                attack_button5.show();
                break;
            case R.id.action_button1:
                AlertDialog.Builder action_button1 = new AlertDialog.Builder(ActionMypage.this);
                action_button1.setTitle("눈을 치뜬다");
                action_button1.setMessage("눈을 치뜨는 이유 설명");
                action_button1.show();
                break;
            case R.id.action_button2:
                AlertDialog.Builder action_button2 = new AlertDialog.Builder(ActionMypage.this);
                action_button2.setTitle("눈을 치뜬다");
                action_button2.setMessage("눈을 치뜨는 이유 설명");
                action_button2.show();
                break;
            case R.id.action_button3:
                AlertDialog.Builder action_button3 = new AlertDialog.Builder(ActionMypage.this);
                action_button3.setTitle("눈을 치뜬다");
                action_button3.setMessage("눈을 치뜨는 이유 설명");
                action_button3.show();
                break;
            case R.id.action_button4:
                AlertDialog.Builder action_button4 = new AlertDialog.Builder(ActionMypage.this);
                action_button4.setTitle("눈을 치뜬다");
                action_button4.setMessage("눈을 치뜨는 이유 설명");
                action_button4.show();
                break;
            case R.id.action_button5:
                AlertDialog.Builder action_button5 = new AlertDialog.Builder(ActionMypage.this);
                action_button5.setTitle("눈을 치뜬다");
                action_button5.setMessage("눈을 치뜨는 이유 설명");
                action_button5.show();
                break;
            case R.id.action_button6:
                AlertDialog.Builder action_button6 = new AlertDialog.Builder(ActionMypage.this);
                action_button6.setTitle("눈을 치뜬다");
                action_button6.setMessage("눈을 치뜨는 이유 설명");
                action_button6.show();
                break;
            case R.id.action_button7:
                AlertDialog.Builder action_button7 = new AlertDialog.Builder(ActionMypage.this);
                action_button7.setTitle("눈을 치뜬다");
                action_button7.setMessage("눈을 치뜨는 이유 설명");
                action_button7.show();
                break;
            case R.id.action_button8:
                AlertDialog.Builder action_button8 = new AlertDialog.Builder(ActionMypage.this);
                action_button8.setTitle("눈을 치뜬다");
                action_button8.setMessage("눈을 치뜨는 이유 설명");
                action_button8.show();
                break;
            case R.id.action_button9:
                AlertDialog.Builder action_button9 = new AlertDialog.Builder(ActionMypage.this);
                action_button9.setTitle("눈을 치뜬다");
                action_button9.setMessage("눈을 치뜨는 이유 설명");
                action_button9.show();
                break;
            case R.id.action_button10:
                AlertDialog.Builder action_button10 = new AlertDialog.Builder(ActionMypage.this);
                action_button10.setTitle("눈을 치뜬다");
                action_button10.setMessage("눈을 치뜨는 이유 설명");
                action_button10.show();
                break;
            case R.id.action_button11:
                AlertDialog.Builder action_button11 = new AlertDialog.Builder(ActionMypage.this);
                action_button11.setTitle("눈을 치뜬다");
                action_button11.setMessage("눈을 치뜨는 이유 설명");
                action_button11.show();
                break;
            case R.id.action_button12:
                AlertDialog.Builder action_button12 = new AlertDialog.Builder(ActionMypage.this);
                action_button12.setTitle("눈을 치뜬다");
                action_button12.setMessage("눈을 치뜨는 이유 설명");
                action_button12.show();
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
