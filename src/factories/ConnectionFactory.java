package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// método para abrir e retornar uma conexão com o MySQL
	public static Connection getConnection() throws Exception {
		
	// parametros para conexão com o MYSQL
	String host = "jdbc:mysql://localhost:3306/bd_projetoaula04?useTimezone=true&serverTimezone=UTC&useSSL=false";
	String user = "root";
	String pass = "reis";
	
	//abrindo e retornando a conexão com o banco de dados
	return DriverManager.getConnection(host, user, pass);
	}
	
	
}
