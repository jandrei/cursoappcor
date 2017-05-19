package com.appcorsan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.appcorsan.download.AutenticacaoClient;
import com.appcorsan.download.DownloadListener;
import com.appcorsan.download.GerarCodigoBarrasClient;
import com.appcorsan.download.ListaEmpresasClient;
import com.appcorsan.download.ListaFaturasClient;
import com.appcorsan.ed.EmpresaOrgao;
import com.appcorsan.ed.Fatura;
import com.appcorsan.ed.ListaFatura;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Fatura fatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        autenticar();

//        downloadListaFaturas();

        //downloadCodigoBarras(fatura);
    }

    public void autenticar(){
        new AutenticacaoClient(getBaseContext(), new DownloadListener() {
            @Override
            public void finishedDownload(Object o) {
                Preferences.saveStringPreferences(MainActivity.this, Utils.TOKEN_API_AOMC,o.toString());

                Log.d("TOKEN",Preferences.getToken(MainActivity.this));

            }
        }).execute();
    }

    public void downloadListaFaturas(){
           new ListaFaturasClient(this, new DownloadListener() {
               @Override
               public void finishedDownload(Object o) {
                   Log.d("JSON",o.toString());

                   ListaFatura fats = new Gson().fromJson(o.toString(),ListaFatura.class);
                   Log.d("FATURAS",fats.getFaturas().size()+"");
                   fatura = fats.getFaturas().get(0);
               }
           },"12676349").execute();
    }


    public void downloadCodigoBarras(View v){
        new GerarCodigoBarrasClient(this, new DownloadListener() {
            @Override
            public void finishedDownload(Object o) {
                Log.d("codigobarra",o.toString()+"");
            }
        }
        ,fatura
        ,"12676349").execute();
    }

    public void downloadListaEmpresaOrgao(View v){
        new ListaEmpresasClient(this, new DownloadListener() {
            @Override
            public void finishedDownload(Object o) {
                Type listType = new TypeToken<ArrayList<EmpresaOrgao>>(){}.getType();

                List<EmpresaOrgao> emps= new Gson().fromJson(o.toString(), listType);

                Log.d("EMPRESAS",emps.size()+"");
            }
        }).execute();
    }

    public void abreSegundaVia(View v){
        startActivity(new Intent(this,SegundaViaLayoutActivity.class));
    }

    public void abreVazamentoAgua(View v){
        startActivity(new Intent(this,VazamentoAguaActivity.class));
    }
}
