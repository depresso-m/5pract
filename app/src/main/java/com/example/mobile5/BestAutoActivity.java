package com.example.mobile5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BestAutoActivity extends AppCompatActivity {

    private RecyclerView bestAutoRecyclerView;
    private BestAutoAdapter bestAutoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_auto);

        bestAutoRecyclerView = findViewById(R.id.best_auto_recycler_view);
        bestAutoRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        bestAutoAdapter = new BestAutoAdapter(generateBestAutoList());
        bestAutoRecyclerView.setAdapter(bestAutoAdapter);
    }

    private List<BestAuto> generateBestAutoList() {
        List<BestAuto> bestAutoList = new ArrayList<>();
        bestAutoList.add(new BestAuto(R.drawable.bmw_m5,"BMW M5"));
        bestAutoList.add(new BestAuto(R.drawable.audi_rs7, "Audi RS7"));
        bestAutoList.add(new BestAuto(R.drawable.mercedes_amg_gt,"Mercedes-AMG GT"));

        return bestAutoList;
    }
}
