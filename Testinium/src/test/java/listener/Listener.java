package listener;

import org.apache.log4j.MDC;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utils.BaseTest;

public class Listener  extends BaseTest implements ITestListener {
	public void onTestStart(ITestResult result) {
		driver.get(baseUrl);
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("basarili");
		log.info("BAÞARILI");

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("basarisiz"); //rapor al, ekran görüntüsü al, mail gönder gibi iþlemler burda yapýlabilir.
		log.error("FAÝL");

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("skipped");
		
		MDC.put("fail",result.getThrowable());

	
		log.warn("FAÝL");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		System.setProperty("webdriver.chrome.driver", "H:\\SeleniumTutorial\\Installers\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		MDC.put("name",context.getName());
		
		
		log.info("Browser AÇILDI");
		
	}

	public void onFinish(ITestContext context) {
		log.info("Browser KAPATILDI");
		//driver.quit();
	}

}
