package framework.common;


import framework.common.BrowserUtilities;
import framework.common.CommonUtilties;
import framework.common.RestUtilities;

public interface BaseTest {
	public  CommonUtilties common_utilities=new CommonUtilties();
	public  BrowserUtilities browser_utilities=new BrowserUtilities();
	public  RestUtilities rest_utilities=new RestUtilities();
   
}

