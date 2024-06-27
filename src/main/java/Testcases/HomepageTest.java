package Testcases;

import Pages.Homepage;
import Pages.ProductsPage;
import org.junit.Test;

import java.net.MalformedURLException;

public class HomepageTest extends BaseTest{
    @Test
    public void appiumTest() throws MalformedURLException, InterruptedException {
        Homepage homepage = new Homepage(driver);
        homepage.clickCountry();
        homepage.setCountryName();
        homepage.namecheck("Your Name");
        homepage.setNameSelect("Sharath Anand");
        homepage.setGender("female");
        homepage.setSignIn();
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.productSelect();
        productsPage.addToCart(0);
        productsPage.addToCart(1);
        productsPage.goToCartPage();
    }

}