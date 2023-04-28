package dao;

import model.Produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO extends DAO {	
	public ProdutoDAO() {
		super();
		conectar();
	}
	
	
	public void finalize() {
		close();
	}
	
	
	public boolean insert(Produto produto) {
		boolean status = false;
		try {
<<<<<<< HEAD
			String sql = "INSERT INTO produto (descricao, preco, quantidade, nome) "
		               + "VALUES ('" + produto.getDescricao() + "', "
		               + produto.getPreco() + ", " + produto.getQuantidade() + ", '" + produto.getNome() + "');";
=======
			String sql = "INSERT INTO produto (id,nome,descricao, preco, quantidade) "
		        + "VALUES ('" produto.getID() + ", " + produto.getNome() + ", " + produto.getDescricao() + "', " + produto.getPreco() + ", " + produto.getQuantidade() + ", ?, ?);";
>>>>>>> 2bd5aa5a5d912cb47069330218a5bd29bd7fd3b3
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Produto get(int id) {
		Produto produto = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto WHERE id = "+id;
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
<<<<<<< HEAD
	        	 produto = new Produto(rs.getInt("id"), rs.getString("nome"), (float)rs.getDouble("preco"), 
	                				   rs.getInt("quantidade"),rs.getString("descricao"));
=======
	        	produto = new Produto(rs.getInt("id"), rs.getNome("nome"), rs.getString("descricao"), (float)rs.getDouble("preco"), rs.getInt("quantidade"));
>>>>>>> 2bd5aa5a5d912cb47069330218a5bd29bd7fd3b3
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return produto;
	}
	
	
	public List<Produto> get() {
		return get("");
	}

	
	public List<Produto> getOrderByID() {
		return get("id");		
	}

	public List<Produto> getOrderByNome() {
		return get("nome");		
	}
	
	
	public List<Produto> getOrderByDescricao() {
		return get("descricao");		
	}
	
	
	public List<Produto> getOrderByPreco() {
		return get("preco");		
	}
	
	
	private List<Produto> get(String orderBy) {
		List<Produto> produtos = new ArrayList<Produto>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
<<<<<<< HEAD
	        	Produto p = new Produto(rs.getInt("id"), rs.getString("nome"), (float)rs.getDouble("preco"), 
				rs.getInt("quantidade"),rs.getString("descricao"));
=======
	        	Produto p = new Produto(rs.getInt("id"), rs.getNome("nome"), rs.getString("descricao"), (float)rs.getDouble("preco"), rs.getInt("quantidade"));
>>>>>>> 2bd5aa5a5d912cb47069330218a5bd29bd7fd3b3
	            produtos.add(p);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return produtos;
	}
	
	
	public boolean update(Produto produto) {
		boolean status = false;
		try {  
<<<<<<< HEAD
			String sql = "UPDATE produto SET descricao = '" + produto.getDescricao() + "', "
					   + "preco = " + produto.getPreco() + ", " 
					   + "quantidade = " + produto.getQuantidade() + ", "
					   + "nome = " + produto.getNome() + ", " 
					   + "WHERE id = " + produto.getId();
=======
			String sql =  "UPDATE produto SET nome = '" + produto.getNome() + "', descricao = "  + produto.getDescricao()  + "', preco = " + produto.getPreco() + ", quantidade = " + produto.getQuantidade();
>>>>>>> 2bd5aa5a5d912cb47069330218a5bd29bd7fd3b3
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
<<<<<<< HEAD
	
	public Produto delete(int id) {
=======
	public boolean delete(int id) {
>>>>>>> 2bd5aa5a5d912cb47069330218a5bd29bd7fd3b3
		boolean status = false;
		Produto product = null;
		try {
			product = get(id);  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM produto WHERE id = " + id);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status ? product : null;
	}
}