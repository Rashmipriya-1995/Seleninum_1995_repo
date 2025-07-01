package extentreports;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AddScreenshotIntoReport {
	@Test
	public void addScreenshot() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.flipkart.com/");
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);
		
		//step 1: create ExtentSparkReporter object
				ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_Reports/screeshotReport.html");
				//step 2: create ExtentReports object
				ExtentReports eReport=new ExtentReports();
				//step 3: attach ExtentSparkReporter to ExtentReports 
				eReport.attachReporter(spark);
				//step 4: create ExtentTest object
				ExtentTest test=eReport.createTest("addScreenshot");// ExtentTest is an Abstract method, we can't create object. use helper class
				//step 5: call log(Status,"message")	
				test.log(Status.INFO, "adding screenshot");
				test.addScreenCaptureFromBase64String(screenshot);
				
				//step 6: call flush()
				eReport.flush();

	}

}
