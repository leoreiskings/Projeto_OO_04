package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// m�todo para abrir e retornar uma conex�o com o MySQL
	public static Connection getConnection() throws Exception {
		

	// parametros para conex�o com o MYSQL
	String host = "xxxxxx";
	String user = "xxxxxx";
	String pass = "xxxxxx";
	
	//abrindo e retornando a conex�o com o banco de dados
	return DriverManager.getConnection(host, user, pass);
	}
	
	
}
