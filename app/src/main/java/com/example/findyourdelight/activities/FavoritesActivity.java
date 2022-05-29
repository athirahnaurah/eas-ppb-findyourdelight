package com.example.findyourdelight.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.findyourdelight.MainActivity;
import com.example.findyourdelight.R;
import com.example.findyourdelight.adapter.FavoriteAdapter;
import com.example.findyourdelight.db.DbHelper;
import com.example.findyourdelight.models.Result;

import java.util.ArrayList;

public class FavoritesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FavoriteAdapter adapter;
    private ArrayList<Result> menuArrayList;

    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        dbHelper = new DbHelper(this);

        recyclerView = (RecyclerView) findViewById(R.id.rvFavorite);
        menuArrayList = dbHelper.getAllMenus();
        //adapter.setListMovies(movieArrayList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        //recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(FavoritesActivity.this, MainActivity.class);
        startActivity(i);
    }
}