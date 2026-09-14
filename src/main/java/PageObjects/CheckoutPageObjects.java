package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPageObjects {

    WebDriver driver;

    @FindBy(xpath = "//span[@class='product-title']")
    private WebElement cartTitle;

    @FindBy(xpath = "//td[@class='col-md-2 align-middle']")
    private WebElement cartQuantity;

    @FindBy(xpath = "//span[@data-test='product-price']")
    private WebElement cartPrice;

    @FindBy(xpath = "//span[@data-test='line-price']")
    private WebElement TotalCartPrice;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    private WebElement continueButton;

    @FindBy(xpath = "//button[text()='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//a[text()='Continue as Guest']")
    private WebElement continueasguest;

    @FindBy(xpath = "//input[@id='guest-email']")
    private WebElement emailAddress;

    @FindBy(xpath = "//input[@id='guest-first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='guest-last-name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@class='btnSubmit' and @value='Continue as Guest']")
    private WebElement continueAsGuestButton;

    @FindBy(xpath = "//button[@data-test='proceed-2-guest']")
    private WebElement proceedToCheckoutButton2;

    @FindBy(xpath = "//select[@id='country']")
    private WebElement country;

    @FindBy(xpath = "//input[@id='postal_code']")
    private WebElement postalCode;

    @FindBy(xpath = "//input[@id='house_number']")
    private WebElement houseNumber;

    @FindBy(xpath = "//input[@id='street']")
    private WebElement street;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement city;

    @FindBy(xpath = "//input[@id='state']")
    private WebElement state;

    @FindBy(xpath = "//button[@data-test='proceed-3']")
    private WebElement proceedToCheckoutButton3;

    public CheckoutPageObjects(WebDriver driver) {  // we create a constructor to intialize the object by passing webdriver driver variable to create object.
        this.driver = driver; // so after creation of constructor and by passing the arguments webdriver driver you have to assign this driver value to globle webdriver driver.By using "this" keyword we will put the local variable driver value to globle variable driver.
        PageFactory.initElements(driver, this);
    }

    public boolean isCartTitlePresent() {
        return cartTitle.isDisplayed();
    }

    public boolean isCartQuantityPresent() {
        return cartQuantity.isDisplayed();
    }

    public boolean isCartPricePresent() {
        return cartPrice.isDisplayed();
    }

    public boolean isTotalCartPrice() {
        return TotalCartPrice.isDisplayed();
    }

    public boolean isContinueButtonPresent() {
        return continueButton.isDisplayed();
    }

    public boolean isProceedToCheckoutButtonPresent() {
        return proceedToCheckoutButton.isDisplayed();
    }

    public void clickCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    public boolean isContinueAsGuestPresent() {
        return continueasguest.isDisplayed();
    }

    public void clickContinueAsGuest() {
        continueasguest.click();
    }

    public boolean isEmailAddressPresent() {
        return emailAddress.isDisplayed();
    }

    public void setEmailAddress(String input) {
        emailAddress.sendKeys(input);
    }

    public boolean isFirstNamePresent() {
        return firstName.isDisplayed();
    }

    public void setFirstName(String input) {
        firstName.sendKeys(input);
    }

    public boolean isLastNamePresent() {
        return lastName.isDisplayed();
    }

    public void setLastName(String input) {
        lastName.sendKeys(input);
    }

    public boolean isContinueAsGuestButtonPresent() {
        return continueAsGuestButton.isDisplayed();
    }

    public void clickContinueAsGuestButton() {
        continueAsGuestButton.click();
    }

    public boolean isProceedToCheckoutButton2Present(){
        return proceedToCheckoutButton2.isDisplayed();
    }

    public void clickProceedToCheckoutButton2(){
        proceedToCheckoutButton2.click();
    }

    public boolean isCountryFieldPresent(){
        return country.isDisplayed();
    }
    public void setCountryField(String input){
        Select select = new Select(country);
        select.selectByVisibleText(input);
    }

    public boolean isPostalCodePresent(){
        return postalCode.isDisplayed();
    }

    public void setPostalCode(String input) {
        postalCode.sendKeys(input);
    }

    public boolean isHouseNumberPresent(){
        return houseNumber.isDisplayed();
    }

    public void setHouseNumber(String input) {
        houseNumber.sendKeys(input);
    }

    public boolean isStreetPresent(){
        return street.isDisplayed();
    }

    public void setStreet(String input) {
        street.sendKeys(input);
    }

    public boolean isStatePresent(){
        return state.isDisplayed();
    }

    public void setState(String input) {
        state.sendKeys(input);
    }

    public boolean isProceedToCheckoutButton3Present(){
        return state.isDisplayed();
    }

    public void clickProceedToCheckoutButton3() {
        proceedToCheckoutButton3.click();
    }


}