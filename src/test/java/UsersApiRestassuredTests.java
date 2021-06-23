import api.UsersResponse;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class UsersApiRestassuredTests {


    @Test
    public void testGetUsersList() {

        given()
                .log().all()
                .baseUri("https://reqres.in/")
        .when()
                .log().all()
                .get("/api/users?page=2")
        .then()
                .log().all()
                .statusCode(200);
    }


    @Test
    public void testGetSingleUser(){
        given().log().all()
                .baseUri("https://reqres.in/")
                .when().log().all().get("/api/users/1")
                .then().log().all().statusCode(200);

        given().log().all().baseUri("https://reqres.in/")
                .when().log().all().get("/api/users/2")
                .then().log().all().statusCode(200);

        given().log().all().baseUri("https://reqres.in/")
                .when().log().all().get("/api/users/0")
                .then().log().all().statusCode(404);

    }














    @Test
    public void testGet() {
        UsersResponse usersResponse = new UsersResponse();
        Response response = usersResponse.getUsers("/api/users?page=2");
        System.out.println(response.prettyPrint());
        assertTrue(response.getStatusCode() == 200);
    }
}
