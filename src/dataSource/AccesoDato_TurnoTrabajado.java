package dataSource;

import connection.Singleton;
import model.TurnoTrabajado;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by KCYTVOG on 21/9/2016.
 */
public class AccesoDato_TurnoTrabajado {
	private static final Singleton conexion = Singleton.getInstance();
	private AccesoDato_Chofer adc = new AccesoDato_Chofer();
	private AccesoDato_Coche adch = new AccesoDato_Coche();
	private TurnoTrabajado turnoTrabajado;


	public TurnoTrabajado getTurnoTrabajado(int codigoChofer, int codigoCoche, int codigoPropietario) {
		try {
			conexion.getConexion();
			String sql = "SELECT tr.CodigoTicket, c.CodigoChofer, ch.CodigoCoche, tr.Recaudacion, tr.CantidadViajes, tr" +
			             ".KilometrosOcupados, tr.KilometrosLibres, tr.Combustible, tr.HorarioRecibido, tr.HorarioEntrega " +
			             "FROM TurnoTrabajado tr " +
			             "JOIN Chofer c on c.CodigoChofer = tr.CodigoCoche " +
			             "JOIN Coche ch on ch.CodigoCoche = tr.CodigoCoche " +
			             "WHERE c.CodigoChofer= " + codigoChofer + " " +
			             "AND ch.CodigoCoche= " + codigoCoche + "";
			Statement st = conexion.getConexion().createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				turnoTrabajado = new TurnoTrabajado();
				turnoTrabajado.setCodigoTicket(resultSet.getInt(1));
				turnoTrabajado.setChofer(adc.getChofer(resultSet.getInt(2)));
				turnoTrabajado.setCoche(adch.getCoche(resultSet.getInt(3), codigoPropietario));
				turnoTrabajado.setRecaudacion(resultSet.getDouble(4));
				turnoTrabajado.setCantidadViajes(resultSet.getInt(5));
				turnoTrabajado.setKilometrosOcupados(resultSet.getInt(6));
				turnoTrabajado.setKilometrosLibres(resultSet.getInt(7));
				turnoTrabajado.setCombustible(resultSet.getInt(8));
				turnoTrabajado.setHorarioRecibido(resultSet.getDate(9));
				turnoTrabajado.setHorarioEntrega(resultSet.getDate(10));
			}
			st.close();
			resultSet.close();
		} catch (Exception e) {
			System.out.println("Error al traer datos del turno trabajado. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return turnoTrabajado;
	}

	public ArrayList<TurnoTrabajado> listaTurnosTrabajados(int codigoChofer, int codigoPropietario) {
		ArrayList<TurnoTrabajado> lista = new ArrayList<>();
		try {
			conexion.getConexion();
			String sql = "SELECT tr.CodigoTicket, c.CodigoChofer, ch.CodigoCoche, tr.Recaudacion, tr.CantidadViajes, tr" +
			             ".KilometrosOcupados, tr.KilometrosLibres, tr.Combustible, tr.HorarioRecibido, tr.HorarioEntrega " +
			             "FROM TurnoTrabajado tr " +
			             "JOIN Chofer c on c.CodigoChofer = tr.CodigoChofer " +
						 "JOIN Coche ch on ch.CodigoCoche = tr.CodigoCoche " +
			             "WHERE c.CodigoChofer= " + codigoChofer+ "";
			Statement st = conexion.getConexion().createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				turnoTrabajado = new TurnoTrabajado();
				turnoTrabajado = new TurnoTrabajado();
				turnoTrabajado.setCodigoTicket(resultSet.getInt(1));
				turnoTrabajado.setChofer(adc.getChofer(resultSet.getInt(2)));
				turnoTrabajado.setCoche(adch.getCoche(resultSet.getInt(3), codigoPropietario));
				turnoTrabajado.setRecaudacion(resultSet.getDouble(4));
				turnoTrabajado.setCantidadViajes(resultSet.getInt(5));
				turnoTrabajado.setKilometrosOcupados(resultSet.getInt(6));
				turnoTrabajado.setKilometrosLibres(resultSet.getInt(7));
				turnoTrabajado.setCombustible(resultSet.getInt(8));
				turnoTrabajado.setHorarioRecibido(resultSet.getDate(9));
				turnoTrabajado.setHorarioEntrega(resultSet.getDate(10));
			}
			st.close();
			resultSet.close();
		} catch (Exception e) {
			System.out.println("Error generar lista de turnos trabajados. Causa: " + e.getMessage());
		} finally {
			conexion.closeConexion();
		}
		return lista;
	}
}
