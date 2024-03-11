package StepDefinictions;


import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AP_State_Portal {
	
	WebDriver driver;
	//Select dropdown ;
	
	@Given("User is on Home page")
	public void user_is_on_home_page() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.ap.gov.in/#/home");
		//driver.navigate().to("https://www.ap.gov.in/#/home");
	    driver.navigate().refresh();
	    //driver.navigate().forward();
	   // driver.navigate().back();
	}

	@When("User enter the Government DropDown")
	public void user_enter_the_government_drop_down() throws InterruptedException {
	   
		
		WebElement testDropDown = driver.findElement(By.id("dropdownMenuButton2"));
		testDropDown.click();
	    Thread.sleep(3000); 
	   // dropdown = new Select(testDropDown);  
	    //dropdown.deselectByVisibleText("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/div/a[5]");
	    //dropdown.deselectByValue("MLA");
	    //Thread.sleep(3000);
	    
	}

	@And("Click on the MLA Sub DropDown")
	public void click_on_the_mla_sub_drop_down() throws Exception {
		
		WebElement testDropDown1 = driver.findElement(By.xpath( "//*[@id=\'navbarSupportedContent\']/ul/li[3]/div/a[5]"));
        testDropDown1.click();
        
        Thread.sleep(3000);
		
        JavascriptExecutor js = ((JavascriptExecutor) driver);
		 js.executeScript("window.scrollBy(0,300)");
       
		 Thread.sleep(3000);
	}

	@And("Click on the Nellore_\\(Dt)DropDown")
	public void click_on_the_nellore_dt_drop_down() throws InterruptedException {
		
		 WebElement testDropDown2= driver.findElement(By.xpath("//*[@id=\"accordion-header-7\"]/div[1]"));
		 testDropDown2.click();
			
			 JavascriptExecutor js1 = ((JavascriptExecutor) driver);
			 js1.executeScript("window.scrollBy(0,500)");
		    
			 Thread.sleep(3000);
	}

	@Then("User take screenshot")
	public void user_take_screenshot() throws Exception {
		
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("C:\\Users\\Admin\\OneDrive\\Desktop\\Screen Shot\\GoogleScreenShot.jpg"));
		Thread.sleep(3000);
	}

	@And("Close The Browser")
	public void close_the_browser() {
		
		driver.close();
		
	 }


}
