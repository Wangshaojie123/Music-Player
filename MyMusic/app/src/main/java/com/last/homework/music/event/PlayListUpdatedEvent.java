package com.last.homework.music.event;

import com.last.homework.music.data.model.PlayList;

public class PlayListUpdatedEvent {

    PlayList playList;

    public PlayListUpdatedEvent(PlayList playList) {
        this.playList = playList;
    }
}
