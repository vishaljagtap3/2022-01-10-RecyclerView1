package in.bitcode.recyclerview1;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.CityViewHolder> {

    private ArrayList<String> cities;

    public CitiesAdapter(ArrayList<String> cities) {
        this.cities = cities;
    }

    class CityViewHolder extends RecyclerView.ViewHolder {

        TextView txtCity;

        public CityViewHolder(View itemView) {
            super(itemView);

            txtCity = (TextView) itemView;
        }
    }


    @Override
    public int getItemCount() {
        log("getItemCount: " + cities.size());
        return cities.size();
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        log("onCreateViewHolder");

        Random random = new Random();


        TextView txtCity = new TextView(parent.getContext());
        txtCity.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                )
        );
        txtCity.setTextSize(25);
        txtCity.setPadding(20, 20, 20, 20);

        txtCity.setBackgroundColor(
                Color.rgb(
                        Math.abs(random.nextInt()) % 256,
                        Math.abs(random.nextInt()) % 256,
                        Math.abs(random.nextInt()) % 256
                )
        );
        return new CityViewHolder(txtCity);

    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {

        log("onBindViewHolder: " + position);

        holder.txtCity.setText(cities.get(position));
    }

    private void log(String text) {
        Log.e("tag", text);
    }
}
