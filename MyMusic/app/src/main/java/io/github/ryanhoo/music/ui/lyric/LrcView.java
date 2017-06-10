package io.github.ryanhoo.music.ui.lyric;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatTextView;

import java.io.File;
import java.util.List;

import io.github.ryanhoo.music.data.model.Lyrc;
import io.github.ryanhoo.music.ui.music.MusicPlayerFragment;
import io.github.ryanhoo.music.utils.FileUtils;
import io.github.ryanhoo.music.utils.LyrcUtil;

/**
 * Created by lenovo on 2017/6/6.
 */

public class LrcView extends AppCompatTextView {
    private List<Lyrc> lyrcList;
    private int current = 0;
    // 行的间距
    private int lineSpacing = 65;

    // 当前正在绘制的行
    private Paint currentPaint;
    private int currentColor = Color.RED;
    private int currentSize = 58;
    private Typeface currentTypeface = Typeface.DEFAULT_BOLD;

    private Paint ortherPaint;
    private int ortherColor = Color.BLACK;
    private int ortherSize = 55;
    private Typeface ortherTypeface = Typeface.SERIF;

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            invalidate();  //重复onDraw()方法
        }
    };


    /**
     * @param context
     * @param attrs
     */
    public LrcView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init("");
    }

    public void init(String lycname){
        File file = new File(Environment.getExternalStorageDirectory().getPath()+ File.separator+ "Music" + File.separator+lycname + ".lrc");
        System.out.println(lycname);
        if(FileUtils.isLyric(file)) {
            handler.removeMessages(10);
            invalidate();
            current = 0;
            lyrcList = LyrcUtil.readLRC(file);
        }

        currentPaint = new Paint();

        currentPaint.setColor(currentColor);
        currentPaint.setTextSize(currentSize);
        currentPaint.setTextAlign(Paint.Align.CENTER);
        currentPaint.setTypeface(currentTypeface);

        ortherPaint = new Paint();

        ortherPaint.setColor(ortherColor);
        ortherPaint.setTextSize(ortherSize);
        ortherPaint.setTextAlign(Paint.Align.CENTER);
        ortherPaint.setTypeface(ortherTypeface);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        // getWidth();
        // getHeight();
        if(lyrcList != null) {
            if (current < lyrcList.size()) {
                if (lyrcList != null && lyrcList.size() > 0) {
                    Lyrc lyrc = null;
                    for (int i = current - 1; i >= 0; i--) {
                        lyrc = lyrcList.get(i);
                        canvas.drawText(lyrc.lrcString, getWidth() / 2, getHeight() / 2 + lineSpacing * (i - current), ortherPaint);
                    }
                    lyrc = lyrcList.get(current);
                    canvas.drawText(lyrc.lrcString, getWidth() / 2, getHeight() / 2, currentPaint);

                    for (int i = current + 1; i < lyrcList.size(); i++) {
                        lyrc = lyrcList.get(i);
                        canvas.drawText(lyrc.lrcString, getWidth() / 2, getHeight() / 2 + lineSpacing * (i - current), ortherPaint);
                    }
                    lyrc = lyrcList.get(current);

                    handler.sendEmptyMessageDelayed(10, lyrc.sleepTime);
                    current++;

                }
            }

        }
        else{
            canvas.drawText("未找到歌词", getWidth() / 2, getHeight() / 2, currentPaint);
        }
        super.onDraw(canvas);
    }

    public void pauseLrc(){
        handler.removeMessages(10);
        current--;
    }

    public void playLrc(){
        invalidate();
    }
}
