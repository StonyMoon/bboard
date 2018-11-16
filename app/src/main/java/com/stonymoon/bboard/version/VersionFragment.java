package com.stonymoon.bboard.version;

import android.content.ClipboardManager;
import android.content.Context;
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
        if (preference.getKey() == null) {
            return false;
        }
        if (preference.getKey().equals("prefs_update")) {
            Beta.checkUpgrade(true, true);
            ToastUtil.show(getActivity(), "检查更新中");
        } else if (preference.getKey().equals("donation")) {
            ClipboardManager cm = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
            cm.setText("2365975967@qq.com");
            ToastUtil.show(getActivity(), "支付宝账号已复制到剪贴板");
        } else if (preference.getKey().equals("")) {


        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }
}
