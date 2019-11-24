package biblioteca.service;

import biblioteca.model.Cliente;
import biblioteca.util.lista.Lista;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Banco {
    static public String serializar(Object x,String path) {
        try {
            FileOutputStream fout = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(x);
            oos.close();
            return "OK";
        }catch(Exception ex) {
            ex.printStackTrace();
            return "ERRO";
        }
    }
    static public Object deserializar(String path) {
        try{
            FileInputStream fin = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fin);

            Object y = ois.readObject();
            ois.close();

            return y;
        }catch(Exception ex){
            ex.printStackTrace();
            return "Erro";
        }
    }
}
