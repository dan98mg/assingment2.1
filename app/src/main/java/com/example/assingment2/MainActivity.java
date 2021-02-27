package com.example.assingment2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int btnclk = 0;
    ImageView[] randomImages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView[] myList = {(ImageView) findViewById(R.id.imageView1),
                (ImageView) findViewById(R.id.imageView2),
                (ImageView) findViewById(R.id.imageView3),
                (ImageView) findViewById(R.id.imageView4)
        };

        Random rImage = new Random();
        Button myButton = (Button) findViewById(R.id.button);
        ImageView Image1 = myList[0];
        ImageView Image2 = myList[1];
        ImageView Image3 = myList[2];
        ImageView Image4 = myList[3];
        TextView textView1 = (TextView) findViewById(R.id.textView);
        Blinker myBlinker = new Blinker(11000, 1000);
        ArrayList<ImageView> list = new ArrayList<ImageView>();

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //disable button so they can't click until i let them
                textView1.setText("Game in Progress, Click on flashed images");
                list.clear();
                int numberOfFlashes = 1;

                if(!myBlinker.isBlinking()){
                //Make a random list of lights to turn on and off
                    int random = rImage.nextInt(4);
                    list.add(myList[random]);
                    randomImages = list.toArray(new ImageView[list.size()]);

                    myBlinker.begin(randomImages);
                }

            }
        });

        Image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkClick(Image1)){
                    if(btnclk == randomImages.length){
                        //user reached end of list
                        textView1.setText("Correct!");
                    }
                    //they clicked the right image but there is another image to do
                    btnclk++;
                }else {
                    textView1.setText("Sorry that was wrong");
                    btnclk = 0;
                    randomImages = new ImageView[0];
                }
            }
        });

        Image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkClick(Image2)){
                    if(btnclk == randomImages.length){
                        //user reached end of list
                        textView1.setText("Correct!");
                    }
                    //they clicked the right image but there is another image to do
                    btnclk++;
                }else {
                    textView1.setText("Sorry that was wrong");
                    btnclk = 0;
                    randomImages = new ImageView[0];
                }
            }
        });

        Image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkClick(Image3)){
                    if(btnclk == randomImages.length){
                        //user reached end of list
                        textView1.setText("Correct!");
                    }
                    //they clicked the right image but there is another image to do
                    btnclk++;
                }else {
                    textView1.setText("Sorry that was wrong");
                    btnclk = 0;
                    randomImages = new ImageView[0];
                }
            }
        });

        Image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkClick(Image4)){
                    if(btnclk == randomImages.length){
                        //user reached end of list
                        textView1.setText("Correct!");
                    }
                    //they clicked the right image but there is another image to do
                    btnclk++;
                }else {
                    textView1.setText("Sorry that was wrong");
                    btnclk = 0;
                    randomImages = new ImageView[0];
                }
            }
        });


    }
    public boolean checkClick(ImageView rImage){
        ImageView image = rImage;
        //If the image clicked is the correct image
        if(image == randomImages[btnclk]){
            //user clicked correct one
            return true;
        }
        return false;
    }
}