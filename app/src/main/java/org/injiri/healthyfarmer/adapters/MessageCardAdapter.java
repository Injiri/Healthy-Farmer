package org.injiri.healthyfarmer.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.injiri.healthyfarmer.MessageCardDetailActivity;
import org.injiri.healthyfarmer.R;

public class MessageCardAdapter extends RecyclerView.Adapter<MessageCardAdapter.MessageCardHolder> {


    @NonNull
    @Override
    public MessageCardAdapter.MessageCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.messages_card_item, parent, false);

        return new MessageCardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageCardAdapter.MessageCardHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;// Replace with the total number of message items available
    }

    public class MessageCardHolder extends RecyclerView.ViewHolder {
        public MessageCardHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View t) {
                    new Intent(t.getContext(), MessageCardDetailActivity.class);
                    t.getContext().startActivity(new Intent(t.getContext(), MessageCardDetailActivity.class));
                }
            });
        }
    }
}
