package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// m�todo para abrir e retornar uma conex�o com o MySQL
	public static Connection getConnection() throws Exception {
		
	// parametros para conex�o com o MYSQL
	String host = "jdbc:mysql://localhost:3306/bd_projetoaula04?useTimezone=true&serverTimezone=UTC&useSSL=false";
	String user = "root";
	String pass = "reis";
	
	//abrindo e retornando a conex�o com o banco de dados
	return DriverManager.getConnection(host, user, pass);
	}
	
	
}
