package com.example.assingment2;

import android.media.Image;
import android.os.CountDownTimer;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import android.view.View;
import java.util.ListIterator;
import java.util.Random;

public class Blinker extends CountDownTimer {
    private ImageView[] myImageList;
    private boolean blinking = false;
    private int imagePointer = 0;

    public Blinker(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        ImageView myImage = myImageList[imagePointer];

        if(myImage.getTag() == "on"){
            myImage.setTag("off");
            myImage.setImageResource(R.drawable.ic_light_off);
            imagePointer++;
        } else {
            myImage.setTag("on");
            myImage.setImageResource(R.drawable.ic_light_on);
        }
        if (imagePointer >= myImageList.length){
            blinking = false;
            cancel();
        }
    }

    @Override
    public void onFinish() {
        blinking = false;
    }

    public void begin(ImageView[] imageList){
        myImageList = imageList;
        blinking = true;
        start();
    }

    public boolean isBlinking(){
        return blinking;
    }
}
