package com.example.mobile5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView carCategoryListView;

    String[] carCategories = {"BMW", "Audi", "Mercedes", "BestAuto", "ScrollActivity", "SpinnerActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Находим представление списка
        carCategoryListView = findViewById(R.id.car_category_list);

        // Создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, carCategories);
        // Устанавливаем адаптер для списка
        carCategoryListView.setAdapter(adapter);

        // Создаем новый интент
        carCategoryListView.setOnItemClickListener((parent, view, position, id) -> {
            if (position < carCategories.length - 3) {
                Intent intent = new Intent(MainActivity.this, CarListActivity.class);
                intent.putExtra("category", carCategories[position]);
                startActivity(intent);
            } else if (position == carCategories.length - 2) {
                Intent intent = new Intent(MainActivity.this, ScrollActivity.class);
                startActivity(intent);
            } else if (position == carCategories.length - 1) {
                Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(MainActivity.this, BestAutoActivity.class);
                startActivity(intent);
            }
        });
    }
}
