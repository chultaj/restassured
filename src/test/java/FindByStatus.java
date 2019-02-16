import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

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
}
