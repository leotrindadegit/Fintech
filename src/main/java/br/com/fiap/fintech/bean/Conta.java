package br.com.fiap.fintech.bean;

public class Conta {
	private int codigo;
	private String agencia;
	private String tipo;
	
	public Conta() {
		super();
	}

	public Conta(int codigo, String agencia, String tipo) {
		super();
		this.codigo = codigo;
		this.agencia = agencia;
		this.tipo = tipo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
