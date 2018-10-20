package com.stonymoon.bboard.songdashboard.chart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.stonymoon.bboard.R;
import com.stonymoon.bboard.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Stony on 2018/10/19.
 */

public class SongChartFragment extends BaseFragment implements SongChartContract.View {
    @BindView(R.id.chart_rank)
    LineChart mChart;
    List<Entry> entries = new ArrayList<>();
    private SongChartContract.Presenter mPresenter;

    public static SongChartFragment getInstance() {
        return new SongChartFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_song_chart, container, false);
        mUnbinder = ButterKnife.bind(this, root);
        mChart.setNoDataText("");
        return root;
    }


    // 自定义表格样式并且展示出来
    @Override
    public void showChart(List<Integer> data) {
        int size = data.size();
        for (int i = 0; i < size; i++) {
            entries.add(new Entry(i + 1, (float) -data.get(i)));
        }
        LineDataSet dataSet = new LineDataSet(entries, getString(R.string.chart_name));
        dataSet.setHighLightColor(Color.TRANSPARENT);

        dataSet.setDrawCircleHole(false);
        dataSet.setValueTextSize(9f);
        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        dataSet.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                int iValue = (int) value;
                return String.valueOf(-iValue);
            }
        });


        LineData lineData = new LineData(dataSet);
        mChart.setScaleYEnabled(false);


        // 自定义X轴样式
        XAxis xAxis = mChart.getXAxis();
        xAxis.setAxisMinimum(1);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);

        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return String.valueOf((int) value);
            }
        });


        // 自定义Y轴样式
        YAxis leftYAxis = mChart.getAxisLeft();
        YAxis rightYAxis = mChart.getAxisRight();
        leftYAxis.setDrawGridLines(false);
        rightYAxis.setDrawGridLines(false);

        leftYAxis.setAxisMaximum(-1f);
        rightYAxis.setEnabled(false);
        leftYAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return String.valueOf((int) -value);
            }
        });
        mChart.setData(lineData);
        mChart.invalidate();

    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }


    @Override
    public void setPresenter(SongChartContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showError() {

    }

    @Override
    public void showProgressBar(boolean show) {

    }
}
