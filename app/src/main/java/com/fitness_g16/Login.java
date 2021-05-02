package com.fitness_g16;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

//Autor/es de la clase: CN18006;
/*
 *Esta clase sirve hacer el inicio de sesión de Facebook, vía correo electrónico y vía cuenta de Google.
 * */
public class Login extends AppCompatActivity {

    //Variables globales que sirven para manejar el inicio de sesión de Facebook.
    private LoginButton loginFacebook;
    private CallbackManager callbackManager=CallbackManager.Factory.create();;
    private View view;

    //Método de Facebook ajustado para este caso particular.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);}

        //Método que genera la pantalla y provee la mayor parte del comportamiento de la misma.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
        loginFacebook = (LoginButton)findViewById(R.id.login_button);
        loginFacebook.setReadPermissions("email");
        loginFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            //En caso de un inicio de sesión correcto.
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(view.getContext(), "Has iniciado sesión correctamente", Toast.LENGTH_SHORT).show();
                return;}

                //En caso de que vuelva al menú de inicio de sesión.
            @Override
            public void onCancel() {
                Toast.makeText(view.getContext(), "Operación cancelada", Toast.LENGTH_SHORT).show();
                return;}

                //En caso de que suceda un error inesperado.
            @Override
            public void onError(FacebookException error) {
                Toast.makeText(view.getContext(), "", Toast.LENGTH_SHORT).show();
                return;}});}}