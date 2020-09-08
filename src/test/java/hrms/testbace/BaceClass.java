package hrms.testbace;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constains;
public class BaceClass {
	public static WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {

		ConfigsReader.readProperties(".\\src\\test\\resources\\configs\\configurations.properties");
		
		switch (ConfigsReader.getPropValue("browser").toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Muslima\\eclipse-workspace\\SyntaxHrms\\src\\test\\resources\\drivers\\chromedriver.exe"
					);
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir" + "/src/test/resources/driver/geckodriver.exe"));
		driver = new FirefoxDriver();
			break;

		default:
			throw new RuntimeException("Browser is not supported");
		}

		driver.manage().window().maximize();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
		
		
		
	}
}