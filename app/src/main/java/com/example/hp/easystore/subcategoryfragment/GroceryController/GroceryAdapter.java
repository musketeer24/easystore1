package com.example.hp.easystore.subcategoryfragment.GroceryController;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.easystore.R;

import java.util.List;

/**
 * Created by hp on 24-Jun-17.
 */

public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.MyViewHolder> {

    private List<GroceryPojo> groceryPojoList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView groceryBusinessName, groceryContactNumber, grocerLocation, groceryDescription;

        public MyViewHolder(View view) {
            super(view);
            groceryBusinessName = (TextView) view.findViewById(R.id.tvGroceryBusinessName);
            groceryContactNumber = (TextView) view.findViewById(R.id.tvGroceryContactNumber);
            grocerLocation = (TextView) view.findViewById(R.id.tvGroceryLocation);
            groceryDescription = (TextView) view.findViewById(R.id.tvGroceryDescription);
        }
    }

    public GroceryAdapter(List<GroceryPojo> groceryPojoList) {
        this.groceryPojoList = groceryPojoList;
    }

    @Override
    public GroceryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View groceryItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_groceries_item, parent, false);
        return new MyViewHolder(groceryItemView);
    }

    @Override
    public void onBindViewHolder(GroceryAdapter.MyViewHolder holder, int position) {
        GroceryPojo groceryPojo = groceryPojoList.get(position);
        holder.groceryBusinessName.setText(groceryPojo.getGroceryBusinessName());
        holder.groceryContactNumber.setText(groceryPojo.getGroceryContactNumber());
        holder.grocerLocation.setText(groceryPojo.getGrocerLocation());
        holder.groceryDescription.setText(groceryPojo.getGroceryDescription());
    }

    @Override
    public int getItemCount() {
        return groceryPojoList.size();
    }
}
