package Auothintication;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class EcommerceAPITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				                  .setContentType(ContentType.JSON).build();
		
		LoginEcom le = new LoginEcom();
		le.setUserEmail("akshaymore984@gmail.com");
		le.setUserPassword("Akshay@1234");
		
		RequestSpecification ReqLog = req.given().spec(req).body(le);
	}

}
