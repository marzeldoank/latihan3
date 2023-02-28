package com.example.latihan3;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latihan3.databinding.ActivityUserDetailBinding;
import com.example.latihan3.databinding.ItemUserListBinding;

import java.util.List;

public class RecyclerAdapterUser extends RecyclerView.Adapter<RecyclerAdapterUser.ViewHolder> {

    private List<UserModel> localDataSet;
    private RecyclerAdapterUserListener listener;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ItemUserListBinding binding;



        public ViewHolder(ItemUserListBinding binding) {
            super(binding.getRoot());
            // Define click listener for the ViewHolder's View
            this.binding=binding;
        }
        private void bind(UserModel userModel){
            binding.setUseModel(userModel);
            binding.executePendingBindings();
        }

    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public RecyclerAdapterUser(List<UserModel> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item

        ItemUserListBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.item_user_list,
                viewGroup,false
        );
        return new ViewHolder(binding);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        final UserModel userModel = localDataSet.get(position);
        viewHolder.bind(userModel);
        viewHolder.binding.cvMain.setOnClickListener(view -> {
            listener.onUserSelected(userModel);

        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public void setListener(RecyclerAdapterUserListener listener) {
        this.listener = listener;
    }
}

