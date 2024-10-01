package co.vinni.soapproyectobase.utilidades;

import java.io.*;
import java.util.List;

public class UtilidadArchivos {
    public static boolean guardar(String archivo, List objeto){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(objeto);
        } catch (IOException e) {
            return false;
        }
        return true;

    }
    public static Object obtener(String archivo){
        Object objetoCOnsultado;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
            objetoCOnsultado = ois.readObject();
            return objetoCOnsultado;
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static void modificar(String archivo, List objetoModificado) {
        guardar(archivo, objetoModificado);
    }

    public static void eliminar(String archivo, long cedula) {

    }
}
