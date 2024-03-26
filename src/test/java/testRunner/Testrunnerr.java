package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\Jatinder\\eclipse-workspace\\Amazonbddframework\\src\\test\\java\\featurefile", glue= {"stepdef"},
plugin= {"pretty","html:target/Htmlreports.html"},monochrome=true)
public class Testrunnerr {	
}
