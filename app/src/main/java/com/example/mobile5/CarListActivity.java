package com.example.mobile5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CarListActivity extends AppCompatActivity {

    private ListView carListView;
    private ArrayAdapter<Car> carAdapter;
    private List<Car> cars;
    private List<Car> selectedCars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);

        carListView = findViewById(R.id.car_list_view);

        String category = getIntent().getStringExtra("category");
        cars = new ArrayList<>();

        if (category.equals("BMW")) {
            cars.add(new Car("BMW", "X5"));
            cars.add(new Car("BMW", "X6"));
            cars.add(new Car("BMW", "M3"));
            cars.add(new Car("BMW", "M5"));
            cars.add(new Car("BMW", "M1"));
            cars.add(new Car("BMW", "M8"));
        } else if (category.equals("Audi")) {
            cars.add(new Car("Audi", "A7"));
            cars.add(new Car("Audi", "TT"));
            cars.add(new Car("Audi", "S5"));
            cars.add(new Car("Audi", "RS7"));
            cars.add(new Car("Audi", "RS6"));
            cars.add(new Car("Audi", "R8"));
        } else if (category.equals("Mercedes")) {
            cars.add(new Car("Mercedes", "AMG S-Model"));
            cars.add(new Car("Mercedes", "600 SEL"));
            cars.add(new Car("Mercedes", "E 55 AMG"));
            cars.add(new Car("Mercedes", "CLS 63 AMG"));
            cars.add(new Car("Mercedes", "CLS 550"));
            cars.add(new Car("Mercedes", "Evolution II"));
        }

        selectedCars = new ArrayList<>();

        carAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_multiple_choice,
                cars);
        carListView.setAdapter(carAdapter);

        carListView.setOnItemClickListener((parent, view, position, id) -> {
            Car selectedCar = (Car) parent.getItemAtPosition(position);
            if (carListView.isItemChecked(position)) {
                selectedCars.add(selectedCar);
            } else {
                selectedCars.remove(selectedCar);
            }
        });

        Button addButton = findViewById(R.id.add_button);
        Button removeButton = findViewById(R.id.remove_button);
        EditText carBrandModelEditText = findViewById(R.id.car_brand_model);

        addButton.setOnClickListener(v -> {
            String input = carBrandModelEditText.getText().toString().trim();
            if (!input.isEmpty()) {
                String[] parts = input.split(" ");
                if (parts.length >= 2) {
                    Car newCar = new Car(parts[0], input.substring(parts[0].length() + 1));
                    cars.add(newCar);
                    carAdapter.notifyDataSetChanged();
                    carBrandModelEditText.setText("");
                }
            }
        });

        removeButton.setOnClickListener(v -> {
            for (int i = 0; i < selectedCars.size(); i++) {
                cars.remove(selectedCars.get(i));
            }
            selectedCars.clear();
            carAdapter.notifyDataSetChanged();
            carListView.clearChoices();
        });
    }
}
