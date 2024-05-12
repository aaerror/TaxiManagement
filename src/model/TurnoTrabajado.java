package model;

import java.util.Date;

/**
 * Created by KCYTVOG on 3/9/2016.
 */

public class TurnoTrabajado {
	private int codigoTicket;
	private Chofer chofer;
	private Coche coche;
	private double recaudacion;
	private int cantidadViajes;
	private int kilometrosOcupados;
	private int kilometrosLibres;
	private int combustible;
	private Date horarioRecibido;
	private Date horarioEntrega;

	public TurnoTrabajado() {
	}

	public TurnoTrabajado(int codigoTicket, Chofer chofer, Coche coche, double recaudacion, int cantidadViajes, int kilometrosOcupados, int kilometrosLibres, int combustible, Date horarioRecibido, Date horarioEntrega) {
		this.codigoTicket = codigoTicket;
		this.chofer = chofer;
		this.coche = coche;
		this.recaudacion = recaudacion;
		this.cantidadViajes = cantidadViajes;
		this.kilometrosOcupados = kilometrosOcupados;
		this.kilometrosLibres = kilometrosLibres;
		this.combustible = combustible;
		this.horarioRecibido = horarioRecibido;
		this.horarioEntrega = horarioEntrega;
	}

	public void setCodigoTicket(int codigoTicket) {
		this.codigoTicket = codigoTicket;
	}

	public int getCodigoTicket() {
		return codigoTicket;
	}

	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}

	public Chofer getChofer() {
		return chofer;
	}

	public void setCoche(Coche coche) {
		this.coche = coche;
	}

	public Coche getCoche() {
		return coche;
	}

	public void setRecaudacion(double recaudacion) {
		this.recaudacion = recaudacion;
	}

	public double getRecaudacion() {
		return recaudacion;
	}

	public void setCantidadViajes(int cantidadViajes) {
		this.cantidadViajes = cantidadViajes;
	}

	public int getCantidadViajes() {
		return cantidadViajes;
	}

	public void setKilometrosOcupados(int kilometrosOcupados) {
		this.kilometrosOcupados = kilometrosOcupados;
	}

	public int getKilometrosOcupados() {
		return kilometrosOcupados;
	}

	public void setKilometrosLibres(int kilometrosLibres) {
		this.kilometrosLibres = kilometrosLibres;
	}

	public int getKilometrosLibres() {
		return kilometrosLibres;
	}

	public void setCombustible(int combustible) {
		this.combustible = combustible;
	}

	public int getCombustible() {
		return combustible;
	}

	public void setHorarioRecibido(Date horarioRecibido) {
		this.horarioRecibido = horarioRecibido;
	}

	public Date getHorarioRecibido() {
		return horarioRecibido;
	}

	public void setHorarioEntrega(Date horarioEntrega) {
		this.horarioEntrega = horarioEntrega;
	}

	public Date getHorarioEntrega() {
		return horarioEntrega;
	}
}