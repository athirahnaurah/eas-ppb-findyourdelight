package com.example.findyourdelight.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.findyourdelight.R;
import com.example.findyourdelight.models.ResultItem;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private List<ResultItem> menuItem;
    private Context context;

    public MenuAdapter(List<ResultItem> menuItem, Context context) {
        this.menuItem = menuItem;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvMenuName.setText(menuItem.get(position).getMenuname());
        Glide.with(context).load(menuItem.get(position).getImages()).into(holder.imgFood);
    }

    @Override
    public int getItemCount() {
        return menuItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFood;
        private TextView tvMenuName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.img_avatar);
            tvMenuName = itemView.findViewById(R.id.tvName);
        }
    }
}
