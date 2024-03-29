package com.rackluxury.lamborghini.reddit.asynctasks;

import android.os.Handler;

import java.util.concurrent.Executor;

import com.rackluxury.lamborghini.reddit.RedditDataRoomDatabase;
import com.rackluxury.lamborghini.reddit.customtheme.CustomTheme;

public class DeleteTheme {

    public static void deleteTheme(Executor executor, Handler handler,
                                   RedditDataRoomDatabase redditDataRoomDatabase, String themeName,
                                   DeleteThemeListener deleteThemeListener) {
        executor.execute(() -> {
            CustomTheme customTheme = redditDataRoomDatabase.customThemeDao().getCustomTheme(themeName);
            if (customTheme != null) {
                boolean isLightTheme = customTheme.isLightTheme;
                boolean isDarkTheme = customTheme.isDarkTheme;
                boolean isAmoledTheme = customTheme.isAmoledTheme;
                redditDataRoomDatabase.customThemeDao().deleteCustomTheme(themeName);
                handler.post(() -> deleteThemeListener.success(isLightTheme, isDarkTheme, isAmoledTheme));
            } else {
                handler.post(() -> deleteThemeListener.success(false, false, false));
            }
        });
    }

    public interface DeleteThemeListener {
        void success(boolean isLightTheme, boolean isDarkTheme, boolean isAmoledTheme);
    }
}
