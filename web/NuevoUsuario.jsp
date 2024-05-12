<%--
  Created by IntelliJ IDEA.
  User: KCYTVOG
  Date: 11/9/2016
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType= "text/html;charset=UTF-8" language= "java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Taxi management - Registro de usuario</title>
</head>
  <body>
  	<fieldset>
		<form action="Usuario.do" method="post">
			<table cellpadding="2" cellspacing="2">
				<th>REGISTRO DE USUARIO</th>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<label for="ape">
						<td>Apellido</td>
						<td><input type="text" name="apellido" id="ape"/></td>
					</label>
				</tr>
				<tr>
					<label for="nom">
						<td>Nombre</td>
						<td><input type="text" name="nombre" id="nom"/></td>
					</label>
				</tr>
				<tr>
					<label for="doc">
						<td>Documento</td>
						<td><input type="text" name="documento" id="doc"/></td>
					</label>
				</tr>
				<tr>
					<label for="tdoc">
						<td>Tipo de documento</td>
						<td>
							<select name="tipoDNI" id="tdoc">
								<option value="">Seleccione</option>
								<c:forEach var= "var" items="${listaDNI}">
									<option value="${var.getCodigoTipoDNI()}">${var.getDescripcion()}</option>
								</c:forEach>
							</select>
						</td>
					</label>
				</tr>
				<tr>
					<td>Sexo</td>
					<td>
						<label for="sx">
							<select name="sexo" id="sx">
								<option value="#">Seleccione</option>
								<c:forEach var= "var" items="${listaSEX}">
									<option value="${var.getCodigoSexo()}">${var.getDescripcion()}</option>
								</c:forEach>
							</select>
						</label>
					</td>
				</tr>
				<tr>
					<label for="nac">
						<td>Fecha de nacimiento</td>
						<td><input type="date" name="fechaNacimiento" id="nac" min="1900-01-02" max="2016-12-31"/></td>
					</label>
				</tr>
				<tr>
					<label for="nacion">
						<td>Nacionalidad</td>
						<td>
							<select name="nacionalidad" id="nacion">
								<option value="">Seleccione</option>
								<c:forEach var= "var" items="${listaNAC}">
									<option value="${var.getCodigoNacionalidad()}">${var.getDescripcion()}</option>
								</c:forEach>
							</select>
						</td>
					</label>
				</tr>
				<tr>
					<label for="user">
						<td>Usuario</td>
						<td><input type="text" name="usuario" id="user"/></td>
					</label>
				</tr>
				<tr>
					<label for="pass">
						<td>Contraseña</td>
						<td><input type="password" name="clave" id="pass"/></td>
					</label>
				</tr>
				<tr>
					<label>
						<td>&nbsp;</td>
						<td><input type="submit" value="Siguiente"/></td>
					</label>
				</tr>
			</table>
			<br>
			${error}
		</form>
	</fieldset>
	  <br>
	  <a href="/Inicio">Volver</a><br>
  </body>
</html>