package com.fitness_g16;

import android.app.Application;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

public class ConectorFacebook extends Application {

    //Autor de la clase: CN18006;
    /*
    *Esta clase sirve para conectar el comportamiento de las actividades con la API de Facebook.
    * */

    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);}}