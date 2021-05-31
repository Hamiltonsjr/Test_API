import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matcher.*;

import static io.restassured.RestAssured.given;

public class APITest {

    @Test
    public void register(){

        String url = " https://api.thecatapi.com/v1/user/passwordlesssignup";
        String body ="{\"email\" :\"hamiltonsjr@hotmail.com\",\"appDescription\":\"test the cat api\"}";

        Response response = given().contentType("application/json").body(body).
                when().post(url);

                response.then().body("message", containsString("SUCCESS")).statusCode(400);
                System.out.println("Return   => "+ response.body().asString());
    }

    @Test
    public void vote() {

        String url = "https://api.thecatapi.com/v1/votes/";

        Response response = given().contentType("application/json").
                body("{\"image_id:\": \"k3O2NERFV\", \"value\": \"true\", \"sub_id\": \"demo-af363a\"}").
                when().post(url);

        response.then().statusCode(400).body("message", containsString("image_id"));

        System.out.println("Return =>" + response.body().asString());
        String id = response.jsonPath().getString("image_id");
        System.out.println("ID =>"+ id);

    }
}
