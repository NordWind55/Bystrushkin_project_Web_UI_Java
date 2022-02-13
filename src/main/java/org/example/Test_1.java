package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

//Тест 1 "Авторизация пользователя на сайте"
public class Test_1 {
    public static void main (String[] args) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");//полноэкранный режим
        options.addArguments("--incognito");//режим инкогнито
        options.addArguments("disable-popup-blocking");//блокировка всплывающих окон
        options.addArguments("--disable-notifications");//блокировка всплывающих окон

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.eldorado.ru/");

        //Нажать на кнопку "Вход или регистрация" в хедере сайта.
        WebElement webElementButtonRegistration = driver.findElement(By.xpath("//button[@class='GF']"));
        webElementButtonRegistration.click();

        //Нажать на кнопку "Вход по e-mail/логину" в модальном окне.
        WebElement webElementLoginByEmail = driver.findElement(By.xpath("//button[@class='of']"));
        webElementLoginByEmail.click();

        //Ввести адрес электронной почты в поле "E-mail или логин".
        WebElement webElementFieldEmail = driver.findElement(By.xpath("//*[@name='login']"));
        webElementFieldEmail.click();
        webElementFieldEmail.sendKeys("wish_test@mail.ru");

        //Ввести пароль в поле "Пароль".
        WebElement webElementFieldPassword = driver.findElement(By.xpath("//*[@name='password']"));
        webElementFieldPassword.click();
        webElementFieldPassword.sendKeys("w!CXfTf5Mm$$P_R");

        //Нажать на кнопку "Войти"
        WebElement webElementButtonSubmit = driver.findElement(By.xpath("//button[@class='If']"));
        webElementButtonSubmit.click();

        //Закрываем всплывающее окно "Подтвердите ваш E-mail" (никак не могу избавиться от него,
        // в письме, присланного на почту, нет возможности подтвердить E-mail...)
        WebElement webElementClosePopupWindow = driver.findElement(By.xpath("//button[@class='Ng Ug']"));
        webElementClosePopupWindow.click();

        //Закрываем браузер
        driver.quit();
    }
}
