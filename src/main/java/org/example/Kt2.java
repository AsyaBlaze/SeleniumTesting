package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Kt2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo-opencart.ru/index.php");
        checkPhotoSwitching(driver);
        addToCard(driver);
        assertPcPageIsEmpty(driver);
        registerNewAccount(driver);
        search(driver);
        driver.close();
    }

    private static void checkPhotoSwitching(WebDriver driver) throws InterruptedException {
        WebElement input = driver.findElement(By.className("swiper-button-next"));
        synchronized (input) {
            input.click();
            input.wait(1000);
            input.click();
            input.wait(1000);
            input.click();
            input.wait(1000);
        }
    }

    private static void addToCard(WebDriver driver) throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector("div.container:nth-child(4) div.row div.col-sm-12 div.row:nth-child(4) div.product-layout.col-lg-3.col-md-3.col-sm-6.col-xs-12:nth-child(1) div.product-thumb.transition div.button-group > button:nth-child(1)"));
        element.click();
        synchronized (element) {
            element.wait(2000);
        }
        element = driver.findElement(By.cssSelector("div.container div.row div.col-sm-3 div.btn-group.btn-block > button.btn.btn-inverse.btn-block.btn-lg.dropdown-toggle"));
        element.click();
        synchronized (element) {
            element.wait(3000);
        }
        element = driver.findElement(By.cssSelector("div.container div.row div.col-sm-3 div.btn-group.btn-block.open ul.dropdown-menu.pull-right table.table.table-striped tbody:nth-child(1) tr:nth-child(1) td.text-left:nth-child(2) > a:nth-child(1)"));
        System.out.println("MacBook was added to card: " + element.getText().equals("MacBook"));
    }

    private static void assertPcPageIsEmpty(WebDriver driver) throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.linkText("Компьютеры"));
        action.moveToElement(element)
                .moveToElement(
                        driver.findElement(By.cssSelector("div.container:nth-child(3) nav.navbar div.collapse.navbar-collapse.navbar-ex1-collapse ul.nav.navbar-nav li.dropdown:nth-child(1) div.dropdown-menu div.dropdown-inner ul.list-unstyled li:nth-child(1) > a:nth-child(1)"))
                ).click().build().perform();
        synchronized (element) {
            element.wait(2000);
        }
        element = driver.findElement(By.cssSelector("body:nth-child(2) div.container:nth-child(4) div.row div.col-sm-9 > p:nth-child(2)"));
        synchronized (element) {
            element.wait(1000);
        }
        System.out.println("PC page was empty: " + element.getText().equals("В данной категории нет товаров."));
    }

    private static void registerNewAccount(WebDriver driver) throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector("div.container div.nav.pull-right ul.list-inline li.dropdown:nth-child(2) > a.dropdown-toggle"));
        element.click();
        synchronized (element) {
            element.wait(1000);
        }
        element = driver.findElement(By.linkText("Регистрация"));
        element.click();

        element = driver.findElement(By.id("input-firstname"));
        synchronized (element) {
            for (char ch : "Анастасия".toCharArray()) {
                element.sendKeys(String.valueOf(ch));
                element.wait(300);
            }
        }

        element = driver.findElement(By.id("input-lastname"));
        synchronized (element) {
            for (char ch : "Выборова".toCharArray()) {
                element.sendKeys(String.valueOf(ch));
                element.wait(300);
            }
        }

        element = driver.findElement(By.id("input-email"));
        synchronized (element) {
            for (char ch : "email@gmail.com".toCharArray()) {
                element.sendKeys(String.valueOf(ch));
                element.wait(300);
            }
        }

        element = driver.findElement(By.id("input-telephone"));
        synchronized (element) {
            for (char ch : "+79245672345".toCharArray()) {
                element.sendKeys(String.valueOf(ch));
                element.wait(300);
            }
        }

        element = driver.findElement(By.id("input-password"));
        synchronized (element) {
            for (char ch : "Password1".toCharArray()) {
                element.sendKeys(String.valueOf(ch));
                element.wait(300);
            }
        }

        element = driver.findElement(By.id("input-confirm"));
        synchronized (element) {
            for (char ch : "Password1".toCharArray()) {
                element.sendKeys(String.valueOf(ch));
                element.wait(300);
            }
        }

        element = driver.findElement(By.name("agree"));
        synchronized (element) {
            element.click();
        }

        element = driver.findElement(By.cssSelector("div.container:nth-child(4) div.row div.col-sm-9 form.form-horizontal:nth-child(3) div.buttons:nth-child(4) div.pull-right > input.btn.btn-primary:nth-child(4)"));
        element.click();
    }

    private static void search(WebDriver driver) throws InterruptedException {
        WebElement element = driver.findElement(By.name("search"));
        synchronized (element) {
            for (char ch : "iPhone".toCharArray()) {
                element.sendKeys(String.valueOf(ch));
                element.wait(300);
            }
        }
        element = driver.findElement(By.cssSelector("div.container div.row div.col-sm-5 div.input-group span.input-group-btn > button.btn.btn-default.btn-lg"));
        element.click();
        synchronized (element) {
            element.wait(2000);
        }
    }
}
