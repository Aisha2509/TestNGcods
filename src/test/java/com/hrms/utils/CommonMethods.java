package com.hrms.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import hrms.testbace.BaceClass;
import hrms.testbace.PageInitializer;

public class CommonMethods extends BaceClass {

	/**
	 * Method that sends text to any given element
	 * @param element
	 * @param text
	 */
	
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys("text");
	}
	public static void click(WebElement element) {
		
		element.click();
	}

	
	public static JavascriptExecutor getJSExecutor() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js;
	}
	public static void jsClick(WebElement element) {
		getJSExecutor().executeScript("argument[0].click", element);
	}
	
	public static void scrollUp(int pixel) {
	getJSExecutor().executeScript("window.scrollBy(0,"+pixel+")");
	}
	public static void scrollDown(int pixel) {
		getJSExecutor().executeScript("window.scrollBy(0,"+pixel+")");
	}
	public static WebDriverWait explicitWait() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		return wait;
	}
	
}
