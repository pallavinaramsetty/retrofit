package com.onexsoftech.retrofit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.onexsoftech.retrofit.R;
import com.onexsoftech.retrofit.Result;
import com.onexsoftech.retrofit.TextAdapter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by SYSTEM5 on 11/29/2018.
 */

public class AlbumAdapter extends RecyclerView.Adapter{

    Context mContext;
    List<Object> list_movie;
    TextAdapter adapter;
    public  static final int USER = 0, IMAGE = 1;
    public AlbumAdapter()
    {
        list_movie=new ArrayList<>();
    }
    public AlbumAdapter(Context mContext, List<Object> list_movie) {
        this.mContext=mContext;
        this.list_movie=list_movie;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder  onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder=null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case USER:
                View v1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
                viewHolder = new MyViewHolder(v1);
                break;
            case IMAGE:
                View v2 = inflater.inflate(R.layout.list_item_recyclerview, parent, false);
                viewHolder = new ViewHolder2(v2);
                break;

        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case USER:
                MyViewHolder vh1 = (MyViewHolder) holder;
                configureViewHolder1(vh1, position);
                break;
            case IMAGE:
                ViewHolder2 vh2 = (ViewHolder2) holder;
                configureViewHolder2(vh2, position);
                break;

        }
    }

    private void configureViewHolder2(ViewHolder2 vh2, int position) {
        adapter=new TextAdapter(mContext,list_movie.get(position));
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, true);
        vh2.recyclerView.setLayoutManager(mLayoutManager);
     //   DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(vh2.recyclerView.getContext(),mLayoutManager.get);
    //    vh2.recyclerView.addItemDecoration(new EqualSpacingItemDecoration(10),EqualSpacingItemDecoration.HORIZONTAL);
        vh2.recyclerView.setNestedScrollingEnabled(false);
        vh2.recyclerView.setAdapter(adapter);

    }


    public void configureViewHolder1(@NonNull MyViewHolder holder, int position) {
        Result res=(Result) list_movie.get(position);
        holder.title.setText(res.getTitle());
        holder.count.setText(res.getOriginalLanguage());
        Glide.with(mContext).load(res.getPosterPath()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return list_movie.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title,count;
        ImageView thumbnail;
        public MyViewHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.title);
            count=(TextView)itemView.findViewById(R.id.count);
            thumbnail=(ImageView) itemView.findViewById(R.id.thumbnail);

        }
    }
    @Override
    public  int getItemViewType(int position) {

            if (list_movie.get(position) instanceof Result) {
                return USER;
            } else if (list_movie.get(position) instanceof ArrayList) {
                return IMAGE;
            }


        return -1;
    }
}
