package com.example.tablayoutexercise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.tablayoutexercise.R;
import com.example.tablayoutexercise.model.MotorCycle;

import java.util.List;

public class MotorCycleAdapter extends RecyclerView.Adapter<MotorCycleAdapter.MotorCylceViewHolder> {
    private List<MotorCycle> motorCycles ;
    private Context context ;

    public MotorCycleAdapter(List<MotorCycle> motorCycles, Context context) {
        this.motorCycles = motorCycles;
        this.context = context;
    }

    public void MotorCycle (){

    }

    public void setData(List<MotorCycle> list){
        this.motorCycles = list ;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MotorCylceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_motorcycle,parent,false);
        return new MotorCylceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MotorCylceViewHolder holder, int position) {
        holder.img.setImageResource(motorCycles.get(position).getImage());
        holder.pub.setText(motorCycles.get(position).getPublisher());
        holder.name.setText(motorCycles.get(position).getName());
        holder.price.setText(Integer.toString(motorCycles.get(position).getPrice()));
        holder.sub.setText(motorCycles.get(position).getSubscription());
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                motorCycles.remove(position) ;
                notifyDataSetChanged();
            }
        }) ;
    }

    @Override
    public int getItemCount() {
        if(motorCycles != null ){
            return motorCycles.size();
        }
        return 0;
    }

    public class MotorCylceViewHolder extends RecyclerView.ViewHolder{
        private ImageView img ;
        private TextView pub,name,price,sub ;
        private Button add ;
        public MotorCylceViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.mt_img) ;
            pub=itemView.findViewById(R.id.mt_pub);
            name=itemView.findViewById(R.id.mt_name);
            price = itemView.findViewById(R.id.mt_price);
            sub=itemView.findViewById(R.id.mt_sub);
            add=itemView.findViewById(R.id.mt_btn);
        }
    }
}
