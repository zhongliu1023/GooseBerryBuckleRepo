package appstute.in.smartbuckle.ui.activity;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;



import java.util.ArrayList;
import java.util.List;


import appstute.in.smartbuckle.ui.fragment.MoveFragment;
import appstute.in.smartbuckle.ui.fragment.SettingFragment;
import appstute.in.smartbuckle.ui.fragment.SleepFragment;
import in.appstute.smartbuckle.R;


public class HomeMoveActivity extends BaseActivity {

    private static final int NUM_PAGES = 3;

    private ViewPager viewPager;
    private PagerAdapter mPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_move);

        //FragmentManager fragmentManager = getSupportFragmentManager();
        // FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // fragmentTransaction.replace(R.id.container, new SettingFragment()).commit();
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        mPagerAdapter = new MPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(viewPager, true);
    }

    public class MPagerAdapter extends FragmentStatePagerAdapter {

        int mNumOfTabs;

        public MPagerAdapter(FragmentManager fm) {
            super(fm);
            this.mNumOfTabs = NUM_PAGES;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    SettingFragment tab1 = new SettingFragment();
                    return tab1;
                case 1:
                    MoveFragment tab2 = new MoveFragment();
                    return tab2;
                case 2:
                    SleepFragment tab3 = new SleepFragment();
                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }
}






