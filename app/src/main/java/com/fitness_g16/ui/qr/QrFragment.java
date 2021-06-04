package com.fitness_g16.ui.qr;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.fitness_g16.Cronometro;
import com.fitness_g16.R;
import com.fitness_g16.qrscanner;
import com.fitness_g16.ui.home.HomeFragment;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static com.facebook.FacebookSdk.getApplicationContext;

public class QrFragment  extends Fragment {
    private ZXingScannerView escanerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_qr, container,false);
        Button btnQr=view.findViewById(R.id.btnQr);
        btnQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cronometro=new Intent(QrFragment.this.getActivity(), qrscanner.class);
                startActivity(cronometro);
            }
        });return view;
    }
}
