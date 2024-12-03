package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.exception.DBException;

public interface UsuarioDAO {
	void cadastrar(Usuario usuario) throws DBException;
	void atualizar(Usuario usuario) throws DBException;
	void remover(int codigo) throws DBException;
	Usuario buscar(int id);
	List<Usuario> listar();
}
