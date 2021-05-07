package com.example.tablayoutexercise.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tablayoutexercise.R;
import com.example.tablayoutexercise.model.SuperCar;

import java.util.List;

public class SuperCarAdapter extends RecyclerView.Adapter<SuperCarAdapter.SuperCarViewHolder> {
    private List<SuperCar> superCars ;
    private Context context ;

    public SuperCarAdapter(List<SuperCar> superCars, Context context) {
        this.superCars = superCars;
        this.context = context;
    }

    public void SuperCarAdapter (){

    }

    public void setData (List<SuperCar> list){
        this.superCars = list ;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SuperCarAdapter.SuperCarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_supercar,parent,false) ;
            return new SuperCarViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull SuperCarViewHolder holder, int position) {
        holder.img.setImageResource(superCars.get(position).getImage());
        holder.pub.setText(superCars.get(position).getPublisher());
        holder.name.setText(superCars.get(position).getName());
        holder.price.setText(Integer.toString(superCars.get(position).getPrice()));
        holder.sub.setText(superCars.get(position).getSubscription());
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                superCars.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        if(superCars != null) {
            return superCars.size();
        }
        return  0  ;
    }

    public class SuperCarViewHolder extends RecyclerView.ViewHolder {
        private ImageView img ;
        private TextView pub,name,price,sub ;
        private Button add ;
        public SuperCarViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.sp_img) ;
            pub=itemView.findViewById(R.id.sp_pub);
            name=itemView.findViewById(R.id.sp_name);
            price = itemView.findViewById(R.id.sp_price);
            sub=itemView.findViewById(R.id.sp_sub);
            add=itemView.findViewById(R.id.sp_btn);
        }
    }
}
