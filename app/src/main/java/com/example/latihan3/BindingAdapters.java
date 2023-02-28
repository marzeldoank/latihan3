package com.example.latihan3;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BindingAdapters {
    @BindingAdapter("app:ImageView")
    public static void setImageView (ImageView imageView, Integer resId) {
        if (resId != null) {
            imageView.setImageResource(resId);
        }
    }
    @BindingAdapter("app:userStatus")
    public static void setUserStatus (TextView textView, Boolean isActive) {
        if (isActive) {
            textView.setText("active");
            textView.setTextColor(ContextCompat.getColor(textView.getContext(),R.color.teal_200));
        }
        else {
            textView.setText(" non active");
            textView.setTextColor(ContextCompat.getColor(textView.getContext(),R.color.black));
        }
    }

    @BindingAdapter("app:setAdapter")
    public static void  setAdapter(RecyclerView recyclerView, BaseRecyclerAdapter adapter){
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
    }


}
