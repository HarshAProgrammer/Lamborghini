package com.rackluxury.lamborghini.reddit;

public interface SetAsWallpaperCallback {
    void setToHomeScreen(int viewPagerPosition);
    void setToLockScreen(int viewPagerPosition);
    void setToBoth(int viewPagerPosition);
}