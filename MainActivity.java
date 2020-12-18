package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.content.ClipData;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private int[] dicesID = { R.id.dice1,R.id.dice2,R.id.dice3};
    private int mMenu;
    private MenuItem stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         Dice[] d = initialFace(dicesID);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.appbar_menu, menu);

        stopButton = menu.findItem(R.id.action_stop);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Dice[] d = initialFace(dicesID);

        switch (item.getItemId()) {
            case R.id.action_roll:
                stopButton.setVisible(true);
                rollDice(d);

                return true;
            case R.id.action_stop:
                stopButton.setVisible(false);
                return true;
            case R.id.action_one:
                makeDiceVisible(1,dicesID);
                return true;
            case R.id.action_two:
                makeDiceVisible(2,dicesID);
                return true;
            case R.id.action_three:
                makeDiceVisible(3,dicesID);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


    private void makeDiceVisible (int numVisible, int[] dicesID) {
        //make dice visible
        for (int i = 0; i<numVisible;i++) {
            ImageView diceOne = (ImageView) findViewById(dicesID[i]);
            diceOne.setVisibility(View.VISIBLE);
        }
        for (int j = numVisible;j<3;j++) {
            ImageView diceOne = (ImageView) findViewById(dicesID[j]);
            diceOne.setVisibility(View.GONE);
        }

    }
    //gives each imageview dice and initail face between 1-6
    private Dice[] initialFace(int[] arr) {
        Dice[] dices = new Dice[3];

        for(int i =0;i<arr.length;i++) {
            ImageView dice = (ImageView) findViewById(arr[i]);
            Dice d = new Dice(dice);
            dices[i] = d;
        }

        return dices;
    }

    private void rollDice (final Dice[] dieByID) {
        new CountDownTimer(10000, 50) {


            public void onTick(long millisUntilFinished) {


                for (int i = 0; i<dieByID.length;i++) {
                    dieByID[i].setNumber();
                }
                if (stopButton.isVisible() == false) {
                    cancel();
                }
            }

            public void onFinish() {
                stopButton.setVisible(false);
            }


        }.start();



    }


}

