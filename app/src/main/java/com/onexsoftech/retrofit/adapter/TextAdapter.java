package com.onexsoftech.retrofit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.onexsoftech.retrofit.R;
import com.onexsoftech.retrofit.Worldpopulation;

import java.util.ArrayList;

/**
 * Created by SYSTEM5 on 11/29/2018.
 */

public class TextAdapter extends RecyclerView.Adapter {
    ArrayList<Worldpopulation> model2;
    public TextAdapter(Context mContext, Object o) {
        this.model2=(ArrayList<Worldpopulation>) o;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_recy_item,parent,false);
        return new MyViewHolder1(v1);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder1 vh1 = (MyViewHolder1) holder;

        vh1.title.setText(model2.get(position).getCountry());
        vh1.count.setText(model2.get(position).getPopulation());
    }


    @Override
    public int getItemCount() {
        return model2.size();
    }

    private class MyViewHolder1 extends RecyclerView.ViewHolder {
        TextView title,count;
        public MyViewHolder1(View v1) {
            super(v1);
            title=(TextView)itemView.findViewById(R.id.title);
            count=(TextView)itemView.findViewById(R.id.count);
        }
    }
}
