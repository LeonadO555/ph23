package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;


public class ApiBase {

    final String BASE_URL = "http://phonebook.telran-edu.de:8080/";

    final String API_KEY = "eyJhbGciOiJIUzUxMiJ9.eyJ1c2VybmFtZSI6InRlc3RAZ21haWwuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MjEwNjk3ODI5Nn0.GM1wsoRV2QoAsD6wKmIk7N49DDpuCejK4BC9H9YItJvesH5vft8HO2uqTPnGQJwJ5oXKS2OILqP1yoanMnIMkA";

    RequestSpecification spec = new RequestSpecBuilder().setBaseUri(BASE_URL)
            .setContentType(ContentType.JSON)
            .addHeader("Access-Token", API_KEY)
            .build();

    protected Response getRequest(String endPoint, int responseCode){
        Response response = RestAssured.given()
            .spec(spec)
            .when()
            .log().all()
            .get(endPoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
}
    protected Response getRequestWithParam(String endPoint, int responseCode, String paramName, int value){
        Response response = RestAssured.given()
                .spec(spec)
                .when()
                .pathParam(paramName, value)
                .log().all()
                .get(endPoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }
    protected Response postRequest(String endPoint, int responseCode, Object body){
        Response response = RestAssured.given()
                .spec(spec)
                .body(body)
                .when()
                .log().all()
                .post(endPoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }
    protected Response putRequest(String endPoint, int responseCode, Object body){
        Response response = RestAssured.given()
                .spec(spec)
                .body(body)
                .when()
                .log().all()
                .put(endPoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    protected Response deleteRequest(String endPoint, int responseCode, int value){
        Response response = RestAssured.given()
                .spec(spec)
                .when()
                .pathParam("id", value)
                .log().all()
                .delete(endPoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }


}
