package com.example.tablayoutexercise.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.tablayoutexercise.R;
import com.example.tablayoutexercise.adapter.SuperCarAdapter;
import com.example.tablayoutexercise.model.SuperCar;

import java.util.ArrayList;
import java.util.List;


public class FragmentSuperCar extends Fragment implements AdapterView.OnItemSelectedListener{
    private Spinner sp  ;
    private EditText name,price,subs,pub;
    private Button btn ;
    private RecyclerView rev ;
    private List<SuperCar> catList =new ArrayList() ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_super_car, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);
        add();
       initSpinner();
       initRecylceView();
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               addCat();
               initRecylceView();
           }
       });
    }

    private void init(View v){
        sp=v.findViewById(R.id.sp1) ;
        pub=v.findViewById(R.id.pub1);
        name=v.findViewById(R.id.name1);
        price=v.findViewById(R.id.price1);
        subs=v.findViewById(R.id.subs1);
        btn =v.findViewById(R.id.btn1);;
        rev=v.findViewById(R.id.re1);

    }

    private void initRecylceView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rev.setLayoutManager(layoutManager);
        SuperCarAdapter adapter =  new SuperCarAdapter(catList,getContext());
        rev.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initSpinner(){
        List<String> catSpin = new ArrayList<>();
        catSpin.add("1");
        catSpin.add("2");
        catSpin.add("3");
        catSpin.add("4");
        catSpin.add("5");
        catSpin.add("6");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,catSpin);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
    }

    private void addCat(){
        SuperCar cat = new SuperCar(1,"","",10,"");
        cat.setPublisher(pub.getText().toString());
        cat.setName(name.getText().toString());
        cat.setPrice(Integer.parseInt(price.getText().toString()));
        cat.setSubscription(subs.getText().toString());
        sp.setOnItemSelectedListener(this);

        int i  = sp.getSelectedItemPosition();
        if(i==0) cat.setImage(R.drawable.s1);
        if(i==1) cat.setImage(R.drawable.s2);
        if(i==2) cat.setImage(R.drawable.s3);
        if(i==3) cat.setImage(R.drawable.s4);
        if(i==4) cat.setImage(R.drawable.s5);
        if(i==5) cat.setImage(R.drawable.s6);

        catList.add(cat);
    }

    public void add(){
        catList.add(new SuperCar(R.drawable.s1,"Lamborghini","Veneno",5000000,"Excellent"));
        catList.add(new SuperCar(R.drawable.s2,"Lamborghini","Aventador",300000,"Excellent"));


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}