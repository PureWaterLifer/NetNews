package com.zzptc.sky.netnews.mvp.ui.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import com.zzptc.sky.netnews.R;
import com.zzptc.sky.netnews.annotation.BindValues;
import com.zzptc.sky.netnews.greendao.NewsChannelTable;
import com.zzptc.sky.netnews.mvp.ui.activities.base.BaseActivity;
import com.zzptc.sky.netnews.mvp.view.NewsView;

import java.util.List;

import butterknife.BindView;

@BindValues(mIsHasNavigationView = true)
public class NewsActivity extends BaseActivity implements NewsView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.nav_news)
    NavigationView mNavView;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_news;
    }

    @Override
    protected void initInjector() {
        mActivityComponent.inject(this);
    }

    @Override
    protected void initViews() {
        
    }

    @Override
    public void initViewPager(List<NewsChannelTable> newsChannelTables) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMsg(String message) {

    }
}
