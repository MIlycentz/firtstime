package com.example.luceropc.ajustes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import java.security.PrivateKey;
import java.util.Locale;




public class MainActivity extends AppCompatActivity {

    private Button button;
    private Locale locale;
    private Configuration configuration = new Configuration();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = ((Button) findViewById(R.id.button));
        button.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        showDialog();
                    }
                });
    }
    private void showDialog(){
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle(getResources().getString(R.string.str_button));
        //aqui se obtiene los idiomas del array de string.xml
        String[] types = getResources().getStringArray(R.array.Idiomas);
        b.setItems(types, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
                switch (which){

                    case 0:
                        locale = new Locale("en");
                        configuration.locale = locale;
                        break;
                    case 1;
                        locale = new Locale("es");
                        configuration.locale = locale;
                        break;
                }
                getResources().updateConfiguration(configuration, null);
                Intent refresh = new Intent(MainActivity.this, MainActivity.class);
                startActivity(refresh);
                finish();
            }
        });
        b.show();



    }








}
