package com.appcorsan;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.appcorsan.download.DownloadListener;
import com.appcorsan.download.ListaFaturasClient;
import com.appcorsan.ed.Fatura;
import com.appcorsan.ed.ListaFatura;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class SegundaViaConsultaActivity extends Activity {

    String mTagCodigoImovel;

    ListaFatura faturas;
    Fatura fatura;

    TextView codigoImovel, endereco, dtComp, dtVencimento, valor, gerarCodigoBarras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_via_consulta);

        mTagCodigoImovel = getIntent().getStringExtra("mTag");

        codigoImovel = (TextView) findViewById(R.id.textViewCodigoImovel);
        endereco = (TextView) findViewById(R.id.textViewEndereco);
        dtComp = (TextView) findViewById(R.id.textViewdtComp);
        dtVencimento = (TextView) findViewById(R.id.textViewVencimento);
        valor = (TextView) findViewById(R.id.textViewValor);
        gerarCodigoBarras = (TextView) findViewById(R.id.textViewGerarCodigoDeBarras);

        downloadListaFaturas();
    }

    public void downloadListaFaturas() {
        new ListaFaturasClient(this, new DownloadListener() {
            @Override
            public void finishedDownload(Object o) {
                faturas = new Gson().fromJson(o.toString(), ListaFatura.class);
                Log.d("FATURASasd", faturas.getFaturas().size() + "");

                populaTela(faturas.getFaturas().get(0));
            }
        }, mTagCodigoImovel).execute();
    }


    public void populaTela(Fatura fatura) {
        codigoImovel.setText(mTagCodigoImovel);
        endereco.setText(faturas.getImovelDto().getEndCodLogr()+", "+faturas.getImovelDto().getEndNumero());
        dtComp.setText(fatura.getTxtCompet());

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(fatura.getDtVencTimestamp());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        dtVencimento.setText(sdf.format(c.getTime()));
        valor.setText("Valor: "+fatura.getVlrFatura());
    }


}
