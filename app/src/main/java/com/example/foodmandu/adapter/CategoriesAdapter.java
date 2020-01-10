package com.example.foodmandu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodmandu.R;
import com.example.foodmandu.model.Contacts;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>{
Context mContext;
List<Contacts> catList;
public CategoriesAdapter(Context mContext,List<Contacts> catList){
    this.catList = catList;
    this.mContext = mContext;
}
    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat,parent,false);
       return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {

        Contacts contacts = catList.get(position);
        holder.tvCat.setText(contacts.getCatName());
        holder.imgProfile.setImageResource(contacts.getImageBtn());

    }

    @Override
    public int getItemCount() {
        return catList.size();
    }

    public class CategoriesViewHolder extends RecyclerView.ViewHolder{

        ImageView imgProfile;
        TextView tvCat;

        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);

           tvCat = itemView.findViewById(R.id.tvCat);
           imgProfile = itemView.findViewById(R.id.imageButton);
        }
    }
}
