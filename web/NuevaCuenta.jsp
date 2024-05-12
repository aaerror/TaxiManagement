<%--
  Created by IntelliJ IDEA.
  User: KCYTVOG
  Date: 11/9/2016
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType= "text/html;charset=UTF-8" language= "java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Taxi Management - Registro de cuenta</title>
</head>
  <body>
	  <fieldset>
		<form action="Cuenta.do" method="post">
			${error}
			<table>
				<th>Registro cuenta</th>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<label for="prov">
						<td>Provincia</td>
						<td>
							<select name="provincia" id="prov">
								<option value="#">Seleccione</option>
								<c:forEach var="var" items="${listaPROV}">
									<option value="${var.getCodigoProvincia()}">${var.getDescripcion()}</option>
								</c:forEach>
							</select>
						</td>
					</label>
				</tr>
				<tr>
					<label for="loc">
						<td>Localidad</td>
						<td>
							<select name="localidad" id="loc">
								<option value="#">Seleccione</option>
								<c:forEach var="var" items="${listaLOC}">
									<option value="${var.getCodigoLocalidad()}">${var.getDescripcion()}</option>
								</c:forEach>
							</select>
						</td>
					</label>
				</tr>
				<tr>
					<label for="bar">
						<td>Barrio</td>
						<td>
							<select name="barrio" id="bar">
								<option value="#">Seleccione</option>
								<c:forEach var="var" items="${listaBAR}">
									<option value="${var.getCodigoBarrio()}">${var.getDescripcion()}</option>
								</c:forEach>
							</select>
						</td>
					</label>
				</tr>
				<tr>
					<label for="call">
						<td>Calle</td>
						<td><input type="text" name="calle" id="call"/></td>
					</label>
				</tr>
				<tr>
					<label for="num">
						<td>Altura</td>
						<td><input type="text" name="altura" id="num"/></td>
					</label>
				</tr>
				<tr>
          <label for="tv">
					  <td>Tipo vivienda</td>
              <td>
                <c:forEach var="var" items="${listaTV}">
                  <input type="radio" value="${var.getCodigoVivienda()}" name="tipoVivienda" id="tv"/>&nbsp;${var.getDescripcion()}<br>
                </c:forEach>
              </td>
          </label>
				</tr>
        <tr>
          <label for="pis">
            <td>Piso</td>
            <td><input type="text" name="piso" placeholder="5 caracteres..." id="pis"/></td>
          </label>
        </tr>
        <tr>
          <label for="dpto">
            <td>Departamento</td>
            <td><input type="text" name="departamento" placeholder="5 caracteres..." id="dpto"/></td>
          </label>
        </tr>
				<tr>
					<label for="obv">
						<td>Observación</td>
						<td><textarea name="observacion" placeholder="140 caracteres..." maxlength="140" id="obv"></textarea></td>
					</label>
				</tr>
				<tr>
					<label for="tel">
						<td>Teléfono de contacto</td>
						<td><input type="text" name="telefono" placeholder="Formato sin 0 y sin 15" id="tel"/></td>
					</label>
				</tr>
				<tr>
					<label for="email">
          <td>Correo electrónico</td>
						<td><input type="email" name="correo" placeholder="20 caracteres..." id="email"/></td>
					</label>
				</tr>
				<tr>
					<td><input type="hidden" name="action" value="newAccount"/></td>
					<td><button type="submit">Guardar</button></td>
				</tr>
			</table>
		</form>
	</fieldset>
	  <br>
	  <a href="Index">Volver</a>
  </body>
</html>