package org.yaminikrishnachalimadugu.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.yaminikrishnachalimadugu.utils.AndroidActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalog extends AndroidActions {
	AppiumDriver driver;
	
	public ProductCatalog(AppiumDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	private List <WebElement> productByIndex;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartbutton;
	
	public void addItemToCartByIndex(int index) {
		productByIndex.get(index).click();
	}
	
	public CartPage goToCart() {
		waitForElementtoAppear(cartbutton, driver).click();
		return new CartPage(driver);
	}

}
