package biblioteca.controler;
import biblioteca.model.*;
import biblioteca.util.lista.*;
import spark.Request;


public class ClienteControler {
	Lista<Livro> l1= new Lista<Livro>();
	
	public static String ciarCliente(Request req) {
		return "ok";
	}

}
