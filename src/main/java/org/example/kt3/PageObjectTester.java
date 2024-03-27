package org.example.kt3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class PageObjectTester {
    private WebDriver driver;

    public PageObjectTester() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver2/chromedriver.exe");
    }

    private WebDriver getChromeDriver() {
        driver = new ChromeDriver();
        return driver;
    }

    private WebDriver getFireFoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        return driver;
    }

    private void closeDriver() {
        driver.close();
    }

    public static void main(String[] args) throws InterruptedException {
        PageObjectTester pageObjectTester = new PageObjectTester();

        pageObjectTester.switchingPictures(pageObjectTester.getChromeDriver());
        pageObjectTester.checkCart(pageObjectTester.getChromeDriver());
        pageObjectTester.addHTCPhoneToCart(pageObjectTester.getChromeDriver());
        pageObjectTester.checkPcPage(pageObjectTester.getChromeDriver());
        pageObjectTester.registerNewAccount(pageObjectTester.getChromeDriver());
        pageObjectTester.search(pageObjectTester.getChromeDriver());
        pageObjectTester.addProductToWishList(pageObjectTester.getChromeDriver());
        pageObjectTester.addCameraToCart(pageObjectTester.getChromeDriver());
        pageObjectTester.addTabletToCart(pageObjectTester.getChromeDriver());
        pageObjectTester.addHTCPhoneToCart(pageObjectTester.getChromeDriver());
        pageObjectTester.writeAReviewTo(pageObjectTester.getChromeDriver());

        pageObjectTester.switchingPictures(pageObjectTester.getFireFoxDriver());
        pageObjectTester.checkCart(pageObjectTester.getFireFoxDriver());
        pageObjectTester.addHTCPhoneToCart(pageObjectTester.getFireFoxDriver());
        pageObjectTester.checkPcPage(pageObjectTester.getFireFoxDriver());
        pageObjectTester.registerNewAccount(pageObjectTester.getFireFoxDriver());
        pageObjectTester.search(pageObjectTester.getFireFoxDriver());
        pageObjectTester.addProductToWishList(pageObjectTester.getFireFoxDriver());
        pageObjectTester.addCameraToCart(pageObjectTester.getFireFoxDriver());
        pageObjectTester.addTabletToCart(pageObjectTester.getFireFoxDriver());
        pageObjectTester.addHTCPhoneToCart(pageObjectTester.getFireFoxDriver());
        pageObjectTester.writeAReviewTo(pageObjectTester.getFireFoxDriver());
    }

    public void checkPcPage(WebDriver driver) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openAtMenu("Компьютеры", "PC");
        Thread.sleep(2000);
        closeDriver();
    }

    public void checkCart(WebDriver driver) {
        MainPage mainPage = new MainPage(driver);
        mainPage.addProductToCart(1);
        mainPage.addProductToCart(3);
        CartPage cartPage = mainPage.goToCart();
        cartPage.getAllProductsInCart().forEach(System.out::println);
        closeDriver();
    }

    public void switchingPictures(WebDriver driver) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.photoSwitchingNext();
        Thread.sleep(2000);
        mainPage.photoSwitchingPrev();
        Thread.sleep(2000);
        mainPage.photoSwitchingPrev();
        Thread.sleep(2000);
        closeDriver();
    }

    public void registerNewAccount(WebDriver driver) throws InterruptedException {
        UserPage userPage = new UserPage(driver);
        userPage.registerNewAccount("Анастасия", "Выборова", "email34@gmail.com", "+79451237821", "Kilop93s");
        closeDriver();
    }

    public void search(WebDriver driver) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.search("iPhone");
        Thread.sleep(2000);
        closeDriver();
    }

    public void addProductToWishList(WebDriver driver) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.addProductToWishList(1);
        Thread.sleep(2000);
        closeDriver();
    }

    public void addCameraToCart(WebDriver driver) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.addProductToCart(4);
        closeDriver();
    }

    public void addTabletToCart(WebDriver driver) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openAtMenu("Планшеты", null);
        mainPage.openProductPage("Samsung Galaxy Tab 10.1").addToCart();
        Thread.sleep(2000);
        closeDriver();
    }

    public void addHTCPhoneToCart(WebDriver driver) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openAtMenu("Телефоны", null);
        mainPage.openProductPage("HTC Touch HD").addToCart();
        Thread.sleep(2000);
        closeDriver();
    }

    public void writeAReviewTo(WebDriver driver) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openAtMenu("Телефоны", null);
        mainPage.openProductPage("iPhone").writeAReview("Анастасия", "Классный телефон за свою цену, но Samsung лучше");
        closeDriver();
    }



}
