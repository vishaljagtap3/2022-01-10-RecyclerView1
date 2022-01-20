package in.bitcode.recyclerview1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerCities;
    private ArrayList<String> cities;
    private CitiesAdapter citiesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        recyclerCities = findViewById(R.id.recyclerCities);
        cities = new ArrayList<>();

        for(int i = 0; i <= 10; i++) {
            cities.add("Pune is nice city.. " + i);
            cities.add("Mumbai is good" + i);
            cities.add("Delhi is far" + i);
            cities.add("Hyd " + i);
            cities.add("Chennai " + i);
            cities.add("Nagpur " + i);
        }

        citiesAdapter = new CitiesAdapter(cities);
        recyclerCities.setAdapter(citiesAdapter);

        /*LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerCities.setLayoutManager(linearLayoutManager);*/

        /*GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerCities.setLayoutManager(gridLayoutManager);*/

        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerCities.setLayoutManager(staggeredGridLayoutManager);

    }
}