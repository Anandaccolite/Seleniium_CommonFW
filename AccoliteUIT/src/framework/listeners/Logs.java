package framework.listeners;

import org.apache.log4j.Logger;
import org.testng.Reporter;

public class Logs extends Reporter{
	private static Logger logger = Logger.getRootLogger();
	public static void log(java.lang.String s){
		logger.info(s);
		Reporter.log(s);
	}
	public static void log(java.lang.String s,boolean logToStandardOut){
		logger.info("\n*******"+s+"*******");
		Reporter.log("\n*******"+s+"*******", logToStandardOut);
	}

}
