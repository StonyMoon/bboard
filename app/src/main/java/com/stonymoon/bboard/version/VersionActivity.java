package com.stonymoon.bboard.version;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.stonymoon.bboard.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class VersionActivity extends AppCompatActivity {
    @BindView(R.id.base_toolbar)
    Toolbar mToolbar;
    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, VersionActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version);
        ButterKnife.bind(this);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_version_content, new VersionFragment())
                .commit();

        initToolbar();

    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            setTitle(getString(R.string.version_info));
        }

    }
}
