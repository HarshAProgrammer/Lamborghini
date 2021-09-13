package com.rackluxury.lamborghini.reddit.events;

import com.rackluxury.lamborghini.reddit.post.Post;

public class PostUpdateEventToPostDetailFragment {
    public final Post post;

    public PostUpdateEventToPostDetailFragment(Post post) {
        this.post = post;
    }
}
