package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.NoSuchElementException;

public class MainPage {
    private WebDriver driver = new ChromeDriver();
    private static List<String> products;

    static {
        products.add("div.container:nth-child(4) div.row div.col-sm-12 div.row:nth-child(4) div.product-layout.col-lg-3.col-md-3.col-sm-6.col-xs-12:nth-child(1) div.product-thumb.transition div.button-group > button:nth-child(1)");
        products.add("div.container:nth-child(4) div.row div.col-sm-12 div.row:nth-child(4) div.product-layout.col-lg-3.col-md-3.col-sm-6.col-xs-12:nth-child(2) div.product-thumb.transition div.button-group > button:nth-child(1)");
        products.add("div.container:nth-child(4) div.row div.col-sm-12 div.row:nth-child(4) div.product-layout.col-lg-3.col-md-3.col-sm-6.col-xs-12:nth-child(3) div.product-thumb.transition div.button-group > button:nth-child(1)");
        products.add("div.container:nth-child(4) div.row div.col-sm-12 div.row:nth-child(4) div.product-layout.col-lg-3.col-md-3.col-sm-6.col-xs-12:nth-child(4) div.product-thumb.transition div.button-group > button:nth-child(1)");
    }

    public MainPage() {
        driver.get("https://demo-opencart.ru/index.php");
    }

    public void mainPage() {
        driver.get("https://demo-opencart.ru/index.php");
    }

    public void switchPhoto() {
        WebElement input = driver.findElement(By.className("swiper-button-next"));
        input.click();
    }

    public void addToCard(int num) {
        if (num > products.size())
            throw new NoSuchElementException(num + " no product");
        driver.findElement(By.cssSelector(products.get(num))).click();
    }
}
