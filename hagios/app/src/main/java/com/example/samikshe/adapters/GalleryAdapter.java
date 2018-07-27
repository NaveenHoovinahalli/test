package com.example.samikshe.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.samikshe.R;
import com.example.samikshe.activity.GalleryActivity;

/**
 * Created by SCS on 1/22/2016.
 */
public class GalleryAdapter extends BaseAdapter {


    View view;
    Context context;
    ImageView imageView;

    public int[] images={R.drawable.ic_launcher1,R.drawable.ic_launcher1,R.drawable.ic_launcher1,
            R.drawable.ic_launcher1,R.drawable.ic_launcher1,R.drawable.ic_launcher1,R.drawable.ic_launcher1};

    public GalleryAdapter(GalleryActivity galleryActivity) {

        this.context=galleryActivity;

    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.galleryitem,null);
        imageView= (ImageView) convertView.findViewById(R.id.gallereyIv);

        imageView.setImageResource(images[position]);
        return convertView;
    }
}
