package dataSource;

import connection.Singleton;
import model.Chofer;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by KCYTVOG on 11/9/2016.
 */

public class AccesoDato_Chofer {
	private static final Singleton conexion = Singleton.getInstance();
	private AccesoDato_TipoDNI      adtdni = new AccesoDato_TipoDNI();
	private AccesoDato_Sexo         adx = new AccesoDato_Sexo();
	private AccesoDato_Nacionalidad adn = new AccesoDato_Nacionalidad();
	private AccesoDato_Cuenta       adcta = new AccesoDato_Cuenta();
	private Statement               statement;
	private ResultSet               resultSet;
	private Chofer                  chofer;


	/* SELECT c.CodigoChofer, c.Apellido, c.Nombre, td.CodigoTipoDNI, c.Documento, sx.CodigoSexo, c.FechaNacimiento, n.CodigoNacionalidad, c
	.Usuario, c.Clave
	   FROM Chofer c, TipoDNI td, Sexo sx, Nacionalidad n
	   WHERE c.CodigoTipoDNI = td.CodigoTipoDNI
	   AND c.CodigoSexo = sx.CodigoSexo
	   AND c.CodigoNacionalidad = n.CodigoNacionalidad */
	public Chofer getChofer(int codigoChofer) {
		try {
			String sql = "SELECT c.CodigoChofer, c.Apellido, c.Nombre, td.CodigoTipoDNI, c.Documento, s.CodigoSexo, c.FechaNacimiento, n" +
			             ".CodigoNacionalidad, c.Usuario, c.Clave " +
			             "FROM Chofer c " +
			             "JOIN TipoDNI td on td.CodigoTipoDNI = c.CodigoTipoDNI " +
			             "JOIN Sexo s on s.CodigoSexo = c.CodigoSexo " +
			             "JOIN Nacionalidad n on n.CodigoNacionalidad = c.CodigoNacionalidad " +
			             "WHERE c.CodigoChofer = " + codigoChofer + "";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				chofer = new Chofer();
				chofer.setIdChofer(resultSet.getInt(1));
				chofer.setApellido(resultSet.getString(2));
				chofer.setNombre(resultSet.getString(3));
				chofer.setTipoDNI(adtdni.getTipoDNI(resultSet.getInt(4)));
				chofer.setDocumento(resultSet.getInt(5));
				chofer.setSexo(adx.getSexo(resultSet.getInt(6)));
				chofer.setFechaNacimiento(resultSet.getDate(7));
				chofer.setNacionalidad(adn.getNacionalidad(resultSet.getInt(8)));
				chofer.setUsuario(resultSet.getString(9));
				chofer.setClave(resultSet.getString(10));
				chofer.setCuenta(adcta.getDomicilio(0, codigoChofer));
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al traer datos del chofer. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return chofer;
	}

	//INSERT
	public void setChofer(Chofer chofer) {
		try {
			String sql = "INSERT INTO Chofer(Apellido, Nombre, CodigoTipoDNI, Documento, CodigoSexo, FechaNacimiento, CodigoNacionalidad," +
			             " Usuario, Clave)" +
			             "VALUES('" + chofer.getApellido() + "', '" + chofer.getNombre() + "'," +
			             "" + chofer.getTipoDNI().getCodigoTipoDNI() + ", " + chofer.getDocumento() + "," +
			             "" + chofer.getSexo().getCodigoSexo() + ", '" + chofer.getFechaNacimiento() + "'," +
			             "" + chofer.getNacionalidad().getCodigoNacionalidad() + ", '" + chofer.getUsuario() + "'," +
			             "'" + chofer.getClave() + "'";
			statement = conexion.getConexion().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			System.out.println("Error al crear un nuevo chofer. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
	}

	//UPDATE
	public void editChofer(Chofer chofer) {
		try {
			String sql = "UPDATE Chofer SET Apellido= '" + chofer.getApellido() + "',Nombre= '" + chofer.getNombre() + "', CodigoTipoDNI= " + chofer.getTipoDNI().getCodigoTipoDNI() + ", Documento= " + chofer.getDocumento() + ", CodigoSexo= " + chofer.getSexo().getCodigoSexo() + ", FechaNacimiento= '" + chofer.getFechaNacimiento() + "', CodigoNacionalidad= " + chofer.getNacionalidad().getCodigoNacionalidad() + ", Usuario= '" + chofer.getUsuario() + "', Clave= '" + chofer.getClave() + "' WHERE CodigoChofer= '" + chofer.getIdChofer() + "'";
			statement = conexion.getConexion().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			System.out.println("Error al modificar datos personales del chofer. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
	}

	public int loginChofer(String usuario, String clave) {
		int ingreso = 0;
		try {
			String sql = "SELECT c.CodigoChofer FROM Chofer c WHERE c.Usuario LIKE '" + usuario +"' AND c.Clave LIKE '" + clave + "'";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				ingreso = resultSet.getInt(1);
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al confirmar el usuario y la contraseña del usuario (chofer). Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return ingreso;
	}
}