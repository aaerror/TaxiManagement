package dataSource;

import connection.Singleton;
import model.Barrio;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by KCYTVOG on 10/9/2016.
 */

public class AccesoDato_Barrio {
	private static final Singleton conexion = Singleton.getInstance();
	private Statement statement;
	private ResultSet resultSet;
	private Barrio barrio;


	public Barrio getBarrio(int codigoBarrio) {
		try {
			String sql = "SELECT b.CodigoBarrio, b.Descripcion FROM Barrio b WHERE b.CodigoBarrio= " + codigoBarrio + "";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				barrio = new Barrio();
				barrio.setCodigoBarrio(resultSet.getInt(1));
				barrio.setDescripcion(resultSet.getString(2));
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al traer datos del barrio. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return barrio;
	}

	public ArrayList<Barrio> listaBarrios() {
		ArrayList<Barrio> lista = new ArrayList<>();
		try {
			String sql = "SELECT b.CodigoBarrio, b.Descripcion FROM Barrio b";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				barrio = new Barrio();
				barrio.setCodigoBarrio(resultSet.getInt(1));
				barrio.setDescripcion(resultSet.getString(2));
				lista.add(barrio);
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al generar lista de barrios. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return lista;
	}
}