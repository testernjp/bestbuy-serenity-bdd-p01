package com.bestbuy.crudtest;

import com.bestbuy.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ProductCRUDTest extends TestBase {

//    static String name= "Energizer - MAX Batteries AA (4-Pack)"+ TestUtils.getRandomName();
//    static String type="Battery"+ TestUtils.getRandomValue();
//    static double price=10.99;
//    static String upc="012345";
//    static int shipping=10;
//    static String description="Long-lasting battery";
//    static String manufacturer="Energizer";
//    static String model=TestUtils.getRandomName();
//    static String url="http://www.bestbuy.com/site/duracell-aaa-batteries-4-pack";
//    static int productId;
//
//    @Steps
//    ProductSteps productSteps;
//
//    @Title("This will create a new product")
//    @Test
//    public void test001() {
//        ValidatableResponse response =productSteps.createProducts(name,type,price,upc,shipping,description,manufacturer,model,url);
//        response.log().all().statusCode(201);
//    }
//
//    @Title("Verify that product has been added to the application")
//    @Test
//    public void test002() {
//        HashMap<String,Object> productMap=productSteps.getProductInfoByName(name);
//        productId=(int) productMap.get("id");
//        Assert.assertThat(productMap,hasValue(name));
//        System.out.println("Created product id : " +productId);
//    }
//
//    @Title("Update the Product information and verify the created product is updated")
//    @Test
//    public void test003() {
//        name = name + "_updated";
//        productSteps.updateProduct(productId, name, type, price, upc, shipping, description, manufacturer, model, url).log().all().statusCode(200);
//        HashMap<String, Object> value = productSteps.getProductInfoByName(name);
//        Assert.assertThat(value, hasValue(name));
//    }
//
//    @Title("Delete the Product and verify if the Product is deleted!")
//    @Test
//    public void test004() {
//        productSteps.deleteProduct(productId).statusCode(200);
//        productSteps.getProductById(productId).statusCode(404);
//    }
}