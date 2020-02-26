package com.anioncode.databindingexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.anioncode.databindingexample.binding.Handlers;
import com.anioncode.databindingexample.binding.ImageDataAdapterView;
import com.anioncode.databindingexample.binding.MainViewModelView;
import com.anioncode.databindingexample.model.ImageModel;
import com.anioncode.databindingexample.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModelView mainViewModel;
    private ImageDataAdapterView adapterView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        ActivityMainBinding activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        // bind RecyclerView
        RecyclerView recyclerView = activityMainBinding.RecyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModelView.class);
        adapterView = new ImageDataAdapterView();
        recyclerView.setAdapter(adapterView);


        getAllImage();

    }
    private void getAllImage() {
        mainViewModel.getAllEmployee().observe(this, new Observer<List<ImageModel>>() {
            @Override
            public void onChanged(@Nullable List<ImageModel> imageModels) {
                adapterView.setEmployeeList((ArrayList<ImageModel>) imageModels);
            }
        });
    }
}
