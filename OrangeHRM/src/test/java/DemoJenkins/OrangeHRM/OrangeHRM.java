package DemoJenkins.OrangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrangeHRM {
	WebDriver driver;
	@Test
	  public void TC1() {
		driver = new ChromeDriver();
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin",Keys.ENTER);
	    driver.findElement(By.name("password")).sendKeys("admin123",Keys.ENTER);
	  }
	  @Test(dependsOnMethods= {"TC1"})

	  public void TC2() {
	     driver.findElement(By.className("oxd-userdropdown-tab")).click();
	     driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")).click();
	     String string = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	     System.out.println(driver.getCurrentUrl().equals(string)?"Pass":"Fail");
	     driver.close();

}
}

