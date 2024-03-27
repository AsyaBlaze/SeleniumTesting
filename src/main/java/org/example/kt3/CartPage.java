package org.example.kt3;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    private WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getAllProductsInCart() {
        List<String> rsl = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            try {
                WebElement element = driver.findElement(By.cssSelector("div.container:nth-child(4) div.row div.col-sm-12 div.table-responsive table.table.table-bordered tbody:nth-child(2) tr:nth-child(" + i +") td.text-left:nth-child(2) > a:nth-child(1)"));
                rsl.add(element.getText());
            } catch (NoSuchElementException e) {
                break;
            }
        }
        return rsl;
    }
}
