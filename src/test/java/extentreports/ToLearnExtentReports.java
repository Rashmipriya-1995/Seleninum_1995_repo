package extentreports;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnExtentReports {
	@Test
	public void createReport() {
		//step 1: create ExtentSparkReporter object
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_Reports/extentreport.html");
		//step 2: create ExtentReports object
		ExtentReports eReport=new ExtentReports();
		//step 3: attach ExtentSparkReporter to ExtentReports 
		eReport.attachReporter(spark);
		//step 4: create ExtentTest object
		ExtentTest test=eReport.createTest("createReport");// ExtentTest is an Abstract method, we can't create object. use helper class
		//step 5: call log(Status,"message")	
		test.log(Status.PASS, "log message added into report");
		
		//step 6: call flush()
		eReport.flush();

		




	}

}
