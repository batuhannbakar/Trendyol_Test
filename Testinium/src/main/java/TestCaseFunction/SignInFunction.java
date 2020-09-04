package TestCaseFunction;



import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.BasePage;

public class SignInFunction extends BasePage{

	public SignInFunction(WebDriver driver) {
		super(driver);
	
}
	public By gender = By.xpath("//img[@src='/frontend/web/assets/images/erkek.png']");
	public By login = By.xpath("//div[@class='login-container']");
	public By email = By.id("email");
	public By password = By.id("password");
	public By loginClick = By.id("loginSubmit");
	public By searchText = By.xpath("//input[@class='search-box']");
	public By searchClick = By.className("search-icon");

    JavascriptExecutor scroll = (JavascriptExecutor) driver;
	int offset = 0;
    
	public By AddBucket = By.xpath("//div[@class='add-to-bs-tx']");

	public By ClickBucket = By.xpath("//li[@id='myBasketListItem']");

	public String strResult =null;
	public String str = null;

	public String actualTitle = null;
	public String actualLink = null;

	public String mainAssert = "En Trend Ürünler Türkiye'nin Online Alýþveriþ Sitesi Trendyol'da"; 
	public String loginAssert = "trendyol.com/butik/liste";

	
	public By counterButton = By.xpath("//button[@class='ty-numeric-counter-button']");
	public By deleteButton  = By.xpath("//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/button");
	public By deleteApproveButton  = By.xpath("//*[@id=\"ngdialog1\"]/div[2]/form/div/div[2]/div/div[1]/button[2]");

	
	public void SignInForm() {
	

		actualTitle= driver.getTitle();
		Assert.assertTrue(actualTitle.equals(mainAssert));
		driver.manage().window().maximize(); 
		thread(1500);
		element(gender).click();
		thread(1500);
		element(login).click();
		thread(1500);
		sendKeys(email,"batuhanbakar3596@gmail.com");
		thread(1500);
		sendKeys(password,"kjkszpj9");
		thread(1500);
		element(loginClick).click();
		thread(1500);
		actualTitle= driver.getCurrentUrl();
		Assert.assertTrue(actualTitle.contains(loginAssert));
		sendKeys(searchText,"bilgisayar");
		thread(1500);
		element(searchClick).click();
		thread(1500);


		
		  List<WebElement> links = driver.findElements(By.cssSelector("div.p-card-wrppr"));

          links.subList(0, 10).clear();

          Random rand = new Random();
          int randIndex = rand.nextInt(links.size());

          offset = 0;
          while(true) {
              try {
                  scroll.executeScript("window.scrollTo(0, " + offset + ")");
                  thread(2000);
                  links.get(randIndex).click();
                  break;
              } catch (ElementClickInterceptedException e) {
                  offset += 500;
              }
          }

          
          
  		thread(1500);
  		
  		element(AddBucket).click();
  		
  		
  		
  		List<WebElement> ProductPrices1 = driver.findElements(By.className("prc-slg"));
  		String text1Price = ProductPrices1.get(0).getText();
  		
  		thread(1500);
  		element(ClickBucket).click();
  		thread(1500);
  
  		
  		List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class, 'pb-basket-item-price')]"));
  		for (WebElement element : elements) {
  		    str = element.getText();

  		    int cntTL = (str.length() - str.replace("TL", "").length()) / 2;
  		    if (2 == cntTL) {
  		        str = str.split("TL")[1] + "TL";
  		    }
  		  
  		}
  		
  		System.out.println("first value : "+text1Price+"Bucket Value : "+str);
		Assert.assertEquals(str, text1Price);

  		thread(1500);

		element(counterButton).click();
  		thread(1500);
  		element(deleteButton).click();
  		thread(1500);
  		element(deleteApproveButton).click();

		 
		 
		}
		
	
	}