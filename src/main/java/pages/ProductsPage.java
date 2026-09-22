package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;
    private By productName = By.cssSelector("[data-test='inventory-item-name']");
    private By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By cartIcon = By.cssSelector("[data-test='shopping-cart-link']");
    private By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");
//    private List<WebElement> products = driver.findElements(productName);
    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }


    @Step("Добавим первый товар в корзину")
    public void addFirstProductToCart(){
        driver.findElement(addToCartButton).click();
    }
    @Step("Получаем название первого товара")
    public String getProductName(){
        return driver.findElement(productName).getText();

    }
    @Step("Получаем количество товаров в корзине")
    public String getCartBadgeCount(){
        return driver.findElement(cartBadge).getText();
    }
    @Step("Переходим в корзину")
    public void goToCart() {
        driver.findElement(cartIcon).click();
    }

    public List<WebElement> getProducts(){
        return driver.findElements(productName);
    }

}
