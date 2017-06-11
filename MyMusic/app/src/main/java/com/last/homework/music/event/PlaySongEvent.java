package com.last.homework.music.event;

import com.last.homework.music.data.model.Song;

public class PlaySongEvent {

    public Song song;

    public PlaySongEvent(Song song) {
        this.song = song;
    }
}
