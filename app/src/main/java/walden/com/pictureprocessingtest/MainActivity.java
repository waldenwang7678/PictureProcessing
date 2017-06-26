package walden.com.pictureprocessingtest;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import walden.com.pictureprocessingtest.adapter.ViewPagerAdapter;
import walden.com.pictureprocessingtest.fragment.ColorFragment;
import walden.com.pictureprocessingtest.fragment.ImageFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private TabLayout tab;
    private ArrayList<Fragment> fgList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        ColorFragment colorFragment = new ColorFragment();
        ImageFragment imageFragment = new ImageFragment();
        fgList.add(colorFragment);
        fgList.add(imageFragment);

    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tab = (TabLayout) findViewById(R.id.tab);
        FragmentManager fm = getSupportFragmentManager();
        ViewPagerAdapter adapter = new ViewPagerAdapter(fm, fgList);
        viewpager.setAdapter(adapter);
        tab.setupWithViewPager(viewpager);
        //tab.setTabsFromPagerAdapter(adapter);
    }
}
