package com.rackluxury.lamborghini.reddit.events;

public class ChangeOnlyDisablePreviewInVideoAndGifPostsEvent {
    public boolean onlyDisablePreviewInVideoAndGifPosts;

    public ChangeOnlyDisablePreviewInVideoAndGifPostsEvent(boolean onlyDisablePreviewInVideoAndGifPosts) {
        this.onlyDisablePreviewInVideoAndGifPosts = onlyDisablePreviewInVideoAndGifPosts;
    }
}
