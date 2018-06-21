package nadi.test;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.equalTo;

public class TestClassNadi {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }


    //Make GET request to file
    @Test
    public void testResponseStatus() {
        when().
                get("/comments").
        then().
                statusCode(200);
    }

    //Make sure that post with id 40 contains 5 comments
    @Test
    public void testPostHasComments() {
        when().
                get("/comments").
        then().
                statusCode(200).
                body("findAll {it.postId == 40}", hasSize(equalTo(5)));
    }

    //Make sure that post with id 40 contains the comment
    @Test
    public void testPostContainsExpectedComment() {
        when().
                get("/comments").
        then().
                statusCode(200).
                root("find {it.postId == 40 && it.id == 199}").
                body(
                        "name", equalTo("pariatur aspernatur nam atque quis"),
                        "email", equalTo("Cooper_Boehm@damian.biz"),
                        "body", equalTo("veniam eos ab voluptatem in fugiat ipsam quis\nofficiis non qui\nquia ut id voluptates et a molestiae commodi quam\ndolorem enim soluta impedit autem nulla")
                );
    }
}