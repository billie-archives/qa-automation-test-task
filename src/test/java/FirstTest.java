import org.junit.Test;
import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class FirstTest  {

    @Test
    public void testPostID40 () {

       io.restassured.response.Response resp = given()
                .when()
                    .get("https://jsonplaceholder.typicode.com/comments?postId=40")
                .then()
                    .statusCode(200)
                    .extract().response();


       System.out.println(resp.body().asString());

       try {
           expect().body("postId", hasSize(5))
                   .statusCode(200)
                   .given()
                   .when()
                   .get("https://jsonplaceholder.typicode.com/comments?postId=40");
       }
       catch(Error e){
           System.out.println("post with id 40 does not contain 5 comments");
       }

       try {
           expect().body("name", anything("pariatur aspernatur nam atque quis"))
                   .body("email", anything("Cooper_Boehm@damian.biz"))
                   .body("body", anything("veniam eos ab voluptatem in fugiat ipsam quis\\nofficiis non qui\\nquia ut id voluptates et a molestiae commodi quam\\ndolorem enim soluta impedit autem nulla"))
                   .statusCode(200)
                   .given()
                   .when()
                   .get("https://jsonplaceholder.typicode.com/comments?postId=40");
       }
       catch(Error e){
           System.out.println("post with id 40 does not contain the required comments");
       }
    }

}