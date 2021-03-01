package com.example.se_ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Analytics extends AppCompatActivity {
    BottomNavigationView navigation;
    DatabaseReference  databaseReference;
    int cbb,cbsd,cgm,cmd,healthy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics);

        navigation = findViewById(R.id.bottomNavigationView_analytics);
        navigation.getMenu().findItem(R.id.bottomnav_analytics).setChecked(true);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getData();

        BarChart barChart = (BarChart) findViewById(R.id.barchart);

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(cbb, 0));
        entries.add(new BarEntry(cbsd, 1));
        entries.add(new BarEntry(cgm, 2));
        entries.add(new BarEntry(cmd, 3));
        entries.add(new BarEntry(healthy, 4));

        BarDataSet bardataset = new BarDataSet(entries, "Diseases");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("CBB");
        labels.add("CBSD");
        labels.add("CGM");
        labels.add("CMD");
        labels.add("Healthy");

        BarData data = new BarData(labels, bardataset);
        barChart.setData(data); // set the data and list of labels into chart
        barChart.setDescription("Set Bar Chart Description Here");  // set the description
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.animateY(2000);
    }

    private void getData() {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Analytics");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                cbb = Integer.parseInt(snapshot.child("0").getValue().toString());
                System.out.println(cbb);
                Log.v("cbb", String.valueOf(cbb));
                cbsd = Integer.parseInt(snapshot.child("0").getValue().toString());
                cgm = Integer.parseInt(snapshot.child("0").getValue().toString());
                cmd = Integer.parseInt(snapshot.child("0").getValue().toString());
                healthy = Integer.parseInt(snapshot.child("0").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.bottomnav_home:
                Intent intent = new Intent(Analytics.this , HomePage.class);
                finish();
                startActivity(intent);
                break;
            case R.id.bottomnav_profile:
                Intent intent1 = new Intent(Analytics.this , UserProfile.class);
                startActivity(intent1);
                break;
            case R.id.bottomnav_prevpred:
                Intent intent2 = new Intent(Analytics.this , Prev_pred.class);
                startActivity(intent2);
                break;
            case R.id.bottomnav_analytics:
                break;
        }
        return false;
    };
}