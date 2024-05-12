<%--
  Created by IntelliJ IDEA.
  User: KCYTVOG
  Date: 25/9/2016
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Gestión coches</title>
</head>
  <body>
    <h3>Lista de coches - <a href="Home?action=propietario">volver</a></h3>
    <c:choose>
        <c:when test="${listaCH.size() <= 0}">
        <p>No tiene ningún coche cargado todavía.</p>
      </c:when>
      <c:when test="${listaCH.size() > 0}">
        <c:forEach var="var" items="${listaCH}">
          <fieldset>
            <table>
              <tr>
                <td>Marca:&nbsp;${var.getMarca().getDescripcion()}</td>
              </tr>
              <tr>
                <td>Año:&nbsp;${var.getAno()}</td>
              </tr>
              <tr>
                <td>Patente:&nbsp;${var.getPatente()}</td>
              </tr>
              <tr>
                <td>Estado:&nbsp;${var.getEstadoCoche().getDescripcion()}</td>
              </tr>
              <tr>
                <td>Fecha alta:&nbsp;${var.getFechaAlta()}</td>
              </tr>
              <tr>
                <td>Revisiones vehiculares:
                  <c:choose>
                    <c:when test="${var.getListaRevisionVehicular().size() > 0}">
                      <a href="">&nbsp;Si</a>
                    </c:when>
                    <c:when test="${var.getListaRevisionVehicular().size() <= 0}">
                      &nbsp;No
                    </c:when>
                  </c:choose>
                </td>
              </tr>
              <tr>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td><a href="/Coche.do?action=edit&id=${var.getCodigoCoche()}"><button type="button">Editar</button></a></td>°
                <td><a href="/Coche.do?action=del&id=${var.getCodigoCoche()}"><button type="button">Eliminar</button></a></td>
              </tr>
            </table>
          </fieldset>
        </c:forEach>
      </c:when>
    </c:choose>
    <div>Coches sin uso:
      <c:choose>
        <c:when test="${listaCD.size() > 0}">
          <span><a href="#">${listaCD.size()}</a> coches deshabilitados.&nbsp;</span>
        </c:when>
        <c:otherwise>
          No tiene coches deshabilitados&nbsp;&nbsp;
        </c:otherwise>
      </c:choose>
      <c:choose>
        <c:when test="${listaCR.size() > 0}">
          <span><a href="#">${listaCR.size()}</a> coches en reparación.&nbsp;</span>
        </c:when>
      </c:choose>
    </div>
   <div>Cargar nuevo coche&nbsp;<a href="/Coche.do?action=new&id=0">x</a></div>
  </body>
</html>