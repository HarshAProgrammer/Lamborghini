package com.rackluxury.lamborghini.reddit.events;

public class ChangeSavePostFeedScrolledPositionEvent {
    public boolean savePostFeedScrolledPosition;

    public ChangeSavePostFeedScrolledPositionEvent(boolean savePostFeedScrolledPosition) {
        this.savePostFeedScrolledPosition = savePostFeedScrolledPosition;
    }
}
