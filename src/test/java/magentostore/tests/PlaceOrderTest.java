package magentostore.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import magentostore.TestComponents.BaseTest;
import magentostore.pageobjects.CheckOutPage;
import magentostore.pageobjects.ConfirmationPage;
import magentostore.pageobjects.GearPage;
import magentostore.pageobjects.MensPage;
import magentostore.pageobjects.MyOrdersPage;
import magentostore.pageobjects.PaymentPage;
import magentostore.pageobjects.SignInPage;
import magentostore.pageobjects.WhatsnewPage;

public class PlaceOrderTest extends BaseTest{
	//WhatsnewPage whatsnewPage = new WhatsnewPage(driver);
	String productsize = "L";
	String parentpage;
	
	@Test
	public void placeorder() throws IOException, InterruptedException
	{
		SignInPage signinPage = landingPage.gotosigninPage();
		signinPage.loginToAccount("manisha.shah@gmail.com", "Anisha@123");
		WhatsnewPage whatsnewPage = new WhatsnewPage(driver);
		whatsnewPage.selectNewProductandAddtoCart("L");
		parentpage = whatsnewPage.newTab();
		GearPage gearPage = new GearPage(driver);
		gearPage.gotogearandwatches();
		gearPage.filterPrice();
		gearPage.filterMaterial();
		getScreenshot("FilterVerification", driver);
		gearPage.selectProductafterFilterandaddToCart();
		gearPage.closecurrenttab(parentpage);
		MensPage mensPage = whatsnewPage.navigateToMenBottomsPants();
		mensPage.sortByPriceAscending();
		mensPage.addFirstItemtoCart();
		mensPage.navigateToCart();
		mensPage.updateMensItemsQuantity();
		String totalamount = mensPage.getTotalCartValue();
		Assert.assertEquals(totalamount,"$220.00");
		CheckOutPage checkOutPage = mensPage.clickProceedtoCheckout();
		checkOutPage.clickOnNextButton();
		PaymentPage paymentPage = new PaymentPage(driver);
		String subtotal = paymentPage.validateSubTotal();
		Assert.assertEquals(subtotal,"$220.00");
		ConfirmationPage confirmationPage = paymentPage.clickonplaceorder();
		String purchasemessage = confirmationPage.confirmationMessage();
		Assert.assertEquals(purchasemessage, "Thank you for your purchase!");
		Boolean match = confirmationPage.confirmorder();
		Assert.assertTrue(match);
		String orderNumber = confirmationPage.getOrderNumber();
		MyOrdersPage myOrdersPage = new MyOrdersPage(driver);
		String orderId = myOrdersPage.getOrderId();
		if(orderId.contains(orderNumber))
		{
			Assert.assertTrue(true);
		}
		
	}
	

}
