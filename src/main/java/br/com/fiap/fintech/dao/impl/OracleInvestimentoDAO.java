package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fintech.bean.Investimento;
import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleInvestimentoDAO implements InvestimentoDAO{
	private Connection conexao;

	@Override
	public void cadastrar(Investimento investimento) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_INVESTIMENTO (cd_investimento, nm_investimento, dt_investimento,"
					+ "vl_investimento, vl_percentual, vl_retorno ) VALUES "
					+ "(SQ_T_INVESTIMENTO.NEXTVAL, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, investimento.getNome());
			java.sql.Date data = new java.sql.Date(investimento.getDataInvestimento().getTimeInMillis());
			stmt.setDate(2, data);
			stmt.setDouble(3, investimento.getValorInvestimento());
			stmt.setDouble(4, investimento.getValorPercentual());
			stmt.setDouble(5, investimento.getRetorno());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void atualizar(Investimento investimento) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_INVESTIMENTO SET nm_investimento = ?, dt_investimento = ?, vl_investimento = ? , vl_percentual = ?, vl_retorno = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, investimento.getNome());
			java.sql.Date data = new java.sql.Date(investimento.getDataInvestimento().getTimeInMillis());
			stmt.setDate(2, data);
			stmt.setDouble(3, investimento.getValorInvestimento());
			stmt.setDouble(4, investimento.getValorPercentual());
			stmt.setDouble(5, investimento.getRetorno());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void remover(int codigo) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_INVESTIMENTO WHERE cd_investimento = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigo);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Investimento buscar(int id) {
		Investimento investimento = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_INVESTIMENTO WHERE cd_investimento = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {

				int codigo = rs.getInt("cd_investimento");
				String nome = rs.getString("nm_investimento");
				java.sql.Date data = rs.getDate("dt_investimento");
				Calendar dataInvestimento = Calendar.getInstance();
				dataInvestimento.setTimeInMillis(data.getTime());
				double valorInvestimento = rs.getDouble("vl_investimento");
				double valorPercentual = rs.getDouble("vl_percentual");
				double retorno = rs.getDouble("vl_retorno");

				investimento = new Investimento(codigo, nome, dataInvestimento, valorInvestimento, valorPercentual, retorno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return investimento;
	}

	@Override
	public List<Investimento> listar() {
		List<Investimento> lista = new ArrayList<Investimento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_INVESTIMENTO");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int codigo = rs.getInt("cd_investimento");
				String nome = rs.getString("nm_investimento");
				java.sql.Date data = rs.getDate("dt_investimento");
				Calendar dataInvestimento = Calendar.getInstance();
				dataInvestimento.setTimeInMillis(data.getTime());
				double valorInvestimento = rs.getDouble("vl_investimento");
				double valorPercentual = rs.getDouble("vl_percentual");
				double retorno = rs.getDouble("vl_retorno");

				Investimento investimento = new Investimento(codigo, nome, dataInvestimento, valorInvestimento, valorPercentual, retorno);
				lista.add(investimento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
	}
	
