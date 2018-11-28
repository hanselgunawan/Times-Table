package com.hanseltritama.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Integer> generateData(ArrayList<Integer> numList, int progress) {
        for(int i = 1; i <= 10; i++) {
            numList.add(progress * i);
        }
        return numList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int minSeekBarValue = 1;
        final ListView timesTableList = findViewById(R.id.timesTableList);
        SeekBar seekBar = findViewById(R.id.seekBar);

        seekBar.setMax(20);
        seekBar.setProgress(1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                if(progress < minSeekBarValue) {
                    seekBar.setProgress(minSeekBarValue);
                    progress = 1;
                }
                ArrayList<Integer> numList = new ArrayList<>();
                numList = generateData(numList, progress);
                ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_list_item_1, numList);
                timesTableList.setAdapter(arrayAdapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
