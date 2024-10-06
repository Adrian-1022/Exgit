package Testcaserun;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Tc1 {
	WebDriver driver;
	WebDriverWait wait;
	
	@Test
	public void setup() throws InterruptedException{
		ChromeDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		//SoftAssert softAssert = new SoftAssert();
		wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
	
		driver.get("https://azfrcer0124.europe.essilor.group/");
		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//label[text()='Work In Progress']/parent::div")).click();
		
		//driver.quit();
	}
}