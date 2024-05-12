package dataSource;

import connection.Singleton;
import model.Recibo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by KCYTVOG on 21/9/2016.
 */

public class AccesoDato_Recibo {
	private static final Singleton conexion = Singleton.getInstance();
	private AccesoDato_Propietario adp;
	private AccesoDato_Chofer adc;
	private AccesoDato_TurnoTrabajado adtt;
	private Recibo recibo;


	public Recibo getRecibo(int codigoRecibo) {
		try {
			conexion.getConexion();
			String sql = "SELECT r.CodigoRecibo, p.CodigoPropietario, c.CodigoChofer, Fecha, dr.Recaudacion, dr.Combustible, dr" +
			             ".Descuento " +
			             "FROM Recibo r, Propietario p, Chofer c, TurnoTrabajado tt, DetalleRecibo dr " +
			             "WHERE r.CodigoRecibo = dr.CodigoRecibo " +
			             "AND r.CodigoPropietario = p.CodigoPropietario " +
			             "AND r.CodigoChofer = c.CodigoChofer " +
			             "AND r.CodigoRecibo = dr.CodigoRecibo " +
						 "AND r.CodigoRecibo= " + codigoRecibo + "";
			Statement st = conexion.getConexion().createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				recibo = new Recibo();
				recibo.setCodigoRecibo(resultSet.getInt(1));
				recibo.setPropietario(adp.getPropietario(resultSet.getInt(2)));
				recibo.setChofer(adc.getChofer(resultSet.getInt(3)));
				recibo.setFecha(resultSet.getDate(4));
				recibo.setRecaudacion(resultSet.getDouble(5));
				recibo.setCombustible(resultSet.getBoolean(6));
				recibo.setDescuento(resultSet.getInt(7));
			}
			st.close();
			resultSet.close();
		} catch (Exception e) {
			System.out.println("Error al traer datos del recibo. Causa" + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return recibo;
	}

	public ArrayList<Recibo> listaRecibos(int codigoChofer) {
		ArrayList<Recibo> lista = new ArrayList<>();
		try {
			conexion.getConexion();
			String sql = "SELECT r.CodigoRecibo, p.CodigoPropietario, c.CodigoChofer, Fecha, dr.Recaudacion, dr.Combustible, dr" +
			             ".Descuento " +
			             "FROM Recibo r, Propietario p, Chofer c, TurnoTrabajado tt, DetalleRecibo dr " +
			             "WHERE r.CodigoRecibo = dr.CodigoRecibo " +
			             "AND r.CodigoPropietario = p.CodigoPropietario " +
			             "AND r.CodigoChofer = c.CodigoChofer " +
			             "AND r.CodigoRecibo = dr.CodigoRecibo " +
			             "AND c.CodigoChofer= " + codigoChofer + "";
			Statement st = conexion.getConexion().createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				recibo = new Recibo();
				recibo.setCodigoRecibo(resultSet.getInt(1));
				recibo.setPropietario(adp.getPropietario(resultSet.getInt(2)));
				recibo.setChofer(adc.getChofer(resultSet.getInt(3)));
				recibo.setFecha(resultSet.getDate(4));
				recibo.setRecaudacion(resultSet.getDouble(5));
				recibo.setCombustible(resultSet.getBoolean(6));
				recibo.setDescuento(resultSet.getInt(7));
				lista.add(recibo);
			}
			st.close();
			resultSet.close();
		} catch (Exception e) {

		} finally {
			conexion.closeConexion();
		}
		return lista;
	}
}