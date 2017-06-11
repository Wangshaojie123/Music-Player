package com.last.homework.music.ui.local.all;

import android.content.Context;
import android.support.v4.app.LoaderManager;

import com.last.homework.music.data.model.PlayList;
import com.last.homework.music.data.model.Song;
import com.last.homework.music.ui.base.BasePresenter;
import com.last.homework.music.ui.base.BaseView;

import java.util.List;


interface LocalMusicContract {

    interface View extends BaseView<Presenter> {

        LoaderManager getLoaderManager();

        Context getContext();

        void showProgress();

        void hideProgress();

        void emptyView(boolean visible);

        void handleError(Throwable error);

        void onLocalMusicLoaded(List<Song> songs);

        void showLoading();

        void hideLoading();

        void onSongDeleted(Song song);
    }

    interface Presenter extends BasePresenter {

        void loadLocalMusic();

        void addSongToPlayList(Song song, PlayList playList);

        void delete(Song song, PlayList playList);
    }
}
