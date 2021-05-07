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
import com.example.tablayoutexercise.adapter.HyperCarAdapter;
import com.example.tablayoutexercise.model.HyperCar;
import com.example.tablayoutexercise.model.SuperCar;

import java.util.ArrayList;
import java.util.List;


public class FragmentHyperCar extends Fragment implements AdapterView.OnItemSelectedListener{
    private Spinner sp  ;
    private EditText name,price,subs,pub;
    private Button btn ;
    private RecyclerView rev ;
    private List<HyperCar> hpList =new ArrayList() ;

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
        sp=v.findViewById(R.id.sp3) ;
        pub=v.findViewById(R.id.pub3);
        name=v.findViewById(R.id.name3);
        price=v.findViewById(R.id.price3);
        subs=v.findViewById(R.id.subs3);
        btn =v.findViewById(R.id.btn3);;
        rev=v.findViewById(R.id.re3);

    }

    private void initRecylceView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rev.setLayoutManager(layoutManager);
        HyperCarAdapter adapter =  new HyperCarAdapter(hpList,getContext());
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
        HyperCar cat = new HyperCar(1,"","",10,"");
        cat.setPublisher(pub.getText().toString());
        cat.setName(name.getText().toString());
        cat.setPrice(Integer.parseInt(price.getText().toString()));
        cat.setSubscription(subs.getText().toString());
        sp.setOnItemSelectedListener(this);

        int i  = sp.getSelectedItemPosition();
        if(i==0) cat.setImage(R.drawable.h1);
        if(i==1) cat.setImage(R.drawable.h2);
        if(i==2) cat.setImage(R.drawable.h7);
        if(i==3) cat.setImage(R.drawable.h4);
        if(i==4) cat.setImage(R.drawable.h5);
        if(i==5) cat.setImage(R.drawable.h6);

        hpList.add(cat);
    }

    public void add(){
        hpList.add(new HyperCar(R.drawable.h1,"Lamborghini","Veneno",5000000,"Excellent"));
        hpList.add(new HyperCar(R.drawable.h2,"Lamborghini","Aventador",300000,"Excellent"));


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hyper_car, container, false);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}