package me.racofix.eyes.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.core.widget.TabStripView;

import me.racofix.eyes.R;
import me.racofix.eyes.view.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private TabStripView navigateTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigateTabBar = (TabStripView) findViewById(R.id.navigateTabBar);
        //恢复选项状态
        navigateTabBar.onRestoreInstanceState(savedInstanceState);

        navigateTabBar.addTab(HomeFragment.class,
                new TabStripView.TabParam(R.drawable.ic_tab_bar_home,
                        R.drawable.ic_tab_bar_home_active, R.string.tab_bar_text_home));

        navigateTabBar.addTab(HomeFragment.class,
                new TabStripView.TabParam(R.drawable.ic_tab_bar_discover,
                        R.drawable.ic_tab_bar_discover_active, R.string.tab_bar_text_discover));

        navigateTabBar.addTab(HomeFragment.class,
                new TabStripView.TabParam(R.drawable.ic_tab_bar_home,
                        R.drawable.ic_tab_bar_home_active, R.string.tab_bar_text_me));
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //保存当前选中的选项状态
        navigateTabBar.onSaveInstanceState(outState);
    }
}
