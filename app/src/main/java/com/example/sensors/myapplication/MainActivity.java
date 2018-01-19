package com.example.sensors.myapplication;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sManager = (SensorManager) this
                .getSystemService(this.SENSOR_SERVICE);
        List<Sensor> sList = sManager.getSensorList(Sensor.TYPE_ALL);

        List<String> sNames = new ArrayList();
        for (int i = 0; i < sList.size(); i++) {
            sNames.add(((Sensor) sList.get(i)).getName());
        }

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, sNames));

        getListView().setTextFilterEnabled(true);

    }
}
