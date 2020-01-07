package com.example.foodmandu.ui.More;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.foodmandu.R;
import com.example.foodmandu.SignupFragment;

public class MoreFragment extends Fragment implements View.OnClickListener {

     TextView tvReg;
    private SendViewModel sendViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sendViewModel =
                ViewModelProviders.of(this).get(SendViewModel.class);
        View root = inflater.inflate(R.layout.fragment_mybasket, container, false);
        tvReg = root.findViewById(R.id.tvReg);
        return root;
    }

    @Override
    public void onClick(View v) {
//        Intent intent = new Intent(MoreFragment.this, SignupFragment.class);
//        startActivity(intent);
    }
}

