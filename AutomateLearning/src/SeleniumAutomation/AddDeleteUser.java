package SeleniumAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddDeleteUser extends OrangeHrm {

	
    public static void AddUser() throws Exception {
    	
    	PIM_Employeepage();
    	//Add button locator
    	driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	//Add employee page
    	String ActualEmpPage=driver.findElement(By.xpath("//li[@class='oxd-topbar-body-nav-tab --visited']")).getText();
    	String Expectedpage="Add Employee";
    	if(Expectedpage.contains(ActualEmpPage))
    	{
    		System.out.println("Add Employee page is shown");
    	}
    	else
    	{
    	System.out.println("Add Employee page is not shown");
    	}
   	
    	//Firstname
    	driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Alen");
    	//Middlename
    	driver.findElement(By.xpath("//input[@placeholder='Middle Name']")).sendKeys("Barker");
    	//Last Name
    	driver.findElement(By.xpath("//input[@placeholder='Middle Name']")).sendKeys("George");
    	//Employee id
    	driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")).sendKeys("10001");
    	driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
    	PIM_Employeepage();
    	
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	String ActualEmpList=driver.findElement(By.xpath("//li[@class='oxd-topbar-body-nav-tab --visited']")).getText();
    	String ExpectedEmpList="Employee List";
    	if(ExpectedEmpList.contains(ActualEmpList))
    	{
    		System.out.println("Employee list section is shown");
    	}
    	else
    		System.out.println("Employee list section is not shown");
    	
    	//Employee id
    	driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")).clear();
    	driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")).sendKeys("10001");
    	driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	WebDriverWait wait=new WebDriverWait(driver, 10);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='orangehrm-container']")));
    	
    	//delete the newly added employee
    	
    	  		

    }
    
    public static void PIM_Employeepage() {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("//div[@class='oxd-layout-navigation']//li[2]")).click();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	String ActualHeaderText = driver.findElement(By.xpath("//h6[normalize-space()='PIM']")).getText();
    	String ExpectedHeaderText = "PIM";
    	if(ExpectedHeaderText.contains(ActualHeaderText))
    		System.out.println("PIM page is selected");
    	else
    	{
    		System.out.println("PIM page is not selected");
    		
    	}
    	
    	
    	
    }
    
    
  
	public static void main(String[] args) throws Exception {
		Login();
		VerifyLogin();
		AddUser();
		Logout();
		

	}

}
