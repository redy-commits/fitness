package com.fitness_g16;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

//Autor/es de la clase: CN18006;
/*
 *Esta clase sirve para dirigir el funcionamiento íntegro de la aplicación.
 * */
public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
Button qrbtn;

    //Autor del comentario: CN18006;
    //Sospecho que esta variable sirve para controlar el menú de navegación. Esta variable se creó junto con el proyecto de manera predeterminada.
    private AppBarConfiguration mAppBarConfiguration;

    //Variables globales para manejar la sesión de Google Mail.
    private GoogleApiClient googleApiClient;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    //Autor del comentario: CN18006;
    //Este método se ejecuta cuando se lanza la actividad.
    @Override
    protected void onStart(){
        super.onStart();
        firebaseAuth.addAuthStateListener(firebaseAuthListener);}

    //Autor del comentario: CN18006;
    //Este método se ejecuta justo después de que se finalice la actividad.
    @Override
    protected void onStop() {
        super.onStop();
        if(firebaseAuthListener!=null){
        firebaseAuth.removeAuthStateListener(firebaseAuthListener);}}

    //Autor del comentario: CN18006;
    /*
    * Método principal de la clase, acá se encuentra el código que permite ejecutar y controlar el resto de las actividades de la aplicación.
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qrbtn= findViewById(R.id.qrbtn);

           qrbtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   startActivity(new Intent(getApplicationContext(),qrscanner.class));
               }
           });
        //Autor del comentario: CN18006;
        //Declaración de variables relacionadas con el LogOut de Google Mail.
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuthListener= firebaseAuth -> {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if(user != null){
                //Obtener los datos del usuario.
            }};

        //Autor del comentario: CN18006;
        //Declaración de variables relacionadas con el LogIn silencioso de Google Mail.
        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient=new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();

        //Autor del comentario: CN18006;
        /*
         * Esta sección del código sirve para controlar que el usuario de la aplicación tenga una sesión activa antes de utilizar todas las
         * funciones de la aplicación.
         * */
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean loggedFacebook = accessToken != null && !accessToken.isExpired();

        if(loggedFacebook){
            //Si queda tiempo, agregar un listado de frases para que no aparezca el mismo texto siempre (requerimiento no funcional).
            Toast.makeText(this,"Bienvenido/a",Toast.LENGTH_SHORT).show();}
        else{
            OptionalPendingResult<GoogleSignInResult> opr=Auth.GoogleSignInApi.silentSignIn(googleApiClient);
            if(opr.isDone()){
                if(opr.get().isSuccess()){
                    Toast.makeText(this,"Bienvenido/a",Toast.LENGTH_SHORT).show();}}
            else{
               // irALogin();
                Toast.makeText(this,"Primero tienes que iniciar sesión",Toast.LENGTH_SHORT).show();}}
        //Fin de la sección señalada.

        //Autor del comentario: CN18006;
        /*
         * Esta sección del código fue generada de manera automática en la creación del proyecto, sospecho que sirve para enlazar todas las
         * pantallas con el menú de ítems del lateral izquierdo de la aplicación.
         * */
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();}});

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,R.id.login).setDrawerLayout(drawer).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);}
        //Fin de la sección señalada.

        //Autor del comentario: CN18006;
        // Método que envía al usuario a la pantalla de inicio de sesión si aún no ha iniciado sesión.
    //private void irALogin(){
      //  Intent intent = new Intent(MainActivity.this,Login.class);
        //finish();
        //startActivity(intent);}

    //Autor del comentario: CN18006;
    //Este método sirve para mandar al usuario a la actividad principal de la aplicación, actualmente se está usando para conocer si es necesario
    // que inicie sesión.
    private void irAMenu(){
        Intent intent = new Intent(MainActivity.this,MainActivity.class);
        finish();
        startActivity(intent);}

    //Autor del comentario: CN18006;
    //Este método sirve para controlar cuáles opciones del menú derecho debe ver el usuario según el proveedor de su cuenta.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean loggedFacebook = accessToken != null && !accessToken.isExpired();

        if(loggedFacebook){getMenuInflater().inflate(R.menu.main_facebook, menu);}
        else{
            OptionalPendingResult<GoogleSignInResult> opr=Auth.GoogleSignInApi.silentSignIn(googleApiClient);
            if(opr.isDone()){
                if(opr.get().isSuccess()){
                    getMenuInflater().inflate(R.menu.main_google, menu);}}}
        return true;}

    //Autor del comentario: CN18006;
    //Este método sirve para cerrar la sesión activa del usuario de Facebook.
    public void logOutFacebook(MenuItem item){
        LoginManager.getInstance().logOut();
        irAMenu();}

    //Autor del comentario: CN18006;
    //Este método sirve para cerrar la sesión activa del usuario de Google Mail.
    public void logOutGoogle(MenuItem item) {
        firebaseAuth.signOut();
        Auth.GoogleSignInApi.signOut(googleApiClient);
        irAMenu();}

    //Autor del comentario: CN18006;
    //Este método se generó de forma automática en la creación del proyecto y me es de poco interés conocer para qué se está usando.
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();}

    //Autor del comentario: CN18006;
    //Este método se ejecuta cuando ocurre un error durante el inicio de sesión con Google Mail.
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this, "HA OCURRIDO UN ERROR", Toast.LENGTH_SHORT).show();}}