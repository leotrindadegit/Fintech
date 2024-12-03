package br.com.fiap.fintech.bean;

import java.util.Calendar;

public class Investimento {
	private int codigo;
	private String nome;
	private Calendar dataInvestimento;
	private double valorInvestimento;
	private double valorPercentual;
	private double retorno;

	public Investimento() {
		super();
	}

	public Investimento(int codigo, String nome, Calendar dataInvestimento, double valorInvestimento, double valorPercentual,
			double retorno) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataInvestimento = dataInvestimento;
		this.valorInvestimento = valorInvestimento;
		this.valorPercentual = valorPercentual;
		this.retorno = retorno;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataInvestimento() {
		return dataInvestimento;
	}

	public void setDataInvestimento(Calendar data) {
		this.dataInvestimento = data;
	}

	public double getValorInvestimento() {
		return valorInvestimento;
	}

	public void setValorInvestimento(double valorInvestimento) {
		this.valorInvestimento = valorInvestimento;
	}

	public double getValorPercentual() {
		return valorPercentual;
	}

	public void setValorPercentual(double valorPercentual) {
		this.valorPercentual = valorPercentual;
	}

	public double getRetorno() {
		return retorno;
	}

	public void setRetorno(double retorno) {
		this.retorno = retorno;
	}

}
