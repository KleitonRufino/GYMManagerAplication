package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.model.User;
import conexao.Conexao;

public class UserDAO {
	public User findById(Long idUser) {
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

}
