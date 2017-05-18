package pe.edu.ulima.handler;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pe.edu.ulima.utils.Httparty;
import pe.edu.ulima.utils.Services;
import spark.Request;
import spark.Response;
import spark.Route;

public class LoginHandler {
	 public static Route validar= (Request request, Response response) -> {
		 String rpta = "";
		 String usuario = request.queryParams("usuario");
		 String contrasenia = request.queryParams("contrasenia");
		 String urlAccesos = Services.getUr("accesos") + "usuario/validar?usuario=" + usuario + "&contrasenia=" + contrasenia;
		 //System.out.println(urlAccesos);
		 
		 Httparty httpartyAccesos = new Httparty(urlAccesos, "POST");
		 httpartyAccesos.action();
		 
		 if(httpartyAccesos.getRpta().equalsIgnoreCase("1")){
			 String urlTokens = Services.getUr("tokens") + "generar?usuario=" + usuario;
			 Httparty httpartyTokens = new Httparty(urlTokens, "POST");
			 httpartyTokens.action();
			 JsonParser parser = new JsonParser();
			 JsonElement rptaTokensElement = parser.parse(httpartyTokens.getRpta());
			 JsonObject rptaTokensJsonObject = rptaTokensElement .getAsJsonObject();
			 String token = rptaTokensJsonObject.get("mensaje").getAsString();
			 
			 JsonArray array = new JsonArray();
			 array.add(1); 
			 array.add(token);
			 
			 JsonObject rptaJsonObject = new JsonObject();
			 rptaJsonObject .addProperty("tipo_mensaje ", "success");
			 rptaJsonObject .add("mensaje ", array);
			 
			 rpta = rptaJsonObject .toString();
		 }else{
			 ArrayList<Object> itemsRpta = new ArrayList<>();
			 itemsRpta.add(0);
			 
			 JsonArray array = new JsonArray();
			 array.add(0); 
			 
			 JsonObject rptaJsonObject = new JsonObject();
			 rptaJsonObject .addProperty("tipo_mensaje ", "error");
			 rptaJsonObject .add("mensaje", array);
			 
			 rpta = rptaJsonObject .toString();
		 }
		 
     	return rpta.toString();
	 };
}