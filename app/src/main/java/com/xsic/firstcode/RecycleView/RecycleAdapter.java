package com.xsic.firstcode.RecycleView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xsic.firstcode.Cat;
import com.xsic.firstcode.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private List<Cat> myCatList;
    /* 内部类 */
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView catImage;
        TextView catName;
        public ViewHolder(View view){
            super(view);
            catImage = (ImageView)view.findViewById(R.id.image);
            catName = (TextView)view.findViewById(R.id.text);
        }
    }

    public RecycleAdapter(List<Cat> myCatList) {
        this.myCatList = myCatList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cat cat = myCatList.get(position);
        holder.catImage.setImageResource(cat.getImageId());
        holder.catName.setText(cat.getName());
    }

    @Override
    public int getItemCount() {
        return myCatList.size();
    }
}
