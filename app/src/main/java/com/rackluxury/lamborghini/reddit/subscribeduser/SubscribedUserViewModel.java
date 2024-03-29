package com.rackluxury.lamborghini.reddit.subscribeduser;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import com.rackluxury.lamborghini.reddit.RedditDataRoomDatabase;

public class SubscribedUserViewModel extends AndroidViewModel {
    private final SubscribedUserRepository mSubscribedUserRepository;
    private final LiveData<List<SubscribedUserData>> mAllSubscribedUsers;
    private final LiveData<List<SubscribedUserData>> mAllFavoriteSubscribedUsers;

    public SubscribedUserViewModel(Application application, RedditDataRoomDatabase redditDataRoomDatabase, String accountName) {
        super(application);
        mSubscribedUserRepository = new SubscribedUserRepository(redditDataRoomDatabase, accountName);
        mAllSubscribedUsers = mSubscribedUserRepository.getAllSubscribedSubreddits();
        mAllFavoriteSubscribedUsers = mSubscribedUserRepository.getAllFavoriteSubscribedSubreddits();
    }

    public LiveData<List<SubscribedUserData>> getAllSubscribedUsers() {
        return mAllSubscribedUsers;
    }

    public LiveData<List<SubscribedUserData>> getAllFavoriteSubscribedUsers() {
        return mAllFavoriteSubscribedUsers;
    }

    public void insert(SubscribedUserData subscribedUserData) {
        mSubscribedUserRepository.insert(subscribedUserData);
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {
        private final Application mApplication;
        private final RedditDataRoomDatabase mRedditDataRoomDatabase;
        private final String mAccountName;

        public Factory(Application application, RedditDataRoomDatabase redditDataRoomDatabase, String accountName) {
            mApplication = application;
            mRedditDataRoomDatabase = redditDataRoomDatabase;
            mAccountName = accountName;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new SubscribedUserViewModel(mApplication, mRedditDataRoomDatabase, mAccountName);
        }
    }
}
