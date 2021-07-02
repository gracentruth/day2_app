package com.example.day2_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MyListActivity extends AppCompatActivity {

    ArrayList<String> data=new ArrayList<>();
    MyListAdapter adapter;
    RecyclerView recyclerView;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        init();
    }
    private void init(){
        /*데이터 추가 add
        가져오기 get
        삭제 remove
        갯수 size*/

        data.add("사과");
        data.add("바나");
        data.add("체리");


        adapter = new MyListAdapter(this,data);
        recyclerView=findViewById(R.id.fruitlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        et=findViewById(R.id.etFruit);


    }
    public void onAdd(View view){
        String newFruit=et.getText().toString();
        data.add(newFruit);
        adapter.notifyDataSetChanged();
    }
    //Custom Adaptor  (그전에 view holder(데이터 한개를보여줌) 필요)
}