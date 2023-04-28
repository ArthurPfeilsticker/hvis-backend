package model;

public class Usuario {
<<<<<<< HEAD
    
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
=======
	private int idusuario;
    private String nomeusuario;
    private String telusuario;
    private String cidade;
    private String estado;
    private String descricaousuario;
    private String cpf;
	private String login;
	private String senha;
	
	public void Usuario() {
		this.idusuario = -1;
        this.nomeusuario = "";
        this.telusuario = "";
        this.cidade = "";
        this.estado = "";
        this.descricaousuario = "";
        this.cpf = "";
		this.login = "";
		this.senha = "";

	}
	
	public void Usuario(int idusuario, String nomeusuario, String telusuario, String cidade, String estado, String descricaousuario, String cpf, String login, String senha) {
		this.idusuario = idusuario;
        this.nomeusuario = nomeusuario;
        this.telusuario = telusuario;
        this.cidade = cidade;
        this.estado = estado;
        this.descricaousuario = descricaousuario;
        this.cpf = cpf;
		this.login = login;
		this.senha = senha;
	}

	public int getIDUsuario() {
		return idusuario;
	}

	public void setIDUsuario(int idusuario) {
		this.idusuario = idusuario;
	}

    public String getNomeUsuario() {
		return nomeusuario;
	}

	public void setNomeUsuario(String nomeusuario) {
		this.nomeusuario = nomeusuario;
	}

    public String getTelUsuario() {
		return telusuario;
	}

	public void setTelUsuario(String telusuario) {
		this.telusuario = telusuario;
	}

    public String getCidade() {
		return cidade;
	}

	public void setNCidade(String cidade) {
		this.cidade = cidade;
	}

    public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

    public String getDescricaoUsuario() {
		return descricaousuario;
	}

	public void setDescricaoUsuario(String descricaousuario) {
		this.descricaousuario = descricaousuario;
	}

    public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	@Override
	public String toString() {
		return "Usuario .idusuario=" + idusuario + ", nome=" + nomeusuario + ", telefone=" + telusuario + ", cidade=" + cidade + ", estado=" + estado + ", descrição=" + descricaousuario + ", CPF=" + cpf + ", login=" + login + ", senha=" + senha + "]";
	}	
>>>>>>> 2bd5aa5a5d912cb47069330218a5bd29bd7fd3b3
}
