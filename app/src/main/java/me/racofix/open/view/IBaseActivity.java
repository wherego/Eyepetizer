package me.racofix.open.view;

import android.content.Context;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by world on 2016-09-22.
 */
public abstract class IBaseActivity extends com.android.core.base.BaseActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
