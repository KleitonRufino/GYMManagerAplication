package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.model.User;
import conexao.Conexao;

public class UserDAO {
	public User findUserById(Long idUser) {
		User user = null;
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select id, login, senha from usuario where id=?";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setLong(1, idUser);
			ResultSet rs = find.executeQuery();

			while (rs.next()) {
				user = new User();
				user.setId(rs.getLong(1));
				user.setLogin(rs.getString(2));
				user.setSenha(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				find.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	public User findUserByLogin(String login) {
		User user = null;
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select id, login, senha from usuario where id=?";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setString(1, login);
			ResultSet rs = find.executeQuery();

			while (rs.next()) {
				user = new User();
				user.setId(rs.getLong(1));
				user.setLogin(rs.getString(2));
				user.setSenha(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				find.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	public void addUser(User user) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement insere = null;
		String sql = "insert into usuario(login, senha) values (?,?)";
		try {
			insere = (PreparedStatement) conexao.prepareStatement(sql);
			insere.setString(1, user.getLogin());
			insere.setString(2, user.getSenha());
			insere.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				insere.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateUser(User user) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement update = null;
		String sql = "update usuario set login=?, senha=? where id=?";
		try {
			update = (PreparedStatement) conexao.prepareStatement(sql);
			update.setString(1, user.getLogin());
			update.setString(2, user.getSenha());
			update.setLong(3, user.getId());
			update.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				update.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteUser(Long idUser) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement delete = null;
		String sql = "delete from usuario where id=?";
		try {
			delete = (PreparedStatement) conexao.prepareStatement(sql);
			delete.setLong(1, idUser);
			delete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				delete.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
