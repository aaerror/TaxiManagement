package dataSource;

import connection.Singleton;
import model.Nacionalidad;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by KCYTVOG on 10/9/2016.
 */

public class AccesoDato_Nacionalidad {
	private static final Singleton conexion = Singleton.getInstance();
	private Statement statement;
	private ResultSet resultSet;
	private Nacionalidad nacionalidad;


	public Nacionalidad getNacionalidad(int codigoNacionalidad) {
		try {
			String sql = "SELECT n.CodigoNacionalidad, n.Descripcion " +
			             "FROM Nacionalidad n " +
			             "WHERE n.CodigoNacionalidad= " + codigoNacionalidad + "";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				nacionalidad = new Nacionalidad();
				nacionalidad.setCodigoNacionalidad(resultSet.getInt(1));
				nacionalidad.setDescripcion(resultSet.getString(2));
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al traer datos de nacionalidad. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return nacionalidad;
	}

	public ArrayList<Nacionalidad> listaNacionalidades() {
		ArrayList<Nacionalidad> lista = new ArrayList<>();
		try {
			String sql = "SELECT n.CodigoNacionalidad, n.Descripcion FROM Nacionalidad n";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				nacionalidad = new Nacionalidad();
				nacionalidad.setCodigoNacionalidad(resultSet.getInt(1));
				nacionalidad.setDescripcion(resultSet.getString(2));
				lista.add(nacionalidad);
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al generar lista de nacionalidades. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return lista;
	}
}