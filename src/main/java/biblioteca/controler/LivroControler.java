package biblioteca.controler;
import biblioteca.model.*;
import biblioteca.service.Banco;
import biblioteca.util.lista.*;
import com.google.gson.Gson;
import spark.Request;

import java.io.File;

public class LivroControler {
	static public String path = ".\\Lista2.txt";

	
	public static String criarLivro(Request req) {
		try{
			Lista<Livro> lista;

			File x = new File(path);
			if(x.isFile()){
				lista = (Lista<Livro>) Banco.deserializar(path);
			}else {
				lista = new Lista();
			}

			Livro livro = new Gson().fromJson(req.body(),Livro.class);

			lista.inserirNocomeco(livro);
			Banco.serializar(lista,path);
			return new Gson().toJson(livro);
		}catch (Exception err) {
			err.printStackTrace();
			String status = "Erro";
			return new Gson().toJson(status);
		}
	}
	
}
