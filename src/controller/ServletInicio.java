package controller;

import dataSource.AccesoDato_Chofer;
import dataSource.AccesoDato_Propietario;
import model.Chofer;
import model.Propietario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by KCYTVOG on 11/9/2016.
 */

public class ServletInicio extends HttpServlet {
	Propietario            propietario;
	AccesoDato_Propietario adp;
	Chofer                 chofer;
	AccesoDato_Chofer      adc;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		adp = new AccesoDato_Propietario();
		adc = new AccesoDato_Chofer();
		if(action == null) {
			//BUSCAMOS EN LA COOKIE EL PROPIETARIO
			int codigoUsuario = verCookies(request);
			if(codigoUsuario <= 0) {
				//REDIRIJIMOS A LA PANTALA DE LOGIN
				request.getRequestDispatcher("Index.jsp").forward(request,response);
			} else {
				//COMPRARAMOS LOS DATOS CON LOS ALMACENADOS EN LA BD PARA DAR ACCESO A LA APLICACIÓN WEB
				Propietario propietario = adp.getPropietario(codigoUsuario);
				Chofer chofer = adc.getChofer(codigoUsuario);
				if(propietario == null) {
					if(chofer == null) {
						request.setAttribute("error", "Datos invalidos.");
						request.getRequestDispatcher("Index.jsp").forward(request,response);
					} else {
						if(adc.loginChofer(chofer.getUsuario(), chofer.getClave()) > 0) {
							session.setAttribute("usuario", chofer);
							response.sendRedirect("Home");
						} else {
							request.setAttribute("error", "Datos invalidos.");
							request.getRequestDispatcher("Index.jsp").forward(request,response);
						}
					}
				} else {
					if(adp.loginPropietario(propietario.getUsuario(), propietario.getClave()) > 0) {
						session.setAttribute("usuario", propietario);
						response.sendRedirect("Home");
					} else {
						request.setAttribute("error", "Datos invalidos.");
						request.getRequestDispatcher("Index.jsp").forward(request,response);
					}
				}
			}
		} else {
			if(action.equalsIgnoreCase("logout")) {
				//ELIMINAR DATOS DE LA SESIÓN
				session.removeAttribute("usuario");
				//ELIMINAR DATOS DE LA COOKIE
				Cookie []cookies = request.getCookies();
				for(Cookie ck : cookies) {
					if(ck.getName().equalsIgnoreCase("cookieID")) {
						ck.setMaxAge(0);
					}
				}
				request.getRequestDispatcher("Index.jsp").forward(request,response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		adp = new AccesoDato_Propietario();
		adc = new AccesoDato_Chofer();
		if(action == null) {
			String usuario = request.getParameter("usuario").trim();
			String clave = request.getParameter("clave").trim();
			boolean recordar = request.getParameter("recordar") != null;
			if(adp.loginPropietario(usuario, clave) <= 0) {
				if(adc.loginChofer(usuario, clave) <= 0) {
					request.setAttribute("error", "Datos invalidos.");
					request.getRequestDispatcher("Index.jsp").forward(request,response);
				} else {
					//BUSCAR ID DE USUARIO QUE LOGRA ENTRAR
					int codigoUsuario = adc.loginChofer(usuario, clave);
					chofer = adc.getChofer(codigoUsuario);
					session.setAttribute("usuario", chofer);
					//SI EL USUARIO ELIGIÓ QUE SE RECUERDEN SUS DATOS, SE CREA UNA COOKIE
					if (recordar) {
						agregarCookie(response, codigoUsuario);
					}
					//TODO REDIRECCIONAR PARA HOME DE CHOFER
					response.sendRedirect("Home?action=chofer");
				}
			} else {
				int codigoUsuario = adp.loginPropietario(usuario, clave);
				propietario = adp.getPropietario(codigoUsuario);
				session.setAttribute("usuario", propietario);
				if (recordar) {
					agregarCookie(response, codigoUsuario);
				}
				//TODO REDIRECCIONAR PARA HOME DE PROPIETARIO
				response.sendRedirect("Home?action=propietario");
			}
		}
	}

	private int verCookies(HttpServletRequest request) {
		//BUSCAMOS LAS TODAS LAS COOKIES Y LAS GUARDAMOS EN UN ARRAY
		Cookie[] cookies = request.getCookies();
		int codigoUsuario = 0;
		if(cookies == null) {
			//NO HAY COOKIES
			return codigoUsuario;
		} else {
			for(Cookie ck : cookies) {
				if(ck.getName().equalsIgnoreCase("cookieID")) {
					//GUARDAMOS EL ID QUE ESTÁ EN LA COOKIE
					codigoUsuario = Integer.parseInt(ck.getValue());
				}
			}
		}
		return codigoUsuario;
	}

	private void agregarCookie(HttpServletResponse response, int id) {
		String codigo = String.valueOf(id);
		Cookie cookieID = new Cookie("codigo", codigo);
		cookieID.setMaxAge(3600);
		response.addCookie(cookieID);
	}
}