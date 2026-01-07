package climateapi;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import configtest.details;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class CityClimateTest {
	
  //@Test
//  public void getCityClimateDetails() {
//	  RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
//	  RequestSpecification httpReq = RestAssured.given();
//	  
////	  Response resp = httpReq.request(Method.GET, "/Kolkata");
//	  
//	  Response resp = httpReq.get("/Kolkata");
//	  int statusCode = resp.getStatusCode();
//	  System.out.println("The status code is: " + statusCode);
//	  System.out.println(resp.getStatusLine() + " is the status line from the server...");
//	  String response = resp.body().asString();
//	  System.out.println("The response rendered from the server: " + response);
//	  Assert.assertEquals(statusCode, 200);
//	  
//	  Headers headers = resp.headers();
//	  for(Header h : headers) {
//		  System.out.println("Header name: " + h.getName() + " and Header Value is: " + h.getValue());
//	  }
//  }
	
	@BeforeMethod
	  public void setup() {
	      RestAssured.baseURI = "http://localhost:3000/stocks";
	  }
	
  @Test
  public void getOperation() {

//      RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";

      Response response = RestAssured
              .given()
              .log().all()
              .when()
              .get()
              .then()
              .extract()
              .response();

      System.out.println("Response Body:\n" + response.asPrettyString());
      Assert.assertEquals(response.getStatusCode(), 200);
  } 
  
  @Test(priority = 1)
  public void postOperation() {
	  
	  details data = new details("4", 1999, "TechMahindra");
	  
      Response response =
              RestAssured
              .given()
              .contentType(ContentType.JSON)
              .body(data)
              .when()
              .post()
              .then()
              .extract()
              .response();

      System.out.println("POST Response:\n" + response.asPrettyString());
      Assert.assertEquals(response.getStatusCode(), 201);
  }
  
  @Test(priority = 2)
  public void patchOperation() {

	  details data = new details(2999, "TM");

      Response response = RestAssured
              .given()
              .contentType(ContentType.JSON)
              .body(data)
              .when()
              .patch("/4")
              .then()
              .extract()
              .response();

      System.out.println("PATCH Response:\n" + response.asPrettyString());
      Assert.assertEquals(response.getStatusCode(), 200);
  }
  
  @Test(priority = 3)
  public void deleteOperation() {

      Response response =
              RestAssured
              .given()
              .when()
              .delete("/4")
              .then()
              .extract()
              .response();

      System.out.println("DELETE Response:\n" + response.asPrettyString());
      Assert.assertEquals(response.getStatusCode(), 200);
  }
}