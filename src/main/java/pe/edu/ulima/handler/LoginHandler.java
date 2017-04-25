package pe.edu.ulima.handler;

import pe.edu.ulima.utils.Httparty;
import pe.edu.ulima.utils.Services;
import spark.Request;
import spark.Response;
import spark.Route;

public class LoginHandler {
	 public static Route validar= (Request request, Response response) -> {
		 String usuario = request.queryParams("usuario");
		 String contrasenia = request.queryParams("contrasenia");
		 
		 String url = Services.getUr("accesos") + "usuario/validar?usuario=" + usuario + "&contrasenia=" + contrasenia;
		 Httparty httparty = new Httparty(url, "POST");
		 httparty.action();
		 		 
		 return httparty.getRpta();
	 };
}