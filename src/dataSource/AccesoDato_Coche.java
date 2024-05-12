package dataSource;

import connection.Singleton;
import model.Coche;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by KCYTVOG on 14/9/2016.
 */

public class AccesoDato_Coche {
	private static final Singleton conexion = Singleton.getInstance();
	private Statement statement;
	private ResultSet resultSet;
	private AccesoDato_Marca adm = new AccesoDato_Marca();
	private AccesoDato_EstadoCoche adec = new AccesoDato_EstadoCoche();
	private AccesoDato_RevisionVehicular adrv = new AccesoDato_RevisionVehicular();
	private Coche coche;


	//BUSCAR UN COCHE EN PARTICULAR DE UN PROPIETARIO EN PARTICULAR
	public Coche getCoche(int codigoPropietario, int codigoCoche) {
		try {
			String sql = "SELECT pc.CodigoPropietario, c.CodigoCoche, c.CodigoMarca, c.Modelo, c.Ano, c.Patente, pc.CodigoEstadoCoche, " +
			             "pc.FechaAlta, pc.FechaBaja " +
			             "FROM Coche c " +
						 "JOIN PropietarioCoche pc on pc.CodigoPropietario = pc.CodigoCoche " +
						 "JOIN Propietario p on p.CodigoPropietario = pc.CodigoPropietario " +
						 "JOIN Marca m on m.CodigoMarca = c.CodigoMarca " +
						 "JOIN EstadoCoche ec on ec.CodigoEstadoCoche = pc.CodigoEstadoCoche " +
						 "WHERE c.CodigoCoche= " + codigoCoche + " " +
						 "AND p.CodigoPropietario= " + codigoPropietario + "";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				coche = new Coche();
				coche.setCodigoCoche(resultSet.getInt(2));
				coche.setMarca(adm.getMarca(resultSet.getInt(3)));
				coche.setModelo(resultSet.getString(4));
				coche.setAno(resultSet.getInt(5));
				coche.setPatente(resultSet.getString(6));
				coche.setEstadoCoche(adec.getEstadoCoche(resultSet.getInt(7)));
				coche.setFechaAlta(resultSet.getDate(8));
				coche.setFechaBaja(resultSet.getDate(9));
				coche.agregarRevisionVehicular(adrv.getRevisionVehicular(codigoPropietario, codigoCoche));
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al traer datos del coche. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return coche;
	}

	//CREAR UN NUEVO COCHE
	public void setCoche(Coche coche, int codigoPropietario) {
		try {
			String sql = "INSERT INTO Coche(CodigoMarca, Modelo, Ano, Patente) " +
			             "VALUES(" + coche.getMarca().getCodigoMarca() + ", " +
			             "'" + coche.getModelo() + "', " +
			             "" + coche.getAno() + ", " +
			             "'" + coche.getPatente() + "')";
			statement = conexion.getConexion().createStatement();
			statement.executeUpdate(sql);
			setPropietarioCoche(coche, codigoPropietario);
			statement.close();
		} catch(Exception e) {
			System.out.println("Error al cargar un nuevo coche. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
	}

	//MODIFICAR DATOS DE UN NUEVO COCHE
	public void editCoche(Coche coche) {
		try {
			String sql = "UPDATE Coche SET CodigoMarca= " + coche.getMarca().getCodigoMarca() + ", Modelo= '" + coche.getModelo() + "', " +
			             "Ano= " + coche.getAno() + ", Patente= '" + coche.getPatente() + "' " +
			             "WHERE CodigoCoche= " + coche.getCodigoCoche() + "";
			statement = conexion.getConexion().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			System.out.println("Error al modificar los datos del coche. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
	}

	//ELIMINAR DATOS DE UN COCHE
	public void delCoche(Coche coche) {
		try {
			String sql = "UPDATE PropietarioCoche " +
			             "SET FechaBaja= FORMAT(GETDATE(), 'yyyy-MM-dd') " +
			             "WHERE CodigoCoche= " + coche.getCodigoCoche() + "";
			statement = conexion.getConexion().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (Exception e) {
			System.out.println("Error al eliminar el coche. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
	}

	//LISTAR TODOS LOS COCHES ACTIVOS DE UN PROPIETARIO EN PARTICULAR
	public ArrayList<Coche> listaCochesActivos(int codigoPropietario, int estadoCoche) {
		ArrayList<Coche> lista = new ArrayList<>();
		try {
			String sql = "SELECT c.CodigoCoche, c.CodigoMarca, c.Modelo, c.Ano, c.Patente, pc.CodigoEstadoCoche, " +
			             "pc.FechaAlta, pc.FechaBaja " +
			             "FROM Coche c " +
			             "JOIN PropietarioCoche pc on pc.CodigoCoche= c.CodigoCoche " +
			             "JOIN Propietario p on p.CodigoPropietario = pc.CodigoPropietario " +
			             "JOIN Marca m on m.CodigoMarca = c.CodigoMarca " +
			             "JOIN EstadoCoche ec on ec.CodigoEstadoCoche = pc.CodigoEstadoCoche " +
			             "WHERE p.CodigoPropietario= " + codigoPropietario + " " +
			             "AND ec.CodigoEstadoCoche= " + estadoCoche + "";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				coche = new Coche();
				coche.setCodigoCoche(resultSet.getInt(1));
				coche.setMarca(adm.getMarca(resultSet.getInt(2)));
				coche.setModelo(resultSet.getString(3));
				coche.setAno(resultSet.getInt(4));
				coche.setPatente(resultSet.getString(5));
				coche.setEstadoCoche(adec.getEstadoCoche(resultSet.getInt(6)));
				coche.setFechaAlta(resultSet.getDate(7));
				coche.setFechaBaja(resultSet.getDate(8));
				coche.agregarRevisionVehicular(adrv.getRevisionVehicular(codigoPropietario, resultSet.getInt(1)));
				lista.add(coche);
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al generar lista de coches. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return lista;
	}

	//ASIGNAR UN COCHE AL PROPIETARIO
	public void setPropietarioCoche(Coche coche, int codigoPropietario) {
		try {
			String sql = "SELECT c.CodigoCoche " +
			             "FROM Coche c " +
			             "WHERE c.Patente LIKE '" + coche.getPatente() + "'  " +
			             "AND c.CodigoMarca= " + coche.getMarca().getCodigoMarca() + " " +
			             "AND c.Modelo LIKE '" + coche.getModelo() + "'";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String sqlPC = "INSERT INTO PropietarioCoche(CodigoPropietario, CodigoCoche, FechaAlta, CodigoEstadoCoche) " +
				               "VALUES(" + codigoPropietario + ", " + id + ", '" + coche.toStringFecha()  + "', 1 )";
				statement.executeUpdate(sqlPC);
			}
			statement.close();
			resultSet.close();
		} catch (Exception e) {
			System.out.println("Error al cargar el coche al propietario. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
	}
}