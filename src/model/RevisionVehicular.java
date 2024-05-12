package model;

import java.util.Date;

/**
 * Created by KCYTVOG on 3/9/2016.
 */

public class RevisionVehicular {
	private int idRevisionVehicular;
	private String descripcion;
	private double costo;
	private Date fecha;

	public RevisionVehicular() {}

	public RevisionVehicular(int idRevisionVehicular, String descripcion, double costo, Date fecha) {
		this.idRevisionVehicular = idRevisionVehicular;
		this.descripcion = descripcion;
		this.costo = costo;
		this.fecha = fecha;
	}

	public void setIdRevisionVehicular(int idRevisionVehicular) {
		this.idRevisionVehicular = idRevisionVehicular;
	}

	public int getIdRevisionVehicular() {
		return idRevisionVehicular;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public double getCosto() {
		return costo;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return fecha;
	}
}