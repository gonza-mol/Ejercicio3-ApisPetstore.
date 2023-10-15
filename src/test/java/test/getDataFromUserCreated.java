package test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getDataFromUserCreated {

    @Test
    public void getDataUserCreated(){
        RestAssured.baseURI = "https://petstore.swagger.io";

        // esta es para Crear el usuario
        String response = given().
                header("Content-Type", "application/json")
                .body(Payload.CreateUser()).
                when().post("/v2/user").
                then().assertThat().statusCode(200).extract().response().asString();

        JsonPath js = new JsonPath(response);//parsing json
        String username = js.getString("username");



        // Obtener el usuario creado
        String getUserCreated = given().log().all().queryParam("username", username)
                .when().get("/v2/user/user1").
                then().assertThat().statusCode(200).extract().response().asString();

        System.out.println("Los datos del usuario creado es:----");
        JsonPath js1 = new JsonPath(getUserCreated);//parsing json
        System.out.println(getUserCreated);
        String userName = js1.getString("username");
        System.out.println("El username del usuario es: ");
        System.out.println(userName);

    }
}
