package jar.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConnection() {
		
		try {
			return DriverManager.getConnection("jdbc.postgresql://localhost:5432/Teste","postgres","postgres");
		} catch (SQLException e) {
			// relan�ando a exception
			throw new RuntimeException(e);
		}
	}
}
