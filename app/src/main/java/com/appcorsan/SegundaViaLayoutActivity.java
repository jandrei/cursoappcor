package com.appcorsan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SegundaViaLayoutActivity extends Activity {


    EditText edtCodigoImovel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_via_layout);

        this.edtCodigoImovel = (EditText) findViewById(R.id.codigoimovel);
        String codigo = Preferences.getStringPreferences(this,"codigoimovel");
        if (codigo!=null && !codigo.trim().isEmpty()){
            this.edtCodigoImovel.setText(codigo);
        }
    }

    public void consultaSegundaVia(View v){
        Intent i = new Intent(this,SegundaViaConsultaActivity.class);

        if (edtCodigoImovel.getText().toString().trim().isEmpty()){
            edtCodigoImovel.setError("Informe o código");
            return;
        }

        Preferences.saveStringPreferences(this,"codigoimovel",edtCodigoImovel.getText().toString());

        i.putExtra("mTag",edtCodigoImovel.getText().toString());
        startActivity(i);
    }


}
