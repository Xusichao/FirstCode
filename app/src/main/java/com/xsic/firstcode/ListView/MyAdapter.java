package com.xsic.firstcode.ListView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xsic.firstcode.Cat;
import com.xsic.firstcode.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter extends ArrayAdapter {
    private int resourceId;
    public MyAdapter(Context context, int resource, List<Cat> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        Cat cat = (Cat) getItem(position);
        ViewHolder viewHolder;
        /**
         * 当有缓存时，则不需要重新加载布局
         * viewHolder用于保存所有控件的实例，不再需要重新调用findbyViewid
         */
        if(convertView==null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_view_item,parent,false);     //获取xml布局
            viewHolder = new ViewHolder();
            viewHolder.catImage = (ImageView)view.findViewById(R.id.image);
            viewHolder.catName = (TextView)view.findViewById(R.id.text);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.catImage = (ImageView) view.findViewById(R.id.image);
        viewHolder.catName = (TextView)view.findViewById(R.id.text);
        viewHolder.catImage.setImageResource(cat.getImageId());
        viewHolder.catName.setText(cat.getName());

        return view;
    }

    class ViewHolder{
        ImageView catImage;
        TextView catName;
    }

}
