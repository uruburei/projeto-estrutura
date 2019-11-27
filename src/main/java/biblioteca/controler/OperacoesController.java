package biblioteca.controler;

import biblioteca.model.Cliente;
import biblioteca.model.Livro;
import biblioteca.service.Banco;
import biblioteca.util.arvore.Arvore;
import biblioteca.util.lista.Lista;
import com.google.gson.Gson;
import spark.Request;

import java.util.ArrayList;

public class OperacoesController {
    static public String livrospath = ".\\Livros.txt";
    static public String clientespath = ".\\Clientes.txt";

    public static String alugarLivro(Request req){
        try{
            Arvore<Livro> livros = (Arvore<Livro>) Banco.deserializar(livrospath);
            Lista<Cliente> clientes = (Lista<Cliente>) Banco.deserializar(clientespath);

            Cliente requisicao = new Gson().fromJson(req.body(),Cliente.class);
            Cliente found = (Cliente) clientes.pesquisarElemento(requisicao.toString());

            livros.find(req.params("nome"));
            ArrayList listaCliente = new ArrayList();
            listaCliente.add(livros.index);
            livros.deleteKey(req.params("nome"));

            found.alugarLivro(listaCliente);
            if(found != null) {
                Banco.serializar(clientes,clientespath);
                Banco.serializar(livros,livrospath);
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

    public static String removerLivro(Request req){
        try{
            Arvore<Livro> livros = (Arvore<Livro>) Banco.deserializar(livrospath);
            Lista<Cliente> clientes = (Lista<Cliente>) Banco.deserializar(clientespath);
            Cliente requisicao = new Gson().fromJson(req.body(),Cliente.class);
            Cliente found = (Cliente) clientes.pesquisarElemento(requisicao.toString());

            found.livros2.forEach(livro -> {
                if (livro.toString().equals(req.params("nome"))) {
                    livros.add((Livro) livro);
                }
            });
            livros.find(req.params("nome"));
            found.livros2.remove(livros.index);
            Banco.serializar(livros,livrospath);
            Banco.serializar(clientes,clientespath);
            return new Gson().toJson(found);
        }catch (Exception err){
            err.printStackTrace();
            String status = "Erro";
            return new Gson().toJson(status);
        }
    }
}
