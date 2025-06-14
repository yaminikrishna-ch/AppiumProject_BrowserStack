package org.yaminikrishnachalimadugu.pageObjects.iOS;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.yaminikrishnachalimadugu.utils.iOSActions;

import io.appium.java_client.ios.IOSDriver;

public class AlertViewsPage extends iOSActions {
	IOSDriver driver;
	public AlertViewsPage(IOSDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeStaticText[`name=='Text Entry'`]")
	private WebElement TextEntry;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField")
	private WebElement TextBox;
	
	@iOSXCUITFindBy(iOSClassChain ="**/XCUIElementTypeButton[`name == 'OK'`]")
	private WebElement OkButton;
	
	@iOSXCUITFindBy(iOSNsPredicate ="type == 'XCUIElementTypeStaticText' AND value BEGINSWITH 'Confirm / Cancel'")
	private WebElement ConfirmCancel;
	
	@iOSXCUITFindBy(iOSNsPredicate ="label BEGINSWITH 'A message' ")
	private WebElement textmessage;
	
	@iOSXCUITFindBy(iOSNsPredicate ="type == 'XCUIElementTypeButton' AND label =='Cancel' ")
	private WebElement CancelButton;
	
	public void clickTextEntry() {
		TextEntry.click();
	}
	
	public void setTextEntryValue(String value) {
		TextBox.sendKeys(value);
	}
	
	public void clickOK() {
		OkButton.click();
	}
	
	public void clickConfirmCancel() {
		ConfirmCancel.click();
	}
	
	public String returnConfirmCancelAlertMsg() {
		return textmessage.getText();
	}
	public void clickCancel() {
		CancelButton.click();
	}
	
}
