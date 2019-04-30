package com.onexsoftech.retrofit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.onexsoftech.retrofit.R;

/**
 * Created by SYSTEM5 on 11/29/2018.
 */

class ViewHolder2 extends RecyclerView.ViewHolder {
    RecyclerView recyclerView;
    public ViewHolder2(View itemView) {
        super(itemView);
        recyclerView=(RecyclerView)itemView.findViewById(R.id.recycler_view_list);


    }
}
