package org.injiri.healthyfarmer.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.injiri.healthyfarmer.AgrovetshopActivity;
import org.injiri.healthyfarmer.HealthplanDetailActivity;
import org.injiri.healthyfarmer.MainActivity;
import org.injiri.healthyfarmer.MapsActivity;
import org.injiri.healthyfarmer.MessageCardDetailActivity;
import org.injiri.healthyfarmer.R;
import org.injiri.healthyfarmer.WellbeingActivity;

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

        if (position == 0) {

            holder.planIcon.setImageResource(R.drawable.organic_food48);
            holder.planDescription.setText("Understand more about your wellbeing");
            holder.planTitle.setText("Wellbeing");
            holder.planIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.getContext().startActivity(new Intent(view.getContext(), WellbeingActivity.class));
                }
            });


        } else if (position == 1) {
            holder.planIcon.setImageResource(R.drawable.harvesting_48);
            holder.planDescription.setText("Let us guid you on better working postures");
            holder.planTitle.setText("Working");
            holder.planIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.getContext().startActivity(new Intent(view.getContext(), HealthplanDetailActivity.class));
                }
            });

        } else if (position == 2) {

            holder.planIcon.setImageResource(R.drawable.weeding_backpain);
            holder.planDescription.setText("Checkout certified agri-products using your points");
            holder.planTitle.setText("Purchase");
            holder.planIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.getContext().startActivity(new Intent(view.getContext(), AgrovetshopActivity.class));
                }
            });
        } else if (position == 3) {

            holder.planIcon.setImageResource(R.drawable.carepoint_market_df);
            holder.planDescription.setText("Physiotherapy services near you");
            holder.planTitle.setText("Physio-locator");
            holder.planIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.getContext().startActivity(new Intent(view.getContext(), MainActivity.class));
                    //start carepoints activity to load map
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 4; // To do -- load the total number of plan items available for display
    }

    public class HealthPlanItemsHolder extends RecyclerView.ViewHolder {
        TextView planTitle, planDescription;
        ImageView planIcon;

        public HealthPlanItemsHolder(@NonNull View itemView) {

            super(itemView);
            planTitle = itemView.findViewById(R.id.plan_title);
            planDescription = itemView.findViewById(R.id.plan_description);
            ;
            planIcon = itemView.findViewById(R.id.plan_icon);
        }
    }
}
