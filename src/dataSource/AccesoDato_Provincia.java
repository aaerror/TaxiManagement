package dataSource;

import connection.Singleton;
import model.Provincia;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by KCYTVOG on 10/9/2016.
 */

public class AccesoDato_Provincia {
	private static final Singleton conexion = Singleton.getInstance();
	private Statement statement;
	private ResultSet resultSet;
	private Provincia provincia;


	public Provincia getProvincia(int codigoProvincia) {
		try {
			String sql = "SELECT p.CodigoProvincia, p.Descripcion " +
			             "FROM Provincia p " +
			             "WHERE p.CodigoProvincia= " + codigoProvincia + "";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				provincia = new Provincia();
				provincia.setCodigoProvincia(resultSet.getInt(1));
				provincia.setDescripcion(resultSet.getString(2));
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al traer datos de provincia. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return provincia;
	}

	public ArrayList<Provincia> listaProvincias() {
		ArrayList<Provincia> lista = new ArrayList<>();
		try {
			String sql = "SELECT p.CodigoProvincia, p.Descripcion FROM Provincia p";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				provincia = new Provincia();
				provincia.setCodigoProvincia(resultSet.getInt(1));
				provincia.setDescripcion(resultSet.getString(2));
				lista.add(provincia);
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al generar lista de pronvicias");
		} finally {
			conexion.closeConexion();
		}
		return lista;
	}
}