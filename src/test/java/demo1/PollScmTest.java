package demo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PollScmTest {
	@Test
	public void demo() {
		WebDriver driver=new ChromeDriver();
		Reporter.log("poll scm class executed", true);
	}

}
