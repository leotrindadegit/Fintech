package br.com.fiap.fintech.teste;

import java.util.List;

import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		UsuarioDAO dao = DAOFactory.getUsuarioDAO();
		
		Usuario user = new Usuario(0,"Leo", "1223413", "leo@gmail.com", "1234");
		try {
			dao.cadastrar(user);
			System.out.println("Usuario cadastrado.");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		user = dao.buscar(7);
		user.setNome("Fer");
		user.setTelefone("0000000000");
		
		try {
			dao.atualizar(user);
			System.out.println("Usuário atualizado");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		List<Usuario> lista = dao.listar();
		for(Usuario item : lista) {
			System.out.println(item.getNome() + " " + item.getTelefone() + item.getEmail());
		}
		
		try {
			dao.remover(1);
			System.out.println("Usuário removido");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

}
