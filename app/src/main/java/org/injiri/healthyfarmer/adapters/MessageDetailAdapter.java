package org.injiri.healthyfarmer.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.injiri.healthyfarmer.R;

public class MessageDetailAdapter extends RecyclerView.Adapter<MessageDetailAdapter.DetailCardHolder> {

    @NonNull
    @Override
    public DetailCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.message_detailcard_item, parent, false);
        return new DetailCardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailCardHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;// replace with an arraySize of the video list
    }

    public class DetailCardHolder extends RecyclerView.ViewHolder {
        public DetailCardHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
