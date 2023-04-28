package dao;

<<<<<<< HEAD
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
=======
import java.sql.*;
>>>>>>> 2bd5aa5a5d912cb47069330218a5bd29bd7fd3b3
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

<<<<<<< HEAD
public class UsuarioDAO extends DAO{
=======
public class UsuarioDAO extends DAO {
>>>>>>> 2bd5aa5a5d912cb47069330218a5bd29bd7fd3b3
	
	public UsuarioDAO() {
		super();
		conectar();
	}
<<<<<<< HEAD
	
=======

>>>>>>> 2bd5aa5a5d912cb47069330218a5bd29bd7fd3b3
	public void finalize() {
		close();
	}
	
<<<<<<< HEAD
	public boolean insert(Usuario usuario) {
		boolean status = false;
		try {
			String sql = "INSERT INTO usuario (nome, username, password, cpf, telefone, email, cidade, estado, descricao) "
		               + "VALUES ('" + usuario.getNome() + "', '"
		               + usuario.getUsername() + "', '" + usuario.getPassword() + "', " + usuario.getCPF() + ", " + usuario.getTelefone() + ", '" + usuario.getEmail() + "', '" + usuario.getCidade() + "', '" + usuario.getEstado() + "', '" + usuario.getDescricao() + "');";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
=======
	
	public boolean insert(Usuario usuario) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO usuario (idusuario, nomeusuario, telusuario, cidade, estado, descricaousuario, cpf, login, senha) "
				+ "VALUES ("+usuario.getIDUsuario()+ ", '" + usuario.getNomeUsuario() + ", '" + usuario.getTelUsuario() + ", '" + usuario.getCidade() + ", '" + usuario.getEstado() + ", '" + usuario.getDescricaoUsuario() + ", '" + usuario.getCpf() + ", '" + usuario.getLogin() + "', '" + usuario.getSenha() + "');";
			System.out.println(sql);
			st.executeUpdate(sql);
>>>>>>> 2bd5aa5a5d912cb47069330218a5bd29bd7fd3b3
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
<<<<<<< HEAD
	
	public Usuario get(int id) {
		Usuario usuario = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM usuario WHERE id = "+id;
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				usuario = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("username"), rs.getLong("cpf"), rs.getInt("telefone"), rs.getString("email"), rs.getString("descricao"), rs.getString("cidade"), rs.getString("estado"));
;			}
			st.close();
		}catch (Exception e){
=======

	
	public Usuario get(int idusuario) {
		Usuario usuario = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto WHERE id=" + idusuario;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	usuario = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"), rs.getString("cidade"), rs.getString("estado"), rs.getString("descricao"), rs.getString("cpf"), rs.getString("login"), rs.getString("senha"));
	        }
	        st.close();
		} catch (Exception e) {
>>>>>>> 2bd5aa5a5d912cb47069330218a5bd29bd7fd3b3
			System.err.println(e.getMessage());
		}
		return usuario;
	}
	
<<<<<<< HEAD
	public boolean update(Usuario usuario) {
		boolean status = false;
		try {  
			String sql = "UPDATE usuario SET nome = '" + usuario.getNome() + "', "
					   + "username = " + usuario.getUsername() + ", " 
					   + "cpf = " + usuario.getCPF() + ","
					   + "telefone = " + usuario.getTelefone() + ", "
					   + "email = " + usuario.getEmail() + ", "
					   + "descricao = " + usuario.getDescricao() + ", "
					   + "cidade = " + usuario.getCidade() + ", "
					   + "estado = " + usuario.getEstado()
					   + " WHERE id = " + usuario.getId();
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
=======
	
	public List<Usuario> get() {
		return get("");
	}

	
	public List<Usuario> getOrderByidusuario() {
		return get("idusuario");		
	}
	
    public List<Usuario> getOrderByNomeUsuario() {
		return get("nomeusuario");		
	}

    public List<Usuario> getOrderByTelUsuario() {
		return get("telusuario");		
	}

    public List<Usuario> getOrderByCidade() {
		return get("cidade");		
	}

    public List<Usuario> getOrderByEstado() {
		return get("estado");		
	}

    public List<Usuario> getOrderByDescricaoUsuario() {
		return get("descricaousuario");		
	}

    public List<Usuario> getOrderByCpf() {
		return get("cpf");		
	}
	
	public List<Usuario> getOrderByLogin() {
		return get("login");		
	}
	
	
	
	private List<Usuario> get(String orderBy) {	
	
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM usuario" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Usuario u = new Usuario(rs.getInt("idusuario"), rs.getString("nomeusuario"), rs.getString("telusuario"), rs.getString("cidade"), rs.getString("estado"), rs.getString("descricaousuario"), rs.getString("cpf"), rs.getString("login"), rs.getString("senha"));
	            usuarios.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return usuarios;
	}
	
	
	public boolean update(Usuario usuario) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE usuario SET nome= " + usuario.getNomeUsuario() + "', telusuario = '" + usuario.getTelUsuario() + "', cidade = '" + usuario.getCidade() + "', estado = '" + usuario.getEstado() + "', descricaousuario = '" + usuario.getDescricaoUsuario() + "', cpf = '" + usuario.getCpf() + "', login = '" + usuario.getLogin() + "', senha = '" + usuario.getSenha() + "'" + " WHERE idusuario = " + usuario.getIDUsuario();
			System.out.println(sql);
			st.executeUpdate(sql);
>>>>>>> 2bd5aa5a5d912cb47069330218a5bd29bd7fd3b3
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
<<<<<<< HEAD
	public Usuario delete(int id) {
		boolean status = false;
		Usuario user = null;
		try {  
			user = get(id);
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM usuario WHERE id = " + id);
=======
	public boolean delete(int idusuario) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM usuario WHERE idusuario = " + idusuario;
			System.out.println(sql);
			st.executeUpdate(sql);
>>>>>>> 2bd5aa5a5d912cb47069330218a5bd29bd7fd3b3
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
<<<<<<< HEAD
		return status ? user : null;
	}
	
	public Usuario login(String username, String password) {
		Usuario usuario = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM usuario WHERE username = '" + username + "' AND password = '" + password + "';";
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				usuario = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("username"), rs.getLong("cpf"), rs.getInt("telefone"), rs.getString("email"), rs.getString("descricao"), rs.getString("cidade"), rs.getString("estado"));
;			}
			st.close();
		}catch (Exception e){
			System.err.println(e.getMessage());
		}
		return usuario;
	}
	
	public List<Usuario> list(){
		List<Usuario> users = new ArrayList<Usuario>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM usuario;";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				users.add(new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("username"), rs.getLong("cpf"), rs.getInt("telefone"), rs.getString("email"), rs.getString("descricao"), rs.getString("cidade"), rs.getString("estado")));
;			}
			st.close();
		}catch (Exception e){
			System.err.println(e.getMessage());
		}
		return users;
	}
=======
		return status;
	}
	
	
	public boolean autenticar(String login, String senha) {
		boolean resp = false;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM usuario WHERE login LIKE '" + login + "' AND senha LIKE '" + senha  + "'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			resp = rs.next();
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return resp;
	}	
>>>>>>> 2bd5aa5a5d912cb47069330218a5bd29bd7fd3b3
}
