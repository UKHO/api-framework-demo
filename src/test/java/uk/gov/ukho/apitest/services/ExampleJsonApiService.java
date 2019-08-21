package uk.gov.ukho.apitest.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ExampleJsonApiService {

    private RequestSpecification spec;
    private final String apiBaseEndpoint;

    public ExampleJsonApiService(final String apiBaseEndpoint) {
        this.apiBaseEndpoint = apiBaseEndpoint;
    }

    public ExtractableResponse<Response> getAllPosts() {
        createRequestSpec("application/json");
        return given(spec)
                .when()
                .get("/posts")
                .then()
                .extract();
    }

    public ExtractableResponse<Response> createANewPost(final String body) {
        createRequestSpec("application/json");
        return given(spec)
                .when()
                .body(body)
                .post("/posts")
                .then()
                .extract();
    }

    //Use this method to build the request, e.g. authorisation, headers
    private void createRequestSpec(final String acceptHeader) {
        spec = new RequestSpecBuilder()
                .setBaseUri(apiBaseEndpoint)
                .setAccept(acceptHeader)
                .build();
    }
}
