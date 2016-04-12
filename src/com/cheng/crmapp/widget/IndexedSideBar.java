package com.cheng.crmapp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class IndexedSideBar extends View {

    private OnTouchingLetterChangedListener onTouchingLetterChangedListener;
    public static String[] index = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
            "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
    private int choose = -1;
    private Paint paint = new Paint();

    private TextView mTextDialog;

    private Context mcontext = null;

    public void setTextView(TextView mTextDialog) {
        this.mTextDialog = mTextDialog;
    }

    public IndexedSideBar(Context context, AttributeSet attrs, int defStyle) {


        super(context, attrs, defStyle);
        this.mcontext = context;
    }

    public IndexedSideBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mcontext = context;
    }

    public IndexedSideBar(Context context) {
        super(context);
        this.mcontext = context;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int height = getHeight();
        int width = getWidth();
        int singleHeight = (height-20) / index.length;

        for (int i = 0; i < index.length; i++) {
        	paint.setColor(Color.parseColor("#9ed0a3"));
            paint.setTypeface(Typeface.DEFAULT);
            paint.setAntiAlias(true);
            paint.setTextSize(40);

            if (i == choose) {
                paint.setColor(Color.parseColor("#ffffff"));
                paint.setFakeBoldText(true);
            }

            float xPos = width / 2 - paint.measureText(index[i]) / 2;
            float yPos = singleHeight * i + singleHeight;
            canvas.drawText(index[i], xPos, yPos, paint);
            paint.reset();
        }

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {


        final int action = event.getAction();
        final float y = event.getY();
        final float x=event.getX();
        
        final int oldChoose = choose;
        final OnTouchingLetterChangedListener listener = onTouchingLetterChangedListener;
        final int c = (int) (y / getHeight() * index.length);
        

        switch (action) {
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                
                setBackgroundDrawable(new ColorDrawable(0x00000000));

                choose = -1;

                invalidate();

                if (mTextDialog != null) {
                    mTextDialog.setVisibility(View.INVISIBLE);
                }
                break;

            default:
                setBackgroundDrawable(new ColorDrawable(0x33000000));//20% 

                if (oldChoose != c) {
                    if (c >= 0 && c < index.length) {
                        if (listener != null) {
                            listener.onTouchingLetterChanged(index[c]);
                        }
                        if (mTextDialog != null) {
                            mTextDialog.setText(index[c]);
                            mTextDialog.setVisibility(View.VISIBLE);
                        }

                        choose = c;
                        invalidate();
                    }
                }

                break;
        }
        return true;
    }

    public void setOnTouchingLetterChangedListener(OnTouchingLetterChangedListener onTouchingLetterChangedListener) {
        this.onTouchingLetterChangedListener = onTouchingLetterChangedListener;
    }

    public interface OnTouchingLetterChangedListener {
        public void onTouchingLetterChanged(String s);
    }

}