package com.fitness_g16;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;
import com.facebook.AccessToken;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
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

public class MainActivity extends AppCompatActivity{

    //Autor del comentario: CN18006;
    //Única variable global hasta el momento, sospecho que sirve para controlar el menú de navegación. Esta variable se creó junto con el
    //proyecto de manera predeterminada.
    private AppBarConfiguration mAppBarConfiguration;

    //Autor del comentario: CN18006;
    /*
    * Método principal de la clase, acá se encuentra el código que permite ejecutar y controlar el resto de las actividades de la
    * aplicación.
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Autor del comentario: CN18006;
        /*
         * Esta sección del código sirve para controlar que el usuario de la aplicación tenga una sesión activa antes de utilizar todas las
         * funciones de la aplicación.
         * */
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();

        if(isLoggedIn){
            //Si queda tiempo, agregar un listado de frases para que no aparezca el mismo texto siempre (requerimiento no funcional).
            Toast.makeText(this,"Bienvenido/a",Toast.LENGTH_SHORT).show();}
        else{
            irALogin();
            Toast.makeText(this,"Primero tienes que iniciar sesión",Toast.LENGTH_SHORT).show();}
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
    private void irALogin(){
        Intent intent = new Intent(MainActivity.this,Login.class);
        startActivity(intent);}

    //Autor del comentario: CN18006;
    //Los siguientes dos métodos fueron generados automáticamente en la creación del proyecto, y me es de poco interés conocer para qué se
    // están usando.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;}

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();}}