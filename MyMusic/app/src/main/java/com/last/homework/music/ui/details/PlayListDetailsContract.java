package com.last.homework.music.ui.details;

import com.last.homework.music.data.model.PlayList;
import com.last.homework.music.data.model.Song;
import com.last.homework.music.ui.base.BasePresenter;
import com.last.homework.music.ui.base.BaseView;

public interface PlayListDetailsContract {

    interface View extends BaseView<Presenter> {

        void showLoading();

        void hideLoading();

        void handleError(Throwable e);

        void onSongDeleted(Song song);
    }

    interface Presenter extends BasePresenter {

        void addSongToPlayList(Song song, PlayList playList);

        void delete(Song song, PlayList playList);
    }
}
