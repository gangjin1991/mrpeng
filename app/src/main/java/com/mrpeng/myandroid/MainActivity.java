package com.mrpeng.myandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

import fm.FmFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private MyFragmentAdapter mAdapter;
    private int[] checkedId = {R.id.radio0, R.id.radio1, R.id.radio2, R.id.radio3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.vp);
        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        mAdapter = new MyFragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(new MyOnPagerChangerListener());
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setCurrentItem(2);
        findViewById(R.id.radio0).setOnClickListener(this);
        findViewById(R.id.radio1).setOnClickListener(this);
        findViewById(R.id.radio2).setOnClickListener(this);
        findViewById(R.id.radio3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int index = -1;
        switch (v.getId()) {
            case R.id.radio0:
                index = 0;
                break;
            case R.id.radio1:
                index = 1;
                break;
            case R.id.radio2:
                index = 2;
                break;
            case R.id.radio3:
                index = 3;
                break;

            default:
                break;
        }
        mViewPager.setCurrentItem(index);

    }


    /**
     * 平常使用的FragmentPagerAdapter和FragmentStatePagerAdapter来自android.support.v4.app包用来构建ViewPager。
     * FragmentPagerAdapter更多的用于少量界面的ViewPager，比如Tab。划过的fragment会保存在内存中，尽管已经划过。
     * 而FragmentStatePagerAdapter和ListView有点类似，会保存当前界面，以及下一个界面和上一个界面（如果有），最多保存3个，其他会被销毁掉。
     * 要注意的是FragmentStatePagerAdapter可能不经意间会造成内存未正常回收，严重导致内存溢出，比如图片资源没有释放，资源引用问题。
     * （之前碰到过EditTextt由于保存焦点导致Fragment未被释放，以至于内存溢出，设置editText.saveEanble(false)就可以解决此问题)。
     */
    private class MyFragmentAdapter extends FragmentStatePagerAdapter {
        private final FmFactory mFactory;

        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
            mFactory = new FmFactory();
        }

        @Override
        public Fragment getItem(int position) {
            return mFactory.createFragment(position);
        }

        @Override
        public int getCount() {
            return checkedId.length;
        }
    }


    class MyOnPagerChangerListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            int id = 0;
            switch (position) {
                case 0:
                    id = R.id.radio0;
                    break;
                case 1:
                    id = R.id.radio1;
                    break;
                case 2:
                    id = R.id.radio2;
                    break;
                case 3:
                    id = R.id.radio3;
                    break;
                default:
                    break;
            }
            mRadioGroup.check(id);
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }


}
