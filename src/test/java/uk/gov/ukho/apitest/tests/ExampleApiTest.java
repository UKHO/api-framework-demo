package uk.gov.ukho.apitest.tests;

import com.github.cliftonlabs.json_simple.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import uk.gov.ukho.apitest.services.ExampleJsonApiService;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleApiTest {

    private ExampleJsonApiService exampleApiService;
    private ExtractableResponse response;

    @Before
    public void setup() {
        exampleApiService = new ExampleJsonApiService();
    }

    @Test
    public void whenCallPostsEndpointThenSuccessStatusReturned() {
        response = exampleApiService.getAllPosts();

        assertThat(response.statusCode())
                .as("status code")
                .isEqualTo(HttpStatus.SC_OK);
    }

    @Test
    public void whenCallPostsEndpointThenJsonBodyIsCorrect() {
        response = exampleApiService.getAllPosts();
        JsonPath jsonPath = response.jsonPath();

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(jsonPath.getString("id"))
                .as("id content")
                .contains("1", "2");

        softly.assertThat((int) jsonPath.get("id.size"))
                .as("id size")
                .isEqualTo(100);

        softly.assertAll();
    }

    @Test
    public void whenCreateANewPostThenSuccessStatusReturned() {
        String body = createExampleJsonPostBody();

        response = exampleApiService.createANewPost(body);

        assertThat(response.statusCode())
                .as("status code")
                .isEqualTo(HttpStatus.SC_CREATED);
    }

    private String createExampleJsonPostBody() {
        JsonObject requestParams = new JsonObject();
        requestParams.put("title", "foo");
        requestParams.put("body", "bar");
        requestParams.put("userId", "3091");
        return requestParams.toJson();
    }
}
