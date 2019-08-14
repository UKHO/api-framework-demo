package uk.gov.ukho.apitest.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ExampleJsonApiService {

    private RequestSpecification spec;

    private final String API_BASE = "https://jsonplaceholder.typicode.com";

    public ExtractableResponse<Response> getAllPosts() {
        createRequestSpec("application/json");
        return given(spec)
                .when()
                .get("/posts")
                .then()
                .extract();
    }

    //Use this method to build the request, e.g. authorisation, headers
    private void createRequestSpec(final String acceptHeader) {
        spec = new RequestSpecBuilder()
                .setBaseUri(API_BASE)
                .setAccept(acceptHeader)
                .build();
    }
}
