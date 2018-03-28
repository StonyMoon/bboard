package com.stonymoon.bboard.songdashboard;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

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
import com.stonymoon.bboard.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class SongDashboardFragment extends Fragment implements SongDashboardContract.View {
    @BindView(R.id.pb_song_dashboard)
    ProgressBar mProgressBar;
    @BindView(R.id.chart_rank)
    LineChart mChart;
    List<Entry> entries = new ArrayList<>();

    private SongDashboardContract.Presenter mPresenter;
    private Context mContext;
    private Unbinder mUnbinder;

    public SongDashboardFragment() {
    }

    public static SongDashboardFragment getInstance() {
        return new SongDashboardFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public void setPresenter(SongDashboardContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showChart(List<List<Double>> data) {
        int size = data.size();
        for (int i = 0; i < size; i++) {
            entries.add(new Entry(i + 1, (float) -data.get(i).get(2)));
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
    public void showError() {
        ToastUtil.show(mContext, getString(R.string.error_message));
    }

    @Override
    public void showProgressBar(boolean show) {
        mProgressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_song_dashboard, container, false);
        mUnbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
