package com.pirani.automation.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\features\\unit_test.feature",
        glue = "com.pirani.automation.stepdefinition",
        snippets = SnippetType.CAMELCASE)
public class UnitTestRunner {
}
