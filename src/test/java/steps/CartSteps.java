package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    @Step("Входим в аккаунт")
    @Given("пользователь залогинен как {string} с паролем {string}")
    public void loginAs(String username, String password){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        productsPage = new ProductsPage(driver);
    }
    @Step("Добавляем первый товар в корзину")
    @When("он добавляет первый товар в корзину")
    public void addFirstProduct() {
        productsPage.addFirstProductToCart();
    }


    @Step("Проверяем счетчик корзины")
    @Then("он видит счётчик корзины {string}")
    public void checkCartBadge(String expectCount){
        assertEquals(expectCount, productsPage.getCartBadgeCount());
    }

    @Step("Проверяем название первого товара")
    @And("название первого товара {string}")
    public void checkProductName(String expectName){
        assertEquals(expectName, productsPage.getProductName());
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
