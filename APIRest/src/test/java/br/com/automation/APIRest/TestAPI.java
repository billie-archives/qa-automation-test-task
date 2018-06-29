package br.com.automation.APIRest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;
import java.util.List;

import org.testng.Assert;
/**
 * This class was created for testing the https://jsonplaceholder.typicode.com/comments using JUNIT
 * API Make GET request to https://jsonplaceholder.typicode.com/comments 
 * 1. Make sure that post with id 40 contains 5 comments 
 * 2. Make sure that post with id 40 contains the following comment: 
 * 	name: pariatur aspernatur nam atque quis
 * 	email: Cooper_Boehm@damian.biz 
 * 	body: veniam eos ab voluptatem in fugiat ipsam
 * 	quis\nofficiis non qui\nquia ut id voluptates et a molestiae
 * 	commodiquam\ndolorem enim soluta impedit autem nulla
 */

public class TestAPI {

	final String URL_BASE = "https://jsonplaceholder.typicode.com/comments";

	@Test
	public void testCommentsListSizePost() {
		given().relaxedHTTPSValidation().param("postId", "40").when().get(URL_BASE).then().contentType(ContentType.JSON)
				.body("list.size()", is(5));
	}

	@Test
	public void testPostContainsAComment() {
		String postId = "40";
		String name = "pariatur aspernatur nam atque quis";
		String email = "Cooper_Boehm@damian.biz";
		String body = "veniam eos ab voluptatem in fugiat ipsam quis\nofficiis non qui\nquia ut id voluptates et a molestiae commodi quam\ndolorem enim soluta impedit autem nulla";

		JsonPath jsonPath = RestAssured.given().when().get(URL_BASE).then().assertThat().extract().body().jsonPath();

		PoolComments poolComments = new PoolComments();
		List<Comment> comments = jsonPath.getList("", Comment.class);
		poolComments.setCommentsList(comments);
		
		boolean commentExists = poolComments.verifyIfCommentExistsOnList(postId,name,email,body);
		String resultMessage = "Verify if the comment with postId: "+ postId + ", Name: "+ name+", Email: " +email + ", Body: "+ body + " exists on comments list";
		Assert.assertTrue(commentExists,resultMessage);
				
	}

}
