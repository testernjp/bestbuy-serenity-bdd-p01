package com.bestbuy.steps;

import com.bestbuy.userinfo.ProductSteps;
import com.bestbuy.util.TestUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.collection.IsMapContaining.hasValue;

@RunWith(CucumberWithSerenity.class)
public class MyStepdefs {

    static String name = null;
    static String type = null;
    static double price = 0.00;
    static String updatedname = null;
    static String updatedtype = null;
    static double updatedprice = 0.00;
    static String upc = null;
    static int shipping= 0;
    static String description=null;
    static String manufacturer=null;
    static String model= null;
    static String url="http://www.bestbuy.com/site/duracell-aaa-batteries-4-pack";
    static int productId;

    @Steps
    ProductSteps productSteps;
    @Given("The application is running")
    public void theApplicationIsRunning() {
    }

    @When("I create a new user providing name {string}, type {string}, price {double}, upc {string},shippping {int}, description {string}, manufacturer {string}, model {string}, url{string}")
    public void iCreateANewUserProvidingNameTypePriceUpcShipppingDescriptionManufacturerModelUrl(String _name, String _type, double _price, String upc, int shipping, String description, String manufacturer, String model, String url) {
        name = _name+ TestUtils.getRandomName();
        type = _type+ TestUtils.getRandomName();
        ValidatableResponse response =productSteps.createProducts(name,type,_price,upc,shipping,description,manufacturer,model,url);
        response.log().all().statusCode(201);
    }

    @Then("I verify that the user is created")
    public void iVerifyThatTheUserIsCreated() {
        HashMap<String,Object> productMap=productSteps.getProductInfoByName(name);
        productId=(int) productMap.get("id");
        Assert.assertThat(productMap,hasValue(name));
        System.out.println("Created product id : " +productId);
    }
    @And("I update the user with updatedname {string} updatedtype {string}, updatedprice {double}, upc {string},shippping {int}, description {string}, manufacturer {string}, model {string}, url{string}")
    public void iUpdateTheUserWithUpdatednameUpdatedtypeUpdatedpriceUpdatedpriceUpcShipppingShippingDescriptionManufacturerModelUrl(String _updatedname, String _updatedtype, double _updatedprice, String upc, int shipping, String description, String manufacturer, String model, String url) {
        updatedname = _updatedname + TestUtils.getRandomName();
        updatedtype = _updatedtype + TestUtils.getRandomName();
        //updatedprice = Double.parseDouble(_updatedprice+ TestUtils.getRandomValue());
        productSteps.updateProduct(productId, name, type, price, upc, shipping, description, manufacturer, model, url).log().all().statusCode(200);
        HashMap<String, Object> value = productSteps.getProductInfoByName(name);
    }


    @Then("I verify that the user with updated name {string} is updated successfully")
    public void iVerifyThatTheUserWithUpdatedNameIsUpdatedSuccessfully(String name1) {
        HashMap<String,Object> productMap=productSteps.getProductInfoByName(name);
        productId=(int) productMap.get("id");
        Assert.assertThat(productMap,hasValue(name));
        System.out.println("Created product id : " +productId);
    }

    @When("I delete the user with same id")
    public void iDeleteTheUserWithSameId() {
        productSteps.deleteProduct(productId).statusCode(200);
    }

    @Then("I verify that the user same id is deleted successfully")
    public void iVerifyThatTheUserSameIdIsDeletedSuccessfully() {
        productSteps.getProductById(productId).statusCode(404);
    }

}
