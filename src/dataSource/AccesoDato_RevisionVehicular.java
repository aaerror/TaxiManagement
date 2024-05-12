package dataSource;

import connection.Singleton;
import model.RevisionVehicular;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by KCYTVOG on 14/9/2016.
 */

public class AccesoDato_RevisionVehicular {
	private static final Singleton conexion = Singleton.getInstance();
	private Statement statement;
	private ResultSet resultSet;
	private RevisionVehicular revisionVehicular;


	//EXTRAER DATOS DE UNA REVISION VEHICULAR ESPECÍFICA.
	public RevisionVehicular getRevisionVehicular(int codigoPropietario, int codigoCoche) {
		try {
			String sql = "SELECT rc.CodigoRevisionCoche, rc.CodigoCoche, rc.CodigoPropietario, rc.Descripcion, rc.Costo, rc.Fecha " +
			             "FROM RevisionCoche rc " +
			             "JOIN Coche c on c.CodigoCoche = rc.CodigoCoche " +
			             "JOIN Propietario p on p.CodigoPropietario = rc.CodigoPropietario " +
			             "WHERE rc.CodigoPropietario= " + codigoPropietario + " " +
			             "AND rc.CodigoCoche= " + codigoCoche + "";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				revisionVehicular = new RevisionVehicular();
				revisionVehicular.setIdRevisionVehicular(resultSet.getInt(1));
				revisionVehicular.setDescripcion(resultSet.getString(2));
				revisionVehicular.setCosto(resultSet.getDouble(3));
				revisionVehicular.setFecha(resultSet.getDate(4));
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al traer datos de la revisión vehicular. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return revisionVehicular;
	}

	public void setRevisionVehicular(RevisionVehicular revisionVehicular, int codigoCoche, int codigoPropietario) {
		try {
			String sql = "INSERT INTO RevisionCoche(CodigoCoche, CodigoPropietario, Descripcion, Costo, Fecha) VALUES(" + codigoCoche + ", " + codigoPropietario + ", '" + revisionVehicular.getDescripcion() + "', " + revisionVehicular.getCosto() + ", '" + revisionVehicular.getFecha() + "')";
			statement = conexion.getConexion().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			System.out.println("Error al cargar una revisión vehicular. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
	}

	public void editRevisionVehicular(RevisionVehicular revisionVehicular, int codigoCoche, int codigoPropietario) {
		try {
			String sql = "UPDATE RevisionCoche SET Descripcion= '" + revisionVehicular.getDescripcion() +"', Costo= " + revisionVehicular.getCosto() + ", Fecha= '" + revisionVehicular.getFecha() + "' WHERE CodigoCoche= " + codigoCoche + " AND CodigoPropietario= " + codigoPropietario +"";
			statement = conexion.getConexion().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			System.out.println("Error al modificar datos de la revision vehicular. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
	}

	//LISTAR REVISIONES VEHICULARES PARA UN PROPIETARIO PARTICULAR Y UN COCHE PARTICULAR
	public ArrayList<RevisionVehicular> listaRevisionesVehiculares(int codigoPropietario, int codigoCoche) {
		ArrayList<RevisionVehicular> lista = new ArrayList<>();
		try {
			String sql = "SELECT rc.CodigoRevisionCoche, rc.CodigoCoche, rc.CodigoPropietario, rc.Descripcion, rc.Costo, rc.Fecha " +
			             "FROM RevisionCoche rc " +
			             "JOIN Coche c on c.CodigoCoche = rc.CodigoCoche " +
			             "JOIN Propietario p on p.CodigoPropietario = rc.CodigoPropietario " +
			             "WHERE rc.CodigoPropietario= " + codigoPropietario + " " +
						 "AND rc.CodigoCoche= " +codigoCoche + "";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				revisionVehicular = new RevisionVehicular();
				revisionVehicular.setIdRevisionVehicular(resultSet.getInt(1));
				revisionVehicular.setDescripcion(resultSet.getString(2));
				revisionVehicular.setCosto(resultSet.getDouble(3));
				revisionVehicular.setFecha(resultSet.getDate(4));
				lista.add(revisionVehicular);
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al genera lista de revisiones vehiculares. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return lista;
	}
}