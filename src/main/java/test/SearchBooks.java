package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

public class SearchBooks {
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

        driver.get("https://www.ozon.ru/seller/rus-velikaya-77277/knigi-16500/?miniapp=seller_77277");

        WebElement element = driver.findElement(By.xpath("//section[@class= 'ik']"));
        if(element != null)
        {
            System.out.println("we find him");
        }
        List<WebElement> webElements = driver.findElements(By.xpath("//section[@class= 'ik']"));

        driver.close();
        System.out.println("Найдено книг: " + webElements.size());

    }
}
