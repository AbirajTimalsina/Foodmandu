package com.example.foodmandu.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodmandu.MainActivity;
import com.example.foodmandu.R;
import com.example.foodmandu.adapter.CategoriesAdapter;
import com.example.foodmandu.adapter.SpotAdapter;
import com.example.foodmandu.model.Contacts;
import com.example.foodmandu.model.Spot;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    ImageView image;
    CarouselView carouselView;
    RecyclerView recyclerView,recyclerView2;


    int[] sampleImages = {R.drawable.coke,R.drawable.add1,R.drawable.real, R.drawable.add2, R.drawable.add3, R.drawable.add4};
    private HomeViewModel homeViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        recyclerView2 = root.findViewById(R.id.recyclerView2);
        carouselView = root.findViewById(R.id.cara1);
        recyclerView = root.findViewById(R.id.recycle1);

        List<Spot> spots = new ArrayList<>();
        spots.add(new Spot(R.drawable.pizza));
        spots.add(new Spot(R.drawable.pasta));
        spots.add(new Spot(R.drawable.burger));
        spots.add(new Spot(R.drawable.download));

        SpotAdapter spotAdapter = new SpotAdapter(getContext(),spots);
        recyclerView2.setAdapter(spotAdapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        List<Contacts> contacts = new ArrayList<>();
        contacts.add(new Contacts("Resturants",R.drawable.ic_restaurant_black_24dp));
        contacts.add(new Contacts("Liquors",R.drawable.ic_local_bar_black_24dp));
        contacts.add(new Contacts("Backaries",R.drawable.ic_cake_black_24dp));
        contacts.add(new Contacts("Refreshment",R.drawable.ic_local_cafe_black_24dp));
        contacts.add(new Contacts("Organic",R.drawable.ic_filter_vintage_black_24dp));

        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(getContext(),contacts);
        recyclerView.setAdapter(categoriesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(sampleImages[position]);
            }
        });

        return root;
    }
}