package qarizwanacademy.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class FirstExtentReportTest {
	ExtentReports reports;
	static String chromepath = "D:\\JavaWorkspace\\Drivers\\chromedriver.exe";

	@BeforeTest
	public void config() {
		// define all the congfiguration- 2 classes, helful top generate reports
		// pass reporter to extentreporter attachReporter method
		//System.getProperty("user.dir") -> gives the path of current proj
		// define extent report variable as global, as the scope of this is within
		// this block only, test should know about this.
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Tester", "mrizwan4");
	}
	
	@Test
	public void initialDemo() {
		ExtentTest test = reports.createTest("initialDemo");
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		test.fail("result not matched");
		reports.flush();
	}

}
