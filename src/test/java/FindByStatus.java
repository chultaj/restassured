import io.restassured.RestAssured;
import io.restassured.mapper.TypeRef;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class FindByStatus extends BaseTest {

    private static final String findByStatus = "/pet/findByStatus";

    @Test
    public void testGetAllAvailable() {
        given().param("status", "available").
                when().get(findByStatus).
                then().statusCode(200).
                and().body("id", hasItems(9199424981609282123L));
    }

    @Test
    public void testAllSold() {
        Response response = given().param("status", "sold").
                when().get(findByStatus).
                then().statusCode(200).
                extract().response();

        List<Map<String, Object>> pets = response.as(new TypeRef<List<Map<String, Object>>>() {});
    }
}
