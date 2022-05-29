package com.example.findyourdelight.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findyourdelight.R;
import com.example.findyourdelight.activities.DetailActivity;
import com.example.findyourdelight.db.DbHelper;
import com.example.findyourdelight.models.Result;

import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder>{

    private ArrayList<Result> listMenus = new ArrayList<>();
    private Activity activity;
    private DbHelper dbHelper;

    public FavoriteAdapter(Activity activity){
        this.activity = activity;
        dbHelper = new DbHelper(activity);
    }

    public ArrayList<Result> getListMovies() {
        return listMenus;
    }

    public void setListMenus(ArrayList<Result> listNotes) {
        if (listNotes.size() > 0){
            this.listMenus.clear();
        }
        this.listMenus.addAll(listNotes);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.ViewHolder holder, int position) {
        holder.tvMenuName.setText(listMenus.get(position).getMenuname());

        holder.tvMenuName.setOnClickListener(view -> {
            Intent intent = new Intent(holder.tvMenuName.getContext(), DetailActivity.class);
            intent.putExtra("id", listMenus.get(position).getId());
            intent.putExtra("title", listMenus.get(position).getMenuname());

            intent.putExtra("context", "favorites");
            holder.tvMenuName.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listMenus.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
//        private ImageView imgFood;
        private TextView tvMenuName;
//        private LinearLayout layoutView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            imgFood = itemView.findViewById(R.id.img_avatar);
            tvMenuName = itemView.findViewById(R.id.tvName);
//            layoutView = itemView.findViewById(R.id.layout_menu_item);
        }
    }
}
