package test;

import files.CreateUserResponse;
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

public class Tests {

    @Test
    public void createUser(){

        RestAssured.baseURI = "https://petstore.swagger.io";

        // esta es para Crear el usuario
        /*String response = given().
                header("Content-Type", "application/json")
                .body(Payload.CreateUser()).
                when().post("/v2/user").
                then().log().all().assertThat().statusCode(200).extract().response().asString();
        System.out.println("La respuesta del código es:");
        System.out.println(response);
        JsonPath js = new JsonPath(response);//parsing json
        String Code = js.getString("code");
        System.out.println(Code);*/


        // Obtener el usuario creado
        /*String getUserCreated = given().log().all().queryParam("username", "user1")
                .when().get("/v2/user/user1").
                then().assertThat().statusCode(200).extract().response().asString();

        System.out.println("Los datos del usuario creado es:----");
        JsonPath js1 = new JsonPath(getUserCreated);//parsing json
        System.out.println(getUserCreated);
        String userName = js1.getString("username");
        System.out.println("El username del usuario es: ");
        System.out.println(userName);*/



    // Obtener todas las mascotas vendidas
        /*String getPetSold = given().log().all().queryParam("status", "sold")
            .when().get("/v2/pet/findByStatus").
            then().assertThat().statusCode(200).extract().response().asString();


        JsonPath js2 = new JsonPath(getPetSold);//parsing json
        int count = js2.getInt("status.size()");
        System.out.println("Las mascotas vendidas son:");
        System.out.println(count);

        System.out.println("--------------");
        System.out.println("Las nombres de las mascotas y id vendidas son:----");
        String usernames = js2.getString("name");
        String id = js2.getString("id");
        System.out.println(usernames);
        System.out.println(id);*/


        // Obtener la cantidad de mascotas con los mismos nombres
        String getPetSold1 = given().log().all().queryParam("status", "sold")
                .when().get("/v2/pet/findByStatus").
                then().assertThat().statusCode(200).extract().response().asString();


        JsonPath js3 = new JsonPath(getPetSold1);//parsing json
        int count1 = js3.getInt("status.size()");
        System.out.println("Las mascotas con nombres iguales son:");
        System.out.println(count1);
        String firstName = js3.getString("name[0]");
        System.out.println(firstName);
        String name = null;
        for (int i=0; i<count1; i++){
            //String title = js3.getString("name["+i+"]");
            if (i == 0){
                name = js3.getString("name["+i+"]");
            }
            else
                if(firstName.equalsIgnoreCase(name));

        }

    }


}

