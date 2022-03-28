package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ozon {
    public static void main(String[] args) {

        /*
        Задаем путь до вебдрайвера в системные переменные
        Если драйвер не подходит скачиваем подходящий тут https://chromedriver.chromium.org/downloads
        */
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        //Создаем объект ChromeDriver
        WebDriver driver = new ChromeDriver();

        //Выставляем максимальный размер окна хрома
        driver.manage().window().maximize();


        //Переходим на страницу https://www.browserstack.com/users/sign_in
        driver.get("https://www.ozon.ru/");

        //Ищем элемент по xpath "//input[@id = 'user_email_login']"
        WebElement findOzon = driver.findElement(By.xpath("//input[@placeholder='Искать на Ozon']"));

        System.out.println(findOzon);

        driver.close();


    }
}
