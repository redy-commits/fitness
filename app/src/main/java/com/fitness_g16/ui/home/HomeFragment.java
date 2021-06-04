package com.fitness_g16.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.fitness_g16.Cronometro;
import com.fitness_g16.Gimnasios;
import com.fitness_g16.R;
import com.fitness_g16.qrscanner;

import static com.facebook.FacebookSdk.getApplicationContext;

public class HomeFragment extends Fragment implements View.OnClickListener{

    //Declaración de variables.
    private ListView lv;
    private String [] nombres = {"Rutina 1","Rutina 2","Rutina 3","Rutina 4","Rutina 5","Rutina 6","Rutina 7","Rutina 8","Rutina 9","Rutina 10","Rutina 11","Rutina 12","Rutina 13","Rutina 14","Rutina 15","Rutina 16","Rutina 17","Rutina 18","Rutina 19","Rutina 20","Rutina 21","Rutina 22"};
    private ImageButton btnAgregar,btnCronometro,btnMapa, btnQr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        //Asignación de variables;
        View view=inflater.inflate(R.layout.fragment_home, container,false);
        btnAgregar= view.findViewById(R.id.btnAgregar);
        btnCronometro=view.findViewById(R.id.btnCronometro);
        btnQr=view.findViewById(R.id.btnQr);
        btnMapa=view.findViewById(R.id.btnMapa);
        btnQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent qr=new Intent(HomeFragment.this.getActivity(), qrscanner.class);
                startActivity(qr);
            }
        });
        btnCronometro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cronometro=new Intent(HomeFragment.this.getActivity(),Cronometro.class);
                startActivity(cronometro);
            }
        });
        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapa=new Intent(HomeFragment.this.getActivity(), Gimnasios.class);
                startActivity(mapa);
            }
        });
        btnAgregar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){Toast.makeText(getApplicationContext(), "Hola papu", Toast.LENGTH_SHORT).show();}});
        lv=(ListView)view.findViewById(R.id.lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.format_listview,nombres);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                //Ir a la pantalla para ver una rutina.
            }});
    return view;}



    @Override
    public void onClick(View v){}

}