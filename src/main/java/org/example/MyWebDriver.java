package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class MyWebDriver {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://konflic.github.io/examples/");

        WebElement input = driver.findElement(By.cssSelector("#inp"));

        //Выводим заголовок страницы
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Пишем текст в поле ввода
        input.click();
        driver.wait(4000);
        char[] text = "text".toCharArray();
        for (int i = 0; i < text.length; i++) {
            input.sendKeys(String.valueOf(text[i]));
            driver.wait(500);
        }
        driver.wait(4000);

        // Открываем меню
        WebElement menu = driver.findElement(By.cssSelector("#dropdownMenuLink"));

        menu.click();
        driver.wait(4000);
        driver.findElement(By.linkText("Select")).click();
        driver.wait(4000);

        //Выводим заголовок страницы
        pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Открытие окна и вывод текста
        WebElement modal = driver.findElement(By.cssSelector("#myBtn"));
        modal.click();
        driver.wait(4000);
        System.out.println(driver.findElement(By.cssSelector("#modal-text")).getText());
        driver.wait(4000);

        driver.findElement(By.linkText("pieter.parker@example.com")).click();
        Thread.sleep(4000);

        driver.quit();
    }


}
