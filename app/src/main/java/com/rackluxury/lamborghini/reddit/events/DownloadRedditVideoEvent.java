package com.rackluxury.lamborghini.reddit.events;

public class DownloadRedditVideoEvent {
    public boolean isSuccessful;

    public DownloadRedditVideoEvent(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }
}
