package proyecto2016.eafit.matrixledandroidwbeimar2;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TabHost;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Tab extends AppCompatActivity {

    CheckBox checkTexto;
    CheckBox checkBanner;
    CheckBox checkPequeño;
    CheckBox checkMediano;
    CheckBox checkGrande;
    CheckBox checkMensajeTexto;
    CheckBox checkMensajeSql;
    CheckBox checkIngresoIzq;
    CheckBox checkIngresoDer;
    CheckBox checkIngresoArr;
    CheckBox checkIngresoAba;
    Spinner color_fondo;
    Spinner color_letra;
    Button guardar;
    EditText editVelocidad;
    EditText editBrillo;
    EditText editTexto;
    EditText editX;
    EditText editY;
    String checkTipo;
    String checkTamaño;
    String checkTipoMensaje;
    String checkTipoIngreso;
    String colorLetra1;
    String colorLetra2;
    String colorLetra3;
    String colorFondo1;
    String colorFondo2;
    String colorFondo3;
    String velocidad;
    String brillo;
    String texto;
    String x;
    String y;
    String parametro = "TITULO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        FindViewById();



        Resources res = getResources();

        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec=tabs.newTabSpec("TITULO");
        spec.setContent(R.id.tab1);
        spec.setIndicator("TITULO",
                res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("CUERPO");
        spec.setContent(R.id.tab2);
        spec.setIndicator("CUERPO",
                res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("PIE");
        spec.setContent(R.id.tab3);
        spec.setIndicator("PIE",
                res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        tabs.setCurrentTab(0);

        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                parametro = tabId;
            }
        });

        checkTexto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkTexto.setChecked(true);
                checkBanner.setChecked(false);

            }
        });

        checkBanner.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkTexto.setChecked(false);
                checkBanner.setChecked(true);

            }
        });

        checkPequeño.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkPequeño.setChecked(true);
                checkMediano.setChecked(false);
                checkGrande.setChecked(false);

            }
        });

        checkMediano.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkPequeño.setChecked(false);
                checkMediano.setChecked(true);
                checkGrande.setChecked(false);

            }
        });

        checkGrande.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkPequeño.setChecked(false);
                checkMediano.setChecked(false);
                checkGrande.setChecked(true);

            }
        });


        checkMensajeTexto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkMensajeTexto.setChecked(true);
                checkMensajeSql.setChecked(false);

            }
        });

        checkMensajeSql.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkMensajeTexto.setChecked(false);
                checkMensajeSql.setChecked(true);

            }
        });

        checkIngresoDer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkIngresoDer.setChecked(true);
                checkIngresoIzq.setChecked(false);
                checkIngresoArr.setChecked(false);
                checkIngresoAba.setChecked(false);
            }
        });

        checkIngresoIzq.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkIngresoDer.setChecked(false);
                checkIngresoIzq.setChecked(true);
                checkIngresoArr.setChecked(false);
                checkIngresoAba.setChecked(false);
            }
        });

        checkIngresoArr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkIngresoDer.setChecked(false);
                checkIngresoIzq.setChecked(false);
                checkIngresoArr.setChecked(true);
                checkIngresoAba.setChecked(false);
            }
        });

        checkIngresoAba.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkIngresoDer.setChecked(false);
                checkIngresoIzq.setChecked(false);
                checkIngresoArr.setChecked(false);
                checkIngresoAba.setChecked(true);
            }
        });

        ArrayList<String> array_lista = new ArrayList<>();
        array_lista.add("ESCOJA COLOR");
        array_lista.add("ROJO");
        array_lista.add("VERDE");
        array_lista.add("AZUL");
        array_lista.add("AMARILLO");
        array_lista.add("BLANCO");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, array_lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        color_letra.setAdapter(adapter);
        color_letra.setGravity(Gravity.CENTER);
        color_fondo.setAdapter(adapter);
        color_fondo.setGravity(Gravity.CENTER);
    }

    public void FindViewById(){
        checkTexto = (CheckBox) findViewById(R.id.check_texto);
        checkBanner = (CheckBox) findViewById(R.id.check_banner);
        checkPequeño = (CheckBox) findViewById(R.id.check_tamañopequeño);
        checkMediano = (CheckBox) findViewById(R.id.check_tamañomediaño);
        checkGrande = (CheckBox) findViewById(R.id.check_tamañogrande);
        checkMensajeTexto = (CheckBox) findViewById(R.id.check_mensajetexto);
        checkMensajeSql = (CheckBox) findViewById(R.id.check_mensajesql);
        checkIngresoIzq = (CheckBox) findViewById(R.id.check_ingresoIzq);
        checkIngresoDer = (CheckBox) findViewById(R.id.check_ingresoDer);
        checkIngresoArr = (CheckBox) findViewById(R.id.check_ingresoArr);
        checkIngresoAba = (CheckBox) findViewById(R.id.check_ingresoAba);
        color_letra = (Spinner) findViewById(R.id.spinnerColor);
        color_fondo = (Spinner) findViewById(R.id.spinnerColorFondo);
        editVelocidad = (EditText) findViewById(R.id.velocidad);
        editBrillo = (EditText) findViewById(R.id.brillo);
        editTexto = (EditText) findViewById(R.id.editText_texto);
        editX = (EditText) findViewById(R.id.editX);
        editY = (EditText) findViewById(R.id.editY);
        guardar = (Button) findViewById(R.id.buttonGuardar);
    }

    public void teensy(View v){
        String url = "http://192.168.1.190:8090/MATRIXConsultarDatos.php";

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        String resultServer  = getHttpPost(url,params);
        System.out.println(resultServer);
        String cadena = "";
        try {

            JSONArray jArray = new JSONArray(resultServer);
            ArrayList<String> array = new ArrayList<String>();
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json = jArray.getJSONObject(i);
                array.add(json.getString("layer"));
                array.add(json.getString("tipo"));
                array.add(json.getString("posicion"));
                array.add(json.getString("ingreso"));
                array.add(json.getString("color1"));
                array.add(json.getString("color2"));
                array.add(json.getString("color3"));
                array.add(json.getString("tamano"));
                array.add(json.getString("fondo1"));
                array.add(json.getString("fondo2"));
                array.add(json.getString("fondo3"));
                array.add(json.getString("brillo"));
                array.add(json.getString("velocidad"));
                array.add(json.getString("efecto"));
                array.add(json.getString("dato"));
                array.add(json.getString("x"));
                array.add(json.getString("y"));
            }

            parametro = array.get(0);
            checkTipo = array.get(2);
            checkTipoIngreso = array.get(3);
            colorLetra1 = array.get(4);
            colorLetra2 = array.get(5);
            colorLetra3 = array.get(6);
            checkTamaño = array.get(7);
            colorFondo1 = array.get(8);
            colorFondo2 = array.get(9);
            colorFondo3 = array.get(10);
            brillo = array.get(11);
            velocidad = array.get(12);
            texto = array.get(14);
            x = array.get(15);
            y = array.get(16);

        }catch (JSONException e ){
            e.printStackTrace();
        }

        cadena = parametro + "-" +  checkTipo + "-" + "N" + "-" + checkTipoIngreso + "-" + colorLetra1 + "-" +
                 colorLetra2 + "-" + colorLetra3 + "-" + checkTamaño + "-" + colorFondo1 + "-" + colorFondo2 +
                 "-" + colorFondo3 + "-" + brillo + "-" + velocidad + "-" + "N" + "-" + texto.trim() + "-" + x.trim()
                 + "-" + y.trim() + "*";

        String url1 = "http://192.168.1.190:8090/MATRIXInsertarTeensy.php";

        List<NameValuePair> params1 = new ArrayList<NameValuePair>();
        params1.add(new BasicNameValuePair("sString",cadena + "."));
        String resultServer1  = getHttpPost(url1,params1);
        System.out.println(resultServer1);
    }


    public void guardar(View v) {

        FindViewById();

        if (checkTexto.isChecked()){
            checkTipo = "T";
        }else{
            if (checkBanner.isChecked()){
                checkTipo = "B";
            }else{
                checkTipo = "N";
            }
        }

        if (checkPequeño.isChecked()){
            checkTamaño = "P";
        }else{
            if (checkMediano.isChecked()){
                checkTamaño = "M";
            }else{
                if (checkGrande.isChecked()){
                    checkTamaño = "G";
                }
            }
        }

        if (checkMensajeTexto.isChecked()){
            checkTipoMensaje = "T";
        }else{
            if (checkMensajeSql.isChecked()){
                checkTipoMensaje = "Q";
            }else{
                checkTipoMensaje = "N";
            }
        }

        if (checkIngresoDer.isChecked()){
            checkTipoIngreso = "R";
        }else{
            if (checkIngresoIzq.isChecked()){
                checkTipoIngreso = "I";
            }else{
                if (checkIngresoAba.isChecked()){
                    checkTipoIngreso = "D";
                }else{
                    if (checkIngresoArr.isChecked()){
                        checkTipoIngreso = "A";
                    }else{
                        checkTipoIngreso = "N";
                    }
                }
            }
        }

        switch (color_letra.getSelectedItem().toString()){
            case "AMARILLO" :
                colorLetra1 = "255";
                colorLetra2 = "255";
                colorLetra3 = "0";
                break;

            case "AZUL" :
                colorLetra1 = "0";
                colorLetra2 = "0";
                colorLetra3 = "255";
                break;

            case "ROJO" :
                colorLetra1 = "255";
                colorLetra2 = "0";
                colorLetra3 = "0";
                break;
        }

        switch (color_fondo.getSelectedItem().toString()){
            case "AMARILLO" :
                colorFondo1 = "255";
                colorFondo2 = "255";
                colorFondo3 = "0";
                break;

            case "AZUL" :
                colorFondo1 = "0";
                colorFondo2 = "0";
                colorFondo3 = "255";
                break;

            case "ROJO" :
                colorFondo1 = "255";
                colorFondo2 = "0";
                colorFondo3 = "0";
                break;
        }

        velocidad = editVelocidad.getText().toString();
        brillo = editBrillo.getText().toString();
        texto = editTexto.getText().toString();
        x = editX.getText().toString();
        y = editY.getText().toString();

        String url = "http://192.168.1.190:8090/MATRIXGuardar.php";
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("sParametro", parametro));

        params.add(new BasicNameValuePair("sLayer", parametro.substring(0,1)));
        params.add(new BasicNameValuePair("sTipo", checkTipo));
        params.add(new BasicNameValuePair("sTamano", checkTamaño));
        params.add(new BasicNameValuePair("sColorLetra1", colorLetra1));
        params.add(new BasicNameValuePair("sColorLetra2", colorLetra2));
        params.add(new BasicNameValuePair("sColorLetra3", colorLetra3));
        params.add(new BasicNameValuePair("sColorFondo1", colorFondo1));
        params.add(new BasicNameValuePair("sColorFondo2", colorFondo2));
        params.add(new BasicNameValuePair("sColorFondo3", colorFondo3));
        params.add(new BasicNameValuePair("sVelocidad", velocidad));
        params.add(new BasicNameValuePair("sTipoMensaje", checkTipoMensaje));
        params.add(new BasicNameValuePair("sTipoIngreso", checkTipoIngreso));
        params.add(new BasicNameValuePair("sBrillo", brillo));
        params.add(new BasicNameValuePair("sDato", texto));
        params.add(new BasicNameValuePair("sX", x));
        params.add(new BasicNameValuePair("sY", y));



        String resultServer = getHttpPost(url, params);
        System.out.println(resultServer);

    }

    public String getHttpPost(String url, List<NameValuePair> params) {
        StringBuilder str = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            HttpResponse response = client.execute(httpPost);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) { // Status OK
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    str.append(line);
                }
            } else {
                Log.e("Log", "Failed to download result..");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }
}
