package dataSource;

import connection.Singleton;
import model.Localidad;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by KCYTVOG on 10/9/2016.
 */

public class AccesoDato_Localidad {
	private static final Singleton conexion = Singleton.getInstance();
	private Statement statement;
	private ResultSet resultSet;
	private Localidad localidad;


	public Localidad getLocalidad(int codigoLocalidad) {
		try {
			String sql = "SELECT l.CodigoLocalidad, l.Descripcion " +
			             "FROM Localidad l " +
			             "WHERE l.CodigoLocalidad= " + codigoLocalidad + "";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				localidad = new Localidad();
				localidad.setCodigoLocalidad(resultSet.getInt(1));
				localidad.setDescripcion(resultSet.getString(2));
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al traer datos de localidad. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return localidad;
	}

	public ArrayList<Localidad> listaLocalidades() {
		ArrayList<Localidad> lista = new ArrayList<>();
		try {
			String sql = "SELECT l.CodigoLocalidad, l.Descripcion FROM Localidad l";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				localidad = new Localidad();
				localidad.setCodigoLocalidad(resultSet.getInt(1));
				localidad.setDescripcion(resultSet.getString(2));
				lista.add(localidad);
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al generar lista de localidades. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return lista;
	}
}