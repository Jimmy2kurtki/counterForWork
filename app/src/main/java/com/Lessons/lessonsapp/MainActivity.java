package com.Lessons.lessonsapp;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    private TextView easySim, middleSim, hardSim;
    private Button easy, middle, hard, allSim;
    int intEasySim, intMiddleSim, intHardSim;
    public String[] arraySim = new String[50];
    int count = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        easySim = findViewById(R.id.easySim);
        middleSim = findViewById(R.id.middleSim);
        hardSim = findViewById(R.id.hardSim);
        allSim = findViewById(R.id.button_allSim);
        easy = findViewById(R.id.easy);
        middle = findViewById(R.id.middle);
        hard = findViewById(R.id.hard);
    }

    public void setCountSim(Button btn) {
        if (btn.equals(easy)) {
            intEasySim++;
            easySim.setText(String.valueOf(intEasySim));
        } else if (btn.equals(middle)) {
            intMiddleSim++;
            middleSim.setText(String.valueOf(intMiddleSim));
        } else {
            intHardSim++;
            hardSim.setText(String.valueOf(intHardSim));
        }
        allSim.setText(String.valueOf(intEasySim+intMiddleSim+intHardSim));
    }


    public void btnClick(View v) {
        customDialog(((Button)v).getText().toString(), ((Button)v));
    }

    private void customDialog(String text,Button btn){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("ВВЕДИ НОМЕР СЭМИКА")
                .setMessage(text)
                .setCancelable(false);
        EditText input = new EditText(this);
        builder.setView(input);
        String numberSim = input.getText().toString();
        if (numberSim.isEmpty()) numberSim = "+";
        String finalNumberSim = numberSim;
        builder.setPositiveButton("ГОТОВО", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        arraySim[count] = finalNumberSim;
                        count++;
                        setCountSim(btn);
                    }
                })
                .setNeutralButton("НАЗАД", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        builder.show();

    }
}