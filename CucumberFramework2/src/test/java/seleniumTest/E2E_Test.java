package seleniumTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class E2E_Test {
	private static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	// ***** Precondition  ******
		init();
		OpenUrl();
		NavigateLogin();
		UserLogin();
	// ****  Process  *****  
		NavigateToApparelAndShoes();
		NavigateBlueJeans();
		OrderBlueJeans();
		NavigatetShoppingCart();
		ShoppingCartProcedure();
		ShoppingCartCheckout();
		getBillingAddress();
		getShippingAddress();
		getShippingMethod();
		getPaymentMethod();
		getPaymentInfo();
		getConfermation();
		VerificationOfSuccess();
		LogOut();
		 CloseApplication();
	}
		
//Post condition
		
	
	public static void init() {
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public static void OpenUrl() {
		 
		 driver.get("http://demowebshop.tricentis.com/");
	}
	
	public static void NavigateLogin() {
		
 	 WebElement login = driver.findElement(By.xpath("//a[@class='ico-login']"));
	 login.click(); 
	}
	
	public static void UserLogin() { 	 
	 WebElement email = driver.findElement(By.xpath("//input [@class='email']"));
	 email.sendKeys("rana.pal@gmail.com");
	 WebElement password = driver.findElement(By.xpath("//input [@class='password']"));
	 password.sendKeys("rana123");
	 WebElement loginBtn = driver.findElement(By.xpath("//input [@class='button-1 login-button']"));
	 loginBtn.click();
	}
	
	public static void NavigateToApparelAndShoes(){ 
	 WebElement aprl = driver.findElement(By.xpath("//a[@href='/apparel-shoes']"));
	 aprl.click();     
	}
	
	public static void NavigateBlueJeans() throws InterruptedException{  
//		WebElement bluejean = driver.findElement(By.xpath("//a [contains(text(),'Blue Jeans')]"));
		WebElement bluejean = driver.findElement(By.xpath("//a [contains(text(),'Blue Jeans')]/parent::h2[@class='product-title']"));
 
		Thread.sleep(3000);
		bluejean.click();
		
	}
	
	public static void OrderBlueJeans(){  
		 WebElement ItemQty=driver.findElement(By.xpath("//input [@class='qty-input']"));
		 ItemQty.clear();
		 ItemQty.sendKeys("25");	 
		 WebElement AddtoCart =  driver.findElement(By.xpath("//input  [@class='button-1 add-to-cart-button']"));
		 AddtoCart.click();		 
		}
	
	public static void NavigatetShoppingCart() {	
		WebElement ShoppingCart = driver.findElement(By.xpath("//span [@class='cart-label' and contains(text(),'Shopping cart')]"));
		ShoppingCart.click(); 
		//GetElements();
	}
	public static void ShoppingCartProcedure() {
		WebElement TermsofService=driver.findElement(By.xpath("//input [@name='termsofservice']"));
		TermsofService.click();
	}
	public static void ShoppingCartCheckout() {
		WebElement Checkout=driver.findElement(By.xpath("//button[@id='checkout']"));
		Checkout.click();
	}
	
	
//==== Checkout Process
	public static void getBillingAddress() {
		WebElement billAdContinue=driver.findElement(By.xpath("//input[@onclick='Billing.save()']"));
		billAdContinue.click();
		
	}
	public static void getShippingAddress() {
		WebElement ShippingAdContinue=driver.findElement(By.xpath("//input[@onclick='Shipping.save()']"));
		ShippingAdContinue.click();
		
	}
	public static void getShippingMethod() throws InterruptedException {
//		WebElement GroundShipping=driver.findElement(By.xpath("//input[@value='Ground___Shipping.FixedRate']"));
//		GroundShipping.click();
//		Thread.sleep(7000);
		System.out.println("Here One ");
		WebElement ShippingContinue=driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']"));	
		ShippingContinue.click();
	}
	public static void getPaymentMethod() throws InterruptedException {
		WebElement CashOnDelivery=driver.findElement(By.xpath("//label [contains(text(),'Ground')]"));
		CashOnDelivery.click();
//		Thread.sleep(2000);
		System.out.println("Here Two");
		WebElement PaymentContinue=driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']"));
		PaymentContinue.click();
	}
	public static void getPaymentInfo() {
		WebElement PaymentInfoContinue=driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']"));	
		PaymentInfoContinue.click();
	}
	
	public static void getConfermation() {
		WebElement PaymentConfContinue=driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']"));	
		PaymentConfContinue.click();
	}
	
	public static void VerificationOfSuccess() {
		WebElement VerificationContinue=driver.findElement(By.xpath("//input [@class='button-2 order-completed-continue-button']"));	
		VerificationContinue.click();
	}
	
	// Post Condition
	public static void LogOut() {
		WebElement Logout=driver.findElement(By.xpath("//a [@class='ico-logout']"));	
		Logout.click();
	}
	
	public static void CloseApplication() {
		System.out.println("Clossing Application");
		driver.close();
		driver.quit();
	}
	
	public static int GetElements() {
		int NoOfElements=0;
		
		List<WebElement> el = driver.findElements(By.xpath("//*"));
         NoOfElements=0;
        for ( WebElement e : el ) {
         System.out.println( e.getTagName()+"    "+e.getText());

         NoOfElements++;

        }
      System.out.println(NoOfElements);
		
		return NoOfElements;
	}
	
	
}

 

