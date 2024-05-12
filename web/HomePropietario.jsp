<%--
  Created by IntelliJ IDEA.
  User: KCYTVOG
  Date: 12/9/2016
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<html>
<head>
	<title>Taxi Management - Propietario</title>
</head>
  <body>
  <div>Bienvenido -&nbsp;<a href="Inicio?action=logout">Salir</a></div>
  <hr>
  <div>Apellido:&nbsp;${sessionScope.usuario.getApellido()}</div>
  <div>Nombre:&nbsp;${sessionScope.usuario.getNombre()}</div>
  <div>${sessionScope.usuario.getTipoDNI().getDescripcion()}:&nbsp;${sessionScope.usuario.getDocumento()}</div>
  <div>Nacionalidad:&nbsp;${sessionScope.usuario.getNacionalidad().getDescripcion()}</div>
  <br>
  <table cellspacing="2" cellpadding="2">
    <th>Lista de tareas</th>
    <tr>
      <td>Modificar datos personales</td>
      <td><a href="">&nbsp;ir</a></td>
    </tr>
    <tr>
      <td>Modificar datos de la cuenta</td>
      <td><a href="">&nbsp;ir</a></td>
    </tr>
    <tr>
      <td>Choferes</td>
      <td><a href="Chofer">&nbsp;ir</a></td>
    </tr>
    <tr>
      <td>Taxis</td>
      <td><a href="Coche">&nbsp;ir</a></td>
    </tr>
    <tr>
      <td>Ver reportes</td>
      <td><a href="Reportes">&nbsp;ir</a></td>
    </tr>
  </table>
  </body>
</html>