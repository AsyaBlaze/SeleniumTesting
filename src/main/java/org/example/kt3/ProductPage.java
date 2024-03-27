package org.example.kt3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        driver.findElement(By.cssSelector("#button-cart")).click();
    }

    public void addToWishList() {
        driver.findElement(By.cssSelector("div.container:nth-child(4) div.row div.col-sm-12 div.row div.col-sm-4 div.btn-group:nth-child(1) > button.btn.btn-default:nth-child(1)"));
    }

    public void addToComparison() {
        driver.findElement(By.cssSelector("div.container:nth-child(4) div.row div.col-sm-12 div.row div.col-sm-4 div.btn-group:nth-child(1) > button.btn.btn-default:nth-child(2)"));
    }

    public void writeAReview(String name, String review) throws InterruptedException {
        driver.findElement(By.partialLinkText("Отзывов (")).click();
        WebElement element = driver.findElement(By.cssSelector("#input-name"));
        for (char ch : name.toCharArray()) {
            element.sendKeys(String.valueOf(ch));
            Thread.sleep(300);
        }

        element = driver.findElement(By.cssSelector("#input-review"));
        for (char ch : review.toCharArray()) {
            element.sendKeys(String.valueOf(ch));
            Thread.sleep(100);
        }
    }
}
