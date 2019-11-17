package Estrutura.BibliotecaProjeto;
import static spark.Spark.*;
import biblioteca.controler.ClienteControler;

public class App 
{
    public static void main( String[] args )
    {
    	
        get("/hello", (req, res) -> ClienteControler.ciarCliente(req));
    }
}
