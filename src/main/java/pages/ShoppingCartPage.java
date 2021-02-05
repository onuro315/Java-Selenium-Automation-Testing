package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import application.Driver;
import constant.IConstant;

public class ShoppingCartPage {
	
	WebDriver driver = Driver.getInstance().getDriver();
	
	By getCartPrice = By.xpath("//*[@id=\"submit-cart\"]/div/div/div[3]/div/div[1]/div/div[5]/div[1]/div/ul/li[1]/div[2]");
	By plusOne = By.className("gg-icon-plus");
	By deleteProduct = By.className("btn-delete");
	By getAmount = By.className("amount");
	
	public void openShoppingCartPage() {
		sleep();
		driver.get(IConstant.SHOPPING_CART_PAGE_URL);
		
	}
	
	public String getShoppingCartPrice() {
		
		openShoppingCartPage();		
		return driver.findElement(getCartPrice).getText();		
	}
	
	public String addOneMoreProductAndGetAmount() {
		
		driver.findElement(plusOne).click();
		return driver.findElement(getAmount).getAttribute("value");
	}
	
	public void deleteCartProduct() {
		sleep();
		driver.findElements(By.className("btn-delete")).get(0).click();
	}
	
	private void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
