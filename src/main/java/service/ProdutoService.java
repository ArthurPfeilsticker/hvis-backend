package service;

import java.util.Scanner;
import java.util.Set;
import java.time.LocalDate;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import dao.ProdutoDAO;
import model.Produto;
import spark.Request;
import spark.Response;


public class ProdutoService {

	private ProdutoDAO produtoDAO = new ProdutoDAO();
	private String json;
	private final int GET_PRODUCT = 1;
	private final int INSERT_PRODUCT = 2;
	private final int DELETE_PRODUCT = 3;
	private final int UPDATE_PRODUCT = 4;
	private final int LIST_PRODUCT = 6;
	private final int ERROR_404 = 7;
	private final int ERROR_401 = 8;
	
	private boolean authMiddleware(Request request) {
		Set<String> headers = request.headers();
		if(headers.contains("Authorization")) {
			String authToken = request.headers("Authorization");
			return true;
		} else {
			makeJson(ERROR_401);
			return false;
		}
	}
	
	private void makeJson(int erro) {
		List<Produto> produtos = new ArrayList<Produto>();
		makeJson(erro, produtos);
	}
	
	private void makeJson(int tipo, List<Produto> produtos) {
		String nomeTemplate = "productJson.json";
		json = "";
		try {
			Scanner entrada = new Scanner(new File(nomeTemplate));
			while(entrada.hasNext()) {
				json += (entrada.nextLine() + "\n");
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		String msg = "";
		String productString = "";
		if(tipo == ERROR_401) {
			msg = "Não autorizado.";
			json = json.replaceFirst("%MESSAGE%", "\"" + msg + "\"");
			json = json.replaceFirst("%PRODUCTINFO%", productString);
		}
		else if(tipo == ERROR_404) {
			msg = "Não encontrado.";
			json = json.replaceFirst("%MESSAGE%", "\"" + msg + "\"");
			json = json.replaceFirst("%PRODUCTINFO%", productString);
		} else {
			Produto produto = produtos.get(0);
			switch(tipo) {
			case GET_PRODUCT:
				msg = "Produto de id " + produto.getId() + " encontrado.";
				productString += "{";
				productString += "\"id\": " + produto.getId() + ",";
				productString += "\"nome\": \"" + produto.getNome() + "\",";
				productString += "\"preco\": " + produto.getPreco() + ",";
				productString += "\"quantidade\": " + produto.getQuantidade() + ",";
				productString += "\"descricao\": \"" + produto.getDescricao() + "\"";
				productString += "}";
				break;
			case INSERT_PRODUCT:
				productString += "{";
				msg = "Produto " + produto.getNome() + " inserido.";
				productString += "\"id\": " + produto.getId() + ",";
				productString += "\"nome\": \"" + produto.getNome() + "\"";
				productString += "}";
				break;
			case DELETE_PRODUCT:
				productString += "{";
				msg = "Produto de id " + produto.getId() + " deletado.";
				productString += "\"nome\": \"" + produto.getNome() + "\"";
				productString += "}";
				break;
			case UPDATE_PRODUCT:
				msg = "Produto de id " + produto.getId() + " atualizado.";
				productString += "{";
				productString += "\"id\": " + produto.getId() + ",";
				productString += "\"nome\": \"" + produto.getNome() + "\",";
				productString += "\"preco\": " + produto.getPreco() + ",";
				productString += "\"quantidade\": " + produto.getQuantidade() + ",";
				productString += "\"descricao\": \"" + produto.getDescricao() + "\"";
				productString += "}";
				break;
			case LIST_PRODUCT:
				msg = "Produtos existestes.";
				for(int i = 0; i < produtos.size(); i++) {
					produto = produtos.get(i);
					productString += "{";
					productString += "\"id\": " + produto.getId() + ",";
					productString += "\"nome\": \"" + produto.getNome() + "\",";
					productString += "\"preco\": " + produto.getPreco() + ",";
					productString += "\"quantidade\": " + produto.getQuantidade() + ",";
					productString += "\"descricao\": \"" + produto.getDescricao() + "\"";
					productString += "}";
				}
				productString = productString.substring(0, productString.length() - 1);
			}
			json = json.replaceFirst("%MESSAGE%", "\"" + msg + "\"");
			json = json.replaceFirst("%PRODUCTINFO%", productString);
		}
	}
	
    public Object get(Request request, Response response) {
    	
    	if(!authMiddleware(request)) {
    		response.status(401);
    		response.type("application/json");
    		return json;
    	}
    	
    	int id = Integer.parseInt(request.params(":id"));
    	Produto produto = (Produto) produtoDAO.get(id);
    	
    	if(produto != null) {
    		response.status(200);
    		response.type("application/json");
    		List<Produto> products = new ArrayList<Produto>();
    		products.add(produto);
    		makeJson(GET_PRODUCT, products);
    	}else {
    		response.status(404);
    		makeJson(ERROR_404);
    	}
    	
    	return json;
    }
    
    public Object insert(Request request, Response response) {
    	
    	if(!authMiddleware(request)) {
    		response.status(401);
    		response.type("application/json");
    		return json;
    	}
    	
    	String body = request.body();
    	String name = "";
    	String price = "";
    	String quantity = "";
    	String descricao = "";
    	
    	String cursor = body.split("\"nome\": \"")[1];
    	int k = 0;
    	while(cursor.charAt(k) != '\"') {
    		name += cursor.charAt(k);
			k++;
    	}
		k=0;
    	cursor = body.split("\"preco\": ")[1];
    	while(cursor.charAt(k) != ',') {
    		price += cursor.charAt(k);
			k++;
    	}
		k=0;
    	cursor = body.split("\"quantidade\": ")[1];
    	while(cursor.charAt(k) != ',') {
    		quantity += cursor.charAt(k);
			k++;
    	}
		k=0;
    	cursor = body.split("\"descricao\": \"")[1];
    	while(cursor.charAt(k) != '\"') {
    		descricao += cursor.charAt(k);
			k++;
    	}
    	
    	Produto produto = new Produto(-1, name, Float.parseFloat(price), Integer.parseInt(quantity), descricao);
    	
    	if(produtoDAO.insert(produto) == true) {
    		response.status(201);
    		response.type("application/json");
    		List<Produto> users = new ArrayList<Produto>();
    		users.add(produto);
    		makeJson(INSERT_PRODUCT, users);
    	}else {
    		response.status(404);
    		makeJson(ERROR_404);
    	}
    	
    	return json;
    }
    
    public Object update(Request request, Response response) {
    	
    	if(!authMiddleware(request)) {
    		response.status(401);
    		response.type("application/json");
    		return json;
    	}
    	
    	String body = request.body();
    	String name = "";
    	String price = "";
    	String quantity = "";
    	String descricao = "";
    	
    	String cursor = body.split("\"nome\": \"")[1];
    	int k = 0;
    	while(cursor.charAt(k) != '\"') {
    		name += cursor.charAt(k);
			k++;
    	}
		k=0;
    	cursor = body.split("\"preco\": ")[1];
    	while(cursor.charAt(k) != ',') {
    		price += cursor.charAt(k);
			k++;
    	}
		k=0;
    	cursor = body.split("\"quantidade\": ")[1];
    	while(cursor.charAt(k) != ',') {
    		quantity += cursor.charAt(k);
			k++;
    	}
		k=0;
    	cursor = body.split("\"descricao\": \"")[1];
    	while(cursor.charAt(k) != '\"') {
    		descricao += cursor.charAt(k);
			k++;
    	}
    	
    	Produto produto = new Produto(-1, name, Float.parseFloat(price), Integer.parseInt(quantity), descricao);
    	
    	if(produtoDAO.update(produto) == true) {
    		response.status(201);
    		response.type("application/json");
    		List<Produto> users = new ArrayList<Produto>();
    		users.add(produto);
    		makeJson(UPDATE_PRODUCT, users);
    	}else {
    		response.status(404);
    		makeJson(ERROR_404);
    	}
    	
    	return json;
    }
    
    public Object delete(Request request, Response response) {
    	if(!authMiddleware(request)) {
    		response.status(401);
    		response.type("application/json");
    		return json;
    	}
    	
    	int id = Integer.parseInt(request.params(":id"));
    	Produto result = produtoDAO.delete(id);
    	
    	if(result != null) {
    		response.status(200);
    		response.type("application/json");
    		List<Produto> users = new ArrayList<Produto>();
    		users.add(result);
    		makeJson(DELETE_PRODUCT, users);
    	}else {
    		response.status(404);
    		makeJson(ERROR_404);
    	}
    	
    	return json;
    }
    
    public Object list(Request request, Response response) {
    	if(!authMiddleware(request)) {
    		response.status(401);
    		response.type("application/json");
    		return json;
    	}
    	
    	List<Produto> result = produtoDAO.get();
    	
    	if(result != null) {
    		response.status(200);
    		response.type("application/json");
    		makeJson(LIST_PRODUCT, result);
    	}else {
    		response.status(404);
    		makeJson(ERROR_404);
    	}
    	
    	return json;
    }
}