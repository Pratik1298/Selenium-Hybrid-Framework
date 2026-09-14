package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPageObjects {

    WebDriver driver;

    @FindBy (xpath = "//h1[@data-test='product-name']")
    private WebElement productTitle;

    @FindBy(xpath = "//div[@class='price-section']")
    private WebElement priceSection;

    @FindBy(xpath ="//p[@id='description']")
    private WebElement productDescription;

    @FindBy(xpath = ("//img[@class='figure-img img-fluid']"))
    private WebElement productImage;

    @FindBy(xpath = "//button[@id='btn-add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='nav-link' and @aria-label='cart']")
    private WebElement addToCartIcon;

    @FindBy(xpath = "//span[@id='lblCartCount']")
    private WebElement cartCount;

    public ProductPageObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isProductTitleVisible(){
        boolean productTitleVisible = productTitle.isDisplayed();
        return productTitleVisible;
    }

    public boolean isPriceSectionVisible(){
        boolean priceSectionVisible = priceSection.isDisplayed();
        return priceSectionVisible;
    }

    public boolean isProductDescriptionVisible(){
        boolean productDescriptionVisible = productDescription.isDisplayed();
        return productDescriptionVisible;
    }

    public boolean isProductImageVisible(){
        boolean productImageVisible = productImage.isDisplayed();
        return productImageVisible;
    }

    public boolean isAddToCartButtonVisible(){
        boolean addToCartVisible = addToCartButton.isDisplayed();
        return addToCartVisible;
    }

    public void clickAddToCart(){
        addToCartButton.click();
    }

    public boolean isAddToCartIconVisible(){
        boolean addToCartIconVisible = addToCartIcon.isDisplayed();
        return addToCartIconVisible;
    }

    public boolean isCartCountVisible(){
        boolean cartCountVisible = cartCount.isDisplayed();
        return cartCountVisible;
    }

    public void clickAddToCartIcon(){
        addToCartIcon.click();
    }




}
