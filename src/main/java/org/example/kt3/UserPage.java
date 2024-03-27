package org.example.kt3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserPage {
    private WebDriver driver;

    public UserPage(WebDriver driver) {
        driver.get("https://demo-opencart.ru/index.php?route=account/login");
        this.driver = driver;
    }

    public void registerNewAccount(String name, String lastname, String email, String phone, String password) throws InterruptedException {
        driver.findElement(By.linkText("Продолжить")).click();
        WebElement element = driver.findElement(By.id("input-firstname"));
        for (char ch : name.toCharArray()) {
            element.sendKeys(String.valueOf(ch));
            Thread.sleep(300);
        }
        element = driver.findElement(By.id("input-lastname"));
        for (char ch : lastname.toCharArray()) {
            element.sendKeys(String.valueOf(ch));
            Thread.sleep(300);
        }
        element = driver.findElement(By.id("input-email"));
        for (char ch : email.toCharArray()) {
            element.sendKeys(String.valueOf(ch));
            Thread.sleep(300);
        }
        element = driver.findElement(By.id("input-telephone"));
        for (char ch : phone.toCharArray()) {
            element.sendKeys(String.valueOf(ch));
            Thread.sleep(300);
        }
        element = driver.findElement(By.id("input-password"));
        for (char ch : password.toCharArray()) {
            element.sendKeys(String.valueOf(ch));
            Thread.sleep(300);
        }
        element = driver.findElement(By.id("input-confirm"));
        for (char ch : password.toCharArray()) {
            element.sendKeys(String.valueOf(ch));
            Thread.sleep(300);
        }
        element = driver.findElement(By.name("agree"));
        element.click();
        element = driver.findElement(By.cssSelector("div.container:nth-child(4) div.row div.col-sm-9 form.form-horizontal:nth-child(3) div.buttons:nth-child(4) div.pull-right > input.btn.btn-primary:nth-child(4)"));
        element.click();
    }
}
