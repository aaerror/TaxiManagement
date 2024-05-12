package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by KCYTVOG on 1/9/2016.
 */

public class Coche {
	private int codigoCoche;
	private Marca marca;
	private String modelo;
	private int ano;
	private String patente;
	private EstadoCoche estadoCoche;
	private Date fechaAlta;
	private Date fechaBaja;
	private ArrayList<RevisionVehicular> listaRevisionVehicular;

	public Coche() {
		listaRevisionVehicular = new ArrayList<>();
	}

	public Coche(int codigoCoche, Marca marca, String modelo, int ano, String patente, EstadoCoche estadoCoche, Date fechaAlta, Date
			fechaBaja) {
		this.codigoCoche = codigoCoche;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.patente = patente;
		this.estadoCoche = estadoCoche;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		listaRevisionVehicular = new ArrayList<>();
	}

	public void setCodigoCoche(int codigoCoche) {
		this.codigoCoche = codigoCoche;
	}

	public int getCodigoCoche() {
		return codigoCoche;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getAno() {
		return ano;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getPatente() {
		return  patente;
	}

	public void setEstadoCoche(EstadoCoche estadoCoche) {
		this.estadoCoche = estadoCoche;
	}

	public EstadoCoche getEstadoCoche() {
		return estadoCoche;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setListaRevisionVehicular(ArrayList<RevisionVehicular> listaRevisionVehicular) {
		this.listaRevisionVehicular = listaRevisionVehicular;
	}

	public ArrayList<RevisionVehicular> getListaRevisionVehicular() {
		return listaRevisionVehicular;
	}

	public void agregarRevisionVehicular(RevisionVehicular revisionVehicular) {
		if(revisionVehicular != null) {
			listaRevisionVehicular.add(revisionVehicular);
		}
	}

	public String toStringFecha() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
		return simpleDateFormat.format(fechaAlta);
	}
}