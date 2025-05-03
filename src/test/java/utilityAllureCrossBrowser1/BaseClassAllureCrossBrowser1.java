package utilityAllureCrossBrowser1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClassAllureCrossBrowser1 {
	
	public static Properties allureCrossBrowser1_prop;
	public static WebDriverWait wait;
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	
	public BaseClassAllureCrossBrowser1 () {
			
		try {
					
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/allureCrossBrowser1.config/AllureCrossBrowser1.properties");
			
			allureCrossBrowser1_prop = new Properties();
			allureCrossBrowser1_prop.load(file);
			
		} catch (FileNotFoundException e) {
		    System.err.println("Properties file not found: " + e.getMessage());
		}
		  catch (IOException e) {
		    System.err.println("Error loading properties file: " + e.getMessage());
		}
		
		}
	
	
	public void allureCrossBrowser1_initializeDriver(String browser) {
		
	//	String browser = System.getProperty("browser", allureCrossBrowser1_prop.getProperty("browser"));  
	
				
		 if (driver.get() == null) {
			 
		 
	            switch (browser.toLowerCase()) {
	            
	                case "chrome":
	                	System.out.println("Initializing Chrome browser...");
	                    driver.set(new ChromeDriver());
	                    break;
	               
	                case "edge":
	                	System.out.println("Initializing Edge browser...");
	                    driver.set(new EdgeDriver());
	                    break;
	                    
	                default:
	                    throw new RuntimeException("Invalid browser: " + browser);
	            }
				
		
	
				wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10)); // Initialize WebDriverWait here
				getDriver().manage().window().maximize();
				getDriver().manage().deleteAllCookies();
	
			}
		}
	
		//Getter method to retrieve WebDriver instance
		public static WebDriver getDriver() {
			if (driver.get() == null) {
			throw new IllegalStateException("Driver is not initialized properly.");
		}
		
		return driver.get();
	}
		
		public void allureCrossBrowser1_launchURL() {
			
			getDriver().get(allureCrossBrowser1_prop.getProperty("base.url"));
		}
	
		 public void quitDriver() {
		        if (driver.get() != null) {
		            driver.get().quit();
		            driver.remove();// remove from ThreadLocal to avoid memory leaks
					System.out.println("Test completed successfully and browser closed.");
		        }else {
			        System.out.println("No active driver found to quit.");
			    }
		    }
		}