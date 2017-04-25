package pe.edu.ulima.utils;

import java.util.HashMap;

public class Services {
	public static String getUr(String service){
		HashMap<String, String> servicesMap = new HashMap<String, String>();
		servicesMap.put("accesos", "http://127.0.0.1:5001/");
		
		if(servicesMap.containsKey(service)){
			return servicesMap.get(service);
		}else{
			return null;
		}
	}
}
