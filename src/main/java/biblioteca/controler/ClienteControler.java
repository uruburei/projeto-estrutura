package biblioteca.controler;
import biblioteca.model.*;
import biblioteca.service.Banco;
import biblioteca.util.arvore.*;
import com.google.gson.Gson;
import spark.Request;

import java.io.File;


public class ClienteControler {

	static public String path = ".\\Clientes.txt";

	public static String criarCliente(Request req) {
		try{
			Arvore<Cliente> tree;

			File x = new File(path);
			if(x.isFile()){
				tree = (Arvore<Cliente>) Banco.deserializar(path);
			}else {
				tree = new Arvore();
			}

			Cliente cliente = new Gson().fromJson(req.body(),Cliente.class);

			tree.add(cliente);
			Banco.serializar(tree,path);
			return new Gson().toJson(cliente);
		}catch (Exception err) {
			err.printStackTrace();
			String status = "Erro";
			return new Gson().toJson(status);
		}
	}

	public static String procurarCliente(Request req){
		try{
			Arvore<Cliente> tree = (Arvore<Cliente>) Banco.deserializar(path);

			Cliente requisicao = new Gson().fromJson(req.body(),Cliente.class);

			tree.find(requisicao);
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

	public static String atualizarCliente(Request req){
		try {
			Arvore<Cliente> tree = (Arvore<Cliente>) Banco.deserializar(path);

			Cliente requisicao = new Gson().fromJson(req.body(),Cliente.class);
			tree.update(requisicao);

			tree.find(requisicao);
			if(tree.index != null) {
                Banco.serializar(tree,path);
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
	
	
}
