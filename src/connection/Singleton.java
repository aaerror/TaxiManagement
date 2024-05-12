package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by KCYTVOG on 16/9/2016.
 */

public class    Singleton {
	public static Singleton instance;
	private Connection conexion;

	//CREACIÓN DE LA CONEXIÓN
	private Singleton() {
		try {
			String user = "sa";
			String pass = "123456";
			String url = "jdbc:sqlserver://localhost\\MÜLLENKAMP:1433;databaseName=TaxiDriver";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conexion = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			System.out.println("Error al establecer la conexión. Causa: " + e.getMessage());
		}
	}

	//BUSCAMOS SI HAY UNA INSTANCIA UTILIZANDOSE Y LA RETORNAMOS EN CASO DE QUE EXISTA
	public synchronized static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	public Connection getConexion() {
		return conexion;
	}

	public void closeConexion() {
		this.instance = null;
	}
}