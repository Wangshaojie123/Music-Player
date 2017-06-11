package com.last.homework.music.ui.local.all;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.last.homework.music.R;
import com.last.homework.music.data.model.Song;
import com.last.homework.music.ui.base.adapter.IAdapterView;
import com.last.homework.music.utils.TimeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LocalMusicItemView extends RelativeLayout implements IAdapterView<Song> {

    @BindView(R.id.text_view_name)
    TextView textViewName;
    @BindView(R.id.text_view_artist)
    TextView textViewArtist;
    @BindView(R.id.text_view_duration)
    TextView textViewDuration;
    @BindView(R.id.layout_action)
    View buttonAction;

    public LocalMusicItemView(Context context) {
        super(context);
        View.inflate(context, R.layout.item_local_music, this);
        ButterKnife.bind(this);
    }

    @Override
    public void bind(Song song, int position) {
        textViewName.setText(song.getDisplayName());
        textViewArtist.setText(song.getArtist());

        textViewDuration.setText(TimeUtils.formatDuration(song.getDuration()));
    }
}
