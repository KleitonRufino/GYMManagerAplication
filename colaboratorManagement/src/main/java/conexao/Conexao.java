package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/gym_manager", "postgres",
					"admin");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}