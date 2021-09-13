package com.rackluxury.lamborghini.reddit.events;

import com.rackluxury.lamborghini.reddit.message.Message;

public class RepliedToPrivateMessageEvent {
    public Message newReply;
    public int messagePosition;

    public RepliedToPrivateMessageEvent(Message newReply, int messagePosition) {
        this.newReply = newReply;
        this.messagePosition = messagePosition;
    }
}
