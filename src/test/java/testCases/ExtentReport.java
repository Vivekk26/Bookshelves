package testCases;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.TestBase;

public class ExtentReport implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports report;
	public ExtentTest test;

	String reportName;

	public void onStart(ITestContext testContext) {
		
		reportName = "TestNG_ExtentReport_"+".html";

		String filepath = System.getProperty("user.dir") + "/Reports/";
		sparkReporter = new ExtentSparkReporter(filepath + reportName);// specify location of the report

		sparkReporter.config().setDocumentTitle("hackathon project "); // Title of report
		sparkReporter.config().setReportName("Display Bookshelves"); // name of the report
		sparkReporter.config().setTheme(Theme.STANDARD);

		report = new ExtentReports();
		report.attachReporter(sparkReporter);
		report.setSystemInfo("Application", "urbanladder");
		report.setSystemInfo("Module", "Display Bookshelves");
		report.setSystemInfo("Sub Module", "Bookshelves");
		report.setSystemInfo("Operating System", System.getProperty("os.name"));
		report.setSystemInfo("User Name", System.getProperty("user.name"));
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		report.setSystemInfo("Browser", browser);
		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
		report.setSystemInfo("Groups", includedGroups.toString());
		}
	}

	public void onTestSuccess(ITestResult result) {
		test = report.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, "Test Passed");
		TakesScreenshot tc=(TakesScreenshot)TestBase.getDriver();
		String path = (System.getProperty("user.dir")+"/screenshot/"+result.getName()+".png");
		try {
			FileUtils.copyFile(tc.getScreenshotAs(OutputType.FILE),new File(path));
		} catch (WebDriverException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path);
	}

	public void onTestFailure(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	}

	public void onTestSkipped(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext testContext) {
		report.flush();

		
	}
}

