package com.fitness_g16;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Set;

public class Bluetooth extends AppCompatActivity {
    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVER_BT = 1;

    TextView mStatusBlueTv, mPairedTv;
    ImageView mBlueIv;
    Button mOnBtn, mOffBtn, mDiscoverBtn, mPairedBtn;

    BluetoothAdapter mBlueAdapter;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        mStatusBlueTv   = findViewById(R.id.statusBluetoothTv);
        mPairedTv       = findViewById(R.id.pairedTv);
        mBlueIv         = findViewById(R.id.bluetoothIv);
        mOnBtn          = findViewById(R.id.onBtn);
        mOffBtn         = findViewById(R.id.offBtn);
        mDiscoverBtn    = findViewById(R.id.discoverableBtn);
        mPairedBtn      = findViewById(R.id.pairedBtn);

        //adapter
        mBlueAdapter = BluetoothAdapter.getDefaultAdapter();

        //verifica si el bluetooth está disponible o no
        if(mBlueAdapter==null){
            mStatusBlueTv.setText("Bluetooth no esta disponible");
        }
        else{
            mStatusBlueTv.setText("Bluetooth esta disponible");
        }

        //coloca una imagen acorde al estado del bluetooth (encendido/apagado)
        if (mBlueAdapter.isEnabled()){
            mBlueIv.setImageResource(R.drawable.ic_action_on);
        }
        else{
            mBlueIv.setImageResource(R.drawable.ic_action_off);
        }

        //click en botón encender
        mOnBtn.setOnClickListener(v -> {
            if(!mBlueAdapter.isEnabled()){
                showToast("Encendiendo Bluetooth...");
                //intent to on bluetooth
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(intent,REQUEST_ENABLE_BT);
            }
            else{
                showToast("Bluetooth ya esta encendido");
            }
        });

        //botón de bluetooth reconocible
        mDiscoverBtn.setOnClickListener(v -> {
            if(!mBlueAdapter.isDiscovering()){
                showToast("Haciendo que tu dispositivo sea reconocible");
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                startActivityForResult(intent,REQUEST_DISCOVER_BT);
            }
        });

        //click en botón apagar
        mOffBtn.setOnClickListener(v -> {
            if(mBlueAdapter.isEnabled()){
                mBlueAdapter.disable();
                showToast("Apagando Bluetooth");
                mBlueIv.setImageResource(R.drawable.ic_action_off);
            }
            else{
                showToast("Bluetooth ya esta apagado");
            }
        });

        //click en botón para vincular dispositivos
        mPairedBtn.setOnClickListener(v -> {
            if(mBlueAdapter.isEnabled()){
                mPairedTv.setText("Dispositivos Vinculados");
                Set<BluetoothDevice> devices = mBlueAdapter.getBondedDevices();
                for (BluetoothDevice device: devices){
                    mPairedTv.append("\nDispositivo" + device.getName() + "," + device);
                }
            }
            else{
                //bluetooth está apagado así que no se pudo vincular dispositivos
                showToast("Encienda el Bluetooth para vincular los dispositivos");
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case REQUEST_ENABLE_BT:
                if (resultCode==RESULT_OK){
                    //bluetooth esta encendido
                    mBlueIv.setImageResource(R.drawable.ic_action_on);
                    showToast("Bluetooth esta encendido");
                }
                else{
                    //el usuario se rehusó a encender el bluetooth
                    showToast("No se pude encender el Bluetooth");
                }
                break;
        }
        super.onActivityResult(requestCode,resultCode,data);
    }

    //funcion de mensaje toast
    private void showToast(String mag) {
        Toast.makeText(this, mag, Toast.LENGTH_SHORT).show();
    }
}
