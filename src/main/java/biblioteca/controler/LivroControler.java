package biblioteca.controler;
import biblioteca.service.Banco;
import com.google.gson.Gson;
import spark.Request;

import java.io.File;

import biblioteca.model.Livro;
import biblioteca.util.lista.Lista;


public class LivroControler {
    static public String path = ".\\Livros.txt";

    public static String criarLivro(Request req){
        try{
            Lista<Livro> list;

            File x = new File(path);
            if(x.isFile()){
                list = (Lista<Livro>) Banco.deserializar(path);
            }else {
                list = new Lista<>();
            }

            Livro livro = new Gson().fromJson(req.body(),Livro.class);
            list.inserirNocomeco(livro);
            Banco.serializar(list,path);
            return new Gson().toJson(livro);
        }catch (Exception err){
            err.printStackTrace();
            String status = "Erro";
            return new Gson().toJson(status);
        }
    }

    public static String procurarLivro(Request req){
        try{
            Lista<Livro> list = (Lista<Livro>) Banco.deserializar(path);
            Livro found = (Livro) list.pesquisarElemento(req.params("nome"));
            if(found != null){
                return new Gson().toJson(found);
            }else {
                String status = "Livro não existe";
                return new Gson().toJson(status);
            }
        }catch (Exception err){
            err.printStackTrace();
            String status = "Erro";
            return new Gson().toJson(status);
        }
    }

    public static String listaLivros(Request req){
        try{
            Lista<Livro> list = (Lista<Livro>) Banco.deserializar(path);
            return new Gson().toJson(list);
        }catch (Exception err){
            err.printStackTrace();
            String status = "Erro";
            return new Gson().toJson(status);
        }
    }

    public static String ordenarLista(Request req){
        try{
            Lista<Livro> list = (Lista<Livro>) Banco.deserializar(path);
            list.ordenarLista();
            return new Gson().toJson(list);
        }catch (Exception err){
            err.printStackTrace();
            String status = "Erro";
            return new Gson().toJson(status);
        }
    }
}
