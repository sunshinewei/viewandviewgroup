package com.example.viewandviewgroup.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/11/23.
 */
public class MP3View extends ViewGroup {
    private int mCount=10;
    private Paint mPaint;
    public MP3View(Context context) {
        super(context);
    }

    public MP3View(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.YELLOW);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    private int mWidth;
    private int mRectWidth;
    private int mRectHeight;
    private LinearGradient mLinearGradient;
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=getWidth();
        mRectHeight=getHeight();
        mRectWidth= (int) ((mWidth*0.6)/mCount);
        mLinearGradient=new LinearGradient(0,0,mRectWidth,mRectHeight,Color.YELLOW,Color.BLUE, Shader.TileMode.CLAMP);
        mPaint.setShader(mLinearGradient);
    }

    private int currentHeight= (int) (Math.random()*mRectHeight);
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i=0;i<mCount;i++){
            canvas.drawRect((float)(mWidth*0.4/2+mRectWidth*i+5),
                    currentHeight,
                    (float)(mWidth * 0.4 / 2 + mRectWidth * (i + 1)),
                    mRectHeight,mPaint);
            postInvalidateDelayed(300);
        }

    }
}
