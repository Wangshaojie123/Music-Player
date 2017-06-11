package com.last.homework.music.ui.music;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.last.homework.music.data.model.Song;
import com.last.homework.music.player.PlayMode;
import com.last.homework.music.player.PlaybackService;
import com.last.homework.music.ui.base.BasePresenter;
import com.last.homework.music.ui.base.BaseView;


/* package */ interface MusicPlayerContract {

    interface View extends BaseView<Presenter> {

        void handleError(Throwable error);

        void onPlaybackServiceBound(PlaybackService service);

        void onPlaybackServiceUnbound();

        void onSongSetAsFavorite(@NonNull Song song);

        void onSongUpdated(@Nullable Song song);

        void updatePlayMode(PlayMode playMode);

        void updatePlayToggle(boolean play);

        void updateFavoriteToggle(boolean favorite);
    }

    interface Presenter extends BasePresenter {

        void retrieveLastPlayMode();

        void setSongAsFavorite(Song song, boolean favorite);

        void bindPlaybackService();

        void unbindPlaybackService();
    }
}
