package org.example.kt3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        driver.get("https://demo-opencart.ru/index.php");
        this.driver = driver;
    }

    public WebElement photoSwitchingNext() {
        return driver.findElement(By.className("swiper-button-next"));
    }

    public WebElement photoSwitchingPrev() {
        return driver.findElement(By.className("swiper-button-prev"));
    }

    public void addProductToCart(int index) {
        getProductButton(index, "cart").click();
    }

    public void addProductToWishList(int index) {
        getProductButton(index, "like").click();
    }

    public void addProductToComparison(int index) {
        getProductButton(index, "comparison").click();
    }

    public void openAtMenu(String menu, String menu2) {
        driver.findElement(By.linkText(menu)).click();
        if (menu2 == null) return;
        driver.findElement(By.partialLinkText(menu2 + " (")).click();
    }

    private WebElement getProductButton(int objectIndex, String button) {
        if (objectIndex < 1 || objectIndex > 4) {
            throw new IllegalArgumentException("Product with this index doesn't exist, try to choose between 1 and 4");
        }
        String css = "div.container:nth-child(4) div.row div.col-sm-12 div.row:nth-child(4) div.product-layout.col-lg-3.col-md-3.col-sm-6.col-xs-12:nth-child(%d) div.product-thumb.transition div.button-group > button:nth-child(%d)";
        if (button.equals("cart")) {
            css = String.format(css, objectIndex, 1);
        } else if (button.equals("like")) {
            css = String.format(css, objectIndex, 2);
        } else if (button.equals("comparison")) {
            css = String.format(css, objectIndex, 3);
        }
        return driver.findElement(By.cssSelector(css));
    }

    public CartPage goToCart() {
        WebElement cart = driver.findElement(By.cssSelector("div.container div.nav.pull-right ul.list-inline li:nth-child(4) > a:nth-child(1)"));
        cart.click();
        return new CartPage(driver);
    }

    public void search(String searching) throws InterruptedException {
        WebElement element = driver.findElement(By.name("search"));
        for (char ch : searching.toCharArray()) {
            element.sendKeys(String.valueOf(ch));
            Thread.sleep(300);
        }
        element = driver.findElement(By.cssSelector("div.container div.row div.col-sm-5 div.input-group span.input-group-btn > button.btn.btn-default.btn-lg"));
        element.click();
    }

    public ProductPage openProductPage(String product) {
        driver.findElement(By.linkText(product)).click();
        return new ProductPage(driver);
    }


}
