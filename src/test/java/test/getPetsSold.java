package test;

import org.testng.annotations.Test;
import files.Payload;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import files.CreateUserRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



public class getPetsSold {

    @Test
    public void getAllPetsSold(){
        RestAssured.baseURI = "https://petstore.swagger.io";

    // Obtener todas las mascotas vendidas
        String getPetSold = given().log().all().queryParam("status", "sold")
            .when().get("/v2/pet/findByStatus").
            then().assertThat().statusCode(200).extract().response().asString();


        JsonPath js2 = new JsonPath(getPetSold);//parsing json
        int count = js2.getInt("status.size()");
        System.out.println("Las cantidad de mascotas vendidas son:");
        System.out.println(count);

        System.out.println("--------------");
        System.out.println("Las nombres de las mascotas y id vendidas son:");
        String usernames = js2.getString("name");
        String id = js2.getString("id");
        System.out.println(usernames);
        System.out.println(id);
    }
}
