package com.Lessons.lessonsapp;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class allSimActivity extends AppCompatActivity {

    int countClick = 2;

    Button[] arrayButton = new Button[48];
    int[] buttons = new int[]{R.id.button12,R.id.button13,R.id.button14,R.id.button15,R.id.button16,
                              R.id.button17,R.id.button18,R.id.button19,R.id.button20,R.id.button21,
                              R.id.button22,R.id.button23,R.id.button24,R.id.button25,R.id.button26,
                              R.id.button27,R.id.button28,R.id.button29,R.id.button30,R.id.button31,
                              R.id.button32,R.id.button33,R.id.button34,R.id.button35,R.id.button36,
                              R.id.button37,R.id.button38,R.id.button39,R.id.button40,R.id.button41,
                              R.id.button42,R.id.button43,R.id.button44,R.id.button45,R.id.button46,
                              R.id.button47,R.id.button48,R.id.button49,R.id.button50,R.id.button51,
                              R.id.button52,R.id.button53,R.id.button54,R.id.button55,R.id.button56,
                              R.id.button57,R.id.button58,R.id.button59};

    MainActivity main = new MainActivity();
    String[] arraySim;

    {
        this.arraySim = main.getArraySim();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_sim);
        for (int i = 12; i < 60; i++) {
           arrayButton[i-12] = (Button) findViewById(buttons[i-12]);
        }
        visualSim();
    }

    public void clickOnSim(View v){
        Button b = ((Button)v);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(countClick % 2 == 0) {
                    b.setBackgroundTintList(ColorStateList.valueOf((int) Color.parseColor("#fe6d2b")));
                } else {
                    b.setBackgroundTintList(ColorStateList.valueOf((int) Color.parseColor("#feb827")));
                }
                countClick++;
            }
        });
    }


    public void visualSim(){
        for (int i = 0; i < arraySim.length; i++) {
            arrayButton[i].setText(arraySim[i].toString());
        }
    }
}