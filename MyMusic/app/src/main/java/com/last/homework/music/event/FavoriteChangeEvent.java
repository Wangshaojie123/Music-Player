package com.last.homework.music.event;

import com.last.homework.music.data.model.Song;

public class FavoriteChangeEvent {

    public Song song;

    public FavoriteChangeEvent(Song song) {
        this.song = song;
    }
}
