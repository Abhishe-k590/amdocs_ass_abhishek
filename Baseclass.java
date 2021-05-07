package genericUtilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.Home;
import objectRepository.Login;



/**
 * 
 * @author abhishek
 *
 */
public class Baseclass {

	/**
	 * object creation
	 */
	public WebDriver driver=null;
	public static WebDriver staticdriver;
	public WebDriverUtilities util=new WebDriverUtilities();
	public FileUtilities file=new FileUtilities();
	public ExcelUtilities excel=new ExcelUtilities();
	public JavaUtilities java=new JavaUtilities();
	
	public DataBaseUtilities database = new DataBaseUtilities();

	@BeforeSuite
	/**
	 * 
	 * to register and connect to the database
	 * 
	 */
	public void configBeforeSuite() throws Throwable {
		database.connectToDB();
	}
	

	@BeforeClass
	/**
	 * 
	 * to launch the specific browser
	 * to read common data from property file
	 * 
	 */
	public void configBeforeClass() throws Throwable {
		String URL = file.PropertyData("url");

		String BROWSER = file.PropertyData("browser");
		
		 if(BROWSER.equals("firefox")) {
		    driver = new FirefoxDriver();
		 }else if(BROWSER.equals("chrome")) {
			 driver = new ChromeDriver();
		 }else if(BROWSER.equals("ie")) {
			 driver = new InternetExplorerDriver();
		 }else {
			 driver = new ChromeDriver();
		 }
		staticdriver=driver;
		 driver.get(URL);
	}
	
	
	/*@Parameters("BROWSER")
	//@BeforeClass(groups = {"smokeTest" , "RegressionTest"})
	*//**
	 * 
	 * to launch the specific browser
	 * to read common data from property file
	 * 
	 *//*
	public void configBeforeClass(String Browser) throws Throwable {
		String URL = file.PropertyData("URL");
		
		 if(Browser.equals("firefox")) {
		    driver = new FirefoxDriver();
		 }else if(Browser.equals("chrome")) {
			 driver = new ChromeDriver();
		 }else if(Browser.equals("ie")) {
			 driver = new InternetExplorerDriver();
		 }else {
			 driver = new ChromeDriver();
		 }
		
		 driver.get(URL);
	}*/
	
	@BeforeMethod
	/**
	 * 
	 * to login to the application
	 * 
	 */
	public void configBeforeMtd() throws Throwable {
		String USERNAME = file.PropertyData("USERNAME");
		String PASSWORD = file.PropertyData("PASSWORD");
		Login log=new Login(driver);
		log.loginToAPP(USERNAME,PASSWORD);
	}
	
	@AfterMethod
	/**
	 * 
	 * to logout of the application
	 * 
	 */
	public void configAfterMethod() throws Throwable {
		Home home= new Home(driver);
			  home.logout();
    }
	
	
	@AfterClass
	/**
	 * 
	 * to close the browser
	 * 
	 */
	public void configAfterClass() {
		driver.close();
	}
	
	@AfterSuite
	/**
	 * to close the database connection
	 */
	public void configAfterSuite() throws Throwable {
		database.closeDb();
		
	}

}