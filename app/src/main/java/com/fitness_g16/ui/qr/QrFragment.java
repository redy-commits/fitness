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

import com.fitness_g16.R;
import com.fitness_g16.qrscanner;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static com.facebook.FacebookSdk.getApplicationContext;

public class QrFragment  extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView escanerView;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_qr);
        Button qrbtn=(Button)findViewById(R.id.qrbtn);
    }
    public void EscanerQR(View view){
        escanerView=new ZXingScannerView(this);
setContentView(escanerView);
escanerView.setResultHandler(this);
escanerView.startCamera();
    }

    @Override

    public void handleResult(Result rawResult){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Resutaldo del scanner");
        builder.setMessage(rawResult.getText());
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
        escanerView.resumeCameraPreview(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        escanerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        escanerView.setResultHandler(this);
       escanerView.startCamera();
    }
}
