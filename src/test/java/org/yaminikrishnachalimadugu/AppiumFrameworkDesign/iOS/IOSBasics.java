package org.yaminikrishnachalimadugu.AppiumFrameworkDesign.iOS;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.yaminikrishnachalimadugu.AppiumFrameworkDesign.TestUtils.iOSBaseTest;
import org.yaminikrishnachalimadugu.pageObjects.iOS.AlertViewsPage;
import org.yaminikrishnachalimadugu.pageObjects.iOS.UIKitCatalogPage;

public class IOSBasics extends iOSBaseTest {
	@Test
	public void IOSBasicsTestClassChain() throws InterruptedException {
		UIKitCatalogPage uikitcatalog = new UIKitCatalogPage(driver);
		uikitcatalog.clickAlertViews();
		AlertViewsPage alertviews = new AlertViewsPage(driver);
		alertviews.clickTextEntry();
		alertviews.setTextEntryValue("Yamini");
		alertviews.clickOK();
	}
	
	@Test
	public void IOSBasicsTestPredicateString() {
		UIKitCatalogPage uikitcatalog = new UIKitCatalogPage(driver);
		uikitcatalog.clickAlertViews();
		AlertViewsPage alertview= new AlertViewsPage(driver);
		alertview.clickConfirmCancel();
		AssertJUnit.assertEquals(alertview.returnConfirmCancelAlertMsg(),"A message should be a short, complete sentence.");
		alertview.clickCancel();
	}

}
