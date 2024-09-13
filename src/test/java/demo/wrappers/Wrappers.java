package demo.wrappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */

    public static void enterText(WebElement locator, String text) {
        try {

            locator.click();
            locator.sendKeys(text);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void radioselection(ChromeDriver driver, String radiobuttonoption)
    {
        try {
            
            WebElement radiobutton = driver.findElement(By.xpath("//span[contains(@class,'aDTYNe ') and contains(text(),'" + radiobuttonoption + "')]/../../..//div[@class='vd3tt']"));
            radiobutton.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkboxselection(ChromeDriver driver, String checkboxoption)
    {
        try {
            
            WebElement checkbox = driver.findElement(By.xpath("//span[contains(@class,'n5vBHf ') and contains(text(),'" + checkboxoption + "')]/../../preceding-sibling::div[@role='checkbox']"));
            checkbox.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dropdownselection(ChromeDriver driver, String dropdownoption)
    {
        try {
            
            WebElement dropdown = driver.findElement(By.xpath("//div[contains(@class,'QXL7Te')]//span[text()='" + dropdownoption + "']"));
            dropdown.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void movetotheelementtoclick(ChromeDriver driver, WebElement locator)
    {
        try {
            
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", locator);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String returnupdatedlocaldate()
    {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current local date is : " + currentDate);

        LocalDate updatedDate = currentDate.minusDays(7);
        System.out.println("updated date is : " + updatedDate);

        DateTimeFormatter formatform = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = updatedDate.format(formatform);

        return formattedDate;
    }

    public static String epochtime()
    {
        long epochsystemtime = System.currentTimeMillis()/1000;
        String epochtimeinstring = String.valueOf(epochsystemtime);
        return epochtimeinstring;
    }
}
