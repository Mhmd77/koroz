package com.myapps.koroz.view.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.myapps.koroz.R;
import com.myapps.koroz.view.fragments.BlankFragment;
import com.myapps.koroz.view.fragments.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.frame_layout_container)
    FrameLayout frameLayoutContainer;
    @BindView(R.id.bottom_navigation_menu_home_home)
    BottomNavigationView bottomNavigationMenuHomeHome;
    private Fragment homeFragment, chartFragment, leaderFragment, active;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragmnets();
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        bottomNavigationMenuHomeHome.setOnNavigationItemSelectedListener(this);
        bottomNavigationMenuHomeHome.setSelectedItemId(R.id.navigation_home);
    }

    private void initFragmnets() {
        fm = getSupportFragmentManager();
        homeFragment = HomeFragment.newInstance();
        leaderFragment = BlankFragment.newInstance();
        chartFragment = BlankFragment.newInstance();
        active = homeFragment;
        fm.beginTransaction().add(R.id.frame_layout_container, chartFragment, "3").hide(chartFragment).commit();
        fm.beginTransaction().add(R.id.frame_layout_container, homeFragment, "2").hide(homeFragment).commit();
        fm.beginTransaction().add(R.id.frame_layout_container, leaderFragment, "1").commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                fm.beginTransaction().hide(active).show(homeFragment).commit();
                active = homeFragment;
                return true;
            case R.id.navigation_chart:
                fm.beginTransaction().hide(active).show(chartFragment).commit();
                active = chartFragment;
                return true;
            case R.id.navigation_leader_board:
                fm.beginTransaction().hide(active).show(leaderFragment).commit();
                active = leaderFragment;
                return true;
        }
        return false;
    }

}
