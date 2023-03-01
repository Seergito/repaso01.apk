package com.example.e01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ET_nick;
    EditText ET_pw;
    CheckBox CB_save;
    Button BTN_entrar;


    SharedPreferences sharedPrefeneces; //DECLARAR SP
    SharedPreferences.Editor editor; //DECLARAR EDITOR DE SP

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ET_nick=findViewById(R.id.etnick);
        ET_pw=findViewById(R.id.edt_clave);
        CB_save=findViewById(R.id.ckb_guardar);
        BTN_entrar=findViewById(R.id.b_entrar);

        sharedPrefeneces=getSharedPreferences("ej01.xml", Context.MODE_PRIVATE); //CARPETA DONDE GUARDAR PREFS
        editor=sharedPrefeneces.edit(); //RELACION EDITOR SP


        BTN_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CB_save.isChecked()){
                    editor.putString("nick",ET_nick.getText().toString());
                    editor.commit();
                    finish();
                }else{
                    editor.clear();
                    editor.commit();
                    finish();
                }
            }
        });






    }


    @Override
    protected void onPause() {
        super.onPause();
        String nick=sharedPrefeneces.getString("nick","ERROR");
        ET_nick.setText(nick);
    }


}