package br.com.fiap.fintech.bean;

public class Usuario {

	private int codigo;
	private String nome;
	private String telefone;
	private String email;
	private String senha;
	
	public Usuario() {
		
	}

	public Usuario(int codigo, String nome, String telefone, String email, String senha) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setId(int codigo) {
		this.codigo = codigo;
	}
	
	
	
	
}
