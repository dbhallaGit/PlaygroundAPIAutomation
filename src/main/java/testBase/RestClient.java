package testBase;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class RestClient {
		
	
	public HashMap<String, String> Defaultheader(){
		HashMap<String, String> header=new HashMap<String, String>(){
			{
				put("Content-Type","application/json");
			}
		};
		return header;
	}
	

	public  CloseableHttpResponse getResponse(String URI, HashMap<String, String> defaultHeader) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient=HttpClients.createDefault();
		HttpGet httpget=new HttpGet(URI);
		
		for(Map.Entry<String, String> map:defaultHeader.entrySet())
			httpget.addHeader(map.getKey(), map.getValue());
		
		return httpClient.execute(httpget);
		
	}
	
	public String getJSONPayloadValue(CloseableHttpResponse response,String Element) throws ParseException, IOException {
		String JsonEntity=EntityUtils.toString(response.getEntity());		
		Object obj=new JSONObject(JsonEntity);
		for(String s:Element.split("/"))
			if(!s.isEmpty())
				if(!(s.contains("[")||s.contains("]")))
					obj=((JSONObject)obj).get(s);
				else if(s.contains("[")||s.contains("]"))
				obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
		return obj.toString();
		
				
	}

}
