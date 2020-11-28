package New_Product;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.util.List;


public class New_Product {
    private WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void start(){
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver,1000);
    }
    @Test
    public void myFirstTest() throws InterruptedException {
        //Переход на страницу админа
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        Thread.sleep(500);
        //Переход на Каталог
        driver.findElement(By.cssSelector("#box-apps-menu li:nth-child(2n) a")).click();
        int count = driver.findElements(By.cssSelector(".dataTable tr.row")).size();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("#content a:nth-child(2n)")).click();
        Thread.sleep(500);
        //Заполнение вкладки General
        driver.findElement(By.cssSelector("input[name = 'name[en]']")).sendKeys("Name");
        driver.findElement(By.cssSelector("input[name = 'code']")).sendKeys("123");
        driver.findElement(By.cssSelector(".input-wrapper input[value='1-3']")).click();
        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("100");
        driver.findElement(By.cssSelector("[type = file]")).sendKeys((new File("src/38341.jpg").getAbsolutePath()));
        driver.findElement(By.cssSelector("input[name= 'date_valid_from']")).sendKeys("28.11.2020");
        driver.findElement(By.cssSelector("input[name = 'date_valid_to']")).sendKeys("29.12.2020");
        //Вкладка Information
        driver.findElement(By.cssSelector("a[href = '#tab-information']")).click();
        Thread.sleep(500);
        Select select = new Select(driver.findElement(By.cssSelector("select[name='manufacturer_id']")));
        select.selectByValue("1");
        driver.findElement(By.cssSelector("input[name = 'keywords']")).sendKeys("Jessi");
        driver.findElement(By.cssSelector("input[name = 'short_description[en]']")).sendKeys("Jessi");
        driver.findElement(By.cssSelector("input[name = 'head_title[en]']")).sendKeys("Jessi");
        driver.findElement(By.name("description[en]")).sendKeys("Ss Jessi");
        driver.findElement(By.cssSelector("input[name = 'meta_description[en]']")).sendKeys("de Jessi");
        //Вкладка Prices
        driver.findElement(By.cssSelector("a[href = '#tab-prices']")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("input[name = 'purchase_price']")).clear();
        driver.findElement(By.cssSelector("input[name = 'purchase_price']")).sendKeys("100");
        select = new Select(driver.findElement(By.cssSelector("select[name = 'purchase_price_currency_code']")));
        select.selectByValue("EUR");
        driver.findElement(By.name("prices[USD]")).sendKeys("100");
        driver.findElement(By.name("prices[EUR]")).sendKeys("73");
        driver.findElement(By.name("save")).click();
        if ((count + 1) == driver.findElements(By.cssSelector(".dataTable tr.row")).size()) {
            System.out.println("Товар добавлен");
        }
    }
        @After
    public void stop(){

        driver.quit();
        driver = null;
    }
}
