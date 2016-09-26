package me.racofix.open.view.activity;

import android.widget.ImageView;

import com.android.core.control.HandlerTip;
import com.android.core.control.StatusBarUtil;
import com.bumptech.glide.Glide;

import butterknife.Bind;
import me.racofix.open.R;
import me.racofix.open.view.BaseActivity;
import me.racofix.open.view.MainActivity;

/**
 * Author: 码农小阿新
 * Date: 2016/9/23
 * Github: https://github.com/racofix
 */
public class SplashActivity extends BaseActivity {
    @Bind(R.id.splash_image_view) ImageView mSplashView;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onInitView() {
        StatusBarUtil.setTranslucentBackground(this);
        sacleLargenView();
    }

    private void sacleLargenView() {
        Glide.with(this)
                .load(R.drawable.landing_background)
                .centerCrop()
                .animate(R.anim.sacle_largen_view)
                .into(mSplashView);

        HandlerTip.getInstance().postDelayed(
                2000, new HandlerTip.HandlerCallback() {
                    @Override
                    public void postDelayed() {
                        MainActivity.jumpTo(SplashActivity.this);
                    }
                });
    }
}
