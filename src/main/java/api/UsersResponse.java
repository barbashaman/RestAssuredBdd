package api;

import api.base.Rest;
import io.restassured.response.Response;

public class UsersResponse extends Rest {

    public Response getUsers(String uri) {
        return apiGet(uri);
    }

}
