package model;

import java.util.Date;

/**
 * Created by KCYTVOG on 30/8/2016.
 */

abstract public class Persona {
	private String       apellido;
	private String       nombre;
	private TipoDNI      tipoDNI;
	private int          documento;
	private Sexo         sexo;
	private Date         fechaNacimiento;
	private Nacionalidad nacionalidad;
	private String       usuario;
	private String       clave;
	private Cuenta       cuenta;

	public Persona() {}

	public Persona(String apellido, String nombre, TipoDNI tipoDNI, int documento, Sexo sexo, Date fechaNacimiento, Nacionalidad nacionalidad, String
			usuario, String clave, Cuenta cuenta) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.tipoDNI = tipoDNI;
		this.documento = documento;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.usuario = usuario;
		this.clave = clave;
		this.cuenta = cuenta;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getApellido() {
		return apellido;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setTipoDNI(TipoDNI tipoDNI) {
		this.tipoDNI = tipoDNI;
	}

	public TipoDNI getTipoDNI() {
		return tipoDNI;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public int getDocumento() {
		return documento;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getClave() {
		return clave;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}
}