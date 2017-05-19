package com.appcorsan.download;

import android.content.Context;
import android.os.AsyncTask;

import com.appcorsan.Preferences;
import com.appcorsan.Utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sala01 on 15/05/2017.
 */

public class ListaEmpresasClient extends AsyncTask<String, Integer, Object> {

    Context ctx;
    DownloadListener downloadListener;



    public ListaEmpresasClient(Context ctx, DownloadListener downloadListener) {
        this.ctx = ctx;
        this.downloadListener = downloadListener;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected Object doInBackground(String... params) {
        //Codigo
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(String.format(Utils.URL_LISTA_EMPRESA))
                    .addHeader("Accept","application/json")
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