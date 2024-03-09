package testBase;

 
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
 
 
public class TestBase {
	public static WebDriver driver; 
	@Parameters({"browser", "url"})
	@BeforeTest(groups={"regression","sanity"})
	public void setup(String browser, String url) throws IOException {

		switch(browser.toLowerCase()) {
		case "chrome":driver = new ChromeDriver();break;
		case "edge" : driver= new EdgeDriver();break;
		default: System.out.println("No valid browser");
							return;
		}
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 
	}
	public static WebDriver getDriver()
	{
		return driver;
	}
	@AfterTest(groups={"regression","sanity"})
	public void closeBrowser() {
		driver.quit();
	}
}