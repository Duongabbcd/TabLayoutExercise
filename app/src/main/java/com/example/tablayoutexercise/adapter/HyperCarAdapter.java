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
import com.example.tablayoutexercise.model.HyperCar;


import java.util.List;

public class HyperCarAdapter extends RecyclerView.Adapter<HyperCarAdapter.HyperCarViewHolder> {
    private List<HyperCar> hyperCar ;
    private Context context ;

    public HyperCarAdapter(List<HyperCar> hyperCar, Context context) {
        this.hyperCar = hyperCar;
        this.context = context;
    }

    public void HyperCar(){

    }

    public void setData(List<HyperCar> list) {
        this.hyperCar = list ;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public HyperCarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hypercar,parent,false) ;
        return new HyperCarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HyperCarViewHolder holder, int position) {
        holder.img.setImageResource(hyperCar.get(position).getImage());
        holder.pub.setText(hyperCar.get(position).getPublisher());
        holder.name.setText(hyperCar.get(position).getName());
        holder.price.setText(Integer.toString(hyperCar.get(position).getPrice()));
        holder.sub.setText(hyperCar.get(position).getSubscription());
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hyperCar.remove(position) ;
                notifyDataSetChanged();
            }
        }) ;
    }

    @Override
    public int getItemCount() {
        if(hyperCar != null) {
            return hyperCar.size();
        }
        return  0 ;
    }

    public class HyperCarViewHolder extends RecyclerView.ViewHolder {
        private ImageView img ;
        private TextView pub,name,price,sub ;
        private Button add ;

        public HyperCarViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.hp_img) ;
            pub=itemView.findViewById(R.id.hp_pub);
            name=itemView.findViewById(R.id.hp_name);
            price = itemView.findViewById(R.id.hp_price);
            sub=itemView.findViewById(R.id.hp_sub);
            add=itemView.findViewById(R.id.hp_btn);
        }
    }

}
