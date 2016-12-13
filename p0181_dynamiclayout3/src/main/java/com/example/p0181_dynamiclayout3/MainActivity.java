package com.example.p0181_dynamiclayout3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    SeekBar seekBar;
    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar)findViewById(R.id.seek_bar);
        button1 = (Button)findViewById(R.id.button_1);
        button2 = (Button)findViewById(R.id.button_2);
        button3 = (Button)findViewById(R.id.button_3);

        seekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams) button1.getLayoutParams(); // new LinearLayout.LayoutParams(this);
        layoutParams1.weight = i;

        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button2.getLayoutParams(); // new LinearLayout.LayoutParams(this);
        layoutParams2.weight = 100-i;

        button1.setLayoutParams(layoutParams1);
        button2.setLayoutParams(layoutParams2);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public void onClick(View view) {
        Random rand = new Random();
        int  n = rand.nextInt(100);
        button3.setText("number " + n);
        seekBar.setProgress(n);
    }
}
