package dataSource;

import connection.Singleton;
import model.TipoVivienda;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by KCYTVOG on 10/9/2016.
 */

public class AccesoDato_TipoVivienda {
	private static final Singleton conexion = Singleton.getInstance();
	private Statement statement;
	private ResultSet resultSet;
	private TipoVivienda tipoVivienda;


	public TipoVivienda getTipoVivienda(int codigoTipoVivienda) {
		try {
			String sql = "SELECT tp.CodigoTipoVivienda, tp.Descripcion " +
			             "FROM TipoVivienda tp " +
			             "WHERE tp.CodigoTipoVivienda= " + codigoTipoVivienda + "";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				tipoVivienda = new TipoVivienda();
				tipoVivienda.setCodigoVivienda(resultSet.getInt(1));
				tipoVivienda.setDescripcion(resultSet.getString(2));
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al traer datos del tipo de vivienda. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return tipoVivienda;
	}

	public ArrayList<TipoVivienda> listaTipoViviendas() {
		ArrayList<TipoVivienda> lista = new ArrayList<>();
		try {
			String sql = "SELECT tp.CodigoTipoVivienda, tp.Descripcion FROM TipoVivienda tp";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				tipoVivienda = new TipoVivienda();
				tipoVivienda.setCodigoVivienda(resultSet.getInt(1));
				tipoVivienda.setDescripcion(resultSet.getString(2));
				lista.add(tipoVivienda);
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al generar lista del tipo de vivienda. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return lista;
	}
}