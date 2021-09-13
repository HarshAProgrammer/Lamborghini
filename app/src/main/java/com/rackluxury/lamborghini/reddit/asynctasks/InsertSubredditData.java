package com.rackluxury.lamborghini.reddit.asynctasks;

import android.os.Handler;

import java.util.concurrent.Executor;

import com.rackluxury.lamborghini.reddit.RedditDataRoomDatabase;
import com.rackluxury.lamborghini.reddit.subreddit.SubredditData;

public class InsertSubredditData {

    public static void insertSubredditData(Executor executor, Handler handler, RedditDataRoomDatabase db,
                                           SubredditData subredditData,
                                           InsertSubredditDataAsyncTaskListener insertSubredditDataAsyncTaskListener) {
        executor.execute(() -> {
            db.subredditDao().insert(subredditData);
            handler.post(insertSubredditDataAsyncTaskListener::insertSuccess);
        });
    }

    public interface InsertSubredditDataAsyncTaskListener {
        void insertSuccess();
    }
}
