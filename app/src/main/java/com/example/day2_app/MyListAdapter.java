package com.example.day2_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyListViewHolder> {
    //Recycleview랑 array를 연결 ?
    //main이 data와 context를 줘야함

    Context context;
    ArrayList<String> data;

    MyListAdapter(Context context,ArrayList<String> data){
        this.context=context;
        this.data=data;
    }

    @Override
    public MyListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.list_item,null);
        return new MyListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyListViewHolder holder, int position) {
        holder.tv.setText(data.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyListViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        TextView tv;

        public MyListViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tvTitle); //받아온 itemView의
            tv.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            tv.setText("Clicked"+tv.getText().toString());
        }
    }

}
