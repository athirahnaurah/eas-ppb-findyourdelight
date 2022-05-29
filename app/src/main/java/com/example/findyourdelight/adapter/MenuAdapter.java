package com.example.findyourdelight.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.findyourdelight.R;
import com.example.findyourdelight.activities.DetailActivity;
import com.example.findyourdelight.models.ResultItem;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private List<ResultItem> menuItem;
    private Context context;


    public MenuAdapter(List<ResultItem> menuItem, Context context) {
        this.menuItem = menuItem;
        this.context = context;
    }

    public void setFilteredList(List<ResultItem> filteredList){
        this.menuItem = filteredList;
        notifyDataSetChanged();
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
        Glide.with(context).load(menuItem.get(position).getImages().get(1)).into(holder.imgFood);
        ResultItem currentMenu = menuItem.get(position);
        holder.layoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent item =new Intent(context, DetailActivity.class);
                item.putExtra("image1",currentMenu.getImages().get(0));
                item.putExtra("image2",currentMenu.getImages().get(1));
                item.putExtra("image3",currentMenu.getImages().get(2));
                item.putExtra("name",currentMenu.getMenuname());
                item.putExtra("desc",currentMenu.getDescription());
                item.putExtra("id",currentMenu.getId());
                context.startActivity(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuItem.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFood;
        private TextView tvMenuName;
        private LinearLayout layoutView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.img_avatar);
            tvMenuName = itemView.findViewById(R.id.tvName);
            layoutView = itemView.findViewById(R.id.layout_menu_item);
        }
    }
}
