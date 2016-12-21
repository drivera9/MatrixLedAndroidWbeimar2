package proyecto2016.eafit.matrixledandroidwbeimar2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.pes.androidmaterialcolorpickerdialog.ColorPicker;

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

public class Titulo extends AppCompatActivity {

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
    Button guardar;
    Button vercolor;
    Button vercolorfondo;
    EditText editVelocidad;
    EditText editBrillo;
    EditText editTexto;
    EditText editX;
    EditText editY;
    EditText editX0_fondo;
    EditText editY0_fondo;
    EditText editX1_fondo;
    EditText editY1_fondo;
    ArrayList checkTipo;
    ArrayList checkTamaño;
    ArrayList checkTipoMensaje;
    ArrayList checkTipoIngreso;
    ArrayList colorLetra1;
    ArrayList colorLetra2;
    ArrayList colorLetra3;
    ArrayList colorFondo1;
    ArrayList colorFondo2;
    ArrayList colorFondo3;
    ArrayList velocidad;
    ArrayList brillo;
    ArrayList texto;
    ArrayList x;
    ArrayList y;
    ArrayList x0;
    ArrayList y0;
    ArrayList x1;
    ArrayList y1;
    String selectedColorRLetra;
    String selectedColorGLetra;
    String selectedColorBLetra;

