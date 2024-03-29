package com.rackluxury.lamborghini.reddit.account;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import com.rackluxury.lamborghini.reddit.RedditDataRoomDatabase;

public class AccountRepository {
    private final AccountDao mAccountDao;
    private final LiveData<List<Account>> mAccountsExceptCurrentAccountLiveData;
    private final LiveData<Account> mCurrentAccountLiveData;

    AccountRepository(RedditDataRoomDatabase redditDataRoomDatabase, String username) {
        mAccountDao = redditDataRoomDatabase.accountDao();
        mAccountsExceptCurrentAccountLiveData = mAccountDao.getAccountsExceptCurrentAccountLiveData();
        mCurrentAccountLiveData = mAccountDao.getCurrentAccountLiveData();
    }

    public LiveData<List<Account>> getAccountsExceptCurrentAccountLiveData() {
        return mAccountsExceptCurrentAccountLiveData;
    }

    public LiveData<Account> getCurrentAccountLiveData() {
        return mCurrentAccountLiveData;
    }

    public void insert(Account Account) {
        new InsertAsyncTask(mAccountDao).execute(Account);
    }

    private static class InsertAsyncTask extends AsyncTask<Account, Void, Void> {

        private final AccountDao mAsyncTaskDao;

        InsertAsyncTask(AccountDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Account... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
