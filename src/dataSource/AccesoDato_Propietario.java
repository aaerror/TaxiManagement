package dataSource;

import connection.Singleton;
import model.Coche;
import model.Propietario;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by KCYTVOG on 13/9/2016.
 */

public class AccesoDato_Propietario {
	private static final Singleton conexion = Singleton.getInstance();
	private AccesoDato_TipoDNI      adtdni = new AccesoDato_TipoDNI();
	private AccesoDato_Sexo         adx = new AccesoDato_Sexo();
	private AccesoDato_Nacionalidad adn = new AccesoDato_Nacionalidad();
	private AccesoDato_Cuenta       adcta = new AccesoDato_Cuenta();
	private AccesoDato_Coche        adch = new AccesoDato_Coche();
	private Coche                   coche;
	private Propietario             propietario;


	public Propietario getPropietario(int codigoPropietario) {
		try {
			String sql = "SELECT p.CodigoPropietario, p.Apellido, p.Nombre, td.CodigoTipoDNI, p.Documento, s.CodigoSexo, p" +
			             ".FechaNacimiento, n.CodigoNacionalidad, p.Usuario, p.Clave " +
			             "FROM Propietario p " +
			             "JOIN TipoDNI td on td.CodigoTipoDNI = p.CodigoTipoDNI " +
			             "JOIN Sexo s on s.CodigoSexo = p.CodigoSexo " +
			             "JOIN Nacionalidad n on n.CodigoNacionalidad = p.CodigoNacionalidad " +
			             "WHERE p.CodigoPropietario= 11";
			Statement st = conexion.getConexion().createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				propietario = new Propietario();
				propietario.setIdPropietario(resultSet.getInt(1));
				propietario.setApellido(resultSet.getString(2));
				propietario.setNombre(resultSet.getString(3));
				propietario.setTipoDNI(adtdni.getTipoDNI(resultSet.getInt(4)));
				propietario.setDocumento(resultSet.getInt(5));
				propietario.setSexo(adx.getSexo(resultSet.getInt(6)));
				propietario.setFechaNacimiento(resultSet.getDate(7));
				propietario.setNacionalidad(adn.getNacionalidad(resultSet.getInt(8)));
				propietario.setUsuario(resultSet.getString(9));
				propietario.setClave(resultSet.getString(10));
				propietario.setCuenta(adcta.getDomicilio(codigoPropietario, 0));
			}
			st.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al traer datos del propietario. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return propietario;
	}

	//INSERT
	public void setPropietario(Propietario propietario) {
		try {
			String sql = "INSERT INTO Propietario(Apellido, Nombre, CodigoTipoDNI, Documento, CodigoSexo, FechaNacimiento," +
			             " CodigoNacionalidad, Usuario, Clave)" +
			             "VALUES('" + propietario.getApellido() + "', '" + propietario.getNombre() + "', " +
			             "" + propietario.getTipoDNI().getCodigoTipoDNI() + ", " + propietario.getDocumento() + ", " +
			             "" + propietario.getSexo().getCodigoSexo() + ", '" + propietario.toStringFecha() + "', " +
			             "" + propietario.getNacionalidad().getCodigoNacionalidad() + ", '" + propietario.getUsuario() + "', " +
			             "'" + propietario.getClave() + "')";
			Statement st = conexion.getConexion().createStatement();
			st.executeUpdate(sql);
			st.close();
		} catch(Exception e) {
			System.out.println("Error al crear un nuevo propietario de taxis. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
	}

	//UPDATE
	public void editPropietario(Propietario propietario) {
		try {
			String sql = "UPDATE Propietario SET Apellido= '" + propietario.getApellido() + "', Nombre= '" + propietario.getNombre() + "', CodigoTipoDNI= " + propietario.getTipoDNI().getCodigoTipoDNI() + ", Documento= " + propietario.getDocumento() + ", CodigoSexo= " + propietario.getSexo().getCodigoSexo() + ", FechaNacimiento= '" + propietario.getFechaNacimiento() + "', CodigoNacionalidad= " + propietario.getNacionalidad().getCodigoNacionalidad() + ", Usuario= '" + propietario.getUsuario() + "', Clave= '" + propietario.getClave() + "' WHERE CodigoPropietario= " + propietario.getIdPropietario() + "";
			Statement st = conexion.getConexion().createStatement();
			st.executeUpdate(sql);
			st.close();
		} catch(Exception e) {
			System.out.println("Error al modificar datos personales del propietario. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
	}

	public int loginPropietario(String usuario, String clave) {
		int ingreso = 0;
		try {
			String sql = "SELECT CodigoPropietario FROM Propietario WHERE Usuario LIKE '" + usuario + "' AND Clave LIKE '" + clave + "'";
			Statement st = conexion.getConexion().createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				ingreso = resultSet.getInt(1);
			}
			st.close();
			resultSet.close();
		} catch (Exception e) {
			System.out.println("Error al confirmar el usuario y la contraseña del usuario (propietario). Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return ingreso;
	}

	public int buscarID(int tipoDNI, int documento) {
		int id = 0;
		try {
			String sql = "SELECT p.CodigoPropietario " +
			             "FROM Propietario p " +
			             "JOIN TipoDNI tdni on tdni.CodigoTipoDNI = p.CodigoTipoDNI " +
			             "WHERE p.Documento= " + documento + " " +
			             "AND tdni.CodigoTipoDNI= " + tipoDNI + "";
			Statement st = conexion.getConexion().createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				id = resultSet.getInt(1);
			}
			st.close();
			resultSet.close();
		} catch (Exception e) {
			System.out.println("Error al traer datos del codigo del propietario. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return id;
	}
}