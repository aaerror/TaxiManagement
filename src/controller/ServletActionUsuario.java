package controller;

import dataSource.*;
import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by KCYTVOG on 11/9/2016.
 */

public class ServletActionUsuario extends HttpServlet {
	Propietario             propietario;
	AccesoDato_Propietario  adp;
	AccesoDato_TipoDNI      adtdni;
	AccesoDato_Sexo         adx;
	AccesoDato_Nacionalidad adn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if(action == null) {
			adtdni = new AccesoDato_TipoDNI();
			adx = new AccesoDato_Sexo();
			adn = new AccesoDato_Nacionalidad();

			//ELIMINAR DATOS DE LA SESIÓN
			session.removeAttribute("usuario");
			//ELIMINAR DATOS DE LA COOKIE
			Cookie[]cookies = request.getCookies();
			for(Cookie ck : cookies) {
				if(ck.getName().equalsIgnoreCase("cookieID")) {
					ck.setMaxAge(0);
				}
			}
			//SETEAMOS LAS LISTA PARA LOS DROPDOWNLIST Y OTROS
			ArrayList<TipoDNI> listaTipoDNI = adtdni.listaTipoDNIs();
			ArrayList<Sexo> listaSexo = adx.listaSexos();
			ArrayList<Nacionalidad> listaNacionalidad = adn.listaNacionalidades();
			request.setAttribute("listaDNI", listaTipoDNI);
			request.setAttribute("listaSEX", listaSexo);
			request.setAttribute("listaNAC", listaNacionalidad);

			request.getRequestDispatcher("NuevoUsuario.jsp").forward(request,response);
		} else {
			//// TODO: 24/9/2016 registro para nuevo chofer get
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		propietario = new Propietario();
		adp = new AccesoDato_Propietario();
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if(action == null) {
			//REGISTRO DE NUEVO USUARIO
			//GUARDAMOS LOS DATOS DEL FORM
			String apellido = request.getParameter("apellido");
			String nombre = request.getParameter("nombre");
			int tDNI = Integer.parseInt(request.getParameter("tipoDNI"));
			int documento = Integer.parseInt(request.getParameter("documento"));

			SimpleDateFormat simpleDateFormat= new SimpleDateFormat("YYYY-MM-dd");
			Date var;
			try {
				var = simpleDateFormat.parse(request.getParameter("fechaNacimiento"));
				propietario.setFechaNacimiento(var);
			} catch (Exception e) {
				System.out.println("Error al darle formato a la la fecha de nacimiento. Causa:" + e.getMessage());
			}

			int sex = Integer.parseInt(request.getParameter("sexo"));
			int nacion = Integer.parseInt(request.getParameter("nacionalidad"));
			String usuario = request.getParameter("usuario");
			String clave = request.getParameter("clave");

			propietario.setApellido(apellido);
			propietario.setNombre(nombre);
			propietario.setTipoDNI(adtdni.getTipoDNI(tDNI));
			propietario.setDocumento(documento);
			propietario.setSexo(adx.getSexo(sex));
			propietario.setNacionalidad(adn.getNacionalidad(nacion));
			propietario.setUsuario(usuario);
			propietario.setClave(clave);
			session.setAttribute("usuario", propietario);
			response.sendRedirect("Cuenta.do?action=nueva");
		} else {
			//// TODO: 24/9/2016 registro para nuevo chofer post
		}
	}
}