package testRunnerAllureCrossBrowser1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilityAllureCrossBrowser1.BaseClassAllureCrossBrowser1;


@CucumberOptions(
        features = "src/test/resource/featureFolderAllureCrossBrowser1",
        plugin = {"pretty", "json:target/cucumber.json"},
        glue = "stepDefinationAllureCrossBrowser1",
        monochrome = true,
        publish = true
)

public class TestRunnerAllureCrossBrowser1 extends AbstractTestNGCucumberTests {
	
	BaseClassAllureCrossBrowser1 test = new BaseClassAllureCrossBrowser1();
	
	@BeforeTest
	@Parameters({"browser"})
	public void setup(String browser) {
		
	//	BaseClassAllureCrossBrowser1 test = new BaseClassAllureCrossBrowser1();
				
		test.allureCrossBrowser1_initializeDriver(browser);	
		
	}
	
	@AfterTest
	public void tearDown() {
		
	//	BaseClassAllureCrossBrowser1 test = new BaseClassAllureCrossBrowser1();
		
		test.quitDriver();
		
		
	}
}
