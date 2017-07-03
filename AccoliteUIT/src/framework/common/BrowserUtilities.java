package framework.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;

import framework.listeners.Logs;
import framework.listeners.WebEventListener;
import net.sf.antcontrib.design.Log;

public class BrowserUtilities extends CommonUtilties {

	private EventFiringWebDriver e_driver;
	private WebEventListener eventListener;
	private WebDriverWait wait;
	public WebDriver launchBrowser(ITestContext obj) throws Exception{
		String browserType=null;
		WebDriver driver=null;
		try{
		  if(System.getProperty("browser")!=null)
			  browserType=System.getProperty("browser").trim();
		  else if(obj.getCurrentXmlTest().getParameter("browser")!=null)
			  browserType=obj.getCurrentXmlTest().getParameter("browser").toString();
		  else if(obj.getCurrentXmlTest().getSuite().getParameter("browser")!=null)
			  browserType=obj.getCurrentXmlTest().getSuite().getParameter("browser");
		  else
			  browserType=this.getBrowser();
		}catch(Exception e)
		{
			e.printStackTrace();
			browserType="firefox";
			Logs.log("Launching the Brwoser with  Firefox driver as a default in case of Exception");
		}
		
		
		Logs.log("Launching the Brwoser with "+browserType);
		switch (browserType) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", ".\\lib\\GeckoDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", ".\\lib\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", ".\\lib\\IEDriverServer\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		e_driver.manage().window().maximize();
		
		obj.setAttribute("BrowserType",browserType);
		obj.setAttribute("Browser", driver);
		return e_driver;
	}
	
	
	
	public WebDriver launchBrowser(String browserType,String Profile) throws Exception{
		;
		WebDriver driver=null;
		try{
		  if(System.getProperty("browser")!=null)
			  browserType=System.getProperty("browser").trim();
		  else
			  browserType=this.getBrowser();
		}catch(Exception e)
		{
			e.printStackTrace();
			browserType="firefox";
			Logs.log("Launching the Brwoser with  Firefox driver as a default in case of Exception");
		}
		
		
		
		switch (browserType) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", ".\\lib\\GeckoDriver\\geckodriver.exe");
			if(Profile!=null&Profile.length()>0){
			FirefoxProfile profile = new ProfilesIni().getProfile(Profile);
			driver = new FirefoxDriver(profile);
			}else{
				driver=new FirefoxDriver();
			}
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", ".\\lib\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", ".\\lib\\IEDriverServer\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		e_driver.manage().window().maximize();
		return e_driver;
	}
	
	
	

	private String getBrowser() throws Exception {
		// TODO Auto-generated method stub
		return getProperty("Browser");
	}
}
