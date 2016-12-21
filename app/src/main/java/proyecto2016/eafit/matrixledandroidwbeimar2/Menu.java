package proyecto2016.eafit.matrixledandroidwbeimar2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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

public class Menu extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String ip;
    String codigo;
    String empresa;
    String sucursal;
    String usuario;
    String clave;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Bundle bundle = this.getIntent().getExtras();

        ip = bundle.getString("ip");
        clave = bundle.getString("clave");
        codigo = bundle.getString("codigo");
        empresa = bundle.getString("empresa");
        sucursal = bundle.getString("sucursal");
        usuario = bundle.getString("usuario");



        // Spinner element
        spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        String url = "http://"+ ip + "/MATRIXConsultarLogin.php";

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("sUsuario", usuario));
        params.add(new BasicNameValuePair("sParametro", "codigos"));
        String resultServer  = getHttpPost(url,params);
        System.out.println(resultServer);
        List<String> codigos = new ArrayList<String>();
        try {

            JSONArray jArray = new JSONArray(resultServer);
            ArrayList<String> array = new ArrayList<String>();
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json = jArray.getJSONObject(i);
                array.add(json.getString("codigo"));
            }

            for (int i =0;i< array.size();i++){
                codigos.add(array.get(i).trim());
            }
        }catch (JSONException e ){
            e.printStackTrace();
        }

        codigos.add("NUEVA");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, codigos);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void titulo(View v){
        Bundle bundle = new Bundle();
        bundle.putString("ip", ip);
        bundle.putString("codigo", spinner.getSelectedItem().toString().trim());
        bundle.putString("empresa", empresa);
        bundle.putString("sucursal", sucursal);
        bundle.putString("clave", clave);
        bundle.putString("usuario", usuario);
        bundle.putString("parametro", "TITULO");
        Intent i = new Intent(Menu.this,Titulo.class);
        i.putExtras(bundle);
        startActivity(i);
    }

    public void cuerpo(View v){
        Bundle bundle = new Bundle();
        bundle.putString("ip", ip);
        bundle.putString("codigo", spinner.getSelectedItem().toString().trim());
        bundle.putString("empresa", empresa);
        bundle.putString("sucursal", sucursal);
        bundle.putString("clave", clave);
        bundle.putString("usuario", usuario);
        bundle.putString("parametro", "CUERPO");
        Intent i = new Intent(Menu.this,Titulo.class);
        i.putExtras(bundle);
        startActivity(i);
    }

    public void pie(View v){
        Bundle bundle = new Bundle();
        bundle.putString("ip", ip);
        bundle.putString("codigo", spinner.getSelectedItem().toString().trim());
        bundle.putString("empresa", empresa);
        bundle.putString("sucursal", sucursal);
        bundle.putString("clave", clave);
        bundle.putString("usuario", usuario);
        bundle.putString("parametro", "PIE");
        Intent i = new Intent(Menu.this,Titulo.class);
        i.putExtras(bundle);
        startActivity(i);
    }

    public void guardarConfiguracion(View v){
        final String[] text = {""};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Title");

// Set up the input
        final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        builder.setView(input);

// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                text[0] = input.getText().toString();
                Toast.makeText(Menu.this, text[0], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();


    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first

        // Spinner element
        spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        String url = "http://"+ ip + "/MATRIXConsultarLogin.php";

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("sUsuario", usuario));
        params.add(new BasicNameValuePair("sParametro", "codigos"));
        String resultServer  = getHttpPost(url,params);
        System.out.println(resultServer);
        List<String> codigos = new ArrayList<String>();
        try {

            JSONArray jArray = new JSONArray(resultServer);
            ArrayList<String> array = new ArrayList<String>();
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json = jArray.getJSONObject(i);
                array.add(json.getString("codigo"));
            }

            for (int i =0;i< array.size();i++){
                codigos.add(array.get(i).trim());
            }
        }catch (JSONException e ){
            e.printStackTrace();
        }

        codigos.add("NUEVA");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, codigos);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

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
