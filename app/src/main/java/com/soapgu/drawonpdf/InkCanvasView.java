package com.soapgu.drawonpdf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class InkCanvasView extends View {

    private Path path;
    private List<Path> paths;

    private Paint brush;

    public InkCanvasView(Context context) {
        super(context);
        setup();
    }

    public InkCanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public InkCanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    public InkCanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setup();
    }

    private void setup()
    {
        this.path = new Path();
        this.paths = new ArrayList<>();
        brush = new Paint();
        brush.setColor(Color.RED);
        brush.setAntiAlias(true);
        brush.setStrokeWidth(5f); // 设置笔触宽度
        brush.setStyle(Paint.Style.STROKE); // 设置绘制样式为描边
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path = new Path();
                paths.add(path);
                path.moveTo(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
        }

        // Redraw the canvas
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Path path : paths) {
            canvas.drawPath(path, brush);
        }
    }

    public void clear(){
        paths.clear();
        path = new Path();
    }
}
