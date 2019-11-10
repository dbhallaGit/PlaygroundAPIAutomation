package TestClass;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import testBase.BaseClass;
import testBase.RestClient;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.com.PlayGroundAPI.Data.Product;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;

public class Products extends BaseClass {
	
	public Products() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	BaseClass base;	
	String URI,serviceUrl,APIUrl;
	HashMap<String, String> defaultHeader;
	RestClient restClient;
	
	@BeforeMethod
	  public void setup() throws IOException {
		base=new BaseClass();
		APIUrl=prop.getProperty("URL");		
	  }
	
  //@Test
  public void getProducts() throws ClientProtocolException, IOException {
	  System.out.println(new Throwable().getStackTrace()[0].getMethodName()+"--Execution Started");
	  URI=APIUrl+prop.getProperty("ProductsService");
	  System.out.println("Service URL used-->"+URI );
	  restClient=new RestClient();
	  defaultHeader=restClient.Defaultheader();
	  CloseableHttpResponse response=restClient.getResponse(URI,defaultHeader);
	  System.out.println("Response Status-->"+response.getStatusLine().getStatusCode());
	  System.out.println("Headers received-->"+response.getAllHeaders());
	  String JSONString=EntityUtils.toString(response.getEntity(),"UTF-8");
	  JSONObject jsonObject=new JSONObject(JSONString);
	  System.out.println(jsonObject);
	  System.out.println(restClient.getJSONPayloadValue(restClient.getResponse(URI,defaultHeader), "total"));
	  System.out.println(new Throwable().getStackTrace()[0].getMethodName()+"--Execution completed");
	  
  }
  
  @Test
  public void getProduct() throws ClientProtocolException, IOException {
	  System.out.println(new Throwable().getStackTrace()[0].getMethodName()+"--Execution Started");
	  URI=APIUrl+prop.getProperty("ProductsService");
	  System.out.println("Service URL used-->"+URI );
	  restClient=new RestClient();
	  defaultHeader=restClient.Defaultheader();
	  CloseableHttpResponse response=restClient.getResponse(URI,defaultHeader);
	  System.out.println("Response Status-->"+response.getStatusLine().getStatusCode());
	  System.out.println("Headers received-->"+response.getAllHeaders());
	  System.out.println(restClient.getJSONPayloadValue(restClient.getResponse(URI,defaultHeader), "/data[0]/id"));
	  String FirstProductId=(restClient.getJSONPayloadValue(restClient.getResponse(URI,defaultHeader), "/data[0]/id"));
	  
	  
	  URI=APIUrl+prop.getProperty("ProductsService")+"/"+FirstProductId;
	  System.out.println("Service URL used-->"+URI );
	  CloseableHttpResponse responseSingleProduct=restClient.getResponse(URI,defaultHeader);
	  System.out.println("Response Status-->"+response.getStatusLine().getStatusCode());
	  System.out.println("Headers received-->"+response.getAllHeaders());
	  String JsonEntity=EntityUtils.toString(responseSingleProduct.getEntity(), "UTF-8");
	  JSONObject obj=new JSONObject(JsonEntity);
	 	  
	  ObjectMapper mapper=new ObjectMapper();
	  mapper.configure(
			    DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
	  Gson gson=new GsonBuilder().setPrettyPrinting().create();
	  
	  Product product1= gson.fromJson(JsonEntity,Product.class);
	  System.out.println(product1.getDescription());
	  	
	  
  }

}
