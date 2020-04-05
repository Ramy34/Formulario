package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener{
    WebView wv;
    Button btnRegresarV2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        wv = findViewById(R.id.wv);
        btnRegresarV2 = findViewById(R.id.btnRegresarV2);

        String signo = getIntent().getStringExtra("sitioWeb"); //Recupera el valor
        wv.setWebViewClient(new WebViewClient()); //No permitir que se navegue afuera
        wv.loadUrl(getResources().getString(R.string.url) + "&q=" + signo); //Abre el sitio solicitado

        btnRegresarV2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnRegresarV2) finish();
    }
}
