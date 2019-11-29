package org.injiri.healthyfarmer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import org.injiri.healthyfarmer.adapters.HealthPlanItemsAdapter;
import org.injiri.healthyfarmer.adapters.MessageCardAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView messageCardsRecyclerView, healthPlanRecyclerView;
    RecyclerView.Adapter messageCardsAdapter, healthPlansAdapter;
    SliderView sliderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderView = findViewById(R.id.imageSlider);
        messageCardsRecyclerView = findViewById(R.id.messages_recycler);
        healthPlanRecyclerView = findViewById(R.id.health_plans_recyclerView);

//        messageCardsAdapter = new MessageCardAdapter();
        healthPlansAdapter = new HealthPlanItemsAdapter();


        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(messageCardsRecyclerView);
        messageCardsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        messageCardsRecyclerView.setAdapter(messageCardsAdapter);

//        messageCardsAdapter.notifyDataSetChanged();


        healthPlanRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        healthPlanRecyclerView.setAdapter(healthPlansAdapter);
        healthPlansAdapter.notifyDataSetChanged();


        MessageCardAdapter adapter = new MessageCardAdapter(this);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimations.SLIDE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.CUBEINROTATIONTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.startAutoCycle();
        sliderView.setScrollTimeInSec(5);

        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                sliderView.setCurrentPagePosition(position);
            }
        });

    }

    public void openLifestyleTipsActivity(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), HealthyLifestyleActivity.class));
    }
}
