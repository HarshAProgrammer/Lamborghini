package com.rackluxury.ferrari.reddit.settings;

import android.os.Bundle;

import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;

import org.greenrobot.eventbus.EventBus;

import com.rackluxury.ferrari.reddit.events.ChangeDisableSwipingBetweenTabsEvent;
import com.rackluxury.ferrari.reddit.events.ChangeEnableSwipeActionSwitchEvent;
import com.rackluxury.ferrari.reddit.events.ChangeSwipeActionEvent;
import com.rackluxury.ferrari.reddit.events.ChangeSwipeActionThresholdEvent;
import com.rackluxury.ferrari.reddit.events.ChangeVibrateWhenActionTriggeredEvent;
import com.rackluxury.ferrari.R;
import com.rackluxury.ferrari.reddit.utils.SharedPreferencesUtils;

public class SwipeActionPreferenceFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.swipe_action_preferences, rootKey);

        SwitchPreference enableSwipeActionSwitch = findPreference(SharedPreferencesUtils.ENABLE_SWIPE_ACTION);
        ListPreference swipeLeftActionListPreference = findPreference(SharedPreferencesUtils.SWIPE_LEFT_ACTION);
        ListPreference swipeRightActionListPreference = findPreference(SharedPreferencesUtils.SWIPE_RIGHT_ACTION);
        SwitchPreference vibrateWhenActionTriggeredSwitch = findPreference(SharedPreferencesUtils.VIBRATE_WHEN_ACTION_TRIGGERED);
        SwitchPreference disableSwipingBetweenTabsSwitch = findPreference(SharedPreferencesUtils.DISABLE_SWIPING_BETWEEN_TABS);
        ListPreference swipeActionThresholdListPreference = findPreference(SharedPreferencesUtils.SWIPE_ACTION_THRESHOLD);

        if (enableSwipeActionSwitch != null) {
            enableSwipeActionSwitch.setOnPreferenceChangeListener((preference, newValue) -> {
                EventBus.getDefault().post(new ChangeEnableSwipeActionSwitchEvent((Boolean) newValue));
                return true;
            });
        }

        if (swipeLeftActionListPreference != null) {
            swipeLeftActionListPreference.setOnPreferenceChangeListener((preference, newValue) -> {
                if (swipeRightActionListPreference != null) {
                    EventBus.getDefault().post(new ChangeSwipeActionEvent(Integer.parseInt((String) newValue), Integer.parseInt(swipeRightActionListPreference.getValue())));
                } else {
                    EventBus.getDefault().post(new ChangeSwipeActionEvent(Integer.parseInt((String) newValue), -1));
                }
                return true;
            });
        }

        if (swipeRightActionListPreference != null) {
            swipeRightActionListPreference.setOnPreferenceChangeListener((preference, newValue) -> {
                if (swipeLeftActionListPreference != null) {
                    EventBus.getDefault().post(new ChangeSwipeActionEvent(Integer.parseInt(swipeLeftActionListPreference.getValue()), Integer.parseInt((String) newValue)));
                } else {
                    EventBus.getDefault().post(new ChangeSwipeActionEvent(-1, Integer.parseInt((String) newValue)));
                }
                return true;
            });
        }

        if (vibrateWhenActionTriggeredSwitch != null) {
            vibrateWhenActionTriggeredSwitch.setOnPreferenceChangeListener((preference, newValue) -> {
                EventBus.getDefault().post(new ChangeVibrateWhenActionTriggeredEvent((Boolean) newValue));
                return true;
            });
        }

        if (disableSwipingBetweenTabsSwitch != null) {
            disableSwipingBetweenTabsSwitch.setOnPreferenceChangeListener((preference, newValue) -> {
                EventBus.getDefault().post(new ChangeDisableSwipingBetweenTabsEvent((Boolean) newValue));
                return true;
            });
        }

        if (swipeActionThresholdListPreference != null) {
            swipeActionThresholdListPreference.setOnPreferenceChangeListener((preference, newValue) -> {
                EventBus.getDefault().post(new ChangeSwipeActionThresholdEvent(Float.parseFloat((String) newValue)));
                return true;
            });
        }
    }
}