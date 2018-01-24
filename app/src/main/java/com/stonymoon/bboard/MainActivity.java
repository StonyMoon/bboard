package com.stonymoon.bboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stonymoon.bboard.itunes.ItunesActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @OnClick(R.id.btn_main_itunes)
    void openItunes() {
        ItunesActivity.startActivity(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
