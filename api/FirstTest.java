package examples;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class FirstTest {
    @Test
    public void getMethodTestWithQueryParam(){
        String baseURL="https://petstore.swagger.io/v2/pet";
        Response response=
                given()
                .headers("Content-Type","application/json")
                .queryParam("status","sold")
                .when()
               .get(baseURL +"/findByStatus");
        System.out.println(response.getBody().asString());
//        System.out.println(response.getHeaders().asList());
        String petStatus=response.then().extract().path("[0].status");
        int petId=response.then().extract().path("[0].id");
        response.then().statusCode(200);
        response.then().body("[0].status",equalTo("sold"));
        response.then().time(lessThan(3000L));
    }
    @Test
    public void getMethodTestWithPathParam(){
        String baseURL="https://petstore.swagger.io/v2/pet";
        Response response=
                given()
                        .headers("Content-Type","application/json")
                        .pathParam("petId","9")
                        .when()
                        .get(baseURL +"/{petId}");
        System.out.println(response.getBody().asPrettyString());
        String petStatus=response.then().extract().path("status");
        int petId=response.then().extract().path("id");
        response.then().statusCode(200);
        response.then().body("[0].status",equalTo("sold"));

    }


}
