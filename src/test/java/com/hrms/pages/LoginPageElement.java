package com.hrms.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hrms.testbace.BaceClass;
public class LoginPageElement extends BaceClass{
	@FindBy(id = "txtUsername")
	public WebElement userNametextBox;
	
	@FindBy(xpath = "//input[@id = 'txtPassword']")
	public WebElement passwordTextBox;
	
	@FindBy(css = "input#btnLogin")
    public WebElement btnLogin;
	
	@FindBy(id = "divLogo")
	public WebElement syntaxLogo;
	
	@FindBy(id = "spanMessage")
	public WebElement spanMessage;
	
	@FindBy(id = "logInPanelHeading")
	public WebElement loginPanelHeading;

	public WebElement usernameField;

	public Object loginButton;

	public Object errorMessage;

	public WebElement passwordField;
	public LoginPageElement() {
		PageFactory.initElements(BaceClass.driver, this);
	}
}