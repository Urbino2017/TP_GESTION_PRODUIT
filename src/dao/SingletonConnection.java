/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author ahoad
 * Un singleton est une classe dans laquelle on declare un objet de type connection et d'une et unique methode getConnection de type static
 */
public class SingletonConnection {
	private static Connection connection; 
	// Creation du bloc static permettant de charger les differentes parametres de connection au debur de toute connections
	
	static {
		try {
			//Chargement du pilote Jdbc
			Class.forName( "com.mysql.jdbc.Driver");
			// Etablissement de la connexion 
			connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/DB_CATAL", "root", "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	/**
	 * @return the connection
	 * // Declaration de l'unique methode la clsse Singleton 
	 */
	public static Connection getConnection() {
		return connection;
	}
}
