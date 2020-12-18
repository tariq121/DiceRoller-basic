package com.example.diceroller;

import android.widget.ImageView;

import java.util.Random;

public class Dice {
    private ImageView mView;

    int[] number = {R.drawable.dice_1,R.drawable.dice_2,R.drawable.dice_3,R.drawable.dice_4,R.drawable.dice_5,R.drawable.dice_6};

    //constructor
    public Dice(ImageView mView) {
        this.mView = mView;
        setNumber();


    }

    public void setNumber() {
        Random rand = new Random();
        int index = rand.nextInt(6);
        this.mView.setImageResource(number[index]);

    }

}
