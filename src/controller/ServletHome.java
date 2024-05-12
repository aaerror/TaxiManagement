package controller;

import dataSource.AccesoDato_Propietario;
import model.Propietario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by KCYTVOG on 14/9/2016.
 */

public class ServletHome extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if(usuarioLogeado(session, request)) {
			if(action.equalsIgnoreCase("propietario")) {
				request.getServletContext().getRequestDispatcher("/HomePropietario.jsp").forward(request, response);
			} else {
				if(action.equalsIgnoreCase("chofer")) {
					request.getServletContext().getRequestDispatcher("/HomeChofer.jsp").forward(request, response);
				}
			}
		} else {
			response.sendRedirect("Inicio");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	private boolean usuarioLogeado(HttpSession session, HttpServletRequest request) {
		boolean ingreso = false;
		if(session != null) {
			Propietario propietario = (Propietario) session.getAttribute("usuario");
			AccesoDato_Propietario adc = new AccesoDato_Propietario();
			int id = adc.loginPropietario(propietario.getUsuario(), propietario.getClave());
			if(id > 0) {
				ingreso = true;
			} else {
				session.removeAttribute("usuario");
				Cookie[]cookies = request.getCookies();
				for(Cookie ck : cookies) {
					if(ck.getName().equalsIgnoreCase("cookieID")) {
						ck.setMaxAge(0);
					}
				}
			}
		}
		return ingreso;
	}
}