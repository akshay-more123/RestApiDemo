package Auothintication;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import Pojo.AddPlace;
import Pojo.LocationClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;


//response nor print in console
public class Serielisation {

	@Test
	 public void getData()
	 {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		AddPlace ap = new AddPlace();
		  ap.setWebsite("https://rahulshettyacademy.com");
		  ap.setAddress("29, side layout, cohen 09");
		  ap.setAccuracy(50);
		  ap.setLanguage("English");
		  ap.setName("Magarpatta Villa");
		  ap.setPhone_number("9172462714");
		  List<String> list = new ArrayList<String>();
		  list.add("shoe park");
		  list.add("shop");
		  ap.setTypes(list);
		  
		  LocationClass l = new LocationClass();
		  l.setLat(-38.383494);
		  l.setLng(33.427362);
		  
		   String res = given().queryParam("key", "qaclick123").body(ap).when()
				            .post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
				            .extract().response().asString();
		 
		  System.out.println(res);
		  
	 }
}
