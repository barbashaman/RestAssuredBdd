package api.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class Rest {

    private RequestSpecification requestSpecification;

    public Rest() {

        RestAssured.baseURI = "https://reqres.in/";
    }

    private RequestSpecification buildRequest(Map<String, String> headers) {
        requestSpecification = RestAssured.given().headers(headers).contentType(ContentType.JSON);
        requestSpecification.log().all();

        return requestSpecification;
    }


    private RequestSpecification buildRequest() {
        requestSpecification = RestAssured.given().contentType(ContentType.JSON);
        requestSpecification.log().all();

        return requestSpecification;
    }

    protected Response apiGet(String url) {
        Response response = buildRequest().get(url);
        return response;
    }

    protected Response apiPost(String url, String payload) {
        Response response = buildRequest().body(payload).post(url);
        System.out.println(response.prettyPrint());

        return response;
    }

    protected Response apiPost(String url, Map<String, String> headers,String payload) {
        Response response = buildRequest(headers).body(payload).post(url);

        return response;
    }

    protected Response apiPut(String url, String payload) {
        Response response = buildRequest().body(payload).put(url);

        return response;
    }

    protected Response apiDelete(String url) {
        return buildRequest().delete(url);
    }
}
