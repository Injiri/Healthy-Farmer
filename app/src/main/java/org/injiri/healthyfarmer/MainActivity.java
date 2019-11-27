package org.injiri.healthyfarmer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import org.injiri.healthyfarmer.adapters.HealthPlanItemsAdapter;
import org.injiri.healthyfarmer.adapters.MessageCardAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView messageCardsRecyclerView, healthPlanRecyclerView;
    RecyclerView.Adapter messageCardsAdapter, healthPlansAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageCardsRecyclerView = findViewById(R.id.messages_recycler);
        healthPlanRecyclerView = findViewById(R.id.health_plans_recyclerView);

        messageCardsAdapter = new MessageCardAdapter();
        healthPlansAdapter = new HealthPlanItemsAdapter();

        messageCardsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        messageCardsRecyclerView.setAdapter(messageCardsAdapter);
        messageCardsAdapter.notifyDataSetChanged();

        healthPlanRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        healthPlanRecyclerView.setAdapter(healthPlansAdapter);
        healthPlansAdapter.notifyDataSetChanged();

    }
}
