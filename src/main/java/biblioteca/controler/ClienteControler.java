package biblioteca.controler;
import biblioteca.model.*;
import biblioteca.service.Banco;
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

			list.pesquisarElemento(requisicao);
			if(list.index != null) {
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

	public static String atualizarCliente(int posicao, Request req){
		try {
			Lista<Cliente> list = (Lista<Cliente>) Banco.deserializar(path);

			Cliente requisicao = new Gson().fromJson(req.body(),Cliente.class);
			list.atializarLista(posicao,requisicao);

                Banco.serializar(list,path);
				return new Gson().toJson(list);

		}catch (Exception err){
			err.printStackTrace();
			String status = "Erro";
			return new Gson().toJson(status);
		}
	}
	
	
}
