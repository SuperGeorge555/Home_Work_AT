package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class NextHomeWork {

    private final static String SEARCH_FIELD = "//input[@placeholder='Искать на Ozon']";
    private final static String FIRST_FIELD_OF_PRICE = "//div/input[@class='ui-h5 ui-h6 ui-a3b']";
    private final static String AUTHOR = "//div[@class='ui-ab4']//span[contains(text(),'Задорнов Михаил Николаевич')]";
    private final static String CHECK_BOX = "//div//span[contains(text(), 'Товары со скидкой')]";
    private final static String FILTERED_BOOKS = "//div[@data-widget = 'searchResultsV2']//div[contains(@class,'m1i')]";
    ////div[@data-widget='searchResultsV2']//div[@class = 'il']
    private final static String CART = "//a[@href='/cart']";


    public static void main(String[] args) {

        /*
        Задаем путь до вебдрайвера в системные переменные
        Если драйвер не подходит скачиваем подходящий тут https://chromedriver.chromium.org/downloads
        */

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //Создаем объект ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Переходим на страницу https://www.ozon.ru/
        driver.get("https://www.ozon.ru/");

        NextHomeWork.timeOut(5);

        //Ищем элемент по xpath "//input[@placeholder='Искать на Ozon']"
        WebElement findOzon = driver.findElement(By.xpath(SEARCH_FIELD));
        findOzon.sendKeys("Михаил Задорнов Книги"); // ввод в поле
        findOzon.sendKeys(Keys.ENTER); //жмем ENTER

        //ждем загрузки странцы
        NextHomeWork.timeOut(5);

        // ставим цену 1000
        List<WebElement> listPrices = driver.findElements(By.xpath(FIRST_FIELD_OF_PRICE));
        String s = listPrices.get(0).getAttribute("value");
        System.out.println(s);
        clearField(s.length(), listPrices.get(0));
        listPrices.get(0).sendKeys("1000");
        listPrices.get(0).sendKeys(Keys.TAB);

        NextHomeWork.timeOut(5);

        WebElement author = driver.findElement(By.xpath(AUTHOR));
        author.click();

        NextHomeWork.timeOut(3);

        //выбираем товар со скидкой
        WebElement checkBox = driver.findElement(By.xpath(CHECK_BOX));
        checkBox.click();

        NextHomeWork.timeOut(3);

        List<WebElement> filteredBooks = driver.findElements(By.xpath(FILTERED_BOOKS));
        WebElement randomBook = filteredBooks.get(new Random().nextInt(filteredBooks.size()));
        String price = randomBook.findElement(By.xpath(".//span[contains(text(), '₽')]")).getText();
        String bookName = randomBook.findElement(By.xpath(".//span[contains(text(), '| Задорнов Михаил Николаевич')]")).getText();
        System.out.println("Цена книги: " + price);
        System.out.println("Название книги: " + bookName);
        WebElement buyBook = randomBook.findElement(By.xpath(".//span[contains(text(),'В корзину')]"));
        buyBook.click();
        driver.findElement(By.xpath(CART)).click();


    }

    public static void timeOut(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clearField(int size, WebElement element) {
        for (int i = 0; i < size; i++)
            element.sendKeys("\b");
    }
}
