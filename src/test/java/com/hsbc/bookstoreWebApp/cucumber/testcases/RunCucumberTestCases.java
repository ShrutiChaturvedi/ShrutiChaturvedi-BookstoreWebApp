package com.hsbc.bookstoreWebApp.cucumber.testcases;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	    plugin = { "json:target/html-reports/cucumber.json", "html:target/html-reports/cucumber" },
	    glue = "steps",
	    features = "classpath:features"
	)
public class RunCucumberTestCases {

}
