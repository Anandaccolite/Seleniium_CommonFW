package framework.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebEventListener implements WebDriverEventListener {
	
	public void beforeNavigateTo(String url, WebDriver driver) {
		Logs.log("Before navigating to: '" + url + "'");
	}
	
	public void afterNavigateTo(String url, WebDriver driver) {
		Logs.log("Navigated to:'" + url + "'");
	}
	
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		Logs.log("Value of the:" + element.toString()+ " before any changes made");
	}
	
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		Logs.log("Element value changed to: " + element.toString());
	}
	
	public void beforeClickOn(WebElement element, WebDriver driver) {
		Logs.log("Trying to click on: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		Logs.log("Clicked on: " + element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {
		Logs.log("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		Logs.log("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		Logs.log("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		Logs.log("Navigated forward to next page");
	}

	public void onException(Throwable error, WebDriver driver) {
		Logs.log("Exception occured: " + error);
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		Logs.log("Trying to find Element By : " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		Logs.log("Found Element By : " + by.toString());
	}

	/*
	 * non overridden methods of WebListener class
	 */
	public void beforeScript(String script, WebDriver driver) {
	}

	public void afterScript(String script, WebDriver driver) {
	}

	@Override
	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}


}