    String selectedColorRFondo;
    String selectedColorGFondo;
    String selectedColorBFondo;
    ColorPicker cp;
    String parametro = "";
    String ip = "";
    String codigo = "";
    String empresa = "";
    String sucursal = "";
    String clave = "";
    String usuario = "";
    String titulo = "";
    String cadena = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_titulo);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);



        Bundle bundle = this.getIntent().getExtras();

        codigo = bundle.getString("codigo");
        empresa = bundle.getString("empresa");
        sucursal = bundle.getString("sucursal");
        parametro = bundle.getString("parametro");
        setTitle(parametro);
        clave = bundle.getString("clave");
        usuario = bundle.getString("usuario");
        ip = bundle.getString("ip");

        FindViewById();
        actualizar();


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



    }

    public void actualizar(){

        checkTipo = new ArrayList() ;
        checkTamaño = new ArrayList();
        checkTipoMensaje = new ArrayList();
        checkTipoIngreso = new ArrayList();
        colorLetra1 = new ArrayList();
        colorLetra2 = new ArrayList();
        colorLetra3 = new ArrayList();
        colorFondo1 = new ArrayList();
        colorFondo2 = new ArrayList();
        colorFondo3 = new ArrayList();
        velocidad = new ArrayList();
        brillo = new ArrayList();
        texto = new ArrayList();
        x = new ArrayList();
        y = new ArrayList();
        x0 = new ArrayList();
        x1 = new ArrayList();
        y0 = new ArrayList();
        y1 = new ArrayList();

        if (codigo.equals("NUEVA")){

        }else {
            String url = "http://" + ip + "/MATRIXActualizar.php";

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("sCodigo", codigo));
            params.add(new BasicNameValuePair("sEmpresa", empresa));
            params.add(new BasicNameValuePair("sSucursal", sucursal));
            params.add(new BasicNameValuePair("sTipo", parametro.substring(0,1).trim()));

            String resultServer = getHttpPost(url, params);
            System.out.println(resultServer);
            String cadena = "";
            try {

                JSONArray jArray = new JSONArray(resultServer);
                ArrayList<String> array = new ArrayList<String>();
                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject json = jArray.getJSONObject(i);
                    array.add(json.getString("layer"));
                    checkTipoMensaje.add(json.getString("tipo"));
                    checkTipo.add(json.getString("posicion"));
                    checkTipoIngreso.add(json.getString("ingreso"));
                    colorLetra1.add(json.getString("color1"));
                    colorLetra2.add(json.getString("color2"));
                    colorLetra3.add(json.getString("color3"));
                    checkTamaño.add(json.getString("tamano"));
                    colorFondo1.add(json.getString("fondo1"));
                    colorFondo2.add(json.getString("fondo2"));
                    colorFondo3.add(json.getString("fondo3"));
                    brillo.add(json.getString("brillo"));
                    velocidad.add(json.getString("velocidad"));
                    array.add(json.getString("efecto"));
                    texto.add(json.getString("dato"));
                    x.add(json.getString("x"));
                    y.add(json.getString("y"));
                    x0.add(json.getString("x0fondo"));
                    y0.add(json.getString("y0fondo"));
                    x1.add(json.getString("x1fondo"));
                    y1.add(json.getString("y1fondo"));
                }

                if (checkTipoMensaje.get(0).toString().trim().equals("T")) {
                    checkMensajeTexto.setChecked(true);
                } else {
                    if (checkTipoMensaje.get(0).toString().trim().equals("Q")) {
                        checkMensajeSql.setChecked(true);
                    } else {
                        checkMensajeTexto.setChecked(false);
                        checkMensajeSql.setChecked(false);
                    }
                }

                if (checkTipo.get(0).toString().trim().equals("T")) {
                    checkTexto.setChecked(true);
                } else {
                    if (checkTipo.get(0).toString().trim().equals("B")) {
                        checkBanner.setChecked(true);
                    } else {
                        checkTexto.setChecked(false);
                        checkBanner.setChecked(false);
                    }
                }

                if (checkTipoIngreso.get(0).toString().trim().equals("R")) {
                    checkIngresoDer.setChecked(true);
                } else {
                    if (checkTipoIngreso.get(0).toString().trim().equals("I")) {
                        checkIngresoIzq.setChecked(true);
                    } else {
                        if (checkTipoIngreso.get(0).toString().trim().equals("D")) {
                            checkIngresoAba.setChecked(true);
                        } else {
                            if (checkTipoIngreso.get(0).toString().trim().equals("A")) {
                                checkIngresoArr.setChecked(true);
                            } else {
                                checkIngresoDer.setChecked(false);
                                checkIngresoIzq.setChecked(false);
                                checkIngresoAba.setChecked(false);
                                checkIngresoArr.setChecked(false);
                            }
                        }
                    }
                }

                if (checkTamaño.get(0).toString().trim().equals("P")) {
                    checkPequeño.setChecked(true);
                } else {
                    if (checkTamaño.get(0).toString().trim().equals("M")) {
                        checkMediano.setChecked(true);
                    } else {
                        if (checkTamaño.get(0).toString().trim().equals("G")) {
                            checkGrande.setChecked(true);
                        } else {
                            checkPequeño.setChecked(false);
                            checkMediano.setChecked(false);
                            checkGrande.setChecked(false);
                        }
                    }
                }

                if (checkPequeño.isChecked()) {
                    checkTamaño.add("P");
                } else {
                    if (checkMediano.isChecked()) {
                        checkTamaño.add("M");
                    } else {
                        if (checkGrande.isChecked()) {
                            checkTamaño.add("G");
                        }
                    }
                }


                selectedColorRLetra = colorLetra1.get(0).toString().trim();
                selectedColorGLetra = colorLetra2.get(0).toString().trim();
                selectedColorBLetra = colorLetra3.get(0).toString().trim();

                selectedColorRFondo = colorFondo1.get(0).toString().trim();
                selectedColorGFondo = colorFondo2.get(0).toString().trim();
                selectedColorBFondo = colorFondo3.get(0).toString().trim();


                editVelocidad.setText(velocidad.get(0).toString().trim());
                editBrillo.setText(brillo.get(0).toString().trim());

                editTexto.setText(texto.get(0).toString().trim());
                editX.setText(x.get(0).toString().trim());
                editY.setText(y.get(0).toString().trim());

                editX0_fondo.setText(x0.get(0).toString().trim());
                editY0_fondo.setText(y0.get(0).toString().trim());
                editX1_fondo.setText(x1.get(0).toString().trim());
                editY1_fondo.setText(y1.get(0).toString().trim());
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

    }

    public void verColor(View v){
        cp.show();

/* On Click listener for the dialog, when the user select the color */
        Button okColor = (Button)cp.findViewById(R.id.okColorButton);

        okColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        /* You can get single channel (value 0-255) */
                selectedColorRLetra = String.valueOf(cp.getRed());
                selectedColorGLetra = String.valueOf(cp.getGreen());
                selectedColorBLetra = String.valueOf(cp.getBlue());

        /* Or the android RGB Color (see the android Color class reference) */
                cp.dismiss();
                vercolor.setBackgroundColor(cp.getColor());
            }
        });


    }

    public void verColorFondo(View v){
        cp.show();

/* On Click listener for the dialog, when the user select the color */
        Button okColor = (Button)cp.findViewById(R.id.okColorButton);

        okColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        /* You can get single channel (value 0-255) */
                selectedColorRFondo = String.valueOf(cp.getRed());
                selectedColorGFondo = String.valueOf(cp.getGreen());
                selectedColorBFondo = String.valueOf(cp.getBlue());

        /* Or the android RGB Color (see the android Color class reference) */
                cp.dismiss();
                vercolorfondo.setBackgroundColor(cp.getColor());
            }
        });


    }

    public void FindViewById(){
        cp = new ColorPicker(Titulo.this, 0, 0, 0);
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
        editVelocidad = (EditText) findViewById(R.id.velocidad);
        editBrillo = (EditText) findViewById(R.id.brillo);
        editTexto = (EditText) findViewById(R.id.editText_texto);
        editX = (EditText) findViewById(R.id.editX);
        editY = (EditText) findViewById(R.id.editY);
        editX0_fondo = (EditText) findViewById(R.id.editX0_fondo);
        editY0_fondo = (EditText) findViewById(R.id.editY0_fondo);
        editX1_fondo = (EditText) findViewById(R.id.editX1_fondo);
        editY1_fondo = (EditText) findViewById(R.id.editY1_fondo);
        guardar = (Button) findViewById(R.id.buttonGuardar);
        vercolor = (Button) findViewById(R.id.vercolor);
        vercolorfondo = (Button) findViewById(R.id.vercolorfondo);
    }

    public void teensy(View v){



    }


    public void guardar(View v) {

         checkTipo = new ArrayList() ;
         checkTamaño = new ArrayList();
         checkTipoMensaje = new ArrayList();
         checkTipoIngreso = new ArrayList();
         colorLetra1 = new ArrayList();
         colorLetra2 = new ArrayList();
         colorLetra3 = new ArrayList();
         colorFondo1 = new ArrayList();
         colorFondo2 = new ArrayList();
         colorFondo3 = new ArrayList();
         velocidad = new ArrayList();
         brillo = new ArrayList();
         texto = new ArrayList();
         x = new ArrayList();
         y = new ArrayList();
         x0 = new ArrayList();
         x1 = new ArrayList();
         y0 = new ArrayList();
         y1 = new ArrayList();

        FindViewById();

        if (checkTexto.isChecked()){
            checkTipo.add("T");
        }else{
            if (checkBanner.isChecked()){
                checkTipo.add("B");
            }else{
                checkTipo.add("T");
            }
        }

        if (checkPequeño.isChecked()){
            checkTamaño.add("P");
        }else{
            if (checkMediano.isChecked()){
                checkTamaño.add("M");
            }else{
                if (checkGrande.isChecked()){
                    checkTamaño.add("G");
                }else{
                    checkTamaño.add("P");
                }
            }
        }

        if (checkMensajeTexto.isChecked()){
            checkTipoMensaje.add("T");
        }else{
            if (checkMensajeSql.isChecked()){
                checkTipoMensaje.add("Q");
            }else{
                checkTipoMensaje.add("T");
            }
        }

        if (checkIngresoDer.isChecked()){
            checkTipoIngreso.add("R");
        }else{
            if (checkIngresoIzq.isChecked()){
                checkTipoIngreso.add("I");
            }else{
                if (checkIngresoAba.isChecked()){
                    checkTipoIngreso.add("D");
                }else{
                    if (checkIngresoArr.isChecked()){
                        checkTipoIngreso.add("A");
                    }else{
                        checkTipoIngreso.add("R");
                    }
                }
            }
        }



        if(editVelocidad.getText().toString().equals("")){
            velocidad.add("10");
        }else{
            velocidad.add(editVelocidad.getText().toString());
        }

        if(editBrillo.getText().toString().equals("")){
            brillo.add("10");
        }else{
            brillo.add(editBrillo.getText().toString());
        }

        if(editTexto.getText().toString().equals("")){
            texto.add("prueba");
        }else{
            texto.add(editTexto.getText().toString());
        }

        if(editX.getText().toString().equals("")){
            x.add("10");
        }else{
            x.add(editX.getText().toString());
        }

        if(editY.getText().toString().equals("")){
            y.add("10");
        }else{
            y.add(editY.getText().toString());
        }

        if(editX0_fondo.getText().toString().equals("")){
            x0.add("10");
        }else{
            x0.add(editX0_fondo.getText().toString());
        }

        if(editY0_fondo.getText().toString().equals("")){
            y0.add("10");
        }else{
            y0.add(editY0_fondo.getText().toString());
        }

        if(editX1_fondo.getText().toString().equals("")){
            x1.add("10");
        }else{
            x1.add(editX1_fondo.getText().toString());
        }

        if(editY1_fondo.getText().toString().equals("")){
            y1.add("10");
        }else{
            y1.add(editY1_fondo.getText().toString());
        }


        if (checkTipoMensaje.get(0).toString().trim().equals("T") || checkTipoMensaje.get(0).toString().trim().equals("N")) {

            if (codigo.trim().equals("NUEVA")){
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                final EditText edittext = new EditText(Titulo.this);
                alert.setMessage("Entre el nombre de la configuracion");
                alert.setTitle("NOMBRE");

                alert.setView(edittext);

                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //What ever you want to do with the value
                        codigo = edittext.getText().toString();

                        String url3 = "http://" + ip + "/MATRIXConsultarDatos.php";

                        List<NameValuePair> params3 = new ArrayList<NameValuePair>();
                        params3.add(new BasicNameValuePair("sCodigo", codigo));
                        params3.add(new BasicNameValuePair("sEmpresa", empresa));
                        params3.add(new BasicNameValuePair("sSucursal", sucursal));
                        params3.add(new BasicNameValuePair("sTipo", parametro.substring(0,1).trim()));
                        params3.add(new BasicNameValuePair("sParametro", "consultar"));

                        String resultServer3 = getHttpPost(url3, params3);
                        System.out.println(resultServer3);
                        String cadena = "";
                        ArrayList<String> lista = new ArrayList<>();
                        lista.add("1");
                        try {

                            JSONArray jArray = new JSONArray(resultServer3);
                            ArrayList<String> array = new ArrayList<String>();
                            for (int i = 0; i < jArray.length(); i++) {
                                JSONObject json = jArray.getJSONObject(i);
                                lista.add(json.getString("layer"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                        if (lista.size() > 1) {


                            String url = "http://" + ip + "/MATRIXGuardarNueva.php";
                            List<NameValuePair> params = new ArrayList<NameValuePair>();
                            params.add(new BasicNameValuePair("sLayer", parametro.substring(0, 1)));
                            params.add(new BasicNameValuePair("sTipo", checkTipo.get(0).toString()));
                            params.add(new BasicNameValuePair("sTamano", checkTamaño.get(0).toString()));
                            params.add(new BasicNameValuePair("sColorLetra1", selectedColorRLetra));
                            params.add(new BasicNameValuePair("sColorLetra2", selectedColorGLetra));
                            params.add(new BasicNameValuePair("sColorLetra3", selectedColorBLetra));
                            params.add(new BasicNameValuePair("sColorFondo1", selectedColorRFondo));
                            params.add(new BasicNameValuePair("sColorFondo2", selectedColorGFondo));
                            params.add(new BasicNameValuePair("sColorFondo3", selectedColorBFondo));
                            params.add(new BasicNameValuePair("sVelocidad", velocidad.get(0).toString()));
                            params.add(new BasicNameValuePair("sTipoMensaje", checkTipoMensaje.get(0).toString()));
                            params.add(new BasicNameValuePair("sTipoIngreso", checkTipoIngreso.get(0).toString()));
                            params.add(new BasicNameValuePair("sBrillo", brillo.get(0).toString()));
                            params.add(new BasicNameValuePair("sDato", texto.get(0).toString()));
                            params.add(new BasicNameValuePair("sX", x.get(0).toString()));
                            params.add(new BasicNameValuePair("sY", y.get(0).toString()));
                            params.add(new BasicNameValuePair("sX0", x0.get(0).toString()));
                            params.add(new BasicNameValuePair("sY0", y0.get(0).toString()));
                            params.add(new BasicNameValuePair("sX1", x1.get(0).toString()));
                            params.add(new BasicNameValuePair("sY1", y1.get(0).toString()));
                            params.add(new BasicNameValuePair("sCodigo", codigo));
                            params.add(new BasicNameValuePair("sEmpresa", empresa));
                            params.add(new BasicNameValuePair("sSucursal", sucursal));
                            params.add(new BasicNameValuePair("sIp", ip));
                            params.add(new BasicNameValuePair("sClave", clave));
                            params.add(new BasicNameValuePair("sUsuario", usuario));
                            params.add(new BasicNameValuePair("sParametro", "update"));


                            String resultServer = getHttpPost(url, params);
                            System.out.println(resultServer);
                        } else {
                            //Toast.makeText(Titulo.this, "INSERT", Toast.LENGTH_SHORT).show();
                            String url = "http://" + ip + "/MATRIXGuardarNueva.php";
                            List<NameValuePair> params = new ArrayList<NameValuePair>();
                            params.add(new BasicNameValuePair("sLayer", parametro.substring(0, 1)));
                            params.add(new BasicNameValuePair("sTipo", checkTipo.get(0).toString()));
                            params.add(new BasicNameValuePair("sTamano", checkTamaño.get(0).toString()));
                            params.add(new BasicNameValuePair("sColorLetra1", selectedColorRLetra));
                            params.add(new BasicNameValuePair("sColorLetra2", selectedColorGLetra));
                            params.add(new BasicNameValuePair("sColorLetra3", selectedColorBLetra));
                            params.add(new BasicNameValuePair("sColorFondo1", selectedColorRFondo));
                            params.add(new BasicNameValuePair("sColorFondo2", selectedColorGFondo));
                            params.add(new BasicNameValuePair("sColorFondo3", selectedColorBFondo));
                            params.add(new BasicNameValuePair("sVelocidad", velocidad.get(0).toString()));
                            params.add(new BasicNameValuePair("sTipoMensaje", checkTipoMensaje.get(0).toString()));
                            params.add(new BasicNameValuePair("sTipoIngreso", checkTipoIngreso.get(0).toString()));
                            params.add(new BasicNameValuePair("sBrillo", brillo.get(0).toString()));
                            params.add(new BasicNameValuePair("sDato", texto.get(0).toString()));
                            params.add(new BasicNameValuePair("sX", x.get(0).toString()));
                            params.add(new BasicNameValuePair("sY", y.get(0).toString()));
                            params.add(new BasicNameValuePair("sX0", x0.get(0).toString()));
                            params.add(new BasicNameValuePair("sY0", y0.get(0).toString()));
                            params.add(new BasicNameValuePair("sX1", x1.get(0).toString()));
                            params.add(new BasicNameValuePair("sY1", y1.get(0).toString()));
                            params.add(new BasicNameValuePair("sCodigo", codigo));
                            params.add(new BasicNameValuePair("sEmpresa", empresa));
                            params.add(new BasicNameValuePair("sSucursal", sucursal));
                            params.add(new BasicNameValuePair("sIp", ip));
                            params.add(new BasicNameValuePair("sClave", clave));
                            params.add(new BasicNameValuePair("sUsuario", usuario));
                            params.add(new BasicNameValuePair("sParametro", "insert"));

                            String resultServer = getHttpPost(url, params);
                            System.out.println(resultServer);
                        }

                        String url6 = "http://" + ip + "/MATRIXConsultarDatos.php";

                        List<NameValuePair> params6 = new ArrayList<NameValuePair>();
                        params6.add(new BasicNameValuePair("sCodigo", codigo));
                        params6.add(new BasicNameValuePair("sEmpresa", empresa));
                        params6.add(new BasicNameValuePair("sSucursal", sucursal));
                        params6.add(new BasicNameValuePair("sTipo", parametro.substring(0,1).trim()));
                        params6.add(new BasicNameValuePair("sParametro", "consultarEnc"));

                        String resultServer6 = getHttpPost(url6, params6);
                        System.out.println(resultServer6);
                        ArrayList<String> listaEnc = new ArrayList<>();
                        listaEnc.add("1");
                        try {

                            JSONArray jArray = new JSONArray(resultServer3);
                            ArrayList<String> array = new ArrayList<String>();
                            for (int i = 0; i < jArray.length(); i++) {
                                JSONObject json = jArray.getJSONObject(i);
                                listaEnc.add(json.getString("layer"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                        if (listaEnc.size()>1){

                        }else {

                            String url5 = "http://" + ip + "/MATRIXGuardarNueva.php";
                            List<NameValuePair> params5 = new ArrayList<NameValuePair>();
                            params5.add(new BasicNameValuePair("sLayer", parametro.substring(0, 1)));
                            params5.add(new BasicNameValuePair("sTipo", checkTipo.get(0).toString()));
                            params5.add(new BasicNameValuePair("sTamano", checkTamaño.get(0).toString()));
                            params5.add(new BasicNameValuePair("sColorLetra1", selectedColorRLetra));
                            params5.add(new BasicNameValuePair("sColorLetra2", selectedColorGLetra));
                            params5.add(new BasicNameValuePair("sColorLetra3", selectedColorBLetra));
                            params5.add(new BasicNameValuePair("sColorFondo1", selectedColorRFondo));
                            params5.add(new BasicNameValuePair("sColorFondo2", selectedColorGFondo));
                            params5.add(new BasicNameValuePair("sColorFondo3", selectedColorBFondo));
                            params5.add(new BasicNameValuePair("sVelocidad", velocidad.get(0).toString()));
                            params5.add(new BasicNameValuePair("sTipoMensaje", checkTipoMensaje.get(0).toString()));
                            params5.add(new BasicNameValuePair("sTipoIngreso", checkTipoIngreso.get(0).toString()));
                            params5.add(new BasicNameValuePair("sBrillo", brillo.get(0).toString()));
                            params5.add(new BasicNameValuePair("sDato", texto.get(0).toString()));
                            params5.add(new BasicNameValuePair("sX", x.get(0).toString()));
                            params5.add(new BasicNameValuePair("sY", y.get(0).toString()));
                            params5.add(new BasicNameValuePair("sX0", x0.get(0).toString()));
                            params5.add(new BasicNameValuePair("sY0", y0.get(0).toString()));
                            params5.add(new BasicNameValuePair("sX1", x1.get(0).toString()));
                            params5.add(new BasicNameValuePair("sY1", y1.get(0).toString()));
                            params5.add(new BasicNameValuePair("sCodigo", codigo));
                            params5.add(new BasicNameValuePair("sEmpresa", empresa));
                            params5.add(new BasicNameValuePair("sSucursal", sucursal));
                            params5.add(new BasicNameValuePair("sIp", ip));
                            params5.add(new BasicNameValuePair("sClave", clave));
                            params5.add(new BasicNameValuePair("sUsuario", usuario));
                            params5.add(new BasicNameValuePair("sParametro", "insertEnc"));

                            String resultServer5 = getHttpPost(url5, params5);
                            System.out.println(resultServer5);
                        }
                    }
                });
                alert.show();
            }else{
                String url3 = "http://" + ip + "/MATRIXConsultarDatos.php";

                List<NameValuePair> params3 = new ArrayList<NameValuePair>();
                params3.add(new BasicNameValuePair("sCodigo", codigo));
                params3.add(new BasicNameValuePair("sEmpresa", empresa));
                params3.add(new BasicNameValuePair("sSucursal", sucursal));
                params3.add(new BasicNameValuePair("sTipo", parametro.substring(0,1).trim()));
                params3.add(new BasicNameValuePair("sParametro", "consultar"));

                String resultServer3 = getHttpPost(url3, params3);
                System.out.println(resultServer3);
                String cadena = "";
                ArrayList<String> lista = new ArrayList<>();
                lista.add("1");
                try {

                    JSONArray jArray = new JSONArray(resultServer3);
                    ArrayList<String> array = new ArrayList<String>();
                    for (int i = 0; i < jArray.length(); i++) {
                        JSONObject json = jArray.getJSONObject(i);
                        lista.add(json.getString("layer"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }



                if (lista.size()>1) {

                    System.out.print(checkTipo.get(0).toString());
                    String url = "http://" + ip + "/MATRIXGuardarNueva.php";
                    List<NameValuePair> params = new ArrayList<NameValuePair>();
                    params.add(new BasicNameValuePair("sLayer", parametro.substring(0, 1)));
                    params.add(new BasicNameValuePair("sTipo", checkTipo.get(0).toString()));
                    params.add(new BasicNameValuePair("sTamano", checkTamaño.get(0).toString()));
                    params.add(new BasicNameValuePair("sColorLetra1", selectedColorRLetra));
                    params.add(new BasicNameValuePair("sColorLetra2", selectedColorGLetra));
                    params.add(new BasicNameValuePair("sColorLetra3", selectedColorBLetra));
                    params.add(new BasicNameValuePair("sColorFondo1", selectedColorRFondo));
                    params.add(new BasicNameValuePair("sColorFondo2", selectedColorGFondo));
                    params.add(new BasicNameValuePair("sColorFondo3", selectedColorBFondo));
                    params.add(new BasicNameValuePair("sVelocidad", velocidad.get(0).toString()));
                    params.add(new BasicNameValuePair("sTipoMensaje", checkTipoMensaje.get(0).toString()));
                    params.add(new BasicNameValuePair("sTipoIngreso", checkTipoIngreso.get(0).toString()));
                    params.add(new BasicNameValuePair("sBrillo", brillo.get(0).toString()));
                    params.add(new BasicNameValuePair("sDato", texto.get(0).toString()));
                    params.add(new BasicNameValuePair("sX", x.get(0).toString()));
                    params.add(new BasicNameValuePair("sY", y.get(0).toString()));
                    params.add(new BasicNameValuePair("sX0", x0.get(0).toString()));
                    params.add(new BasicNameValuePair("sY0", y0.get(0).toString()));
                    params.add(new BasicNameValuePair("sX1", x1.get(0).toString()));
                    params.add(new BasicNameValuePair("sY1", y1.get(0).toString()));
                    params.add(new BasicNameValuePair("sCodigo", codigo));
                    params.add(new BasicNameValuePair("sEmpresa", empresa));
                    params.add(new BasicNameValuePair("sSucursal", sucursal));
                    params.add(new BasicNameValuePair("sIp", ip));
                    params.add(new BasicNameValuePair("sClave", clave));
                    params.add(new BasicNameValuePair("sUsuario", usuario));
                    params.add(new BasicNameValuePair("sParametro", "update"));


                    String resultServer = getHttpPost(url, params);
                    System.out.println(resultServer);
                }else{
                    //Toast.makeText(Titulo.this, "INSERT", Toast.LENGTH_SHORT).show();
                    String url = "http://" + ip + "/MATRIXGuardarNueva.php";
                    List<NameValuePair> params = new ArrayList<NameValuePair>();
                    params.add(new BasicNameValuePair("sLayer", parametro.substring(0, 1)));
                    params.add(new BasicNameValuePair("sTipo", checkTipo.get(0).toString()));
                    params.add(new BasicNameValuePair("sTamano", checkTamaño.get(0).toString()));
                    params.add(new BasicNameValuePair("sColorLetra1", selectedColorRLetra));
                    params.add(new BasicNameValuePair("sColorLetra2", selectedColorGLetra));
                    params.add(new BasicNameValuePair("sColorLetra3", selectedColorBLetra));
                    params.add(new BasicNameValuePair("sColorFondo1", selectedColorRFondo));
                    params.add(new BasicNameValuePair("sColorFondo2", selectedColorGFondo));
                    params.add(new BasicNameValuePair("sColorFondo3", selectedColorBFondo));
                    params.add(new BasicNameValuePair("sVelocidad", velocidad.get(0).toString()));
                    params.add(new BasicNameValuePair("sTipoMensaje", checkTipoMensaje.get(0).toString()));
                    params.add(new BasicNameValuePair("sTipoIngreso", checkTipoIngreso.get(0).toString()));
                    params.add(new BasicNameValuePair("sBrillo", brillo.get(0).toString()));
                    params.add(new BasicNameValuePair("sDato", texto.get(0).toString()));
                    params.add(new BasicNameValuePair("sX", x.get(0).toString()));
                    params.add(new BasicNameValuePair("sY", y.get(0).toString()));
                    params.add(new BasicNameValuePair("sX0", x0.get(0).toString()));
                    params.add(new BasicNameValuePair("sY0", y0.get(0).toString()));
                    params.add(new BasicNameValuePair("sX1", x1.get(0).toString()));
                    params.add(new BasicNameValuePair("sY1", y1.get(0).toString()));
                    params.add(new BasicNameValuePair("sCodigo", codigo));
                    params.add(new BasicNameValuePair("sEmpresa", empresa));
                    params.add(new BasicNameValuePair("sSucursal", sucursal));
                    params.add(new BasicNameValuePair("sIp", ip));
                    params.add(new BasicNameValuePair("sClave", clave));
                    params.add(new BasicNameValuePair("sUsuario", usuario));
                    params.add(new BasicNameValuePair("sParametro", "insert"));

                    String resultServer = getHttpPost(url, params);
                    System.out.println(resultServer);


                }
            }


            Toast.makeText(Titulo.this, "Se guardo!", Toast.LENGTH_SHORT).show();


        }else{
            String url2 = "http://" + ip + "/MATRIXGuardarSql.php";

            List<NameValuePair> params2 = new ArrayList<NameValuePair>();
            params2.add(new BasicNameValuePair("sSql", texto.get(0).toString().trim()));
            String resultServer2  = getHttpPost(url2,params2);

            System.out.println(resultServer2);
            String cadena = "";
            try {

                JSONArray jArray = new JSONArray(resultServer2);
                ArrayList<String> array = new ArrayList<String>();
                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject json = jArray.getJSONObject(i);
                    array.add(json.getString("dato"));
                }

                texto.add(array.get(0).toString().trim());
            }catch (JSONException e ){
                e.printStackTrace();
            }

            String url1 = "http://" + ip + "/MATRIXGuardar.php";
            List<NameValuePair> params1 = new ArrayList<NameValuePair>();
            params1.add(new BasicNameValuePair("sLayer", parametro.substring(0, 1)));
            params1.add(new BasicNameValuePair("sTipo", checkTipo.get(0).toString()));
            params1.add(new BasicNameValuePair("sTamano", checkTamaño.get(0).toString()));
            params1.add(new BasicNameValuePair("sColorLetra1", selectedColorRLetra));
            params1.add(new BasicNameValuePair("sColorLetra2", selectedColorGLetra));
            params1.add(new BasicNameValuePair("sColorLetra3", selectedColorBLetra));
            params1.add(new BasicNameValuePair("sColorFondo1", selectedColorRFondo));
            params1.add(new BasicNameValuePair("sColorFondo2", selectedColorGFondo));
            params1.add(new BasicNameValuePair("sColorFondo3", selectedColorBFondo));
            params1.add(new BasicNameValuePair("sVelocidad", velocidad.get(0).toString()));
            params1.add(new BasicNameValuePair("sTipoMensaje", checkTipoMensaje.get(0).toString()));
            params1.add(new BasicNameValuePair("sTipoIngreso", checkTipoIngreso.get(0).toString()));
            params1.add(new BasicNameValuePair("sBrillo", brillo.get(0).toString()));
            params1.add(new BasicNameValuePair("sDato", texto.get(1).toString()));
            params1.add(new BasicNameValuePair("sX", x.get(0).toString()));
            params1.add(new BasicNameValuePair("sY", y.get(0).toString()));
            params1.add(new BasicNameValuePair("sX0", x0.get(0).toString()));
            params1.add(new BasicNameValuePair("sY0", y0.get(0).toString()));
            params1.add(new BasicNameValuePair("sX1", x1.get(0).toString()));
            params1.add(new BasicNameValuePair("sY1", y1.get(0).toString()));
            params1.add(new BasicNameValuePair("sId", "67"));


            String resultServer1 = getHttpPost(url1, params1);
            System.out.println(resultServer1);
        }

        checkTipo = new ArrayList() ;
        checkTamaño = new ArrayList();
        checkTipoMensaje = new ArrayList();
        checkTipoIngreso = new ArrayList();
        colorLetra1 = new ArrayList();
        colorLetra2 = new ArrayList();
        colorLetra3 = new ArrayList();
        colorFondo1 = new ArrayList();
        colorFondo2 = new ArrayList();
        colorFondo3 = new ArrayList();
        velocidad = new ArrayList();
        brillo = new ArrayList();
        texto = new ArrayList();
        x = new ArrayList();
        y = new ArrayList();
        x0 = new ArrayList();
        x1 = new ArrayList();
        y0 = new ArrayList();
        y1 = new ArrayList();


        String url = "http://"+ ip + "/MATRIXConsultarDatos.php";

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("sCodigo", codigo));
        params.add(new BasicNameValuePair("sEmpresa", empresa));
        params.add(new BasicNameValuePair("sSucursal", sucursal));
        params.add(new BasicNameValuePair("sTipo", parametro.substring(0,1).trim()));
        params.add(new BasicNameValuePair("sParametro", "todo"));
        String resultServer  = getHttpPost(url,params);
        System.out.println(resultServer);
        try {

            JSONArray jArray = new JSONArray(resultServer);
            ArrayList<String> array = new ArrayList<String>();
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json = jArray.getJSONObject(i);
                array.add(json.getString("layer").trim());
                checkTipoMensaje.add(json.getString("tipo").trim());
                checkTipo.add(json.getString("posicion").trim());
                checkTipoIngreso.add(json.getString("ingreso").trim());
                colorLetra1.add(json.getString("color1").trim());
                colorLetra2.add(json.getString("color2").trim());
                colorLetra3.add(json.getString("color3").trim());
                checkTamaño.add(json.getString("tamano").trim());
                colorFondo1.add(json.getString("fondo1").trim());
                colorFondo2.add(json.getString("fondo2").trim());
                colorFondo3.add(json.getString("fondo3").trim());
                brillo.add(json.getString("brillo").trim());
                velocidad.add(json.getString("velocidad").trim());
                array.add(json.getString("efecto").trim());
                texto.add(json.getString("dato").trim());
                x.add(json.getString("x").trim());
                y.add(json.getString("y").trim());
                x0.add(json.getString("x0fondo").trim());
                y0.add(json.getString("y0fondo").trim());
                x1.add(json.getString("x1fondo").trim());
                y1.add(json.getString("y1fondo").trim());
            }



        }catch (JSONException e ){
            e.printStackTrace();
        }

        for (int i = 0;i<colorLetra1.size();i++){
            cadena += checkTipoMensaje.get(i) + "-" +  checkTipo.get(i) + "-" +  "N" + "-" + checkTipoIngreso.get(i) + "-" + colorLetra1.get(i) + "-" +
                    colorLetra2.get(i) + "-" + colorLetra3.get(i) + "-" + checkTamaño.get(i) + "-" + colorFondo1.get(i) + "-"
                    + colorFondo2.get(i) + "-" + colorFondo3.get(i) + "-" + brillo.get(i) + "-" + velocidad.get(i) + "-" + "N"
                    + "-" + texto.get(i).toString().trim() + "-" + x.get(i).toString().trim() + "-" + y.get(i).toString().trim() + "-"
                    +  x0.get(i).toString().trim() + "-" + y0.get(i).toString().trim() + "-"  + x1.get(i).toString().trim() + "-"
                    + y1.get(i).toString().trim() + "-";
        }


        if (colorLetra1.size()==1){
            for (int i = 0;i<2;i++){
                cadena += "1" + "-" +  "1" + "-" +  "N" + "-" + "1" + "-" + "1" + "-" +
                        "1" + "-" + "1" + "-" + "1" + "-" + "1" + "-"
                        + "1" + "-" + "1" + "-" + "1" + "-" + "1" + "-" + "N"
                        + "-" + "1" + "-" + "1" + "-" + "1" + "-"
                        +  "1" + "-" +"1" + "-"  + "1" + "-"
                        + "1" + "-";
            }
        }

        if (colorLetra1.size()==2){
            for (int i = 0;i<1;i++){
                cadena += "1" + "-" +  "1" + "-" +  "N" + "-" + "1" + "-" + "1" + "-" +
                        "1" + "-" + "1" + "-" + "1" + "-" + "1" + "-"
                        + "1" + "-" + "1" + "-" + "1" + "-" + "1" + "-" + "N"
                        + "-" + "1" + "-" + "1" + "-" + "1" + "-"
                        +  "1" + "-" +"1" + "-"  + "1" + "-"
                        + "1" + "-";
            }
        }


        cadena += "*";


        System.out.println("ESTA ES LA CADENA FINAL");
        System.out.println(cadena);

        String url1 = "http://" + ip + "/MATRIXInsertarTeensy.php";

        List<NameValuePair> params1 = new ArrayList<NameValuePair>();
        params1.add(new BasicNameValuePair("sString",cadena + "."));
        params1.add(new BasicNameValuePair("sCodigo",codigo));
        String resultServer1  = getHttpPost(url1,params1);
        System.out.println(resultServer1);

        Toast.makeText(Titulo.this, "si", Toast.LENGTH_SHORT).show();
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
