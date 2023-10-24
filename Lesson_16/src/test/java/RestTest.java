import EchoPostman.EchoPostResp;
import EchoPostman.EchoPostReq;
import Spec.Specifications;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class RestTest {
    private static final String URL = "https://postman-echo.com";

    @BeforeEach
    void setup() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec200ok());
    }
    @AfterEach
    void tearDown() {
        System.out.println("--------------------------------------------");
    }
    @Test
    void echoGetTest() {
        given()
                .when().get("/get?foo1=bar1&foo2=bar2")
                .then()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.accept",equalTo("application/json, application/javascript, text/javascript, text/json"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.20)"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"));
    }
    @Test
    void echoPostTest() {
        given()
                .when().post("/post")
                .then()
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.accept",equalTo("application/json, application/javascript, text/javascript, text/json"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.20)"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"));
        ;
    }
    @Test
    void echoBodyPostTest() {
        EchoPostReq req = new EchoPostReq("bar1", "bar2");
        EchoPostResp resp = given().body(req)
                .when().post("/post")
                .then()
                .body("json.foo1", equalTo("bar1"))
                .and().body("json.foo2", equalTo("bar2"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.accept",equalTo("application/json, application/javascript, text/javascript, text/json"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.20)"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .extract().body().jsonPath().getObject("json", EchoPostResp.class);
        Assertions.assertAll(()->Assertions.assertTrue(resp.getFoo1().equals("bar1")),
                ()->Assertions.assertTrue(resp.getFoo2().equals("bar2")));
    }
    @Test
    void echoPutTest() {
        given()
                .when().put("/put")
                .then()
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.accept",equalTo("application/json, application/javascript, text/javascript, text/json"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.20)"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"));
    }
    @Test
    void echoPatchTest() {
        given()
                .when().patch("/patch")
                .then()
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.accept",equalTo("application/json, application/javascript, text/javascript, text/json"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.20)"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"));
    }
    @Test
    void echoDeleteTest() {
        given()
                .when().delete("/delete")
                .then()
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.accept",equalTo("application/json, application/javascript, text/javascript, text/json"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.20)"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"));
    }
}