package model;

public class Usuario {
    
	private int id;
	private String nome;
	private String username;
	private String password;
	private long cpf;
	private int telefone;
	private String email;
	private String cidade;
	private String estado;
	private String descricao;
	
	public Usuario(int id, String nome, String username, String password, long cpf, int telefone, String email, String descricao, String cidade, String estado) {
		this.id = id;
		this.nome = nome;
		this.username = username;
		this.password = password;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.cidade = cidade;
		this.estado = estado;
		this.descricao = descricao;
	}
	
	public Usuario(int id, String nome, String username, long cpf, int telefone, String email, String descricao, String cidade, String estado) {
		this.id = id;
		this.nome = nome;
		this.username = username;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.cidade = cidade;
		this.estado = estado;
		this.descricao = descricao;
	}
	
	public Usuario() {
		this.id = -1;
		this.nome = null;
		this.username = null;
		this.password = null;
		this.cpf = 0;
		this.telefone = 0;
		this.email = null;
		this.cidade = null;
		this.estado = null;
		this.descricao = null;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public long getCPF() {
		return this.cpf;
	}
	
	public int getTelefone() {
		return this.telefone;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public String getCidade() {
		return this.cidade;
	}
	public String getEstado() {
		return this.estado;
	}
}
