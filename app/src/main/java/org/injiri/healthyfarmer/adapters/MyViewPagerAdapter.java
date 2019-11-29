package org.injiri.healthyfarmer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.injiri.healthyfarmer.R;

public class MyViewPagerAdapter extends PagerAdapter {
    private Context context;
    View layout;

    public MyViewPagerAdapter(Context context) {
        this.context = context;

    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup collection, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);

        if (position == 0) {
            layout = (View) inflater.inflate(R.layout.message_detailcard_item, collection, false);
        } else if (position == 2) {
            layout = (View) inflater.inflate(R.layout.message_detailcard_item, collection, false);
        } else if (position == 3) {
            layout = (View) inflater.inflate(R.layout.message_detailcard_item, collection, false);
        } else if (position == 4) {

        } else if (position == 5) {
            layout = (View) inflater.inflate(R.layout.message_detailcard_item, collection, false);
        }
        return layout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object view) {
        container.removeView((View) view);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;

    }

}
