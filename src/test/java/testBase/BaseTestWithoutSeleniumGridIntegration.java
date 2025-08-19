package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTestWithoutSeleniumGridIntegration {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	//necessarily include groups in setup() and teardown() methods because even though
	//this class is inherited by other test classes , once groups tag is included , only
	//test methods are directly called and executed
	@BeforeClass(groups={"Sanity","Regression","Master"})
	@Parameters({"browser","os"})
	public void setup(String browser, String os) throws IOException {
		//log4j2
		logger = LogManager.getLogger(this.getClass());	
		
		//Loading configuration properties
		FileReader file = new FileReader("./src//test/resources//config.properties");
		FileReader file2 = new FileReader("./src//test/resources//messages.properties");

		p=new Properties();
		p.load(file);
		p.load(file2);
		
		//Initializing browser
		switch(browser.toLowerCase()){
		case "chrome": 		driver = new ChromeDriver();			logger.info("Initializing "+browser); 	break;
		case "safari":		driver = new SafariDriver();			logger.info("Initializing "+browser);	break;
		case "firefox":		driver = new FirefoxDriver();			logger.info("Initializing "+browser);	break;
		case "edge":		driver = new EdgeDriver();				logger.info("Initializing "+browser);	break;
		default : System.out.println("Invalid driver information");
		}
		
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("Navigating to Application URL");
		driver.get(p.getProperty("appUrl"));	//reading URL from config.properties file
//		driver.get("https://practice.expandtesting.com/dropdown");
		logger.info("Maximizing window");
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups={"Sanity","Regression","Master"})
	public void tearDown() {
		logger.info("Closing browser");
		driver.quit();
	}
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		return generatedString;
	}
	
	public String randomNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(9);
		return generatedNumber;
	}
	
	public String randomAlphaNum() {
		String generatedAlphaNum = RandomStringUtils.randomAlphanumeric(7);
		return generatedAlphaNum;
	}


	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		// String targetFilePath=System.getProperty("user.dir")+"/screenshots/" + tname + "_" + timeStamp + ".png";

		// Instead of hardcoding fileseparators , used Paths to make the execution and reports OS Agnostic		
		//TargetFilePath should be the complete path from the user's directory util the screenshot
		String targetFilePath=Paths.get(System.getProperty("user.dir"), "screenshots", tname+"_" + timeStamp + ".png").toString();
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}


}
