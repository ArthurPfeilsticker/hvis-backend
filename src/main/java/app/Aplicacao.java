package app;

import static spark.Spark.*;
import service.UsuarioService;


public class Aplicacao {
	
	private static UsuarioService usuarioService = new UsuarioService();
	
    public static void main(String[] args) {
        port(6789);
        
        staticFiles.location("/public");
        
        get("/usuario", (request, response) -> usuarioService.list(request, response));
        
        post("/usuario", (request, response) -> usuarioService.insert(request, response));
        
        get("/usuario/:id", (request, response) -> usuarioService.get(request, response));
         
        post("/login", (request, response) -> usuarioService.login(request, response));
        
        delete("/usuario/:id", (request, response) -> usuarioService.delete(request, response));

    }
}