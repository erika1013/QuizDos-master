package com.jonmid.quizdos.Fragments;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jonmid.quizdos.Adapter.AdapterUserModelReyesErika;
import com.jonmid.quizdos.Coneccion.HttpManagerErikaReyes;
import com.jonmid.quizdos.Models.UserModelReyesErika;
import com.jonmid.quizdos.Parser.JsonUserModelReyesErika;
import com.jonmid.quizdos.R;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends AppCompatActivity {

    ProgressBar progressBar;
    RecyclerView recyclerView;
    List<UserModelReyesErika> userList;
    AdapterUserModelReyesErika adapterusuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_user);

        progressBar = (ProgressBar) findViewById(R.id.id_pb_item_user);

        recyclerView = (RecyclerView) findViewById(R.id.id_rv_item_user);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    // Metodo para validar la conexion a internet
    public Boolean isOnLine(){
        // Hacer llamado al servicio de conectividad utilizando el ConnectivityManager
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        // Obtener el estado de la conexion a internet en el dispositivo
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        // Validar el estado obtenido de la conexion
        if (networkInfo != null){
            return true;
        }else {
            return false;
        }
    }

    public void loadData(View view){
        if (isOnLine()){
            TaskUsuarios taskCountry = new TaskUsuarios();
            taskCountry.execute("https://jsonplaceholder.typicode.com/users");
        }else {
            Toast.makeText(this, "Sin conexion", Toast.LENGTH_SHORT).show();
        }
    }

    public void processData(){
        //adapterCountry = new AdapterCountry(countryList, getApplicationContext());
        //recyclerView.setAdapter(adapterCountry);
        adapterusuarios= new AdapterUserModelReyesErika(userList, getApplicationContext());
        recyclerView.setAdapter(adapterusuarios);
    }

    public class TaskUsuarios extends AsyncTask<String, String, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            String content = null;
            try {
                content = HttpManagerErikaReyes.getData(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                //countryList = JsonCountry.getData(s);
                userList = JsonUserModelReyesErika.getData(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            processData();

            progressBar.setVisibility(View.GONE);
        }
    }
}
