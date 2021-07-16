package com.example.atgtask1_saurabhmulgaonkar.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.atgtask1_saurabhmulgaonkar.Adapter.ImageAdapter;
import com.example.atgtask1_saurabhmulgaonkar.Interface.ApiInterface;
import com.example.atgtask1_saurabhmulgaonkar.Pojo.Main;
import com.example.atgtask1_saurabhmulgaonkar.Pojo.Photo;
import com.example.atgtask1_saurabhmulgaonkar.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Home extends Fragment {

    String url="https://api.flickr.com/";
    List<Photo> photos=new ArrayList<Photo>();
    RecyclerView rec;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);

        rec=view.findViewById(R.id.rec);
        Retrofit retrofit=new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface=retrofit.create(ApiInterface.class);
        Call<Main> call=apiInterface.getImages();
        call.enqueue(new Callback<Main>() {
            @Override
            public void onResponse(Call<Main> call, Response<Main> response) {
                //Toast.makeText(MainActivity.this,"Response found",Toast.LENGTH_SHORT).show();
                photos=response.body().getPhotos().getPhoto();

                rec.setAdapter(new ImageAdapter(getActivity(),photos));
                rec.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

                Log.e("MainActivity","Response->"+response.body().getPhotos().getPhoto().get(14).getWidth());
            }

            @Override
            public void onFailure(Call<Main> call, Throwable t) {

                //Toast.makeText(MainActivity.this,"error found",Toast.LENGTH_SHORT).show();
                Log.e("MainActivity",""+t);
            }
        });



        return view;
    }
}