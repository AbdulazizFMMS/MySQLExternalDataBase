package com.mofidx.mysqlexternaldatabase.receyclerViewUtils;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mofidx.mysqlexternaldatabase.R;


public class MyHolder extends RecyclerView.ViewHolder {
TextView desc, link;
ImageView img1;

    public MyHolder(@NonNull View itemView) {
        super(itemView);
        desc = itemView.findViewById(R.id.txtitem1);
        link = itemView.findViewById(R.id.txtitem2);
        img1 = itemView.findViewById(R.id.roundedImageView);

    }
}
