package org.injiri.healthyfarmer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.injiri.healthyfarmer.R;
import org.injiri.healthyfarmer.WellbeingFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextScreenSlideAdapter extends FragmentStateAdapter {

    private Context context;

    private List<View> slideViews;


    public NextScreenSlideAdapter(FragmentActivity fa) {
        super(fa);
        this.context = fa ;
        slideViews = new ArrayList<>();

        //Create the views from layout files and pass to the list

        LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = vi.inflate(R.layout.activity_healthplan_detail, null);
        View view2= vi.inflate(R.layout.activity_healthplan_detail, null);
        View view3= vi.inflate(R.layout.activity_healthplan_detail, null);

        slideViews.addAll(Arrays.asList(view1,view2,view3));
    }

    @Override
    public Fragment createFragment(int position) {


        return new WellbeingFragment(slideViews.get(position));

    }

    @Override
    public int getItemCount() {
        return slideViews.size();
    }
}