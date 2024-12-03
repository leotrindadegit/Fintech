package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleContaDAO implements ContaDAO {
	private Connection conexao;

	@Override
	public void cadastrar(Conta conta) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_CONTA_BANCARIA (cd_conta, ag_conta," + "tipo_conta) VALUES "
					+ "(SQ_T_CLIENTE.NEXTVAL, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, conta.getAgencia());
			stmt.setString(2, conta.getTipo());

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
	public void atualizar(Conta conta) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_CONTA_BANCARIA SET ag_conta = ?, tipo_conta = ?," + "where cd_conta = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, conta.getAgencia());
			stmt.setString(2, conta.getTipo());

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
			String sql = "DELETE FROM T_CONTA_BANCARIA WHERE cd_conta = ?";
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
	public Conta buscar(int id) {
		Conta conta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_CONTA_BANCARIA WHERE cd_conta = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigo = rs.getInt("cd_conta");
				String agencia = rs.getString("ag_conta");
				String tipo = rs.getString("tipo_conta");

				conta = new Conta(codigo, agencia, tipo);
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
		return conta;
	}

	@Override
	public List<Conta> listar() {
		List<Conta> lista = new ArrayList<Conta>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_CONTA_BANCARIA");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int codigo = rs.getInt("cd_conta");
				String agencia = rs.getString("ag_conta");
				String tipo = rs.getString("tipo_conta");

				Conta conta = new Conta(codigo, agencia, tipo);
				lista.add(conta);
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
