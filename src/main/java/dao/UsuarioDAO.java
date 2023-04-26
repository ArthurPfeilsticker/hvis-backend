package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDAO extends DAO {
	
	public UsuarioDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	
	public boolean insert(Usuario usuario) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO usuario (idusuario, nomeusuario, telusuario, cidade, estado, descricaousuario, cpf, login, senha) "
				       + "VALUES ("+usuario.getIDUsuario()+ ", '" + usuario.getNomeUsuario() + ", '" + usuario.getTelUsuario() + ", '" + usuario.getCidade() + ", '" + usuario.getEstado() + ", '" + usuario.getDescricaoUsuario() + ", '" + usuario.getCpf() + ", '" + usuario.getLogin() + "', '" + usuario.getSenha() + "');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Usuario get(int idusuario) {
		Usuario usuario = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto WHERE id=" + idusuario;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	 usuario = new Usuario(rs.getInt("idusuario"), rs.getString("nomeusuario"), rs.getString("telusuario"), rs.getString("cidade"), rs.getString("estado"), rs.getString("descricaousuario"), rs.getString("cpf"), rs.getString("login"), rs.getString("senha"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return usuario;
	}
	
	
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
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(int idusuario) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM usuario WHERE idusuario = " + idusuario;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
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
}
