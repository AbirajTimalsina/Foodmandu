package com.example.foodmandu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodmandu.R;
import com.example.foodmandu.model.Spot;

import java.util.List;

public class SpotAdapter extends RecyclerView.Adapter<SpotAdapter.SpotViewHolder> {

    Context mContext;
    List<Spot> spotList;
    public SpotAdapter(Context mContext,List<Spot> spotList){
        this.mContext = mContext;
        this.spotList = spotList;
    }
    @NonNull
    @Override
    public SpotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.spot,parent,false);
        return new SpotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpotViewHolder holder, int position) {

        Spot spot = spotList.get(position);
        holder.image.setImageResource(spot.getImage());
    }

    @Override
    public int getItemCount() {
        return spotList.size();
    }

    public class SpotViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        public SpotViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.ImgSpot);
        }
    }

}
