package dataSource;

import connection.Singleton;
import model.Marca;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by KCYTVOG on 14/9/2016.
 */

public class AccesoDato_Marca {
	private static final Singleton conexion = Singleton.getInstance();
	private Statement statement;
	private ResultSet resultSet;
	private Marca marca;


	public Marca getMarca(int codigoMarca) {
		try {
			String sql = "SELECT m.CodigoMarca, m.Descripcion " +
			             "FROM Marca m " +
			             "WHERE m.CodigoMarca= " + codigoMarca + "";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				marca = new Marca();
				marca.setCodigoMarca(resultSet.getInt(1));
				marca.setDescripcion(resultSet.getString(2));
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al traer datos de la marca. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return marca;
	}

	public ArrayList<Marca> listaMarcas() {
		ArrayList<Marca> lista = new ArrayList<>();
		try {
			String sql = "SELECT m.CodigoMarca, m.Descripcion FROM Marca m";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				marca = new Marca();
				marca.setCodigoMarca(resultSet.getInt(1));
				marca.setDescripcion(resultSet.getString(2));
				lista.add(marca);
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al generar lista de marcas. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return lista;
	}
}