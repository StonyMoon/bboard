package com.stonymoon.bboard.version;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.support.annotation.Nullable;

import com.stonymoon.bboard.R;
import com.stonymoon.bboard.util.ToastUtil;
import com.tencent.bugly.beta.Beta;

/**
 * Created by Stony on 2018/10/28.
 */

public class VersionFragment extends PreferenceFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);

    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if (preference.getKey() != null && preference.getKey().equals("prefs_update")) {
            Beta.checkUpgrade(true, true);
            ToastUtil.show(getActivity(), "检查更新中");
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }
}
