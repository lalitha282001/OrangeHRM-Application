# OrangeHRM-Application

**AIM :** To automate Orange HRM application

**Test case:**
1. Login to Orange HRM application
2. Verify the login
3. Add user
4. Logout

**Steps involved in creating a java project:**

1. File -> New -> Java project
2. Right click on the project src -> New -> Package
3. Right click on the project Package -> New -> Class
4. As we are just creating a simple java project we are adding two external jars
5. Download https://selenium-release.storage.googleapis.com/3.5/selenium-server-standalone-3.5.3.jar (Purpose: provides referenced library)
6. Download https://master.dl.sourceforge.net/project/webdrivermanager.mirror/webdrivermanager-5.9.2/webdrivermanager-5.9.2-fat.jar?viasf=1 (It supports direct chromedriver lauch even without downloading it in our local every time as it will be complicated when each time the chrome version gets updated)
7. Right click on the project -> Build path -> configure build path -> Libraries -> Add external jars -> Apply and close

**New commands Used**

**Command used to setup chrome**
WebDriverManager.chromedriver().setup();
driver= new ChromeDriver();

**For implicit wait**
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

**To verify the text is same**
String ActualText=driver.findElement(By.xpath("....")).getText();
		String ExpectedText =".....";
		if (ExpectedText.contains(ActualText)) {
			System.out.println("Message");
		}
		else {
			System.out.println("Message");
		}

**To verify whether the element is visible**
WebDriverWait wait=new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".....")));

**NOTE:**  If we create multiple method inside a class we should mention all the method name inside the main class otherwise it will be terminated
