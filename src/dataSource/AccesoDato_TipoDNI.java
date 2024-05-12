package dataSource;

import connection.Singleton;
import model.TipoDNI;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by KCYTVOG on 7/9/2016.
 */

public class AccesoDato_TipoDNI {
	private static final Singleton conexion = Singleton.getInstance();
	private Statement statement;
	private ResultSet resultSet;
	private TipoDNI tipoDNI;


	public TipoDNI getTipoDNI(int codigoTipoDNI) {
		try {
			String sql = "SELECT dni.CodigoTipoDNI, dni.Descripcion " +
			             "FROM TipoDNI dni " +
			             "WHERE dni.CodigoTipoDNI= " + codigoTipoDNI +"";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				tipoDNI = new TipoDNI();
				tipoDNI.setCodigoTipoDNI(resultSet.getInt(1));
				tipoDNI.setDescripcion(resultSet.getString(2));
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al traer datos del tipo de D.N.I. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return tipoDNI;
	}

	public ArrayList<TipoDNI> listaTipoDNIs() {
		ArrayList<TipoDNI> lista = new ArrayList<>();
		try {
			String sql = "SELECT dni.CodigoTipoDNI, dni.Descripcion FROM TipoDNI dni";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				tipoDNI = new TipoDNI();
				tipoDNI.setCodigoTipoDNI(resultSet.getInt(1));
				tipoDNI.setDescripcion(resultSet.getString(2));
				lista.add(tipoDNI);
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al generar lista del tipo de D.N.I. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return lista;
	}
}