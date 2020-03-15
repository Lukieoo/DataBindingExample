package com.anioncode.databindingexample.binding;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.anioncode.databindingexample.model.ImageModel;
import com.anioncode.databindingexample.R;
import com.anioncode.databindingexample.databinding.ItemImageBinding;

import java.util.ArrayList;

public class ImageDataAdapterView
        extends RecyclerView.Adapter<ImageDataAdapterView.ViewHolder> {

    private ArrayList<ImageModel> image;
//  private ListnerClick click;
//
//  interface ListnerClick{
//    void itemClick();
//  }
//  ImageDataAdapterView(ListnerClick click){
//    this.click=click;
//  }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemImageBinding employeeListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.item_image, viewGroup, false);
        return new ViewHolder(employeeListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder employeeViewHolder, int i) {
        ImageModel currentStudent = image.get(i);
        employeeViewHolder.binding.setImage(currentStudent);
        Handlers handlers = new Handlers() {
            @Override
            public void onClickPressed(View view, ImageModel imageModel) {

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(view.getContext());

                LayoutInflater inflater =  LayoutInflater.from(view.getContext());
                View dialogView = inflater.inflate(R.layout.item_dialog, null);
                dialogBuilder.setView(dialogView);
                ImageView photo=dialogView.findViewById(R.id.showImage);
                    Picasso.get().load(imageModel.getUrls().getRegular()).into(photo);
                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog.show();

            }
        };
        employeeViewHolder.binding.setHandlers(handlers);
    }

    @Override
    public int getItemCount() {
        if (image != null) {
            return image.size();
        } else {
            return 0;
        }
    }

    public void setEmployeeList(ArrayList<ImageModel> employees) {
        this.image = employees;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ItemImageBinding binding;

        public ViewHolder(@NonNull ItemImageBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
