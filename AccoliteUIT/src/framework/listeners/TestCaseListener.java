package framework.listeners;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestCaseListener implements ITestListener{

	

	
	private static String ScreenShotspath; 
	
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		synchronized (this) {
		// TODO Auto-generated method stub
		Logs.log("**************Started TestCase OnStart Method********\n");
	
		Logs.log("**************Done with TestCase OnStart Method********\n");
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		Logs.log("**************Started TestCase onTestFailure Method********\n");
		
		synchronized (this) {
			
			WebDriver browser=(WebDriver) arg0.getAttribute("Browser");
			String TName=arg0.getAttribute("TestName").toString();
			System.out.println(browser);
			String ScreenShotPath=null;
			Logs.log(this.getStackAsString(arg0.getThrowable()));
			try {ScreenShotPath=getScreenShotPath(arg0,browser, TName, "Failed");} catch (Exception e) {e.printStackTrace();}
			try {this.captureScreenShot(arg0,browser,ScreenShotPath);} catch (Exception e) {e.printStackTrace();}}
		
		
		Logs.log("**************Done with TestCase onTestFailure Method********\n");
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		Logs.log("**************Started TestCase onTestSkipped Method********\n");
		Logs.log(ScreenShotspath+arg0.getName()+"_Skipped.png");
		synchronized (this) {
			Logs.log(this.getStackAsString(arg0.getThrowable()));
			WebDriver browser=(WebDriver) arg0.getAttribute("Browser");
			String TName=arg0.getAttribute("TestName").toString();
			System.out.println(browser);
			try {arg0.setAttribute("ScreenShotPath",getScreenShotPath(arg0,browser, TName, "Skipped"));} catch (Exception e1) {e1.printStackTrace();}
			try {this.captureScreenShot(arg0,browser,getScreenShotPath(arg0,browser, TName, "Skipped") );} catch (Exception e) {e.printStackTrace();}
		}
		
		Logs.log("**************Done with TestCase onTestSkipped Method********\n");
	}

	public void onTestStart(ITestResult arg0) {}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		Logs.log("**************Started TestCase onTestSuccess Method********\n");
		
		synchronized (this) {
			
			WebDriver browser=(WebDriver) arg0.getAttribute("Browser");
			String TName=arg0.getAttribute("TestName").toString();
			System.out.println(browser);
			try {arg0.setAttribute("ScreenShotPath",getScreenShotPath(arg0,browser, TName, "Passed"));} catch (Exception e1) {e1.printStackTrace();}
			try {this.captureScreenShot(arg0,browser,getScreenShotPath(arg0,browser, TName, "Passed") );} catch (Exception e) {e.printStackTrace();}
		}
		
		Logs.log("**************Done with TestCase onTestSuccess Method********\n");
	}

	public void captureScreenShot(ITestResult ir,WebDriver browser,String Filepath) throws Exception{
		
		synchronized (this) {
			Logs.log("ScreenShotPath****"+Filepath);
			ir.setAttribute("ScreenShotPath", Filepath);
			File scrFile = ((TakesScreenshot)browser).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Filepath));
			
		}
	}
		
	private String getScreenShotPath(ITestResult ir,WebDriver browser,String TName,String Result) throws Exception{
		ScreenShotspath="";
		try {
			File f=new File("./Screenshots/"+ir.getAttribute("SuiteName").toString());
			if(!f.exists())
			{
				f.mkdirs();
			}
			ScreenShotspath=f.getCanonicalPath()+"\\";
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String browserType="";
		
		ITestContext cntxt=(ITestContext) ir.getAttribute("TestContxt");
		if(cntxt.getAttribute("BrowserType")!=null)
		{
			browserType=cntxt.getAttribute("BrowserType").toString();
			ir.setAttribute("BrowserType",browserType);
		}
		
		ScreenShotspath=ScreenShotspath+TName.replace("\\","_").replace("/", "_")+"_"+browserType+"_"+Result+".png";
		Logs.log("ScreenShot Path******"+ScreenShotspath);
		return ScreenShotspath;
	}
	public String getStackAsString(Throwable th){
		if(th!=null){
		final Writer result = new StringWriter();
	    final PrintWriter printWriter = new PrintWriter(result);
	    th.printStackTrace(printWriter);
	    return result.toString().replace("\"", "");
		}
		return "";
	}
	

}
