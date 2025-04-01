package stepDefinition;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.DriverManager;
import utils.Screenshot;

public class Hooks {
	static WebDriver driver;
	static WebDriverWait wait;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeAll
	public static void beforeAll() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("target/Extent_Report.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Poongodi");
		extent.setSystemInfo("co-tester", "ajai");
	}

	@Before
	public void setup(Scenario scene) {
		driver = DriverManager.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		test = extent.createTest(scene.getName());
	}

	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			System.out.println(scenario.getName());
			test.assignDevice("Windows 10 chrome browser");
			test.info("the user is invalid");
			Map<String, Object> myMap = new HashMap<String, Object>();
			myMap.put("name", "our name");
			myMap.put("tested Engineer", "our name");
			test.log(Status.PASS, new Media(Screenshot.getScreenshot(driver, scenario.getName()),"This is Title",Screenshot.getScreenshot(driver, scenario.getName()),myMap));
			test.addScreenCaptureFromPath(Screenshot.getScreenshot(driver, scenario.getName()));
		}
		driver.quit();
	}
	
	@AfterAll
	public static void afterAll() {
		extent.flush();
	}
	
	

//	@BeforeAll
//	public static void setupReport() {
//		ExtentSparkReporter reporter = new ExtentSparkReporter("target/ExtentReport.html");
//		extent = new ExtentReports();
//		extent.attachReporter(reporter);
//		extent.setSystemInfo("Tester", "poongodi");
//		System.out.println("Extent Report initialized.");
//	}
//
//	@Before
//	public void setUp(Scenario scene) {
//		driver = new ChromeDriver();
//		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//		driver.manage().window().maximize();
//		test = extent.createTest(scene.getName()); // Start Extent Test
//	}
//
//	@After
//	public void tearDown(Scenario scene) {
//
//		if (scene.isFailed()) {
//			test.fail("Test Failed: " + scene.getName());
//			String screenShotPath = takeScreenshot(scene);
//			test.addScreenCaptureFromPath(screenShotPath);
//		} else {
//			test.pass("Test Passed: " + scene.getName());
//		}
//		System.out.println("teard down");
//		driver.quit();
//	}
//
//	@AfterAll
//	public static void closeReport() {
//		extent.flush(); // Write results to report
//		System.out.println("Extent Report saved.");
//	}
//
//	public static String takeScreenshot(Scenario scene) {
//		return Screenshot.getScreenshot(driver, scene.getName());
//	}

}
