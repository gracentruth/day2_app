package com.example.day2_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView article_text;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* 여기서 아이디 찾기 !! 주의 ! */
        article_text=findViewById(R.id.context1);
        registerForContextMenu(article_text);

        button=findViewById(R.id.button);
        registerForContextMenu(button);

    }

//    //xml을 가져와 메뉴를 붙이는 과정
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        MenuInflater inflater=getMenuInflater();
//        inflater.inflate(R.menu.menu,menu);
//       // return super.onCreateOptionsMenu(menu);
//        return true;
//    }

    //클릭했을 때 토스트 나타나도록
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        //return super.onOptionsItemSelected(item);
//        if(item.getItemId()==R.id.menu1){
//            displayToast();
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    private void displayToast() {
//        Toast.makeText(this,"Clicked menu1", Toast.LENGTH_SHORT).show();
//    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v == article_text) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu, menu); //R.menu.menu는 menu.xml위치를 의미함
        }
        if(v == button) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu2, menu); //R.menu.menu는 menu.xml위치를 의미함
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu1:
                Toast.makeText(this,"Clicked menu1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu2:
                Toast.makeText(this,"Clicked menu2", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.b1:
                Toast.makeText(this,"Clicked b1", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.b2:
                Toast.makeText(this,"Clicked b2", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }




}