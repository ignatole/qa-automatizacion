package com.enviopack.factory;

import com.enviopack.driver.DriverManagerChrome;
import com.enviopack.driver.DriverManagerEdge;
import com.enviopack.driver.DriverManagerFirefox;
import com.enviopack.driver.DriverManagerSafari;
import com.enviopack.driver.IDriverManager;
import com.enviopack.enums.Browser;

public class DriverManagerFactory {

	public static IDriverManager getManager(Browser browser) {

		switch (browser) {
		
		case CHROME : {
			return new DriverManagerChrome();
		}
		case FIREFOX : {
			return new DriverManagerFirefox();
		}
		case EDGE : {
			return new DriverManagerEdge();
		}
		case SAFARI : {
			return new DriverManagerSafari();
		}
		default : throw new IllegalArgumentException("Invalid Driver: " + browser);	
		}
	}

}