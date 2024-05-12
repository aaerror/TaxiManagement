<%--
  Created by IntelliJ IDEA.
  User: KCYTVOG
  Date: 11/9/2016
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
	<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimum-scale=1.0"/>
    <title>Taxi management</title>
    <link rel="stylesheet" href="Resources/css/bootstrap.css">
	</head>
  <body>
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <fieldset>
            <legend>¡Ingreso a Taxi Management!</legend>
            <form class="form-horizontal" action="Inicio" method="post">
              <div class="form-group">
                <label for="txtBxUsuario" class="col-sm-2 control-label">Usuario</label>
                <div class="col-sm-10">
                  <input type="text" name="usuario" class="form-control" id="txtBxUsuario" placeholder="Usuario">
                </div>
              </div>
              <div class="form-group">
                <label for="txtBxClave" class="col-sm-2 control-label">Contraseña</label>
                <div class="col-sm-10">
                  <input type="password" name="clave" class="form-control" id="txtBxClave" placeholder="Contraseña">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <div class="checkbox">
                    <label for="txtBxRecordar">
                      <input type="checkbox" name="recordar" id="txtBxRecordar"> Recordar datos?
                    </label>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-default">Ingresar</button>
                </div>
              </div>
              <p class="col-sx-10 col-sm-offset-2 text-danger">${error}</p>
            </form>
          </fieldset>
          <br>
          <span class="col-xs-12">Sino tiene usuario y quiere crea uno, hacer click&nbsp<a href="/Usuario.do">aquí</a>.
          </span>
        </div>
      </div>
    </div>
  <script src="Resources/js/jQuery-3.1.1.js"></script>
  <script src="Resources/js/bootstrap.js"></script>
	</body>
</html>