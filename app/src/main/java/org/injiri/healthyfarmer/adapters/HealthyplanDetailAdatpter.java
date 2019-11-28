package org.injiri.healthyfarmer.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HealthyplanDetailAdatpter extends RecyclerView.Adapter<HealthyplanDetailAdatpter.HealthyplanDetailHolder> {


    @NonNull
    @Override
    public HealthyplanDetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HealthyplanDetailHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8; // replace with actual videolist arraysize
    }

    public class HealthyplanDetailHolder extends RecyclerView.ViewHolder {
        public HealthyplanDetailHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
