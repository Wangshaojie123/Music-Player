package com.last.homework.music.event;

import com.last.homework.music.data.model.PlayList;

public class PlayListCreatedEvent {

    public PlayList playList;

    public PlayListCreatedEvent(PlayList playList) {
        this.playList = playList;
    }
}
