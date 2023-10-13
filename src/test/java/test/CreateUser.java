package test;

import files.CreateUserResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import files.CreateUserRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class CreateUser {

    @Test
    public void createUser(){

        //Crear el user
        RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io").
                setContentType(ContentType.JSON).build();

        CreateUserRequest createuserRequest = new CreateUserRequest();
        createuserRequest.setId(1);
        createuserRequest.setUsername("user1");
        createuserRequest.setFirstName("juancito");
        createuserRequest.setLastName("juanito");
        createuserRequest.setEmail("juanito@gmail.com");
        createuserRequest.setPassword("algo123");
        createuserRequest.setPhone("1111");
        createuserRequest.setUserStatus(0);

        RequestSpecification reqCreate = given().log().all().spec(req).body(createuserRequest);
        CreateUserResponse createuserResponse = reqCreate.when().post("/v2/user").
        then().log().all().assertThat().statusCode(200).extract().response().as(CreateUserResponse.class);



        // Obtener el usuario creado
        String getUserCreated = given().log().all()
                .when().get("/v2/user/user1").
                then().log().all().extract().response().asString();

        RequestSpecification reqGetUserCreated = given().log().all().spec(addProductBaseReq).param("productName", "Laptop")
                .param("productAddedBy", userId).param("productCategory", "fashion").param("productSubCategory", "shirts").
                param("productPrice", "11500").param("productDescription", "Lenova").
                param("productFor", "men").multiPart("productImage", new File("C:\\Users\\User\\Downloads\\descarga (1).png"));


        String getUserCreatedResponse = reqAddProduct.when().post("/api/ecom/product/add-product").
                then().log().all().extract().response().asString();
        JsonPath js = new JsonPath(addProductResponse);
        String productId = js.get("productId");
        System.out.println("El id del producto es: "+productId);



    }
}
