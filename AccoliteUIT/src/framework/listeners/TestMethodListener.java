package framework.listeners;


import org.testng.IInvokedMethod;
import org.testng.ITestContext;
import org.testng.ITestResult;



public class TestMethodListener implements org.testng.IInvokedMethodListener2 {
	
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1,
			ITestContext arg2) {
		
		arg1.setAttribute("Browser", arg2.getAttribute("Browser"));
		arg1.setAttribute("TestName", arg2.getCurrentXmlTest().getName().toString());
		arg1.setAttribute("SuiteName", arg2.getSuite().getName());
		arg1.setAttribute("TestContxt",arg2);
	}

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1,
			ITestContext arg2) {
		    arg1.setAttribute("Browser", arg2.getAttribute("Browser"));
		    arg1.setAttribute("TestName", arg2.getCurrentXmlTest().getName().toString());
		    arg1.setAttribute("SuiteName", arg2.getSuite().getName());
		    arg1.setAttribute("TestContxt",arg2);
		}

	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {}

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {}

}