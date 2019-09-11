import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RegisterSucessfull {
    protected static WebDriver driver;
    @BeforeMethod
    public void browser()
    {
        System.setProperty("webdriver.chrome.driver", "src\\main\\Resourses\\BrowserDrive\\chromedriver.exe");

        //open browser
        driver = new ChromeDriver();

        //set implicitly wait for driver object
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //open the website
        driver.get("https://demo.nopcommerce.com/");
    }
    @AfterMethod
    public void closing()
    {

        //close window
        driver.close();

    }

    @Test
    public void reg()
    {
        //click on register button
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();

        //enter first name
        driver.findElement(By.id("FirstName")).sendKeys("Baman");

        //enter last name
        driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("Lal");

        //random number
        Random r= new Random();
        int random = r.nextInt(100000);

        //enter email
        driver.findElement(By.name("Email")).sendKeys("BamanLa"+random+"@test.com");

        //enter password
        driver.findElement(By.id("Password")).sendKeys("abc123");

        //enter confirm password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("abc123");

        //click register button
        driver.findElement(By.id("register-button")).click();

        //testing Sucessfull
        String expectedMsg = "Your registration completed";
        String actualMsg = driver.findElement(By.xpath("//div[@class=\'result\']")).getText();
        System.out.println(actualMsg);
        Assert.assertEquals(actualMsg,expectedMsg);
    }

    @Test
    public void RegisterMemberThenSendEmail()
    {
        //click on register button
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();

        //enter first name
        driver.findElement(By.id("FirstName")).sendKeys("gaman");

        //enter last name
        driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("Lal");

        //random number
        Random r= new Random();
        int random = r.nextInt(100000);

        //enter email
        driver.findElement(By.name("Email")).sendKeys("gamanLal"+random+"@test.com");

        //enter password
        driver.findElement(By.id("Password")).sendKeys("abc123");

        //enter confirm password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("abc123");

        //click register button
        driver.findElement(By.id("register-button")).click();

        //click on categories ,computers
        driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/computers\"]")).click();

        //click on notebook
        driver.findElement(By.xpath("//h2/a[@href=\"/notebooks\"]")).click();

        //select Apple Macbook
        driver.findElement(By.xpath("//img[contains(@src,'apple-macbook-pro-13-inch')]")).click();

        //click email a friend
        driver.findElement(By.xpath("//input[@onclick='setLocation(\"/productemailafriend/4\")']")).click();

        //enter friend's email
        driver.findElement(By.className("friend-email")).sendKeys("ChaganLal@test.com");

        //enter message
        driver.findElement(By.xpath("//textarea[@id='PersonalMessage']")).sendKeys("Amazing Product have a look in it.");

        //click on send email
        driver.findElement(By.name("send-email")).click();

        //Testing
        String expected = "Your message has been sent.";
        String actual = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void cameraPage()
    {
        //click on electronics
        driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/electronics\"]")).click();

        //click on camera-photo
        driver.findElement(By.xpath("//h2[@class=\"title\"]//a[@href=\"/camera-photo\"]")).click();

        //Testing
        String expected = "Camera & photo";
        String actual = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(actual,expected);
    }
    @Test
    public  void addToCartTwoProducts() {

        //click on catagories
        driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/apparel\"]")).click();

        //click on clothing
        driver.findElement(By.xpath("//h2/a[@href=\"/clothing\"]")).click();

        //add to cart product 1
        driver.findElement(By.xpath("//h2[@class=\"product-title\"]//a[@href=\"/levis-511-jeans\"]")).click();

        //click on add to cart button
        driver.findElement(By.xpath("//input[@id=\"add-to-cart-button-30\"]")).click();

        //close message box
        driver.findElement(By.xpath("//span[@class=\"close\"]")).click();

        //add to cart product 2
        driver.findElement(By.xpath("//div[@data-productid=\"27\"]")).click();

        //click on add to cart button
        driver.findElement(By.xpath("//input[@id=\"add-to-cart-button-27\"]")).click();

        //Testing
        String expected2 = "The product has been added to your shopping cart";
        String actual2 = driver.findElement(By.xpath("//p[@class=\"content\"]")).getText();
        Assert.assertEquals(actual2, expected2);

    }
    @Test
    public void jewelryPriceSelection()
    {
        //click on jewelry
        driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/jewelry\"]")).click();

        //click on price range $700- $3000
        driver.findElement(By.xpath("//a[@href=\"//demo.nopcommerce.com/jewelry?price=700-3000\"]")).click();

        //making variable name & store in productPrice
        String  productPrice = driver.findElement(By.xpath("//span[@class=\"price actual-price\"]")).getText();

        //remove $ from string productPrice
        String pprice=productPrice.substring(1);

        //converting string to float
        float price =Float.parseFloat(pprice.replaceAll(",",""));

        //testing
        Assert.assertTrue(price > 700 && price < 3000);

    }

    }
