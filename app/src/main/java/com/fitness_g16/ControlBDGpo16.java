package com.fitness_g16;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ControlBDGpo16 {
    private DatabaseHelper DBHelper;
    private final Context context;
    private SQLiteDatabase db;

    public ControlBDGpo16(Context ctx){
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);}

    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String BASE_DATOS = "db.s3db";
        private static final int VERSION = 1;
        public DatabaseHelper(Context context) {
            super(context, BASE_DATOS, null, VERSION);}

        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL("drop index if exists CONTIENE_3_FK;");
                db.execSQL("drop index if exists CONTIENE_2_FK;");
                db.execSQL("drop table if exists CONTIENE_2;");
                db.execSQL("drop table if exists CONVERSACION;");
                db.execSQL("drop index if exists CONTIENE_FK;");
                db.execSQL("drop table if exists DIA;");
                db.execSQL("drop table if exists EJERCICIO;");
                db.execSQL("drop index if exists ESTA2_FK;");
                db.execSQL("drop index if exists ESTA_FK;");
                db.execSQL("drop table if exists ESTA;");
                db.execSQL("drop table if exists GRUPO;");
                db.execSQL("drop index if exists TIENE_FK;");
                db.execSQL("drop table if exists HORARIO;");
                db.execSQL("drop index if exists MANTIENE2_FK;");
                db.execSQL("drop index if exists MANTIENE_FK;");
                db.execSQL("drop table if exists MANTIENE;");
                db.execSQL("drop index if exists ESTA_COMPUESTA_FK;");
                db.execSQL("drop table if exists MENSAJE;");
                db.execSQL("drop index if exists CAEN_EN_FK;");
                db.execSQL("drop index  if exists CORRESPONDE_A_FK;");
                db.execSQL("drop table  if exists NOTIFICACION;");
                db.execSQL("drop index  if exists TIENE_3_FK;");
                db.execSQL("drop table if exists TIENE_3;");
                db.execSQL("drop table  if exists RUTINA;");
                db.execSQL("drop table  if exists USUARIO;");
                db.execSQL("create table EJERCICIO(IDEJERCICIO int not null,TIEMPOACCION DATE, TIEMPODESCANSO DATE, NOMBREEJERCICIO VARCHAR(20),DESCRIPCIONEJERCICIO VARCHAR(256),constraint PK_EJERCICIO primary key (IDEJERCICIO));");
                db.execSQL("create table USUARIO(IDUSUARIO INT not null,NOMBREUSUARIO VARCHAR(15),CORREOELECTRONICO VARCHAR(90), CONTRASENA VARCHAR(15), NOMBRECOMPLETO VARCHAR(100),constraint PK_USUARIO primary key (IDUSUARIO));");
                db.execSQL("create table RUTINA(IDUSUARIO INT not null,IDRUTINA INT not null,TIEMPOPREPARACION INT,NOMBRERUTINA VARCHAR(20),DESCRIPCIONRUTINA VARCHAR(256),DURACION DATE,CODIGOQR BLOB,constraint PK_RUTINA primary key (IDUSUARIO, IDRUTINA),foreign key (IDUSUARIO) references USUARIO (IDUSUARIO));");
                db.execSQL("create table CONTIENE_2(IDEJERCICIO int not null,IDRUTINA int not null,constraint PK_CONTIENE_2 primary key (IDEJERCICIO, IDRUTINA), foreign key (IDEJERCICIO) references EJERCICIO (IDEJERCICIO),foreign key (IDRUTINA) references RUTINA (IDRUTINA));");
                db.execSQL("create index CONTIENE_2_FK on CONTIENE_2 (IDEJERCICIO ASC);");
                db.execSQL("create index CONTIENE_3_FK on CONTIENE_2 (IDRUTINA ASC);");
                db.execSQL("create table TIENE_3(IDRUTINA INT not null,IDUSUARIO INT not null,constraint PK_TIENE_3 primary key (IDRUTINA, IDUSUARIO),foreign key (IDRUTINA) references RUTINA (IDRUTINA),foreign key (IDUSUARIO) references USUARIO (IDUSUARIO));");
                db.execSQL("create index TIENE_3_FK on TIENE_3 (IDRUTINA ASC);");
                db.execSQL("create table CONVERSACION(IDCONVERSACION INT not null,constraint PK_CONVERSACION primary key (IDCONVERSACION));");
                db.execSQL("create table HORARIO(IDUSUARIO INT not null,IDHORARIO INT not null,constraint PK_HORARIO primary key (IDUSUARIO, IDHORARIO),foreign key (IDUSUARIO) references USUARIO (IDUSUARIO));");
                db.execSQL("create index TIENE_FK on HORARIO (IDUSUARIO ASC);");
                db.execSQL("create table DIA(IDUSUARIO INT not null,IDHORARIO INT not null,IDDIA INT not null,FECHADIA DATE,constraint PK_DIA primary key (IDUSUARIO, IDHORARIO, IDDIA),foreign key (IDUSUARIO, IDHORARIO) references HORARIO (IDUSUARIO, IDHORARIO));");
                db.execSQL("create index CONTIENE_FK on DIA (IDUSUARIO ASC,IDHORARIO ASC);");
                db.execSQL("create table GRUPO(IDGRUPO INT not null,constraint PK_GRUPO primary key (IDGRUPO));");
                db.execSQL("create table ESTA(IDUSUARIO INT not null,IDGRUPO INT not null,constraint PK_ESTA primary key (IDUSUARIO, IDGRUPO),foreign key (IDUSUARIO) references USUARIO (IDUSUARIO),foreign key (IDGRUPO) references GRUPO (IDGRUPO));");
                db.execSQL("create index ESTA_FK on ESTA (IDUSUARIO ASC);");
                db.execSQL("create index ESTA2_FK on ESTA (IDGRUPO ASC);");
                db.execSQL("create table MANTIENE(IDUSUARIO INT not null,IDCONVERSACION INT not null,constraint PK_MANTIENE primary key (IDUSUARIO, IDCONVERSACION),foreign key (IDUSUARIO) references USUARIO (IDUSUARIO),foreign key (IDCONVERSACION) references CONVERSACION (IDCONVERSACION));");
                db.execSQL("create index MANTIENE_FK on MANTIENE (IDUSUARIO ASC);");
                db.execSQL("create index MANTIENE2_FK on MANTIENE (IDCONVERSACION ASC);");
                db.execSQL("create table MENSAJE(IDMENSAJE INTEGER not null,IDCONVERSACION INT,CONTENIDO text,constraint PK_MENSAJE primary key (IDMENSAJE),foreign key (IDCONVERSACION) references CONVERSACION (IDCONVERSACION));");
                db.execSQL("create index ESTA_COMPUESTA_FK on MENSAJE (IDCONVERSACION ASC);");
                db.execSQL("create table NOTIFICACION(IDNOTIFICACION INT not null,IDUSUARIO INT,IDRUTINA INT,IDHORARIO INT,IDDIA INT,HORA VARCHAR(5),constraint PK_NOTIFICACION primary key (IDNOTIFICACION),foreign key (IDUSUARIO, IDHORARIO, IDDIA) references DIA (IDUSUARIO, IDHORARIO, IDDIA),foreign key (IDRUTINA) references RUTINA (IDRUTINA));");
                db.execSQL("create index CORRESPONDE_A_FK on NOTIFICACION (IDRUTINA ASC);");
                db.execSQL("create index CAEN_EN_FK on NOTIFICACION (IDUSUARIO ASC,IDHORARIO ASC,IDDIA ASC);");}
            catch(Exception e){e.printStackTrace();} }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){}}

    public void abrir() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return;}

    public void cerrar(){DBHelper.close();}

    private boolean verificarIntegridad(Object dato, int relacion) throws SQLException{
        switch(relacion){
            //Verificación de integridad de CN18006 (del caso 1 al caso 13).
            case 1:{
                //Verificar que exista la reservación para poder actualizarla.
                //Reservacion reservacion = (Reservacion)dato;
                //String[] id = {String.valueOf(reservacion.getIdReservacion())};
                //abrir();
                //Cursor c = db.query("reservacion", null, "idReservacion = ?", id, null, null,null);
               // if(c.moveToFirst()){
                    //Se encontró la reservación.
                    //return true;}
                return false;}
            default:
                return false;}}

    public String LlenarBDGpo16(){
        abrir();
        //Código de llenado.
        cerrar();
        return "Guardó correctamente";}}
