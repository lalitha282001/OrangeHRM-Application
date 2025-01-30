package SeleniumAutomation;

import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrm {
	static WebDriver driver;
	
	public static void Login() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");	
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}
	
	public static void VerifyLogin() throws Exception {
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String ActualText=driver.findElement(By.xpath("//h6[normalize-space()=\"Dashboard\"]")).getText();
		String ExpectedText ="Dashboard";
		if (ExpectedText.contains(ActualText)) {
			System.out.println("User logged in successfully");
		}
		else {
			System.out.println("Failed: user login");
		}
	}
	
	public static void Logout() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span")).click();
		driver.findElement(By.xpath("//a[normalize-space()=\"Logout\"]")).click();
		System.out.println("User logged out successfully");
		driver.close();
	}
	
		public static void main(String[] args) throws Exception {
               Login();
               VerifyLogin();
               Logout();
}
}
