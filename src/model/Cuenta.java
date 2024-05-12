package model;

/**
 * Created by KCYTVOG on 30/8/2016.
 */

public class Cuenta {
	private int idCuenta;
	private Provincia provincia;
	private Localidad localidad;
	private Barrio barrio;
	private String calle;
	private int altura;
	private TipoVivienda tipoVivienda;
	private String piso;
	private String departamento;
	private String observacion;
	private String telefonoContacto;
	private String correoElectronico;

	public Cuenta() {}

	public Cuenta(int idCuenta, Provincia provincia, Localidad localidad, Barrio barrio, String calle, int altura, TipoVivienda tipoVivienda, String piso, String departamento, String observacion, String telefonoContacto, String correoElectronico) {
		this.idCuenta = idCuenta;
		this.provincia = provincia;
		this.localidad = localidad;
		this.barrio = barrio;
		this.calle = calle;
		this.altura = altura;
		this.tipoVivienda = tipoVivienda;
		this.piso = piso;
		this.departamento = departamento;
		this.observacion = observacion;
		this.telefonoContacto = telefonoContacto;
		this.correoElectronico = correoElectronico;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}

	public Barrio getBarrio() {
		return barrio;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCalle() {
		return calle;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getAltura() {
		return altura;
	}

	public void setTipoVivienda(TipoVivienda tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
	}

	public TipoVivienda getTipoVivienda() {
		return tipoVivienda;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getPiso() {
		return piso;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}
}