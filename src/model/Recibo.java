package model;

import java.util.Date;

/**
 * Created by KCYTVOG on 21/9/2016.
 */

public class Recibo {
	private int             codigoRecibo;
	private Propietario     propietario;
	private Chofer          chofer;
	private Date            fecha;
	private TurnoTrabajado  turnoTrabajado;
	private double          recaudacion;
	private boolean         combustible;
	private int             descuento;

	public Recibo() {}

	public Recibo(int codigoRecibo, Propietario propietario, Chofer chofer, Date fecha, TurnoTrabajado turnoTrabajado, double
			recaudacion, boolean combustible, int descuento) {
		this.codigoRecibo = codigoRecibo;
		this.propietario = propietario;
		this.chofer = chofer;
		this.fecha = fecha;
		this.turnoTrabajado = turnoTrabajado;
		this.recaudacion = recaudacion;
		this.combustible = combustible;
		this.descuento = descuento;
	}

	public void setCodigoRecibo(int codigoRecibo) {
		codigoRecibo = codigoRecibo;
	}

	public int getCodigoRecibo() {
		return codigoRecibo;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}

	public Chofer getChofer() {
		return chofer;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setTurnoTrabajado(TurnoTrabajado turnoTrabajado) {
		this.turnoTrabajado = turnoTrabajado;
	}

	public TurnoTrabajado getTurnoTrabajado() {
		return turnoTrabajado;
	}

	public void setRecaudacion(double recaudacion) {
		this.recaudacion = recaudacion;
	}

	public double getRecaudacion() {
		return recaudacion;
	}

	public void setCombustible(boolean combustible) {
		this.combustible = combustible;
	}

	public boolean isCombustible() {
		return combustible;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public int getDescuento() {
		return descuento;
	}
}