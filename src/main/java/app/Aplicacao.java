package app;

import static spark.Spark.*;
import service.UsuarioService;
import service.ProdutoService;


public class Aplicacao {
	
	private static UsuarioService usuarioService = new UsuarioService();
	private static ProdutoService produtoService = new ProdutoService();
	
    public static void main(String[] args) {
        port(6789);
        
        staticFiles.location("/public");
        
        get("/usuario", (request, response) -> usuarioService.list(request, response));
        
        post("/usuario", (request, response) -> usuarioService.insert(request, response));
        
        get("/usuario/:id", (request, response) -> usuarioService.get(request, response));
         
        post("/login", (request, response) -> usuarioService.login(request, response));
        
        put("/usuario/:id", (request, response) -> usuarioService.update(request, response));
        
        delete("/usuario/:id", (request, response) -> usuarioService.delete(request, response));
        
        get("/produto", (request, response) -> produtoService.list(request, response));
        
        post("/produto", (request, response) -> produtoService.insert(request, response));
        
        get("/produto/:id", (request, response) -> produtoService.get(request, response));
        
        delete("/produto/:id", (request, response) -> produtoService.delete(request, response));

    }
}