package com.hrms.testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElement;
import com.hrms.pages.LoginPageElement;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constains;

public class LoginTest extends CommonMethods{
	@Test(groups = "smoke")
	public void validLogin() {

	LoginPageElement login = new LoginPageElement();
	sendText(login.userNametextBox, ConfigsReader.getPropValue("username"));
	sendText(login.passwordTextBox, ConfigsReader.getPropValue("password"));
	click(login.btnLogin);
	
	DashboardPageElement dashboard = new DashboardPageElement();
	Assert.assertTrue(dashboard.welcomeMessage.isDisplayed());
	}
	@Test(dataProvider = "getData",enabled=false)
	public void negativeLogin(String username, String password, String cases) {
		LoginPageElement loginPage = new LoginPageElement();
		sendText(loginPage.userNametextBox, username);
		sendText(loginPage.passwordTextBox, password);
		//click(loginPage.loginButton);
		switch (cases) {
		case "case1":
			Assert.assertEquals(((WebElement) loginPage.errorMessage).getText(), Constains.ERROR_MESSAGE_BLANK_USERNAME);
			break;
		case "case2":
			Assert.assertEquals(((WebElement) loginPage.errorMessage).getText(), Constains.ERROR_MESSAGE_BLANK_PASSWORD);
			break;
		case "case3":
			Assert.assertEquals(((WebElement) loginPage.errorMessage).getText(), Constains.ERROR_MESSAGE_INVALID_PASSWORD);
			break;
		}
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] data = { { "", "Hum@nhrm123", "case1" }, { "Admin", "", "case2" }, { "Admin", "Admin14", "case3" } };
		return data;
	}
}
