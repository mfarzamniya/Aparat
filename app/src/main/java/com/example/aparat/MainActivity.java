package com.example.aparat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.aparat.adapter.TabsAdapter;
import com.example.aparat.databinding.ActivityMainBinding;
import com.example.aparat.fragments.CategoryFragment;
import com.example.aparat.fragments.FovoriteFragment;
import com.example.aparat.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new CategoryFragment());
        fragments.add(new FovoriteFragment());

        TabsAdapter tabsAdapter = new TabsAdapter(getSupportFragmentManager(), fragments);
        binding.pager.setAdapter(tabsAdapter);

        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.item_home :
                        binding.pager.setCurrentItem(0);
                        binding.bottomNavigation.getMenu().getItem(0).setChecked(true);
                        break;
                    case R.id.item_category :
                        binding.pager.setCurrentItem(1);
                        binding.bottomNavigation.getMenu().getItem(1).setChecked(true);
                        break;
                    case R.id.item_favorite :
                        binding.pager.setCurrentItem(2);
                        binding.bottomNavigation.getMenu().getItem(2).setChecked(true);
                        break;
                }
                return false;
            }
        });


        binding.pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                binding.bottomNavigation.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
}