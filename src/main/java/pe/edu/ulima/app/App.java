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
    	
    	post("/login", LoginHandler.validar);
    	post("/usuario/validar_correo_repetido", UsuarioHandler.validarCorreoRepetido);
    	post("/usuario/validar_usuario_repetido", UsuarioHandler.validarUsuarioRepetido);
    }
}