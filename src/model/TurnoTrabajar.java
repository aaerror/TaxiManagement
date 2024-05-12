package model;

import java.util.Date;

/**
 * Created by KCYTVOG on 3/9/2016.
 */

public class TurnoTrabajar {
	private Coche coche;
	private Chofer chofer;
	private int turno;
	private Date fecha;
	private boolean confirmado;

	public TurnoTrabajar() {}

	public TurnoTrabajar(Coche coche, Chofer chofer, int turno, Date fecha, boolean confirmado) {
		this.coche = coche;
		this.chofer = chofer;
		this.turno = turno;
		this.fecha = fecha;
		this.confirmado = confirmado;
	}

	public void setCoche(Coche coche) {
		this.coche = coche;
	}

	public Coche getCoche() {
		return coche;
	}

	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}

	public Chofer getChofer() {
		return  chofer;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public int getTurno() {
		return turno;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}

	public boolean getConfirmado() {
		return confirmado;
	}
}