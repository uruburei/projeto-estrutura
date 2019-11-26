package Estrutura.BibliotecaProjeto;
import static spark.Spark.*;
import biblioteca.controler.ClienteControler;
import biblioteca.controler.LivroControler;

public class App 
{
    public static void main( String[] args )
    {
        port(3333);
        //Criar Cliente
        post("/cliente", (req, res) ->{res.type("application/json"); return ClienteControler.criarCliente(req);});
        //Procurar Cliente(cpf)
        post("/cliente/login", (req, res) ->{res.type("application/json"); return ClienteControler.procurarCliente(req);});
        //Atualizar Cliente(cpf)
        put("/cliente", (req, res) ->{res.type("application/json"); return ClienteControler.atualizarCliente(req);});

        //Listar Livro
        get("/livro", (req, res) ->{res.type("application/json"); return LivroControler.listaLivros(req);});
        //Criar Livro
        post("/livro", (req, res) ->{res.type("application/json"); return LivroControler.criarLivro(req);});
        //Procurar Livro(nome)
        get("/livro/:nome", (req, res) ->{res.type("application/json"); return LivroControler.procurarLivro(req);});
        //Ordenar Livros
        get("/livro/orde/",(req, res) ->{res.type("application/json"); return LivroControler.ordenarLista(req);});
    }
}
