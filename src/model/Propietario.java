package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by KCYTVOG on 30/8/2016.
 */

public class Propietario extends Persona {
	private int idPropietario;
	private ArrayList<Chofer> listaChoferes;
	private ArrayList<Coche> listaCoches;
	private ArrayList<TurnoTrabajado> listaTurnosTrabajodos;

	public Propietario() {
		listaChoferes = new ArrayList<>();
		listaCoches = new ArrayList<>();
		listaTurnosTrabajodos = new ArrayList<>();
	}

	public Propietario(String apellido, String nombre, TipoDNI tipoDNI, int documento, Sexo sexo, Date fechaNacimiento, Nacionalidad nacionalidad, String usuario, String clave, int idPropietario, Cuenta cuenta) {
		super(apellido, nombre, tipoDNI, documento, sexo, fechaNacimiento, nacionalidad, usuario, clave, cuenta);
		this.idPropietario = idPropietario;
		cuenta = new Cuenta();
		listaChoferes = new ArrayList<>();
		listaCoches = new ArrayList<>();
		listaTurnosTrabajodos = new ArrayList<>();
	}

	public void setIdPropietario(int idPropietario) {
		this.idPropietario = idPropietario;
	}

	public int getIdPropietario() {
		return idPropietario;
	}

	public void agregarChofer(Chofer chofer) {
		if(chofer != null) {
			listaChoferes.add(chofer);
		}
	}

	public void agregarCoche(Coche coche) {
		if(coche != null) {
			listaCoches.add(coche);
		}
	}

	public void agregarTurnoTrabajado(TurnoTrabajado turnoTrabajado) {
		if(turnoTrabajado != null) {
			listaTurnosTrabajodos.add(turnoTrabajado);
		}
	}

	public String toStringFecha() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
		return simpleDateFormat.format(super.getFechaNacimiento());
	}
}