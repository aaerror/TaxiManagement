package dataSource;

import connection.Singleton;
import model.Cuenta;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by KCYTVOG on 10/9/2016.
 */

public class AccesoDato_Cuenta {
	private static final Singleton conexion = Singleton.getInstance();
	private Statement               statement;
	private ResultSet               resultSet;
	private AccesoDato_Provincia    adp = new AccesoDato_Provincia();
	private AccesoDato_Localidad    adl = new AccesoDato_Localidad();
	private AccesoDato_Barrio       adb = new AccesoDato_Barrio();
	private AccesoDato_TipoVivienda adtp = new AccesoDato_TipoVivienda();
	private Cuenta                  cuenta;


	public Cuenta getDomicilio(int codigoPropietario, int codigoChofer) {
		try {
			String sql = "";
			if(codigoPropietario >= 0 && codigoChofer == 0) {
				sql = "SELECT dp.CodigoCuenta, dp.CodigoProvincia, dp.CodigoLocalidad, dp.CodigoBarrio, dp.Calle, dp.Altura, " +
				      "dp.CodigoTipoVivienda, dp.Piso, dp.Departamento, dp.Observacion, dp.TelefonoContacto, dp.CorreoElectronico, " +
				      "dp.CodigoPropietario " +
				      "FROM DomicilioPropietario dp " +
				      "WHERE dp.CodigoPropietario= " + codigoPropietario + "";
			} else {
				if(codigoChofer >= 0 && codigoPropietario == 0) {
					sql = "SELECT dc.CodigoCuenta, dc.CodigoProvincia, dc.CodigoLocalidad, dc.CodigoBarrio, dc.Calle, dc.Altura, " +
					      "dc.CodigoTipoVivienda, dc.Piso, dc.Departamento, dc.Observacion, dc.TelefonoContacto, dc.CorreoElectronico, " +
					      "dc.CodigoChofer " +
					      "FROM DomicilioChofer dc " +
					      "WHERE dc.CodigoPropietario= " + codigoChofer + "'";
				}
			}
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				cuenta = new Cuenta();
				cuenta.setIdCuenta(resultSet.getInt(1));
				cuenta.setProvincia(adp.getProvincia(resultSet.getInt(2)));
				cuenta.setLocalidad(adl.getLocalidad(resultSet.getInt(3)));
				cuenta.setBarrio(adb.getBarrio(resultSet.getInt(4)));
				cuenta.setCalle(resultSet.getString(5));
				cuenta.setAltura(resultSet.getInt(6));
				cuenta.setTipoVivienda(adtp.getTipoVivienda(resultSet.getInt(7)));
				cuenta.setPiso(resultSet.getString(8));
				cuenta.setDepartamento(resultSet.getString(9));
				cuenta.setObservacion(resultSet.getString(10));
				cuenta.setTelefonoContacto(resultSet.getString(11));
				cuenta.setCorreoElectronico(resultSet.getString(12));
			}
			statement.close();
			resultSet.close();
		} catch(Exception e) {
			System.out.println("Error al traer datos del domicilio. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return cuenta;
	}

	//INSERT
	public void setDomicilio(Cuenta cuenta, int codigoPropietario, int codigoChofer) {
		try {
			String sql = "";
			if(codigoPropietario >= 0 && codigoChofer == 0) {
				sql = "INSERT INTO Cuenta(CodigoProvincia, CodigoLocalidad, CodigoBarrio, Calle, Altura, CodigoTipoVivienda, Piso, " +
				      "Departamento, Observacion, TelefonoContacto, CorreoElectronico, CodigoPropietario) " +
				      "VALUES(" + cuenta.getProvincia().getCodigoProvincia() + ", " + cuenta.getLocalidad().getCodigoLocalidad() + ", " +
				      ""+ cuenta.getBarrio().getCodigoBarrio() + ", '" + cuenta.getCalle() + "', " + cuenta.getAltura() + ", " +
				      "" + cuenta.getTipoVivienda().getCodigoVivienda() + ", '" + cuenta.getPiso() + "', " +
				      "'" + cuenta.getDepartamento() + "', '"	+ cuenta.getObservacion() + "', '" + cuenta.getTelefonoContacto() + "', " +
				      "'" + cuenta.getCorreoElectronico() + "', " + codigoPropietario + ")";
			} else {
				if(codigoChofer >= 0 && codigoPropietario == 0) {
					sql = "INSERT INTO Cuenta(CodigoProvincia, CodigoLocalidad, CodigoBarrio, Calle, Altura, CodigoTipoVivienda, Piso, " +
					      "Departamento, Observacion, TelefonoContacto, CorreoElectronico, CodigoChofer) " +
					      "VALUES(" + cuenta.getProvincia().getCodigoProvincia() + ", " + cuenta.getLocalidad().getCodigoLocalidad() + "," +
					      " " + cuenta.getBarrio().getCodigoBarrio() + ", '" + cuenta.getCalle() + "', " + cuenta.getAltura() + ", " +
					      "" + cuenta.getTipoVivienda().getCodigoVivienda() + ", '" + cuenta.getPiso() + "', " +
					      "'" + cuenta.getDepartamento() + "', '"	+ cuenta.getObservacion() + "', '" + cuenta.getTelefonoContacto() + "'," +
					      " '" + cuenta.getCorreoElectronico() + "', " + codigoChofer + ")";
				}
			}
			statement = conexion.getConexion().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			System.out.println("Error al crear el domicilio del usuario. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
	}

	//UPDATE
	public void editDomicilio(Cuenta cuenta) {
		try {
			String sql = "UPDATE Chofer SET CodigoProvincia= " + cuenta.getProvincia().getCodigoProvincia() + ", CodigoLocalidad= " + cuenta.getLocalidad().getCodigoLocalidad() + ", CodigoBarrio= " + cuenta.getBarrio().getCodigoBarrio() + ", Calle= '" + cuenta.getCalle() + "', Altura= " + cuenta.getAltura() + ", CodigoTipoVivienda= " + cuenta.getTipoVivienda().getCodigoVivienda() + ", Piso= '" + cuenta.getPiso() + "', Departamento= '" + cuenta.getDepartamento() + "', Observacion= '" + cuenta.getObservacion() + "', TelefonoContacto= '" + cuenta.getTelefonoContacto() + "', CorreoElectronico= '" + cuenta.getCorreoElectronico() + "', WHERE CodigoCuenta= " + cuenta.getIdCuenta() + "";
			statement = conexion.getConexion().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch(Exception e) {
			System.out.println("Error al modificar datos del domicilio del usuario. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
	}

	public boolean correo(String correo) {
		boolean valido = false;
		try {
			String sql = "SELECT c.CodigoCuenta, c.CodigoProvincia, c.CodigoLocalidad, c.CodigoBarrio, c.Calle, c.Altura, c.CodigoTipoVivienda, c.Piso, c.Departamento, c.Observacion, c.TelefonoContacto, c.CorreoElectronico FROM Cuenta c, Provincia p, Localidad l, Barrio b, TipoVivienda tv WHERE c.CodigoProvincia = p.CodigoProvincia AND c.CodigoLocalidad = l.CodigoLocalidad AND c.CodigoBarrio = b.CodigoBarrio AND c.CodigoTipoVivienda = tv.CodigoTipoVivienda AND c.CorreoElectronico = '" + correo + "'";
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				valido = true;
			}
			statement.close();
			resultSet.close();
		} catch (Exception e) {
			System.out.println("Error al corroborar el correo electrónico. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return valido;
	}
}