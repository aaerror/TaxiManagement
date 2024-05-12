package controller;

import dataSource.AccesoDato_Coche;
import dataSource.AccesoDato_Marca;
import model.Coche;
import model.Marca;
import model.Propietario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by KCYTVOG on 25/9/2016.
 */

public class ServletActionCoche extends HttpServlet {
	Coche coche;
	AccesoDato_Marca adm;
	AccesoDato_Coche adc;
	Propietario propietario;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		int idCoche = Integer.parseInt(request.getParameter("id"));
		propietario = (Propietario) session.getAttribute("usuario");

		if(action.equalsIgnoreCase("new")) {
			adm = new AccesoDato_Marca();
			ArrayList<Marca> listaMarca = adm.listaMarcas();
			request.setAttribute("listaMAR", listaMarca);
			request.getServletContext().getRequestDispatcher("/NuevoCoche.jsp").forward(request, response);
		} else {
			if(action.equalsIgnoreCase("edit")) {
				adm = new AccesoDato_Marca();
				adc = new AccesoDato_Coche();
				coche = adc.getCoche(propietario.getIdPropietario(), idCoche);
				adm = new AccesoDato_Marca();
				ArrayList<Marca> listaMarca = adm.listaMarcas();
				request.setAttribute("listaMAR", listaMarca);
				request.setAttribute("coche", coche);
				request.getServletContext().getRequestDispatcher("/EditarCoche.jsp").forward(request, response);
			} else {
				if(action.equalsIgnoreCase("del")) {
					adc = new AccesoDato_Coche();
					adc.delCoche(adc.getCoche(propietario.getIdPropietario(), idCoche));
					response.sendRedirect("Coche");
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		propietario = (Propietario) session.getAttribute("usuario");
		if(action == null) {
			adc = new AccesoDato_Coche();
			Coche coche = new Coche();
			int marca = Integer.parseInt(request.getParameter("marca"));
			String modelo = request.getParameter("modelo");
			int ano = Integer.parseInt(request.getParameter("ano"));
			String patente = request.getParameter("patente");

			coche.setMarca(adm.getMarca(marca));
			coche.setModelo(modelo);
			coche.setAno(ano);
			coche.setPatente(patente);
			Date date = new Date();
			coche.setFechaAlta(date);
			adc.setCoche(coche, propietario.getIdPropietario());
			propietario.agregarCoche(coche);
			session.removeAttribute("usuario");
			session.setAttribute("usuario", propietario);
			response.sendRedirect("Coche");
		} else {
			if(action.equalsIgnoreCase("editar")) {
				adc = new AccesoDato_Coche();
				Coche coche = (Coche) request.getAttribute("coche");
				String patente = request.getParameter("patente");
				coche.setPatente(patente);
				adc.editCoche(coche);
				response.sendRedirect("Coche");
			}
		}
	}
}