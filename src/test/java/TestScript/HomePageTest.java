package TestScript;

import PageObjects.CheckoutPageObjects;
import PageObjects.HomePageObjects;
import PageObjects.ProductPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeOptions;
import Listeners.TestListener;

import java.time.Duration;
@Listeners(TestListener.class)
public class HomePageTest {
    WebDriver driver;
    HomePageObjects hpo;
    ProductPageObjects ppo;
    CheckoutPageObjects cpo;

    @BeforeSuite
    void initSetup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        TestListener.driver = driver;
    }

    @BeforeTest
    void launchURL(){
        driver.get("https://practicesoftwaretesting.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @BeforeClass
    void initObjects(){
        hpo = new HomePageObjects(driver);
        ppo = new ProductPageObjects(driver);
        cpo = new CheckoutPageObjects(driver);
    }

    @Test(priority = 1)
    void currentURL(){
        String actualURl = driver.getCurrentUrl();
        Assert.assertEquals(actualURl,"https://practicesoftwaretesting.com/","URL is present");
    }

    @Test(priority = 2)
    void logoTest(){
        boolean actualLogo = hpo.isLogoPresent();
        Assert.assertTrue(actualLogo,"Logo is present");
    }

    @Test(priority = 3)
    void searchQuery() throws InterruptedException {
       boolean searchBarFlag = hpo.searchBarPresent();
       Assert.assertTrue(searchBarFlag,"Search Bar is Present");
       hpo.setSearchBar("Combination Pliers");
       Assert.assertTrue(hpo.searchIconPresent(),"Search Icon is Present");
       hpo.clickSearchIcon();
       Assert.assertTrue(hpo.searchProductImage(),"Search Product is Present ");
       hpo.clickSearchProduct();
    }

    @Test(priority = 4)
    void productDetails(){
        Assert.assertTrue(ppo.isProductTitleVisible(),"Product Title is Visible");
        Assert.assertTrue(ppo.isPriceSectionVisible(),"Price Section is Visible");
        Assert.assertTrue(ppo.isProductDescriptionVisible(),"Product Description is Visible");
        Assert.assertTrue(ppo.isProductImageVisible(),"Product Image is Visible");
        Assert.assertTrue(ppo.isAddToCartButtonVisible(),"Add to Cart is Visible");
        ppo.clickAddToCart();
        boolean addToCartIcon = ppo.isAddToCartIconVisible();
        if(addToCartIcon){
            Assert.assertTrue(ppo.isCartCountVisible(),"Cart Count Visible");
            ppo.clickAddToCartIcon();
        }
    }
    @Test(priority = 5)
    void checkOut() throws InterruptedException {
       Assert.assertTrue(cpo.isCartTitlePresent(),"Cart Title is Visible");
       Assert.assertTrue(cpo.isCartQuantityPresent(),"Cart Quantity is Visible");
       Assert.assertTrue(cpo.isCartPricePresent(),"Cart price is Visible");
       Assert.assertTrue(cpo.isTotalCartPrice(),"Total cart price is Visible");
       Assert.assertTrue(cpo.isContinueButtonPresent(),"Continue shopping button is visible");
       boolean clickCheckout = cpo.isProceedToCheckoutButtonPresent();
       if(clickCheckout){
           cpo.clickCheckoutButton();
       }
       Assert.assertTrue(cpo.isContinueAsGuestPresent(),"Continue as Guest Visible");
       cpo.clickContinueAsGuest();
//       Assert.assertTrue(cpo.isEmailAddressPresent(),"Email address field is visible");
       cpo.setEmailAddress("pratikbhosale340@gmail.com");
//       Assert.assertTrue(cpo.isFirstNamePresent(),"First Name field is Visible");
       cpo.setFirstName("Pratik");
//       Assert.assertTrue(cpo.isLastNamePresent(),"Last Name field is visible");
       cpo.setLastName("Bhosale");
//       Assert.assertTrue(cpo.isContinueAsGuestButtonPresent(),"Continue as guest button visible");
       cpo.clickContinueAsGuestButton();
       Assert.assertTrue(cpo.isProceedToCheckoutButton2Present(),"Proceed to Checkout is visible");
       cpo.clickProceedToCheckoutButton2();
       Assert.assertTrue(cpo.isCountryFieldPresent(),"Country field is present");
       cpo.setCountryField("Ireland");
       Assert.assertTrue(cpo.isPostalCodePresent(),"Postal code field is present");
       cpo.setPostalCode("N37 F9H0");
       Assert.assertTrue(cpo.isHouseNumberPresent(),"House Number Field is Present");
       cpo.setHouseNumber("123");
       Assert.assertTrue(cpo.isStreetPresent(),"Street field is present");
       cpo.setStreet("Dublin road");
       Assert.assertTrue(cpo.isStatePresent(),"State field is present");
       cpo.setState("westmeath");
       Thread.sleep(1000);
       Assert.assertTrue(cpo.isProceedToCheckoutButton3Present(),"Checkout button is present");
       cpo.clickProceedToCheckoutButton3();
    }

    @AfterClass
    void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }







}
