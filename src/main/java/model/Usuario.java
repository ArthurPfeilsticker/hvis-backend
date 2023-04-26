package model;

public class Usuario {
	private int idusuario;
    private String nomeusuario;
    private String telusuario;
    private String cidade;
    private String estado;
    private String descricaousuario;
    private String cpf;
	private String login;
	private String senha;
	
	public Usuario() {
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
	
	public Usuario(int.idusuario, String nomeusuario, String telusuario, String cidade, String estado, String descricaousuario, String cpf, String login, String senha,) {
		this.idusuario =.idusuario;
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
		return.idusuario;
	}

	public void setIDUsuario(int idusuario) {
		this.idusuario =.idusuario;
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
		return "Usuario .idusuario=" +.idusuario + ", nome=" + nomeusuario + ", telefone=" + telusuario + ", cidade=" + cidade + ", estado=" + estado + ", descrição=" + descricaousuario + ", CPF=" + cpf + ", login=" + login + ", senha=" + senha + "]";
	}	
}
