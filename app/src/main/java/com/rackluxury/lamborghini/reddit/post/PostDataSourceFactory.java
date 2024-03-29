package com.rackluxury.lamborghini.reddit.post;

import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import java.util.List;
import java.util.concurrent.Executor;

import com.rackluxury.lamborghini.reddit.SortType;
import com.rackluxury.lamborghini.reddit.postfilter.PostFilter;
import com.rackluxury.lamborghini.reddit.readpost.ReadPost;
import retrofit2.Retrofit;

class PostDataSourceFactory extends DataSource.Factory {
    private final Executor executor;
    private final Handler handler;
    private final Retrofit retrofit;
    private final String accessToken;
    private final String accountName;
    private final SharedPreferences sharedPreferences;
    private final SharedPreferences postFeedScrolledPositionSharedPreferences;
    private String name;
    private String query;
    private String trendingSource;
    private final int postType;
    private SortType sortType;
    private PostFilter postFilter;
    private String userWhere;
    private final List<ReadPost> readPostList;

    private PostDataSource postDataSource;
    private final MutableLiveData<PostDataSource> postDataSourceLiveData;

    PostDataSourceFactory(Executor executor, Handler handler, Retrofit retrofit, String accessToken, String accountName,
                          SharedPreferences sharedPreferences,
                          SharedPreferences postFeedScrolledPositionSharedPreferences, int postType,
                          SortType sortType, PostFilter postFilter, List<ReadPost> readPostList) {
        this.executor = executor;
        this.handler = handler;
        this.retrofit = retrofit;
        this.accessToken = accessToken;
        this.accountName = accountName;
        this.sharedPreferences = sharedPreferences;
        this.postFeedScrolledPositionSharedPreferences = postFeedScrolledPositionSharedPreferences;
        postDataSourceLiveData = new MutableLiveData<>();
        this.postType = postType;
        this.sortType = sortType;
        this.postFilter = postFilter;
        this.readPostList = readPostList;
    }

    PostDataSourceFactory(Executor executor, Handler handler, Retrofit retrofit, String accessToken, String accountName,
                          SharedPreferences sharedPreferences, SharedPreferences postFeedScrolledPositionSharedPreferences,
                          String name, int postType, SortType sortType, PostFilter postFilter,
                          List<ReadPost> readPostList) {
        this.executor = executor;
        this.handler = handler;
        this.retrofit = retrofit;
        this.accessToken = accessToken;
        this.accountName = accountName;
        this.sharedPreferences = sharedPreferences;
        this.postFeedScrolledPositionSharedPreferences = postFeedScrolledPositionSharedPreferences;
        this.name = name;
        postDataSourceLiveData = new MutableLiveData<>();
        this.postType = postType;
        this.sortType = sortType;
        this.postFilter = postFilter;
        this.readPostList = readPostList;
    }

    PostDataSourceFactory(Executor executor, Handler handler, Retrofit retrofit, String accessToken, String accountName,
                          SharedPreferences sharedPreferences, SharedPreferences postFeedScrolledPositionSharedPreferences,
                          String name, int postType, SortType sortType, PostFilter postFilter,
                          String where, List<ReadPost> readPostList) {
        this.executor = executor;
        this.handler = handler;
        this.retrofit = retrofit;
        this.accessToken = accessToken;
        this.accountName = accountName;
        this.sharedPreferences = sharedPreferences;
        this.postFeedScrolledPositionSharedPreferences = postFeedScrolledPositionSharedPreferences;
        this.name = name;
        postDataSourceLiveData = new MutableLiveData<>();
        this.postType = postType;
        this.sortType = sortType;
        this.postFilter = postFilter;
        userWhere = where;
        this.readPostList = readPostList;
    }

    PostDataSourceFactory(Executor executor, Handler handler, Retrofit retrofit, String accessToken, String accountName,
                          SharedPreferences sharedPreferences, SharedPreferences postFeedScrolledPositionSharedPreferences,
                          String name, String query, String trendingSource, int postType, SortType sortType,
                          PostFilter postFilter, List<ReadPost> readPostList) {
        this.executor = executor;
        this.handler = handler;
        this.retrofit = retrofit;
        this.accessToken = accessToken;
        this.accountName = accountName;
        this.sharedPreferences = sharedPreferences;
        this.postFeedScrolledPositionSharedPreferences = postFeedScrolledPositionSharedPreferences;
        this.name = name;
        this.query = query;
        this.trendingSource = trendingSource;
        postDataSourceLiveData = new MutableLiveData<>();
        this.postType = postType;
        this.sortType = sortType;
        this.postFilter = postFilter;
        this.readPostList = readPostList;
    }

    @NonNull
    @Override
    public DataSource<String, Post> create() {
        if (postType == PostDataSource.TYPE_FRONT_PAGE) {
            postDataSource = new PostDataSource(executor, handler, retrofit, accessToken, accountName,
                    sharedPreferences, postFeedScrolledPositionSharedPreferences, postType, sortType,
                    postFilter, readPostList);
        } else if (postType == PostDataSource.TYPE_SEARCH) {
            postDataSource = new PostDataSource(executor, handler, retrofit, accessToken, accountName,
                    sharedPreferences, postFeedScrolledPositionSharedPreferences, name, query, trendingSource,
                    postType, sortType, postFilter, readPostList);
        } else if (postType == PostDataSource.TYPE_SUBREDDIT || postType == PostDataSource.TYPE_MULTI_REDDIT) {
            Log.i("asdasfd", "s5 " + (postFilter == null));
            postDataSource = new PostDataSource(executor, handler, retrofit, accessToken, accountName,
                    sharedPreferences, postFeedScrolledPositionSharedPreferences, name, postType,
                    sortType, postFilter, readPostList);
        } else if (postType == PostDataSource.TYPE_ANONYMOUS_FRONT_PAGE) {
            postDataSource = new PostDataSource(executor, handler, retrofit, null, null,
                    sharedPreferences, null, name, postType,
                    sortType, postFilter, null);
        } else {
            postDataSource = new PostDataSource(executor, handler, retrofit, accessToken, accountName,
                    sharedPreferences, postFeedScrolledPositionSharedPreferences, name, postType,
                    sortType, postFilter, userWhere, readPostList);
        }

        postDataSourceLiveData.postValue(postDataSource);
        return postDataSource;
    }

    public MutableLiveData<PostDataSource> getPostDataSourceLiveData() {
        return postDataSourceLiveData;
    }

    PostDataSource getPostDataSource() {
        return postDataSource;
    }

    void changeSortTypeAndPostFilter(SortType sortType, PostFilter postFilter) {
        Log.i("asdasfd", "s6 " + (postFilter == null));
        this.sortType = sortType;
        this.postFilter = postFilter;
    }
}
