package com.team_react.inhproject;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CheckIMG extends androidx.appcompat.widget.AppCompatImageView {

    float cx, cy;
    private Paint circlePaint;

    public CheckIMG(@NonNull Context context) {
        super(context);
        init();
    }

    public CheckIMG(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CheckIMG(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        // Initialize the Paint object
        int padding = 16;
        setPadding(padding, padding, padding, padding);
        circlePaint = new Paint();
        circlePaint.setColor(Color.BLUE); // Set the color of the circle
        circlePaint.setStyle(Paint.Style.STROKE); // Set the style to stroke (outline)
        circlePaint.setStrokeWidth(10); // Set the stroke width
        circlePaint.setAntiAlias(true); // Enable anti-aliasing for smooth edges
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        cx = (float) getWidth() / 2;
        cy = (float) getHeight() / 2;

        // Set the radius (you can adjust this)
        float radius = Math.min(cx, cy) - 4; // Subtract 20 to keep the circle inside the view

        // Draw the circle
        canvas.drawCircle(cx, cy, radius, circlePaint);
    }

    public void setUp(int stockWidth, int color) {
        circlePaint.setStrokeWidth(stockWidth);
        circlePaint.setColor(color);
        setImageTintList(ColorStateList.valueOf(color));
    }
}
