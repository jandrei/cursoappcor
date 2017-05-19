package com.appcorsan;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.appcorsan.download.DownloadListener;
import com.appcorsan.download.ListaFaturasClient;
import com.appcorsan.ed.Fatura;
import com.appcorsan.ed.ListaFatura;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class VazamentoAguaActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vazamento_layout);

        }


}
