package com.onexsoftech.retrofit;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;

import com.onexsoftech.retrofit.adapter.AlbumAdapter;
import com.onexsoftech.retrofit.api.Api;
import com.onexsoftech.retrofit.api.Config;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    Call<Movie> movie;
    Movie list_movie;
    RecyclerView recyclerView;
    AlbumAdapter adapter;
    List<Object> obj;
    Call<Model2> model2call;
    Model2 model2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj=new ArrayList<>();
        recyclerView=(RecyclerView) findViewById(R.id.recycler_view);

        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(position==10)

                return (2);
                else
                    return 1;
            }
        });
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        Api api=Utils.callUrl().create(Api.class);
        movie=api.getMovieList(Config.API_KEY);
        movie.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if(response.isSuccessful()){
                    list_movie=response.body();


                }

            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });
        Api api1=Utils.callUrl1().create(Api.class);
        model2call=api1.getText();
        model2call.enqueue(new Callback<Model2>() {
            @Override
            public void onResponse(Call<Model2> call, Response<Model2> response) {
                if(response.isSuccessful()){
                    model2=response.body();
                    merge();
                }
            }

            @Override
            public void onFailure(Call<Model2> call, Throwable t) {

            }
        });

    }
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
    void merge()
    {
            if(list_movie.getResults().size()!=0)
            {
                for(int i=0;i<list_movie.getResults().size();i++){
                    obj.add(list_movie.getResults().get(i));
                }
                if(model2.getWorldpopulation().size()!=0)
                {
                    obj.add(10,model2.getWorldpopulation());
                }
                adapter=new AlbumAdapter(getApplicationContext(),obj);
                recyclerView.setAdapter(adapter);
            }


    }
}
