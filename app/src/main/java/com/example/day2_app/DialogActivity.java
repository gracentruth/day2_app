package com.example.day2_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3,b4;
    int selectMenu=0;
    String menu[]={"치킨","피자","스파게"};
    boolean checked[]={true,true,false};
    //String result=" ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        init();
    }
    private void init(){
        b1=findViewById(R.id.button1);
        b1.setOnClickListener(this);
        b2=findViewById(R.id.button2);
        b2.setOnClickListener(this);
        b3=findViewById(R.id.button3);
        b3.setOnClickListener(this);
        b4=findViewById(R.id.button4);
        b4.setOnClickListener(this);
    }


    @Override
    public void onClick(View v){
        if(v.getId()==R.id.button1){
            displayDialog();
        }
        else if(v.getId()==R.id.button2){
            displayDialog2();
        }
        else if(v.getId()==R.id.button3){
            displayDialog3();
        }
        else if(v.getId()==R.id.button4){
            displayDialog4();
        }
    }

    private void displayDialog(){
        Toast.makeText(this,"Didalog",Toast.LENGTH_LONG).show();
        AlertDialog.Builder dlg=new AlertDialog.Builder(this);
        dlg.setTitle("기본 대화상자1");
        dlg.setMessage("대화상자 메세");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast(null);
            }
        });
        dlg.show();
    }

    //라디오 버튼
    private void displayDialog2(){
        Toast.makeText(this,"Didalog",Toast.LENGTH_LONG).show();
        AlertDialog.Builder dlg=new AlertDialog.Builder(this);
        dlg.setTitle("라디오 버튼 대화상");
        dlg.setSingleChoiceItems(menu, selectMenu, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { //which= 라디오에서 몇번이 선택된지
                selectMenu=which;
            }
        });
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast(menu[selectMenu]+"가 선택되었습니다.");
            }
        });
        dlg.show();
    }

    private void displayDialog3(){
        Toast.makeText(this,"Didalog",Toast.LENGTH_LONG).show();
        AlertDialog.Builder dlg=new AlertDialog.Builder(this);
        dlg.setTitle("체크박스 대화상자");
        dlg.setMultiChoiceItems(menu, checked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked){ //라디오랑 다른 ischecked
                checked[which]=isChecked;
            }
        }); //두번째 boolean배열

        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String result="";
                for(int i=0;i<3;i++){
                    if(checked[i]==true){ result=result+menu[i]; } }

                if(result=="") displayToast("아무것도 선택되지 않았습니다");
                else displayToast(result+"가 선택되었습니다.");
            }
        });
        dlg.show();
    }


    private void displayDialog4(){
        Toast.makeText(this,"Didalog",Toast.LENGTH_LONG).show();
        AlertDialog.Builder dlg=new AlertDialog.Builder(this);
        dlg.setTitle("사용자 정의 대화상자");
        dlg.setSingleChoiceItems(menu, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { // which= 라디오에서 몇번이 선택된지
                selectMenu=which;
            }
        });
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast(menu[selectMenu]+"가 선택되었습니다.");
            }
        });
        dlg.show();
    }

    public void displayToast(String msg){
        if(msg==null)msg="Ok Clicked";

        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

}

//직접 인터페이스를 구현하는 방법