package com.team_react.inhproject;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;
import com.team_react.inhproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MaterialButton explore = binding.explore;

        explore.setIcon(ContextCompat.getDrawable(this, R.drawable.explore));
        explore.setIconGravity(MaterialButton.ICON_GRAVITY_END);
        explore.setIconTint(ColorStateList.valueOf(Color.parseColor("#333A73")));

        explore.setOnClickListener(view -> {
            bgAnim(explore, 0x80FBA834, 0xFF333A73, 1000);
            iconAnim(explore, 0xFF333A73, 0xFFFBA834, 1000);
        });
    }


    public void bgAnim(MaterialButton button, int startColor, int endColor, int duration) {
        ValueAnimator colorAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), startColor, endColor);
        colorAnimator.setDuration(duration);
        colorAnimator.addUpdateListener(animator -> {
            button.setBackgroundColor((int) animator.getAnimatedValue());
        });
        colorAnimator.start();
    }

    public void iconAnim(MaterialButton button, int startColor, int endColor, int duration) {
        ValueAnimator colorAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), startColor, endColor);
        colorAnimator.setDuration(duration);
        colorAnimator.addUpdateListener(animator -> {
            button.setIconTint(ColorStateList.valueOf((int) animator.getAnimatedValue()));
            button.setIconTintMode(PorterDuff.Mode.SRC_IN);
            button.setTextColor((int) animator.getAnimatedValue());
        });
        colorAnimator.start();
    }
}