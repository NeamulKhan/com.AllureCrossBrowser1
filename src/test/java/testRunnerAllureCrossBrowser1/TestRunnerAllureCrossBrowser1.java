package testRunnerAllureCrossBrowser1;


import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilityAllureCrossBrowser1.BaseClassAllureCrossBrowser1;


@CucumberOptions(
        features = "src/test/resources/featureFolderAllureCrossBrowser1",
        plugin = {"pretty", "json:target/cucumber.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        glue = "stepDefinationAllureCrossBrowser1",
        monochrome = true,
        publish = true
)

public class TestRunnerAllureCrossBrowser1 extends AbstractTestNGCucumberTests {
	
	BaseClassAllureCrossBrowser1 test = new BaseClassAllureCrossBrowser1();
	
	
	//Cross-browser setup using parameterized @BeforeTest – ✔️ Makes the test portable across Chrome and Edge.
	//Driver initialization in @BeforeTest (TestNG) :❌ @BeforeTest runs once per test class, not per scenario/thread.
	
	//Use Cucumber @Before hook in a Hooks.java file for per-scenario setup.
	
	@BeforeTest
	@Parameters({"browser"})
	
	public void setup(String browser) {
					
		test.allureCrossBrowser1_initializeDriver(browser);	
		
	}
	
	@AfterTest
	public void tearDown() {
				
		test.quitDriver();
		
		
	}
}
