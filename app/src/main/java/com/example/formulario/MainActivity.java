package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.formulario.model.Usuario;

import java.io.Serializable;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etNombre, etAp, etAm, etFecha;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Definimos la realción del entorno gráfico con el código
        etNombre = findViewById(R.id.etNombre);
        etAp = findViewById(R.id.etAp);
        etAm = findViewById(R.id.etAm);
        etFecha = findViewById(R.id.etFecha);
        btnEnviar = findViewById(R.id.btnEnviar);

        //Evento de los botones
        btnEnviar.setOnClickListener(this);
        etFecha.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.etFecha:
                showDatePickerDialog((EditText) v);
                break;
            case R.id.btnEnviar:
                if(validarDatos()){
                    int edad = calcularEdad();
                    if(comprobarEdad(edad)){
                        String rfc = calcularRFC(etNombre.getText().toString(),etAp.getText().toString(),etAm.getText().toString(),etFecha.getText().toString());
                        String signoCh = obtenerSignoChino(etFecha);
                        String signoZo = obtenerSignoZodiacal(etFecha);
                        Usuario usuario = new Usuario(rfc,signoCh,signoZo,etNombre.getText().toString(),etAp.getText().toString(),etAm.getText().toString(),etFecha.getText().toString(),edad);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("usuario", usuario);
                        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                        intent.putExtras(bundle);
                        Toast.makeText(MainActivity.this,getResources().getString(R.string.aprobacion),Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                }else{
                    Toast.makeText(MainActivity.this,getResources().getString(R.string.error),Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    private String obtenerSignoZodiacal(EditText etFecha) {
        String fecha, signo="";
        String[] fechaSeparada;
        int dia, mes;
        fecha = etFecha.getText().toString();
        fechaSeparada = fecha.split("/");
        dia = Integer.parseInt(fechaSeparada[0]);
        mes = Integer.parseInt(fechaSeparada[1]);

        switch (mes){
            case 1:
                if(dia >= 20) signo = getResources().getString(R.string.acuario);
                else signo = getResources().getString(R.string.capricornio);
                break;
            case 2:
                if(dia >= 19) signo = getResources().getString(R.string.piscis);
                else signo = getResources().getString(R.string.acuario);
                break;
            case 3:
                if(dia >= 21) signo = getResources().getString(R.string.aries);
                else signo = getResources().getString(R.string.piscis);
                break;
            case 4:
                if(dia >= 20) signo = getResources().getString(R.string.tauro);
                else signo = getResources().getString(R.string.aries);
                break;
            case 5:
                if(dia >= 21) signo = getResources().getString(R.string.geminis);
                else signo = getResources().getString(R.string.tauro);
                break;
            case 6:
                if(dia >= 21) signo = getResources().getString(R.string.cancer);
                else signo = getResources().getString(R.string.geminis);
                break;
            case 7:

                if(dia >= 23) signo = getResources().getString(R.string.leo);
                else signo = getResources().getString(R.string.cancer);
                break;
            case 8:
                if(dia >= 23) signo = getResources().getString(R.string.virgo);
                else signo = getResources().getString(R.string.leo);
                break;
            case 9:
                if(dia >= 23) signo = getResources().getString(R.string.libra);
                else signo = getResources().getString(R.string.virgo);
                break;
            case 10:
                if(dia >= 23) signo = getResources().getString(R.string.escorpio);
                else signo = getResources().getString(R.string.libra);
                break;
            case 11:
                if(dia >= 22) signo = getResources().getString(R.string.sagitario);
                else signo = getResources().getString(R.string.escorpio);
                break;
            case 12:
                if(dia >= 22) signo = getResources().getString(R.string.capricornio);
                else signo = getResources().getString(R.string.sagitario);
                break;
        }
        return signo;
    }

    private String obtenerSignoChino(EditText etFecha) {
        String[] signosChinos = {getResources().getString(R.string.rata),getResources().getString(R.string.buey),
                getResources().getString(R.string.tigre),getResources().getString(R.string.conejo),
                getResources().getString(R.string.dragon),getResources().getString(R.string.serpiente),
                getResources().getString(R.string.caballo),getResources().getString(R.string.oveja),
                getResources().getString(R.string.mono),getResources().getString(R.string.gallo),
                getResources().getString(R.string.perro),getResources().getString(R.string.cerdo)
        };
        int indice,parteEntera;
        double division, tmp, parteDecimal;
        String fecha,signo;
        String[] fechaSeparada;
        fecha = etFecha.getText().toString();
        fechaSeparada = fecha.split("/");
        int anio = Integer.parseInt(fechaSeparada[2]);
        division = (anio-1900)/12;
        parteDecimal = division % 1;
        tmp = division - parteDecimal;
        parteEntera = (int)tmp;
        indice = anio - (parteEntera*12) - 1900;
        signo = signosChinos[indice];
        return signo;
    }

    private String calcularRFC(String nombre, String apP, String apM, String fecha) {
        String[] fechaSeparada;
        String dia, sMes, anio;
        int mes;
        fecha = etFecha.getText().toString();
        fechaSeparada = fecha.split("/");
        dia = fechaSeparada[0];
        mes = Integer.parseInt(fechaSeparada[1]);
        anio = fechaSeparada[2];
        if(mes > 9){
            sMes = mes+"";
        }else{
            sMes = "0"+mes;
        }
        String rfc = apP.substring(0,2).toUpperCase() + apM.substring(0,1).toUpperCase() + nombre.substring(0,1).toUpperCase() + anio.substring(2,4) + sMes +  dia;
        return rfc;
    }

    private boolean comprobarEdad(int edad) {
        if(edad < 0){
            Toast.makeText(MainActivity.this,getResources().getString(R.string.error1),Toast.LENGTH_SHORT).show();
            etFecha.setError(getResources().getString(R.string.error1));
            return false;
        }
        return true;
    }

    private int calcularEdad() {
        String fecha;
        String[] fechaSeparada;
        int dia, mes, anio, edad=0;
        int fDia, fMes, fAnio;
        Calendar c = Calendar.getInstance();
        fDia = c.get(Calendar.DATE);
        fMes = c.get(Calendar.MONTH) + 1;
        fAnio = c.get(Calendar.YEAR);
        fecha = etFecha.getText().toString();
        fechaSeparada = fecha.split("/");
        dia = Integer.parseInt(fechaSeparada[0]);
        mes = Integer.parseInt(fechaSeparada[1]);
        anio = Integer.parseInt(fechaSeparada[2]);
        edad = fAnio - anio;
        if(mes > fMes){
            edad--;
        }else{
            if(dia > fDia){
                edad--;
            }
        }
        return edad;
    }

    private boolean validarDatos() {
        if(etNombre.getText().length() == 0){
            etNombre.setError(getResources().getString(R.string.requerido));
            return false;
        }
        if(etAp.getText().length() == 0){
            etAp.setError(getResources().getString(R.string.requerido));
            return false;
        }
        if(etAm.getText().length() == 0){
            etAm.setError(getResources().getString(R.string.requerido));
            return false;
        }
        if(etFecha.getText().length() == 0){
            etFecha.setError(getResources().getString(R.string.requerido));
            return false;
        }
        return true;
    }

    public void showDatePickerDialog(EditText v) {
        DialogFragment newFragment = DatePickerFragment.newInstance(v);
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
