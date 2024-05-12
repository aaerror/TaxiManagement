package controller;

import dataSource.AccesoDato_Coche;
import dataSource.AccesoDato_Marca;
import dataSource.AccesoDato_RevisionVehicular;
import model.Coche;
import model.Propietario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by KCYTVOG on 25/9/2016.
 */

public class ServletCoche extends HttpServlet {
	Propietario propietario = new Propietario();
	AccesoDato_Coche adc;
	AccesoDato_RevisionVehicular adrv;
	AccesoDato_Marca adm;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		propietario = (Propietario) session.getAttribute("usuario");
		if(action == null) {
			adc = new AccesoDato_Coche();
			adrv = new AccesoDato_RevisionVehicular();
			ArrayList<Coche> habilitados = adc.listaCochesActivos(propietario.getIdPropietario(), 1);
			ArrayList<Coche> deshabilitados = adc.listaCochesActivos(propietario.getIdPropietario(), 2);
			ArrayList<Coche> enReparacion = adc.listaCochesActivos(propietario.getIdPropietario(), 3);
			request.setAttribute("listaCH", habilitados);
			request.setAttribute("listaCD", habilitados);
			request.setAttribute("listaCR", habilitados);
			request.getServletContext().getRequestDispatcher("/GestionCoche.jsp").forward(request,response);
		} else {

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}