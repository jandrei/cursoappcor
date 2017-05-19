package com.appcorsan.download;

import android.content.Context;
import android.os.AsyncTask;

import com.appcorsan.Preferences;
import com.appcorsan.Utils;
import com.appcorsan.ed.Fatura;

import java.net.URLEncoder;
import java.util.HashMap;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by sala01 on 15/05/2017.
 */

public class GerarCodigoBarrasClient extends AsyncTask<String, Integer, Object> {

    Context ctx;
    DownloadListener downloadListener;
    //ProgressBar progressBar;
    Fatura fatura;
    String codigoImovel;

    public GerarCodigoBarrasClient(Context ctx, DownloadListener downloadListener, Fatura fatura,String codigoImovel) {
        this.ctx = ctx;
        this.downloadListener = downloadListener;
      //  this.progressBar = progressBar;
        this.fatura = fatura;
        this.codigoImovel = codigoImovel;
    }

    @Override
    protected void onPreExecute() {
//        progressBar.setIndeterminate(true);
//
    }

    @Override
    protected Object doInBackground(String... params) {
        //Codigo
        try {
            OkHttpClient client = new OkHttpClient();

            String nroDifer = fatura.getNroDifer().toString();
            String txtComp = fatura.getTxtCompet();
            txtComp = URLEncoder.encode(txtComp);

            String url = String.format(Utils.URL_EMISSAO_FATURA, nroDifer, codigoImovel, txtComp);
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Accept","text/plain")
                    .addHeader("Authorization", Preferences.getToken(ctx))
                    .build();

            Response response = client.newCall(request).execute();
            String body = response.body().string();
            return body;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onPostExecute(Object retorno) {
        if (retorno != null) {
            downloadListener.finishedDownload(retorno);
        }
        //progressBar.setVisibility(View.GONE);

    }

    protected void onProgressUpdate(Integer... arams) {
        //Codigo
    }


}