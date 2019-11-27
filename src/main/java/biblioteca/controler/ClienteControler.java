package biblioteca.controler;
import biblioteca.model.*;
import biblioteca.service.Banco;
import biblioteca.util.arvore.Arvore;
import biblioteca.util.lista.Lista;

import com.google.gson.Gson;
import spark.Request;

import java.io.File;


public class ClienteControler {

	static public String path = ".\\Clientes.txt";

	public static String criarCliente(Request req) {
		try{
			Lista<Cliente> list;

			File x = new File(path);
			if(x.isFile()){
				list = (Lista<Cliente>) Banco.deserializar(path);
			}else {
				list = new Lista();
			}

			Cliente cliente = new Gson().fromJson(req.body(),Cliente.class);

			list.inserirNocomeco(cliente);
			Banco.serializar(list,path);
			return new Gson().toJson(cliente);
		}catch (Exception err) {
			err.printStackTrace();
			String status = "Erro";
			return new Gson().toJson(status);
		}
	}

	public static String procurarCliente(Request req){
		try{
			Lista<Cliente> list = (Lista<Cliente>) Banco.deserializar(path);

			Cliente requisicao = new Gson().fromJson(req.body(),Cliente.class);

			Cliente found = (Cliente) list.pesquisarElemento(requisicao.toString());

			if(found != null) {
				return new Gson().toJson(found);
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
			Lista<Cliente> list = (Lista<Cliente>) Banco.deserializar(path);

			Cliente requisicao = new Gson().fromJson(req.body(),Cliente.class);
			list.atualizarLista(requisicao);

			Banco.serializar(list,path);

			return new Gson().toJson(list);
		}catch (Exception err){
			err.printStackTrace();
			String status = "Erro";
			return new Gson().toJson(status);
		}
	}
	
	
}
