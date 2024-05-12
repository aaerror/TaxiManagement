<%--
  Created by IntelliJ IDEA.
  User: KCYTVOG
  Date: 24/9/2016
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Gestión Coche - Agregar nuevo coche</title>
</head>
  <body>
    <fieldset>
      <form action="Coche.do" method="post">
        <table cellpadding="2" cellspacing="2">
          <th>REGISTRO DE COCHES</th>
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <label for="mar">
              <td>Marca</td>
              <td>
                <select name="marca" id="mar">
                  <option value="#">Seleccione</option>
                  <c:forEach var="var" items="${listaMAR}">
                    <option value="${var.getCodigoMarca()}">${var.getDescripcion()}</option>
                  </c:forEach>
                </select>
              </td>
            </label>
          </tr>
          <tr>
            <label for="mod">
              <td>Modelo</td>
              <td><input type="text" name="modelo" id="mod"/></td>
            </label>
          </tr>
          <tr>
            <label for="ano">
              <td>Año</td>
              <td><input type="text" name="ano" id="ano"/></td>
            </label>
          </tr>
          <tr>
            <label for="pat">
              <td>Patente</td>
              <td><input type="text" name="patente" id="pat"/></td>
            </label>
          </tr>
          <tr>
            <label>
              <td>&nbsp;</td>
              <td><input type="submit" value="Cargar"/></td>
            </label>
          </tr>
        </table>
        <br>
        ${error}
      </form>
    </fieldset>
    <br>
    <a href="Coche">Volver</a><br>
  </body>
</html>