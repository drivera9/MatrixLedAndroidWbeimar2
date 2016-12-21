package proyecto2016.eafit.matrixledandroidwbeimar2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

public class Login extends Activity {

    EditText Ip;
    EditText usuario;
    EditText contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        FindViewById();
    }

    public void  FindViewById(){
        usuario = (EditText) findViewById(R.id.editUsuario);
        contraseña = (EditText) findViewById(R.id.editContrasena);
        Ip = (EditText) findViewById(R.id.ip);
    }



    public void ingresar(View v){



        String url = "http://"+ Ip.getText().toString() + "/MATRIXConsultarLogin.php";

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("sParametro", "login"));
        params.add(new BasicNameValuePair("sUsuario", usuario.getText().toString()));
        String resultServer  = getHttpPost(url,params);
        System.out.println(resultServer);
        String pass = "";
        String empresa = "";
        String sucursal = "";
        try {

            JSONArray jArray = new JSONArray(resultServer);
            ArrayList<String> array = new ArrayList<String>();
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json = jArray.getJSONObject(i);
                array.add(json.getString("clave"));
                array.add(json.getString("empresa"));
                array.add(json.getString("sucursal"));

            }
            pass = array.get(0).trim();
            empresa = array.get(1).trim();
            sucursal = array.get(2).trim();
        }catch (JSONException e ){
            e.printStackTrace();
        }

        if (pass.equals(contraseña.getText().toString())){
            Bundle bundle = new Bundle();
            bundle.putString("ip", Ip.getText().toString());
            bundle.putString("usuario", usuario.getText().toString());
            bundle.putString("clave", pass.trim().toString());
            bundle.putString("empresa", empresa);
            bundle.putString("sucursal", sucursal);
            Intent i = new Intent(Login.this,Menu.class);
            i.putExtras(bundle);
            startActivity(i);
        }else{
            Toast.makeText(Login.this, "Contraseña incorrecta , Intentelo de nuevo!", Toast.LENGTH_SHORT).show();
        }
    }

    public void cancelar(View v){
        finish();
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
