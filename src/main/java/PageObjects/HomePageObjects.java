package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePageObjects {

    WebDriver driver; // we create a globle variable so it is access able within the class.

    @FindBy(xpath = "//a[@class='navbar-brand']") // The "FindBy" method is use to find the locators by xpath,id,name etc
    private WebElement logo;// And we have make the logo variable private because know can change the locator expect the current class.

    @FindBy(xpath = "//input[@id='search-query']")
    private WebElement searchBar;

    @FindBy(xpath="//button[@class='btn btn-secondary']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@class='card']")
    private WebElement searchProduct;

    public HomePageObjects(WebDriver driver){  // we create a constructor to intialize the object by passing webdriver driver variable to create object.
        this.driver = driver; // so after creation of constructor and by passing the arguments webdriver driver you have to assign this driver value to globle webdriver driver.By using "this" keyword we will put the local variable driver value to globle variable driver.
        PageFactory.initElements(driver,this);
    }

    public boolean isLogoPresent(){
        boolean logoVisible = logo.isDisplayed();
        return  logoVisible;
    }

    public boolean searchBarPresent(){
        boolean searchBarFlag = searchBar.isDisplayed();
        return searchBarFlag;
    }

    public void setSearchBar(String input){
        searchBar.sendKeys(input);
    }

    public boolean searchIconPresent(){
        boolean searchflag = searchButton.isDisplayed();
        return searchflag;
    }

    public void clickSearchIcon(){
        searchButton.click();
    }

    public boolean searchProductImage(){
        boolean searchproductFlag = searchProduct.isDisplayed();
        return searchproductFlag;
    }

    public void clickSearchProduct(){
        searchProduct.click();
    }

}
