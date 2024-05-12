package controller;

import dataSource.*;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by KCYTVOG on 24/9/2016.
 */

public class ServletActionCuenta extends HttpServlet {
	Cuenta                  cuenta;
	Propietario             propietario;
	AccesoDato_Propietario  adp;
	AccesoDato_Cuenta       adc;
	AccesoDato_Provincia    adprov;
	AccesoDato_Localidad    adl;
	AccesoDato_Barrio       adb;
	AccesoDato_TipoVivienda adtv;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("nueva")) {
			adprov = new AccesoDato_Provincia();
			adl = new AccesoDato_Localidad();
			adb = new AccesoDato_Barrio();
			adtv = new AccesoDato_TipoVivienda();
			ArrayList<Provincia> listaProvincia = adprov.listaProvincias();
			ArrayList<Localidad> listaLocalidad = adl.listaLocalidades();
			ArrayList<Barrio> listaBarrio = adb.listaBarrios();
			ArrayList<TipoVivienda> listaTipoVivienda = adtv.listaTipoViviendas();
			request.setAttribute("listaPROV", listaProvincia);
			request.setAttribute("listaLOC", listaLocalidad);
			request.setAttribute("listaBAR", listaBarrio);
			request.setAttribute("listaTV", listaTipoVivienda);
			request.getServletContext().getRequestDispatcher("/NuevaCuenta.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if(action.equalsIgnoreCase("newAccount")) {
			cuenta = new Cuenta();
			adp = new AccesoDato_Propietario();
			adc = new AccesoDato_Cuenta();
			//TOMAMOS DATOS DE LA VISTA
			int provincia = Integer.parseInt(request.getParameter("provincia"));
			int localidad = Integer.parseInt(request.getParameter("localidad"));
			int bar = Integer.parseInt(request.getParameter("barrio"));
			String calle = request.getParameter("calle");
			int altura = Integer.parseInt(request.getParameter("altura"));
			int tipoVivi = Integer.parseInt(request.getParameter("tipoVivienda"));
			String piso = request.getParameter("piso");
			String departamento = request.getParameter("departamento");
			String observacion = request.getParameter("observacion");
			String telefono = request.getParameter("telefono");
			String correo = request.getParameter("correo");

			cuenta.setProvincia(adprov.getProvincia(provincia));
			cuenta.setLocalidad(adl.getLocalidad(localidad));
			cuenta.setBarrio(adb.getBarrio(bar));
			cuenta.setCalle(calle);
			cuenta.setAltura(altura);
			cuenta.setTipoVivienda(adtv.getTipoVivienda(tipoVivi));
			cuenta.setPiso(piso);
			cuenta.setDepartamento(departamento);
			cuenta.setObservacion(observacion);
			cuenta.setTelefonoContacto(telefono);
			cuenta.setCorreoElectronico(correo);

			propietario = (Propietario) session.getAttribute("usuario");
			adp.setPropietario(propietario);
			propietario.setIdPropietario(adp.buscarID(propietario.getTipoDNI().getCodigoTipoDNI(), propietario.getDocumento()));
			adc.setDomicilio(cuenta, propietario.getIdPropietario(), 0);
			propietario.setCuenta(cuenta);
			session.removeAttribute("usuario");
			session.setAttribute("usuario", propietario);
			response.sendRedirect("Home?action=propietario");
		}
	}
}