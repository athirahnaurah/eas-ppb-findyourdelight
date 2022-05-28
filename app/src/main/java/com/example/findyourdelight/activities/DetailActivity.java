package com.example.findyourdelight.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.findyourdelight.R;
import com.example.findyourdelight.adapter.MenuAdapter;
import com.example.findyourdelight.models.ResultItem;

public class DetailActivity extends AppCompatActivity {
    MenuAdapter menuAdapter;
    String vName, vDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        TextView tvName = findViewById(R.id.tvDetailName);
        TextView tvDesc = findViewById(R.id.tvDescription);
        ImageView imgFood = findViewById(R.id.imgDetail);

        Intent item = getIntent();
        item.getStringExtra("image");
        vName = item.getStringExtra("name");
        vDesc = item.getStringExtra("desc");

        tvName.setText(vName);
        tvDesc.setText(vDesc);
    }

}
