package com.hoanv.fragment_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFragment.ItemSelected {
    TextView tvDescription;
    String[] description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDescription = findViewById(R.id.tv_Description);
        description = getResources().getStringArray(R.array.descriptions);
        // the phone is in portrait mode
        if(findViewById(R.id.layout_portrait) != null){
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.list_fragment))
                    .hide(manager.findFragmentById(R.id.detail_fragment))
                    .commit();
        }
        // the phone is in landscape mode
        if(findViewById(R.id.layout_land)!= null){
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.list_fragment))
                    .show(manager.findFragmentById(R.id.detail_fragment))
                    .commit();
        }
    }

    @Override
    public void onItemSelected(int index) {
        tvDescription.setText(description[index]);
        if(findViewById(R.id.layout_portrait)!= null){
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.list_fragment))
                    .show(manager.findFragmentById(R.id.detail_fragment))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
