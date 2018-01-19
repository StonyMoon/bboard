package com.stonymoon.bboard.itunes;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.bean.ItunesBean;

import java.util.List;

import butterknife.BindView;

public class ItunesActivity extends AppCompatActivity implements ItunesContract.View{

    @BindView(R.id.recycler_itunes)
    RecyclerView recyclerItunes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itunes);

    }

    @Override
    public void setTitle(String title) {
        this.setTitle(title);
    }

    @Override
    public void showItunes(List<ItunesBean> list) {

    }
}
