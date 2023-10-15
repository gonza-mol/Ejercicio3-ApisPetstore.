package test;

import org.testng.annotations.Test;
import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;


public class createUser {


    @Test
    public void createNewUser(){
        RestAssured.baseURI = "https://petstore.swagger.io";

        // esta es para Crear el usuario
        String response = given().
                header("Content-Type", "application/json")
                .body(Payload.CreateUser()).
                when().post("/v2/user").
                then().log().all().assertThat().statusCode(200).extract().response().asString();
        System.out.println("La respuesta del código es:");
        System.out.println(response);
        JsonPath js = new JsonPath(response);//parsing json
        String Code = js.getString("code");
        System.out.println(Code);

    }
}
