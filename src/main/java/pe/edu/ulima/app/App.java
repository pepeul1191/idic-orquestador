package pe.edu.ulima.app;

import static spark.Spark.*;

import javassist.NotFoundException;
import pe.edu.ulima.handler.LoginHandler;
import pe.edu.ulima.handler.UsuarioHandler;

public class App 
{
    public static void main( String[] args )
    {
    	exception(Exception.class, (e, req, res) -> e.printStackTrace()); 
    	
    	port(2000);
    	
    	options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });
    	
    	before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Request-Method",  "*");
            response.header("Access-Control-Allow-Headers",  "*");
            // Note: this may or may not be necessary in your particular application
            response.type("application/json");
        });
    	
    	post("/login", LoginHandler.validar);
    	post("/usuario/validar_correo_repetido", UsuarioHandler.validarCorreoRepetido);
    	post("/usuario/validar_usuario_repetido", UsuarioHandler.validarUsuarioRepetido);
    }
}