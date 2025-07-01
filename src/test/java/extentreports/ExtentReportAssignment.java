package extentreports;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportAssignment {
	@Test
	public void addScreeshotWithTimeStamp() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String time = LocalDateTime.now().toString().replace(":", "-");
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("rashmikumari123@gmail.com");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		TakesScreenshot ts=(TakesScreenshot) driver;
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_Reports/screenshot_report"+time+".html");
		ExtentReports ereport=new ExtentReports();
		ereport.attachReporter(spark);
		ExtentTest test=ereport.createTest("addScreeshotWithTimeStamp");
		test.log(Status.INFO, "Adding Screenshot");
		test.addScreenCaptureFromBase64String(screenshot);
		ereport.flush();
		
		
		

	}

}
