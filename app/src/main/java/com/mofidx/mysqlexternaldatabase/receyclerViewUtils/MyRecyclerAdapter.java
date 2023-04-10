package com.mofidx.mysqlexternaldatabase.receyclerViewUtils;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mofidx.mysqlexternaldatabase.R;
import com.mofidx.mysqlexternaldatabase.nasheed;

import java.util.ArrayList;

public class MyRecyclerAdapter  extends RecyclerView.Adapter<MyHolder> {
    ArrayList<nasheed> nasheedArrayList;

    public MyRecyclerAdapter(ArrayList<nasheed> nasheedArrayList) {
        this.nasheedArrayList = nasheedArrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent , false);
        MyHolder viewholder = new MyHolder(v);
        return viewholder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        nasheed nasheed = nasheedArrayList.get(position);
        holder.desc.setText(nasheed.getDesc());
        holder.link.setText(nasheed.getLink());
    }

    @Override
    public int getItemCount() {
        return nasheedArrayList.size();
    }



}



