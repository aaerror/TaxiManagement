package dataSource;

import connection.Singleton;
import model.EstadoCoche;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by KCYTVOG on 14/9/2016.
 */

public class AccesoDato_EstadoCoche {
	private static final Singleton conexion = Singleton.getInstance();
	private Statement statement;
	private ResultSet resultSet;
	private EstadoCoche estadoCoche;


	public EstadoCoche getEstadoCoche(int codigoEstadoCoche) {
		try {
			String sql = "SELECT ec.CodigoEstadoCoche, ec.Descripcion " +
			             "FROM EstadoCoche ec " +
			             "WHERE ec.CodigoEstadoCoche= " + codigoEstadoCoche + "";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				estadoCoche = new EstadoCoche();
				estadoCoche.setCodigoEstadoCoche(resultSet.getInt(1));
				estadoCoche.setDescripcion(resultSet.getString(2));
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al traer datos del estado de coche. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return estadoCoche;
	}

	public ArrayList<EstadoCoche> listaEstadoCoches() {
		ArrayList<EstadoCoche> lista = new ArrayList<>();
		try {
			String sql = "SELECT ec.CodigoEstadoCoche, ec.Descripcion FROM EstadoCoche ec";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				estadoCoche = new EstadoCoche();
				estadoCoche.setCodigoEstadoCoche(resultSet.getInt(1));
				estadoCoche.setDescripcion(resultSet.getString(2));
				lista.add(estadoCoche);
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al generar lista de estado de coches. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return lista;
	}
}