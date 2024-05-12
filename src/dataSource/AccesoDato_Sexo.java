package dataSource;

import connection.Singleton;
import model.Sexo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by KCYTVOG on 10/9/2016.
 */

public class AccesoDato_Sexo {
	private static final Singleton conexion = Singleton.getInstance();
	private Statement statement;
	private ResultSet resultSet;
	private Sexo sexo;


	public Sexo getSexo(int codigoSexo) {
		try {
			String sql = "SELECT x.CodigoSexo, x.Descripcion " +
			             "FROM Sexo x " +
			             "WHERE x.CodigoSexo= " + codigoSexo + "";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				sexo = new Sexo();
				sexo.setCodigoSexo(resultSet.getInt(1));
				sexo.setDescripcion(resultSet.getString(2));
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al traer datos del sexo. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return sexo;
	}

	public ArrayList<Sexo> listaSexos() {
		ArrayList<Sexo> lista = new ArrayList<>();
		try {
			String sql = "SELECT x.CodigoSexo, x.Descripcion FROM Sexo x";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				sexo = new Sexo();
				sexo.setCodigoSexo(resultSet.getInt(1));
				sexo.setDescripcion(resultSet.getString(2));
				lista.add(sexo);
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al generar lista de tipos de sexo. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return lista;
	}
}