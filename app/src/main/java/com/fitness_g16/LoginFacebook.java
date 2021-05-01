package com.fitness_g16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class LoginFacebook extends AppCompatActivity {

    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login_facebook);
        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");

        // Callback registration
        loginButton.registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult){Toast.makeText(LoginFacebook.this, "Registrado correctamente", Toast.LENGTH_SHORT).show();}

                    @Override
                    public void onCancel(){Toast.makeText(LoginFacebook.this, "Operación cancelada", Toast.LENGTH_SHORT).show();}

                    @Override
                    public void onError(FacebookException exception){Toast.makeText(LoginFacebook.this, "Hay un problema con el Registro", Toast.LENGTH_SHORT).show();}});

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult){
                        Toast.makeText(LoginFacebook.this, "Sesión iniciada correctamente", Toast.LENGTH_SHORT).show();
                        irAMenu();}

                    private void irAMenu(){
                        Intent intent=new Intent(LoginFacebook.this,MainActivity.class);
                        finish();
                        startActivity(intent);}

                    protected void onActivityResult(int requestCode, int resultCode,Intent data){
                        LoginFacebook.super.onActivityResult(requestCode,resultCode,data);
                        callbackManager.onActivityResult(requestCode,resultCode,data);}

                    @Override
                    public void onCancel(){Toast.makeText(LoginFacebook.this, "Operación cancelada", Toast.LENGTH_SHORT).show();}

                    @Override
                    public void onError(FacebookException exception){Toast.makeText(LoginFacebook.this, "Hay un problema con el Inicio de sesión", Toast.LENGTH_SHORT).show();}});}}