package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
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
    MediaPlayer mp;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

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
        usuario = (Usuario)bundle.getSerializable("usuario");

        tvInicio.setText(getResources().getString(R.string.inicio)  + usuario.getNombre());
        tvRFC.setText(getResources().getString(R.string.rfc) + usuario.getRfc());
        tvEdad.setText(getResources().getString(R.string.edad) + usuario.getEdad());
        tvSZ.setText(usuario.getSignoZodiacal());
        tvSC.setText(usuario.getSignoChino());

        ibSC.setImageDrawable(getResources().getDrawable(nombre_fondo_chino(usuario.getSignoChino())));
        ibSZ.setImageDrawable(getResources().getDrawable(nombre_fondo_zodiaco(usuario.getSignoZodiacal())));

        btnRegresar.setOnClickListener(this);
        ibSC.setOnClickListener(this);
    }

    private int nombre_fondo_zodiaco(String signoZodiacal) {
        int id_signo = idSignoZ(signoZodiacal);
        switch(id_signo){
            case 0:
                return R.drawable.aries;
            case 1:
                return R.drawable.taurus;
            case 2:
                return R.drawable.gemini;
            case 3:
                return R.drawable.cancer;
            case 4:
                return R.drawable.leo;
            case 5:
                return R.drawable.virgo;
            case 6:
                return R.drawable.libra;
            case 7:
                return R.drawable.scorpio;
            case 8:
                return R.drawable.sagittarius;
            case 9:
                return R.drawable.capricorn;
            case 10:
                return R.drawable.aquarius;
            case 11:
                return R.drawable.pisces;
        }
        return R.drawable.libra;
    }

    private int idSignoZ(String signoZodiacal) {
        String[] signos = {getResources().getString(R.string.aries),getResources().getString(R.string.tauro),
                getResources().getString(R.string.geminis),getResources().getString(R.string.cancer),
                getResources().getString(R.string.leo),getResources().getString(R.string.virgo),
                getResources().getString(R.string.libra),getResources().getString(R.string.escorpio),
                getResources().getString(R.string.sagitario),getResources().getString(R.string.capricornio),
                getResources().getString(R.string.acuario),getResources().getString(R.string.piscis)
        };
        for(int i = 0; i <= signos.length;i++){
            if(signoZodiacal.toLowerCase().equals(signos[i].toLowerCase())){
                return i;
            }
        }
        return -1;
    }

    private int nombre_fondo_chino(String signoChino) {
        int id_signo = idSignoC(signoChino);
        switch(id_signo){
            case 0:
                return R.drawable.rata;
            case 1:
                return R.drawable.buey;
            case 2:
                return R.drawable.tigre;
            case 3:
                return R.drawable.conejo;
            case 4:
                return R.drawable.dragon;
            case 5:
                return R.drawable.serpiente;
            case 6:
                return R.drawable.caballo;
            case 7:
                return R.drawable.oveja;
            case 8:
                return R.drawable.mono;
            case 9:
                return R.drawable.gallo;
            case 10:
                return R.drawable.perro;
            case 11:
                return R.drawable.cerdo;
        }
        return R.drawable.buey;
    }

    private int idSignoC(String signoChino) {
        String[] signos = {getResources().getString(R.string.rata),getResources().getString(R.string.buey),
                getResources().getString(R.string.tigre),getResources().getString(R.string.conejo),
                getResources().getString(R.string.dragon),getResources().getString(R.string.serpiente),
                getResources().getString(R.string.caballo),getResources().getString(R.string.oveja),
                getResources().getString(R.string.mono),getResources().getString(R.string.gallo),
                getResources().getString(R.string.perro),getResources().getString(R.string.cerdo)
        };
        for(int i = 0; i <= signos.length;i++){
            if(signoChino.toLowerCase().equals(signos[i].toLowerCase())){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnRegresar:
                mp = MediaPlayer.create(this, R.raw.button);
                mp.start();
                finish();
                break;
            case R.id.ibSC:
                audio(mp, usuario.getSignoChino());
                break;
            case R.id.ibSZ:
                break;
        }
    }

    private void audio(MediaPlayer mp, String sigChino) {
        int id_signo = idSignoC(sigChino);
        switch(id_signo){
            case 0:
                mp = MediaPlayer.create(this, R.raw.rata);
                break;
            case 1:
                mp = MediaPlayer.create(this, R.raw.buey);
                break;
            case 2:
                mp = MediaPlayer.create(this, R.raw.rata);
                break;
            case 3:
                mp = MediaPlayer.create(this, R.raw.tigre);
                break;
            case 4:
                mp = MediaPlayer.create(this, R.raw.dragon);
                break;
            case 5:
                mp = MediaPlayer.create(this, R.raw.serpiente);
                break;
            case 6:
                mp = MediaPlayer.create(this, R.raw.caballo);
                break;
            case 7:
                mp = MediaPlayer.create(this, R.raw.oveja);
                break;
            case 8:
                mp = MediaPlayer.create(this, R.raw.mono);
                break;
            case 9:
                mp = MediaPlayer.create(this, R.raw.gallo);
                break;
            case 10:
                mp = MediaPlayer.create(this, R.raw.perro);
                break;
            case 11:
                mp = MediaPlayer.create(this, R.raw.cerdo);
                break;
        }
        mp.start();
    }
}
