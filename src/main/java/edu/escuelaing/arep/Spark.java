package edu.escuelaing.arep;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

public class Spark
{
	private static calculadoraHTTP servidor;

	 public static void main(String[] args )
	    {
	    	port(getPort());
	    	get("/", (req, res)-> datosDeEntrada(req, res));
	    	get("/API/calculadora", (req, res)->
	    	{
	    		String operacion = req.queryParams("operacion");
	    		String numero = req.queryParams("numero");
	    		JSONObject json = new JSONObject(ServidorHTTP.get(operacion, numero));
	    		return json;
	    	});
	    	get("/resultados", (req, res) ->
	    	{
	    		String operacion = req.queryParams("operacion");
	    		String numero = req.queryParams("numero");
	    		JSONObject json = new JSONObject(servidorHTTP.get(operacion, numero));
	    		return datosDeSalida(jsonObject);
	    	});
	    }
	    
	    public static String datosDeSalida(JSONObject json)
	    {
	        String contenido
	        = "<!DOCTYPE html>"
	        + "<html>"
	        + "<body>"
	        + "<h2>Calculadora Trigonometrica</h2>"
	        + "<h4>Operation</h4>"
	        + json.get("operacion")
	        + "<h4>Valor</h4>"
	        + json.get("valor")
	        + "<br/>"
	        + "<button onclick=\"window.location.href='/'\">Nueva Operacion</button>"
	        + "</body>"
	        + "</html>";
	        return contenido;
	    }
	    
	    public static String datosDeEntrada(Request re, Response res)
	    {
	    	String contenido
	        = "<!DOCTYPE html>"
	        + "<html>"
	        + "<body>"
	        + "<h2>Calculadora Trigonometrica</h2>"
	        + "<form action=\"/resultados\">"
	        + "  Number:<br>"
	        + "  <input type=\"text\" name=\"numero\" value=\"\">"
	        + "  <br><br>"
	        + "<label for=\"method\">Operacion:</label>"
	        + "<select name=\"operacion\" id=\"operacion\">"
	        + "<option value=\"sin\">Sin</option>"
	        + "<option value=\"cos\">Cos</option>"
	        + "<option value=\"tan\">Tan</option>"
	        + "</select>"
	        + "<br/>"
	        + "<input type=\"submit\" value=\"Submit\">"
	        + "</form>"
	        + "</body>"
	        + "</html>";
	    	return contenido;
	    }
	    
	public static int getPort()
	{
		if (System.getenv("PORT") != null)
		{
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; 
	}
}
