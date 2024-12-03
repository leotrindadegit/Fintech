package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Investimento;
import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

/**
 * Servlet implementation class InvestimentoServlet
 */
@WebServlet("/investimento")
public class InvestimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private InvestimentoDAO dao;

	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getInvestimentoDAO();
	}

	public InvestimentoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");

		switch (acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;
		case "editar":
			editar(request, response);
			break;
		case "excluir":
			excluir(request, response);
			break;
		}
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(request.getParameter("dataInvestimento")));
			double valorInvestimento = Double.parseDouble(request.getParameter("valorInvestimento"));
			double valorPercentual = Double.parseDouble(request.getParameter("valorPercentual"));
			double retorno = Double.parseDouble(request.getParameter("retorno"));

			Investimento investimento = new Investimento(0, nome, data, valorInvestimento, valorPercentual, retorno);
			dao.cadastrar(investimento);

			request.setAttribute("msg", "Investimento cadastrado!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro-investimento.jsp").forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String nome = request.getParameter("nome");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(request.getParameter("dataInvestimento")));
			double valorInvestimento = Double.parseDouble(request.getParameter("valorInvestimento"));
			double valorPercentual = Double.parseDouble(request.getParameter("valorPercentual"));
			double retorno = Double.parseDouble(request.getParameter("retorno"));
			
			Investimento investimento = new Investimento(codigo, nome, data, valorInvestimento, valorPercentual, retorno);
			dao.atualizar(investimento);
			
			request.setAttribute("msg", "Investimento atualizado!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		}catch(Exception e ) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		listar(request, response);
	}
	
	private void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		try {
			dao.remover(codigo);
			request.setAttribute("msg", "Investimento removido!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		}
		listar(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch(acao) {
		case "listar":
			listar(request, response);
			break;
		case "abrir-form-edicao":
			int id = Integer.parseInt(request.getParameter("codigo"));
			Investimento investimento = dao.buscar(id);
			request.setAttribute("investimento", investimento);
			request.getRequestDispatcher("edicao-investimento.jsp").forward(request, response);;
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Investimento> lista = dao.listar();
		request.setAttribute("investimentos", lista);
		request.getRequestDispatcher("lista-investimento.jsp").forward(request, response);
	}
}

