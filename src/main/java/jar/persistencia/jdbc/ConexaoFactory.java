package jar.persistencia.jdbc;

import java.sql.DriverManager;

public class ConexaoFactory {

	public static Connection getConnection() {
		
		return DriverManager.getConnection();
	}

}
