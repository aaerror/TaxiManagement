package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by KCYTVOG on 30/8/2016.
 */

public class Chofer extends Persona {
	private int idChofer;
	private ArrayList<TurnoTrabajar> listaTurnoTrabajar;

	public Chofer() {}

	public Chofer(String apellido, String nombre, TipoDNI tipoDNI, int documento, Sexo sexo, Date fechaNacimiento, Nacionalidad nacionalidad, String usuario, String clave, int idChofer, Cuenta cuenta) {
		super(apellido, nombre, tipoDNI, documento, sexo, fechaNacimiento, nacionalidad, usuario, clave, cuenta);
		this.idChofer = idChofer;
		listaTurnoTrabajar = new ArrayList<>();
	}

	public void setIdChofer(int idChofer) {
		this.idChofer = idChofer;
	}

	public int getIdChofer() {
		return idChofer;
	}
}