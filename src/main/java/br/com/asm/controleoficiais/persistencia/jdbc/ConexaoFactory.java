package br.com.asm.controleoficiais.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConnection() {
		
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdControleOficiais","postgres","187oeg2d1KZXdaEMfXp5");
		} catch (SQLException e) {
			// relan�ando a exception
			System.out.println("Erro na conex�o");
			throw new RuntimeException(e);
		}
	}
}
