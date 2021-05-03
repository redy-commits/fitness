package com.fitness_g16;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//Autor/es de la clase: CN18006;
/*
 *Esta clase sirve hacer el inicio de sesión de Facebook, vía correo electrónico y vía cuenta de Google.
 * */
public class Login extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    //Constantes globales.
    private final static int CODE_GOOGLE=777;

    //Variables globales que sirven para manejar el inicio de sesión de Facebook.
    private LoginButton loginFacebook;
    private CallbackManager callbackManager=CallbackManager.Factory.create();

    //Variable globales que sirven para manejar el inicio de sesión de Google Mail.
    private GoogleApiClient googleApiClient;
    private SignInButton loginGoogle;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    //Este método se ejecuta cuando se lanza la actividad.
    @Override
    protected void onStart(){
        super.onStart();
        firebaseAuth.addAuthStateListener(firebaseAuthListener);}

        //Este método se ejecuta justo después de que se finalice la actividad.
        @Override
        protected void onStop() {
            super.onStop();
            firebaseAuth.removeAuthStateListener(firebaseAuthListener);}

        //Método que genera la pantalla y provee la mayor parte del comportamiento de la misma.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        //Declaración e inicialización de variables.
        //Para cerrar la sesión de Google Mail.
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser();
                if(user!=null){irAMenu();}}};

        //Para iniciar sesión con Google Mail.
        loginGoogle=(SignInButton)findViewById(R.id.loginGoogle);
        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();
        googleApiClient=new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();

        //Para iniciar sesión con Facebook
        loginFacebook = (LoginButton)findViewById(R.id.loginFacebook);
        loginFacebook.setReadPermissions("email");
        loginFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            //En caso de un inicio de sesión correcto con Facebook.
            @Override
            public void onSuccess(LoginResult loginResult) {
                irAMenu();
                return;}

                //En caso de que vuelva al menú de inicio de sesión.
            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "Operación cancelada", Toast.LENGTH_SHORT).show();
                return;}

                //En caso de que suceda un error inesperado.
            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), "No ha sido posible iniciar sesión, inténtalo de nuevo", Toast.LENGTH_SHORT).show();
                return;}});

        //En caso de un inicio de sesión correcto con Google Mail.
        loginGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent,CODE_GOOGLE);}});}

                //Este método se ejecuta cuando ocurre un error durante el inicio de sesión con Google Mail.
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(getApplicationContext(), "HA OCURRIDO UN ERROR", Toast.LENGTH_SHORT).show();}

    //Método para comprobar si se ha iniciado sesión en Google Mail o no.
    private void handleSignInResult(GoogleSignInResult result) {
        if(result.isSuccess()){
            Toast.makeText(getApplicationContext(), "Has iniciado sesión correctamente", Toast.LENGTH_SHORT).show();
            irAMenu();}
        else{Toast.makeText(getApplicationContext(), "No ha sido posible iniciar sesión, inténtalo de nuevo", Toast.LENGTH_SHORT).show();}}

        //Este método sirve para mandar al usuario a la actividad principal de la aplicación luego de haber iniciado sesión.
    private void irAMenu() {
        Intent intent = new Intent(Login.this,MainActivity.class);
        finish();
        startActivity(intent);}

    //Método para validar el inicio de sesión.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==CODE_GOOGLE){
                GoogleSignInResult result=Auth.GoogleSignInApi.getSignInResultFromIntent(data);
                handleSignInResult(result);}else{
                callbackManager.onActivityResult(requestCode,resultCode,data);}}}