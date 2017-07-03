package framework.common;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class CommonUtilties {
	
	public String getProperty(String Key) throws Exception{
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./config.properties").getCanonicalFile()));
		return prop.getProperty(Key.trim()).trim();
	}
	
	public String getEmailProperty(String Key) throws Exception{
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./email.properties").getCanonicalFile()));
		return prop.getProperty(Key.trim()).trim();
	}
	
	public int getRandomNumber(){
		return new Random().nextInt((100000 - 1) + 1) + 1;
	}
	public String getTimeStamp() throws Exception {
		Thread.sleep(1000);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSSMs");
		return sdf.format(new Date());
	}

}
