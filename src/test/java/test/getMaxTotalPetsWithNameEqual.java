package test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getMaxTotalPetsWithNameEqual {

    @Test
    public void getMaxTotalPetsWithSameName(){
        RestAssured.baseURI = "https://petstore.swagger.io";

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

