package com.Lessons.lessonsapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private TextView easySim, middleSim, hardSim;
    private Button easy, middle, hard, allSim;
    int intEasySim, intMiddleSim, intHardSim;
    String[] arraySim = new String[48];
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        easySim = findViewById(R.id.easySim);
        middleSim = findViewById(R.id.middleSim);
        hardSim = findViewById(R.id.hardSim);
        allSim = findViewById(R.id.allSim);
        easy = findViewById(R.id.easy);
        middle = findViewById(R.id.middle);
        hard = findViewById(R.id.hard);



    }

    public void setNumberSim(Button btn, EditText in) {
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
        arraySim[count] = String.valueOf(in.getText());
        count++;
    }

    public String[] getArraySim(){
        return this.arraySim;
    }

    public void nextActivity(View v) {
        Intent intent = new Intent(this,allSimActivity.class);
        startActivity(intent);
    }

    public void btnClick(View v) {
        numberSimAlert(((Button) v).getText().toString(), ((Button) v));
    }

    private void numberSimAlert(String text, Button btn) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(text)
                .setMessage("Какой номер сэмика?")
                .setCancelable(false);
        EditText input = new EditText(this);
        builder.setView(input);
        builder.setPositiveButton("этот", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                setNumberSim(btn, input);
            }
        });
        builder.setNegativeButton("НАЗАД", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}