package edu.escuelaing.arep;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class calculadoraHTTP
{
	public static String get(String operacion, String numero)
	{
		HttpResponse<String> response = null;
		try
		{
			response = Unirest.get("https://calculadora-arep-parcial.herokuapp.com/operacion?operacion="+operacion+"&numero="+numero).asString();
		} catch(UnirestException e)
		{
			e.printStackTrace();
		}
		return response.getBody();
	}
}
