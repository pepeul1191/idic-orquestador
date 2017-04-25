package pe.edu.ulima.app;

import static spark.Spark.*;

import javassist.NotFoundException;
import pe.edu.ulima.handler.LoginHandler;

public class App 
{
    public static void main( String[] args )
    {
    	exception(Exception.class, (e, req, res) -> e.printStackTrace()); 
    	port(2000);
    	post("/login", LoginHandler.validar);
    }
}