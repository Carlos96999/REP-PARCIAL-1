package edu.escuelaing.arep;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.escuelaing.arep.components.HttpRequest;

public class Cliente 
{
	public static void main(String[] args)
	{
		HttpResponse<String> response = null;
		try
		{
			response = Unirest.get("url").asString();
		}catch (UnirestException e)
		{
			e.printStackTrace();
		}
		System.out.println(response.getBody());
	}
}
