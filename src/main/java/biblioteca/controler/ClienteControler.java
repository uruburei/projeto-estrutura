package biblioteca.controler;
import biblioteca.model.*;
import biblioteca.service.Banco;
import biblioteca.util.lista.*;
import com.google.gson.Gson;
import spark.Request;

import java.io.File;


public class ClienteControler {
	static public String path = ".\\Lista.txt";

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
			Node<Cliente> clientNote = new Node<>(cliente);
			list.inserirNocomeco(clientNote);
			list.imprimirLista();
			Banco.serializar(list,path);
			return new Gson().toJson(cliente);
		}catch (Exception err) {
			String status = "Erro";
			return new Gson().toJson(status);
		}
	}

	public static String removerCliente(Request req){
		try{
			Lista<Cliente> list = (Lista<Cliente>) Banco.deserializar(path);
			Cliente body = new Gson().fromJson(req.body(),Cliente.class);
			Node<Cliente> aux = list.primeiro;
			int i = 0;
			while(aux.getProximo() != null) {
				i++;
				if(aux.getAtual().getCpf().equals(body.getCpf())) {
					break;
				}
				aux = aux.getProximo();
			}
			list.removerPosicao(i);
			Banco.serializar(list,path);
			String status = "OK";
			return new Gson().toJson(status);
		}catch (Exception err){
			err.printStackTrace();
			String status = "Erro";
			return new Gson().toJson(status);
		}

	}

}
