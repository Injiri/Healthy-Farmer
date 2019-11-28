package org.injiri.healthyfarmer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.injiri.healthyfarmer.adapters.MessageDetailAdapter;

public class MessageCardDetailActivity extends AppCompatActivity {

    RecyclerView videoThumbnailsRecyclerView;
    RecyclerView.Adapter thumbnailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_card_detail);

        videoThumbnailsRecyclerView = findViewById(R.id.msgdetail_thumbnail_recyclerview);

        thumbnailsAdapter = new MessageDetailAdapter();
        videoThumbnailsRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
//        videoThumbnailsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        videoThumbnailsRecyclerView.setAdapter(thumbnailsAdapter);
        thumbnailsAdapter.notifyDataSetChanged();


    }
}
