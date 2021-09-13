package com.rackluxury.lamborghini.reddit.events;

public class ChangeTimeFormatEvent {
    public String timeFormat;

    public ChangeTimeFormatEvent(String timeFormat) {
        this.timeFormat = timeFormat;
    }
}
