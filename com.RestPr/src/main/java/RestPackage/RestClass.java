package RestPackage;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import static org.testng.Assert.*;
import java.util.List;
import java.util.ArrayList;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class RestClass {

	// Test setup
	@BeforeClass
	public void setBaseUri()

	{
		// public static void main(String[] args) {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/comments";

	}

	public static Object resp;

	@BeforeMethod
	public void getURIResp() {
		RequestSpecification httpRequest = RestAssured.given();
		// This will return the Response from the server. Store the response in a
		// variable.
		Response resp = httpRequest.request(Method.GET);
		RestClass.resp = resp;
	}

	// Test cases
	@Test
	public void verifyGetURI() {
		//Test 1
		// Assert the success response code on get
		try {
			assertEquals(200, ((ResponseOptions<Response>) RestClass.resp).getStatusCode());
			System.out.format("Get Request successful. Response code: %d \n",
					((ResponseOptions<Response>) RestClass.resp).getStatusCode());
		} catch (AssertionError e) {
			System.out.println("Get Request unsuccessful.");
		}

	}

	@Test
	public void verifyPostId40Count() {
		// Test 2
		// Now let us print the body of the message to see what response
		// we have received from the server
		JsonPath jsonPathEvaluator = ((ResponseBodyExtractionOptions) RestClass.resp).jsonPath();
		List<Integer> PostID = new ArrayList<Integer>();

		/* ArrayList */ PostID = jsonPathEvaluator.get("postId");
		// System.out.println("received from Response " + PostID);
		// ArryaList with Duplicate Values of postIds

		Integer[] arr = new Integer[PostID.size()];
		arr = PostID.toArray(arr);

		int charCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 40)

				charCount++;
		}
		try {
			assertEquals(charCount, 5);
			System.out.println("Post id 40 data is repeted exact 5 times");
		} catch (AssertionError e) {
			System.out.println("Post id 40 is not repeted 5 times");
		}

	}

	@Test
	public void verifyPostId40Data() {
		// test 3
		RequestSpecification httpRequest = RestAssured.given();
		Response resp = httpRequest.request(Method.GET, "199");
		JsonPath jsonPathEvaluator = resp.jsonPath();
		try {
			assertEquals(jsonPathEvaluator.get("postId"), 40);
			assertEquals(jsonPathEvaluator.get("id"), 199);
			assertEquals(jsonPathEvaluator.get("name"), "pariatur aspernatur nam atque quis");
			assertEquals(jsonPathEvaluator.get("email"), "Cooper_Boehm@damian.biz");
			assertEquals(jsonPathEvaluator.get("body"),
					"veniam eos ab voluptatem in fugiat ipsam quis\nofficiis non qui\nquia ut id voluptates et a molestiae commodi quam\ndolorem enim soluta impedit autem nulla");
			System.out.println("Post id 40 with id 199 received data match the expected data");
		} catch (AssertionError e) {
			System.out.println("Post id 40 with id 199 received data doesnt match the expected data");
		}
	}

}