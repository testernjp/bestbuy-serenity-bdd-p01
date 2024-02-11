package com.bestbuy.userinfo;

import com.bestbuy.constant.EndPoints;
import com.bestbuy.model.ProductsPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import java.util.HashMap;

public class ProductSteps {


    @Step("Creating product with name : {0}, type : {1}, price : {2}, upc : {3}, shipping : {4}, description : {5}, manufacturer : {6}, model : {7}, url : {8}")
    public ValidatableResponse createProducts(String name, String type, Double price, String upc, Integer shipping, String description, String manufacturer, String model, String url) {
        ProductsPojo productsPojo = ProductsPojo.getProductsPojo(name, type, price, upc, shipping, description, manufacturer, model, url);
        //got the above line from pojo class made it shorter
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(productsPojo)
                .when()
                .post()
                .then();
    }

    @Step("Getting single Product information with name: {0}")
    public HashMap<String, Object> getProductInfoByName(String name) {
        String p1 = "data.findAll{it.name='";
        String p2 = "'}.get(0)";
        return SerenityRest.given().log().all()
                .queryParam("name", name)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + name + p2);
    }

    @Step("Updating Product information with ProductID: {0}, name : {1}, type: {2}, price: {3},  upc: {4},shipping: {5},description: {6}, manufacturer: {7},model: {8},url: {9}")
    public ValidatableResponse updateProduct(int productId, String name, String type, Double price, String upc, Integer shipping, String description, String manufacturer, String model, String url) {
        ProductsPojo productsPojo = ProductsPojo.getProductsPojo(name, type, price, upc, shipping, description, manufacturer, model, url);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("productID", productId)
                .body(productsPojo)
                .when()
                .put(EndPoints.UPDATE_PRODUCT_BY_ID)
                .then();
    }

    @Step("Deleting Product information with ProductID: {0}")
    public ValidatableResponse deleteProduct(int productId) {
        return SerenityRest
                .given()
                .pathParam("productID", productId)
                .when()
                .delete(EndPoints.DELETE_PRODUCT_BY_ID)
                .then();
    }

    @Step("Getting Product information with ProductID: {0}")
    public ValidatableResponse getProductById(int productId) {
        return SerenityRest
                .given()
                .pathParam("productID", productId)
                .when()
                .get(EndPoints.GET_SINGLE_PRODUCT_BY_ID)
                .then();
    }
}
