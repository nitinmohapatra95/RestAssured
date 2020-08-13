/**
 * 
 */
package testcases;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;

/**
 * @author nmohapat
 *
 */
public class TestCase01 {
	private Response response;
	private static String URI = "https://reqres.in/api/users?page=2";

	@BeforeClass
	void getResponse() {
		response = given().log().all().get(URI).then().log().all().extract().response();
	}

	@Test
	void verifyStatusCode() {
		Assert.assertEquals(response.getStatusCode(), 200, "Status code verification");
	}

	@Test
	void verifyHeaderServer() {
		Assert.assertEquals(response.getHeader("Server"), "cloudflare", "Server header verification");
	}

	@Test
	void verifyPageValue() {
		Assert.assertEquals(response.jsonPath().getInt("page"), 2, "page value verification");
	}
	
	@Test
	void verifyFirstName() {
		Assert.assertEquals(response.jsonPath().get("data[1].first_name"), "Lindsay", "name verification with id 8");
	}
	
	
}
