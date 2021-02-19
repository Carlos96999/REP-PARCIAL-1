package edu.escuelaing.arep;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.escuelaing.arep.calculadoraHTTP;

public class Cliente 
{
	public static void main(String[] args)
	{
		HttpResponse<String> response = null;
		try
		{
			response = Unirest.get("https://arep-parcial-fachada.herokuapp.com/API/calcualdora?operacion=sin&numero=0.778548").asString();
		}catch (UnirestException e)
		{
			e.printStackTrace();
		}
		System.out.println(response.getBody());
	}
}
