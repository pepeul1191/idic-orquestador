package pe.edu.ulima.handler;

import pe.edu.ulima.utils.Httparty;
import pe.edu.ulima.utils.Services;
import spark.Request;
import spark.Response;
import spark.Route;

public class UsuarioHandler {
	public static Route validarCorreoRepetido= (Request request, Response response) -> {
		 String correo = request.queryParams("correo");
		 String url = Services.getUr("accesos") + "usuario/validar_correo_repetido?correo=" + correo;
		 Httparty httparty = new Httparty(url, "POST");
		 httparty.action();
		 		 
		 return httparty.getRpta();
	 };
	 
	 public static Route validarUsuarioRepetido= (Request request, Response response) -> {
		 String usuario = request.queryParams("usuario");
		 String url = Services.getUr("accesos") + "usuario/validar_usuario_repetido?usuario=" + usuario;
		 Httparty httparty = new Httparty(url, "POST");
		 httparty.action();
		 		 
		 return httparty.getRpta();
	 };
}
