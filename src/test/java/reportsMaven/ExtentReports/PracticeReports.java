package reportsMaven.ExtentReports;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class PracticeReports {
	ExtentReports extent;
	
	@BeforeTest
	public void reportMethod() {
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Wweb Automation Selenium");
		reporter.config().setDocumentTitle("Test Extent Results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Kavya Chithra");
	}
	@Test
	public void visitPage() {
		ExtentTest test = extent.createTest("Visting Page");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sudhe\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/#/index");
		driver.getTitle();
		//test.fail("This got failed");
		driver.close();
		extent.flush();
	}

}
