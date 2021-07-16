package com.example.atgtask1_saurabhmulgaonkar.Adapter;

import android.content.Context;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.atgtask1_saurabhmulgaonkar.Pojo.Photo;
import com.example.atgtask1_saurabhmulgaonkar.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    Context context;
    List<Photo> photos;
    public ImageAdapter(Context ctx, List<Photo> pht)
    {
        context=ctx;
        photos=pht;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_image,parent,false);


        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        //String img=photos.get(position).getUrlS();
        String img="https://live.staticflickr.com/"+photos.get(position).getServer()+"/"+photos.get(position).getId()+"_"+photos.get(position).getSecret()+"_m.jpg";
        //Toast.makeText(context,photos.get(position).getHeightS()+"",Toast.LENGTH_SHORT).show();
        Glide.with(context)
                .load(img)
                .into(holder.imgSingle);

        //holder.imgSingle.setMinimumWidth(150);
        //Picasso.get().load(img).into(holder.imgSingle);
       // holder.txt.setText(photos.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageView imgSingle;
        TextView txt;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSingle=itemView.findViewById(R.id.imgSingle);
            //txt=itemView.findViewById(R.id.txt);
        }
    }
}
