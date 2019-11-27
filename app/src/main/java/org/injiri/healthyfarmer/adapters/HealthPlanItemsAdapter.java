package org.injiri.healthyfarmer.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.injiri.healthyfarmer.R;

public class HealthPlanItemsAdapter extends RecyclerView.Adapter<HealthPlanItemsAdapter.HealthPlanItemsHolder> {


    @NonNull
    @Override
    public HealthPlanItemsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.healthplans_card_item, parent, false);
        return new HealthPlanItemsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HealthPlanItemsHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5; // To do -- load the total number of plan items available for display
    }

    public class HealthPlanItemsHolder extends RecyclerView.ViewHolder {
        public HealthPlanItemsHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
