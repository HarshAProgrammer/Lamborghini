package com.rackluxury.lamborghini.reddit.events;

import com.rackluxury.lamborghini.reddit.post.Post;

public class PostUpdateEventToPostList {
    public final Post post;
    public final int positionInList;

    public PostUpdateEventToPostList(Post post, int positionInList) {
        this.post = post;
        this.positionInList = positionInList;
    }
}
