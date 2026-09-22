package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Epic("Swag Labs")
@Feature("Корзина")
public class CartTest {


    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

        productsPage = new ProductsPage(driver);

    }
    @Test
    @Description("Проверить, что название первого товара соответсвует")
    @Severity(SeverityLevel.CRITICAL)
    public void addFirstProductToCart (){
        productsPage.addFirstProductToCart();
        assertEquals("1", productsPage.getCartBadgeCount());
        assertEquals("Sauce Labs Backpack",productsPage.getProductName());
    }
    @AfterEach
        public void tearDown(){
            if (driver != null) {
                driver.quit();
            }
        }

}
