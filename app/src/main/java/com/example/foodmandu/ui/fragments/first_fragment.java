package com.example.foodmandu.ui.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodmandu.R;
import com.example.foodmandu.adapter.advertiseAdapter;
import com.example.foodmandu.api.UsersAPI;
import com.example.foodmandu.model.first_advertise;
import com.example.foodmandu.url.Url;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class first_fragment extends Fragment {


    RecyclerView recyclerView;
List<first_advertise> advertiseModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first_fragment, container, false);

        recyclerView = view.findViewById(R.id.rec);

       List<first_advertise> advertiseList= new ArrayList<>();
       advertiseList.add(new first_advertise("Second",R.drawable.download,R.drawable.coke,"Mitho Mo:Mo",
               "Nepali,Tibten","NayaBazar"));
        advertiseList.add(new first_advertise("Third",R.drawable.pizza,R.drawable.burger,"FryDays",
                "SouthAsian","Gausahala"));
        advertiseList.add(new first_advertise("Second",R.drawable.pasta,R.drawable.coke,"Erma Resturants",
                "Nepali,Indian","Maharajgunj"));
        advertiseList.add(new first_advertise("Second",R.drawable.burger,R.drawable.pasta,"jomson resturant",
                "Nepali,Indian,Thai","Baudha"));


        advertiseAdapter advertiseAdapter= new advertiseAdapter(getContext(),advertiseList,"ABC");
        recyclerView.setAdapter(advertiseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        return view;
    }

}
