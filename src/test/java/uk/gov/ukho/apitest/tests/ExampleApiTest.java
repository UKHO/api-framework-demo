package uk.gov.ukho.apitest.tests;

import io.restassured.response.ExtractableResponse;
import org.apache.http.HttpStatus;
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
    public void WhenCallPostsEndpointThenSuccessStatusReturned() {

        response = exampleApiService.getAllPosts();

        assertThat(response.statusCode())
                .isEqualTo(HttpStatus.SC_OK);
    }
}
