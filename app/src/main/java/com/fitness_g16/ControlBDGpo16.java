package com.fitness_g16;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.Image;

public class ControlBDGpo16 {
    private DatabaseHelper DBHelper;
    private final Context context;
    private SQLiteDatabase db;
    private String[] camposRutina=new String [] {"IDRUTINA","TIEMPOPREPARACION","NOMBRERUTINA","DESCRIPCIONRUTINA","DURACION","CODIGOQR"};

    public ControlBDGpo16(Context ctx){
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);}

    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String BASE_DATOS = "db.s3db";
        private static final int VERSION = 1;
        public DatabaseHelper(Context context){super(context, BASE_DATOS, null, VERSION);}

        @Override
        public void onCreate(SQLiteDatabase db){
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
                db.execSQL("create table RUTINA(IDUSUARIO INT not null,IDRUTINA INT not null,TIEMPOPREPARACION INT,NOMBRERUTINA VARCHAR(20),DESCRIPCIONRUTINA VARCHAR(256),DURACION VARCHAR(5),CODIGOQR BLOB,constraint PK_RUTINA primary key (IDUSUARIO, IDRUTINA),foreign key (IDUSUARIO) references USUARIO (IDUSUARIO));");
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

    //Métodos para la tabla Rutina.

    public String insertar(Rutina rutina){
        String regInsertados="¡Rutina guardada correctamente!";
        long contador=0;
        ContentValues cv = new ContentValues();
        cv.put("IDRUTINA",rutina.getIdRutina());
        cv.put("TIEMPOPREPARACION",rutina.getTiempoPreparacion());
        cv.put("NOMBRERUTINA",rutina.getNombreRutina());
        cv.put("DESCRIPCIONRUTINA",rutina.getDescripcionRutina());
        cv.put("DURACION",rutina.getDuracion());
        //cv.put("CODIGOQR", rutina.getCodigoQR());
        contador=db.insert("RUTINA", null,cv);

        if(contador==-1 || contador==0){regInsertados= "Error al insertar el registro. Verifique la inserción, por favor";}

        return regInsertados;}

    public Rutina consultarRutina(int idRutina){
        String[] id = {String.valueOf(idRutina)};
        Cursor cursor = db.query("RUTINA", camposRutina, "IDRUTINA = ?", id, null, null, null);

        if(cursor.moveToFirst()){
            Rutina rutina = new Rutina();
            rutina.setIdRutina(cursor.getInt(0));
            rutina.setTiempoPreparacion(cursor.getInt(1));
            rutina.setNombreRutina(cursor.getString(2));
            rutina.setDescripcionRutina(cursor.getString(3));
            rutina.setDuracion(cursor.getString(4));
            //rutina.setCodigoQR(cursor.getBlob(5));
            return rutina;}else{return null;}}

    public String actualizar(Rutina rutina) {
        if(verificarIntegridad(rutina, 1)){
            String[] id = {String.valueOf(rutina.getIdRutina())};
            ContentValues cv = new ContentValues();
            cv.put("IDRUTINA",rutina.getIdRutina());
            cv.put("TIEMPO0PREPARACION",rutina.getTiempoPreparacion());
            cv.put("NOMBRERUTINA",rutina.getNombreRutina());
            cv.put("DESCRIPCIONRUTINA",rutina.getDescripcionRutina());
            cv.put("DURACION",rutina.getDuracion());
            //cv.put("CODIGORUTINA",rutina.getCodigoQR());
            db.update("RUTINA", cv, "IDRUTINA = ?", id);
            return "Registro actualizado correctamente";}
        else{return "La rutina "+rutina.getIdRutina()+" no existe";}}

    public String eliminar(Rutina rutina) {
        String regAfectados="Filas afectadas: ";
        int contador=0;
        //if(verificarIntegridad(rutina,2)){
            contador+=db.delete("RUTINA", "IDRUTINA='"+rutina.getIdRutina()+"'", null);
        //}
        regAfectados+=contador;
        return regAfectados;}

    private boolean verificarIntegridad(Object dato, int relacion) throws SQLException{
        switch(relacion){
            case 1:{//Verificar que exista la rutina para poder actualizarla.
                Rutina rutina = (Rutina)dato;
                String[] id = {String.valueOf(rutina.getIdRutina())};
                abrir();
                Cursor c = db.query("RUTINA", null, "IDRUTINA = ?", id, null, null,null);
                if(c.moveToFirst()){
                    //Se encontró la reservación.
                    return true;}
                return false;}
            default:
                return false;}}

    public String LlenarBDGpo16(){
        abrir();
        //Código de llenado.
        cerrar();
        return "Guardó correctamente";}}
