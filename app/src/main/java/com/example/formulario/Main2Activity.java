package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.formulario.model.Usuario;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    TextView tvInicio, tvRFC, tvEdad, tvSC, tvSZ;
    Button btnRegresar;
    ImageButton ibSC, ibSZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnRegresar = findViewById(R.id.btnRegresar);
        tvInicio = findViewById(R.id.tvInicio);
        tvRFC = findViewById(R.id.tvRFC);
        tvEdad = findViewById(R.id.tvEdad);
        tvSC = findViewById(R.id.tvSC);
        tvSZ = findViewById(R.id.tvSZ);
        ibSC = findViewById(R.id.ibSC);
        ibSZ = findViewById(R.id.ibSZ);

        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
        Usuario usuario = (Usuario)bundle.getSerializable("usuario");



        tvInicio.setText(getResources().getString(R.string.inicio)  + usuario.getNombre());
        tvRFC.setText(getResources().getString(R.string.rfc) + usuario.getRfc());
        tvEdad.setText(getResources().getString(R.string.edad) + usuario.getEdad());
        tvSZ.setText(usuario.getSignoZodiacal());
        tvSC.setText(usuario.getSignoChino());

        ibSC.setBackground(getResources().getDrawable(nombre_fondo_chino(usuario.getSignoChino())));

        btnRegresar.setOnClickListener(this);
    }

    private int nombre_fondo_chino(String signoChino) {
        String tmp = signoChino.toLowerCase();
        switch(tmp){
            case "buey": //getResources().getString(R.string.buey):
                return R.drawable.buey;
            case "caballo": //getResources().getString(R.string.caballo).toLowerCase():
                return R.drawable.caballo;
            case "conejo": //getResources().getString(R.string.conejo).toLowerCase():
                return R.drawable.conejo;
            case "cerdo": //getResources().getString(R.string.cerdo).toLowerCase():
                return R.drawable.cerdo;
            case "dragon": //getResources().getString(R.string.dragon).toLowerCase():
                return R.drawable.dragon;
            case "gallo": //getResources().getString(R.string.gallo).toLowerCase():
                return R.drawable.gallo;
            case "mono": //getResources().getString(R.string.mono).toLowerCase():
                return R.drawable.mono;
            case "oveja": //getResources().getString(R.string.oveja).toLowerCase():
                return R.drawable.oveja;
            case "perro": //getResources().getString(R.string.perro).toLowerCase():
                return R.drawable.perro;
            case "rata": //getResources().getString(R.string.rata).toLowerCase():
                return R.drawable.rata;
            case "serpiente": //getResources().getString(R.string.serpiente).toLowerCase():
                return R.drawable.serpiente;
            case "tigre"://getResources().getString(R.string.tigre).toLowerCase():
                return R.drawable.tigre;
        }
        return R.drawable.buey;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegresar:
                finish();
                break;
            case R.id.ibSC:
                break;
            case R.id.ibSZ:
                break;
        }
    }
}
