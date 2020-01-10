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
import com.example.foodmandu.model.first_advertise;
import com.example.foodmandu.url.Url;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.List;

public class advertiseAdapter extends RecyclerView.Adapter<advertiseAdapter.AdvertiseViewHolder>{
    private Context mcontext;
    private List<first_advertise> first_advertise;

    private String advertiseposition;


    public advertiseAdapter(Context mcontext, List<first_advertise> first_advertise, String advertiseposition) {
        this.mcontext = mcontext;
        this.first_advertise = first_advertise;

        this.advertiseposition = advertiseposition;
    }

    @NonNull
    @Override
    public AdvertiseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.for_fragment_first, parent, false);

        return new AdvertiseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdvertiseViewHolder holder, int position) {

        final first_advertise First_Advertise = first_advertise.get(position);

//
//            String firstimagePath = Url.imagePath + First_Advertise.getFirstimage();
//            String secondimagePath = Url.imagePath + First_Advertise.getSecondimage();

            // Log.e("Image path is:" ,"iamge is" +firstimagePath);
            holder.firstimage.setImageResource(First_Advertise.getFirstimage());
        holder.secondimage.setImageResource(First_Advertise.getSecondimage());
            holder.title.setText(First_Advertise.getTitle());
            holder.country.setText(First_Advertise.getCountry());
            holder.location.setText(First_Advertise.getLocation());


    }

    @Override
    public int getItemCount() {

        return first_advertise.size();
    }

    public class AdvertiseViewHolder extends RecyclerView.ViewHolder {


        //second ADs
        ImageView firstimage, secondimage;
        TextView title, country, location;


        public AdvertiseViewHolder(@NonNull View itemView) {
            super(itemView);
            //2nd
            firstimage = itemView.findViewById(R.id.img01);
            secondimage = itemView.findViewById(R.id.img02);
            title = itemView.findViewById(R.id.tvTitle);
            country = itemView.findViewById(R.id.tvCountry);
            location = itemView.findViewById(R.id.tvLocation);

        }

    }

}
