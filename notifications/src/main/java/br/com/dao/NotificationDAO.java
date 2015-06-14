package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.model.Notification;
import conexao.Conexao;

public class NotificationDAO {

	public void save(Notification notification, Long idCliente) {
		Connection conexao = Conexao.getConnection();
		PreparedStatement insereSt = null;
		String sql = "insert into notificacao(mensagem, cliente_id) values (?,?)";
		try {
			insereSt = (PreparedStatement) conexao.prepareStatement(sql);
			insereSt.setString(1, notification.getMensagem());
			insereSt.setLong(2, idCliente);
			insereSt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				insereSt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public List<Notification> findBy(Long idCliente) {
		Notification notification;
		List<Notification> notifications = new ArrayList<Notification>();
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from notificacao c where id=?";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			find.setLong(1, idCliente);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				notification = new Notification();
				notification.setId(rs.getLong("id"));
				notification.setMensagem(rs.getString("mensagem"));
				notifications.add(notification);
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
		return notifications;
	}

	public List<Notification> findAll() {
		Notification notification;
		List<Notification> notifications = new ArrayList<Notification>();
		Connection conexao = Conexao.getConnection();
		PreparedStatement find = null;
		String sql = "select * from notificacao";
		try {
			find = (PreparedStatement) conexao.prepareStatement(sql);
			ResultSet rs = find.executeQuery();
			while (rs.next()) {
				notification = new Notification();
				notification.setId(rs.getLong("id"));
				notification.setMensagem(rs.getString("mensagem"));
				notifications.add(notification);
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
		return notifications;

	}

}
