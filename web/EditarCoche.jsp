<%--
  Created by IntelliJ IDEA.
  User: KCYTVOG
  Date: 25/9/2016
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<html>
  <head>
    <title>Gestión coche - Editar coche</title>
  </head>
  <body>
    <fieldset>
      <form action="Coche.do" method="post">
        <table cellpadding="2" cellspacing="2">
          <th>MODIFICAR COCHES</th>
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>Marca:</td>
            <td><input type="text" name="marca" value="${coche.getMarca().getDescripcion()}" disabled></td>
          </tr>
          <tr>
            <td>Modelo</td>
            <td>${coche.getModelo()}<input type="text" name="modelo" value="${coche.getCodigoModelo()}"disabled></td>
          </tr>
          <tr>
            <td>Año</td>
            <td><input type="text" name="ano" value="${coche.getAno()}" disabled></td>
          </tr>
          <tr>
            <label for="pat">
              <td>Patente</td>
              <td><input type="text" placeholder="${coche.getPatente()}" name="patente" id="pat"/></td>
            </label>
          </tr>
          <tr>
            <label>
              <td><input type="hidden" name="action" value="edit"> </td>
              <td><input type="submit" value="Guardar"/></td>
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
