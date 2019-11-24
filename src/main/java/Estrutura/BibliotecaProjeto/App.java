package Estrutura.BibliotecaProjeto;
import static spark.Spark.*;
import biblioteca.controler.ClienteControler;

public class App 
{
    public static void main( String[] args )
    {
        port(3333);
        post("/client", (req, res) ->{res.type("application/json"); return ClienteControler.criarCliente(req);});
        delete("/client", (req, res) ->{res.type("application/json"); return ClienteControler.removerCliente(req);});
    }
}
