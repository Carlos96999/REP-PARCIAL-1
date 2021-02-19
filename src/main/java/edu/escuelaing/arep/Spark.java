package edu.escuelaing.arep;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

public class Spark
{
	private static ServidorHTTP servidor;
	private static App main;
	
	public Spark()
	{
	}

	public int getPort()
	{
		if (System.getenv("PORT") != null)
		{
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; 
	}
}
