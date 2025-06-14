package org.yaminikrishnachalimadugu.pageObjects.iOS;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.yaminikrishnachalimadugu.utils.iOSActions;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.ios.IOSDriver;

public class UIKitCatalogPage extends iOSActions {
	IOSDriver driver;
	public UIKitCatalogPage(IOSDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@iOSXCUITFindBy(accessibility="Alert Views")
	private WebElement AlertViewButton;
	
	@iOSXCUITFindBy(accessibility="Web View")
	private WebElement WebView;
	
	@iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeStaticText[`value == 'Picker View'`]")
	private WebElement PickerView;
	
	@iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeStaticText[`value == 'Steppers'`]")
	private WebElement Steppers;
	
	public void clickAlertViews() {
		AlertViewButton.click();
	}
	public void clickSteppers() {
		Steppers.click();
	}
	public void clickPickerView() {
		PickerView.click();
	}
	public void clickWebView() {
		WebView.click();
	}
	
}
