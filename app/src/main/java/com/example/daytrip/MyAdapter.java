package com.example.daytrip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//import com.firebase.ui.firestore.FirestoreRecyclerAdapter;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<Costumer> costumerArrayList;

    public MyAdapter(Context context, ArrayList<Costumer> costumerArrayList) {
        this.context = context;
        this.costumerArrayList = costumerArrayList;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {Costumer costumer = costumerArrayList.get(position);
        holder.name.setText(costumer.getName());
        holder.sirname.setText(costumer.getSirname());
        holder.hotel.setText(costumer.getHotel());
        //holder.trip.setText(costumer.getTrip);
    }

    @Override
    public int getItemCount() {
        return costumerArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,sirname,hotel,trip;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.TextViewName);
            sirname = itemView.findViewById(R.id.TextViewSurname);
            hotel = itemView.findViewById(R.id.TextViewHotel);
            //trip = itemView.findViewById(R.id.)

        }
    }
}
