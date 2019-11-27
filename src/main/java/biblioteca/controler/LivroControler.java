package biblioteca.controler;
import biblioteca.service.Banco;
import com.google.gson.Gson;
import spark.Request;

import java.io.File;

import biblioteca.model.Cliente;
import biblioteca.model.Livro;
import biblioteca.util.arvore.Arvore;


public class LivroControler {
    static public String path = ".\\Livros.txt";

    public static String criarLivro(Request req){
        try{
            Arvore<Livro> tree;

            File x = new File(path);
            if(x.isFile()){
                tree = (Arvore<Livro>) Banco.deserializar(path);
            }else {
                tree = new Arvore<>();
            }

            Livro livro = new Gson().fromJson(req.body(),Livro.class);
            tree.add(livro);
            Banco.serializar(tree,path);
            return new Gson().toJson(livro);
        }catch (Exception err){
            err.printStackTrace();
            String status = "Erro";
            return new Gson().toJson(status);
        }
    }

    public static String procurarLivro(Request req){
    	try{
			Arvore<Livro> tree = (Arvore<Livro>) Banco.deserializar(path);
            Livro livro = new Gson().fromJson(req.body(),Livro.class);
			tree.find(livro.getNome());
			if(tree.index != null) {
				return new Gson().toJson(tree.index);
			}else {
				String status = "Cliente não existe";
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
            Arvore<Livro> tree ;
            File x = new File(path);
            if(x.isFile()){
                tree = (Arvore<Livro>) Banco.deserializar(path);
            }else {
                tree = new Arvore<>();
            }
            tree.view();
            return new Gson().toJson(tree.formated);
        }catch (Exception err){
            err.printStackTrace();
            String status = "Erro";
            return new Gson().toJson(status);
        }
    }

    public static String ordenarLista(Request req){
        try{
            Arvore<Livro> tree = (Arvore<Livro>) Banco.deserializar(path);
            tree.inorderRec(tree.root);
            return new Gson().toJson(tree.sorted);
        }catch (Exception err){
            err.printStackTrace();
            String status = "Erro";
            return new Gson().toJson(status);
        }
    }

    
}
