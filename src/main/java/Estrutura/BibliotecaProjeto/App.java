package Estrutura.BibliotecaProjeto;
import static spark.Spark.*;
import biblioteca.controler.ClienteControler;

public class App 
{
    public static void main( String[] args )
    {
        port(3333);
        //Criar Cliente
        post("/client", (req, res) ->{res.type("application/json"); return ClienteControler.criarCliente(req);});
        //Procurar Cliente(cpf)
        post("/client/login", (req, res) ->{res.type("application/json"); return ClienteControler.indexCliente(req);});
        //Atualizar Cliente(cpf)
        put("/client", (req, res) ->{res.type("application/json"); return ClienteControler.atualizarCliente(req);});


    }
}
