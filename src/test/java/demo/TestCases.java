package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();
    }

    @Test
    public void testCase01() throws InterruptedException
    {
        
        driver.get("https://forms.gle/wjPkzeSEk1CM7KgGA");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Enter the Name
        WebElement Nametext = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'aXBtI ')]//input[@type='text' and contains(@aria-labelledby,'i')]")));
        Wrappers.movetotheelementtoclick(driver, Nametext);
        Thread.sleep(4000);
        System.out.println("Wait 1");
        Wrappers.enterText(Nametext, "Crio Learner");

        //Enter the Text
        WebElement textarea = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@class='KHxj8b tL9Q4c']")));
        Wrappers.movetotheelementtoclick(driver, textarea);
        String content = "I want to be the best QA Engineer! ";
        String epoctimestring = Wrappers.epochtime();
        Thread.sleep(2000);
        System.out.println("Wait 2");
        Wrappers.enterText(textarea, content+" "+epoctimestring);
        

        //Radio Button
        Wrappers.radioselection(driver, "0 - 2");

        //Checkbox selction
        Wrappers.checkboxselection(driver, "Java");
        Wrappers.checkboxselection(driver, "Selenium");
        Wrappers.checkboxselection(driver, "TestNG");

        //Click on the dropdown
        WebElement maindropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ry3kXd']")));
        Wrappers.movetotheelementtoclick(driver, maindropdown);
        Thread.sleep(2000);
        System.out.println("Wait 3");
        Wrappers.dropdownselection(driver, "Mrs");


        //Select the date
        WebElement selectinputdate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='date']")));
        String selectdatefrompastsevendays = Wrappers.returnupdatedlocaldate();
        Wrappers.movetotheelementtoclick(driver, textarea);
        // Thread.sleep(3000);
        // System.out.println("Wait 4");
        Wrappers.enterText(selectinputdate, selectdatefrompastsevendays);

        //Enter the time
        WebElement timeinHours = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Xb9hP']//input[@aria-label='Hour']")));
        WebElement timeinMin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Xb9hP']//input[@aria-label='Minute']")));

        Wrappers.enterText(timeinHours, "07");
        Wrappers.enterText(timeinMin, "30");
        Thread.sleep(2000);

        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Submit']")));
        submit.click();

        WebElement successmessage1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='vHW8K']")));
        String validatemessage = successmessage1.getText();
        if(validatemessage.contains("Thanks for your response, Automation Wizard!"))
        {
            System.out.println("The success message is printed successfully: " + validatemessage);
        }
        else{
            System.out.println("validation failed");
        }

        

    }



}