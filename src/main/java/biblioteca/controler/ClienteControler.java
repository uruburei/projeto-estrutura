package biblioteca.controler;
import biblioteca.model.*;
import biblioteca.service.Banco;
import biblioteca.util.lista.*;
import biblioteca.util.arvore.*;
import com.google.gson.Gson;
import spark.Request;

import java.io.File;


public class ClienteControler {
	static public String path = ".\\Lista.txt";

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
			//Node2<Cliente> clientNote = new Node2<>(cliente);
			tree.add(cliente);
			tree.view();
			Banco.serializar(tree,path);
			return new Gson().toJson(cliente);
		}catch (Exception err) {
			String status = "Erro";
			return new Gson().toJson(status);
		}
	}

	public static String removerCliente(Request req){
		try{
			Arvore<Cliente> tree = (Arvore<Cliente>) Banco.deserializar(path);
			Cliente body = new Gson().fromJson(req.body(),Cliente.class);
			/*Node<Cliente> aux = list.primeiro;
			int i = 0;
			while(aux.getProximo() != null) {
				i++;
				if(aux.getAtual().getCpf().equals(body.getCpf())) {
					break;
				}
				aux = aux.getProximo();
			}*/
			tree.remove(body);
			Banco.serializar(tree,path);
			String status = "OK";
			return new Gson().toJson(status);
		}catch (Exception err){
			err.printStackTrace();
			String status = "Erro";
			return new Gson().toJson(status);
		}

	}
	
	

}
