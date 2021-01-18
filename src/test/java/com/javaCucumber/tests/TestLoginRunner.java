package com.javaCucumber.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
        features = {"src/test/resources/feature/Login.feature"},
        glue = {"com/javaCucumber/stepDefinitions/",
                "com.javaCucumber.hooks"}

)
public class TestLoginRunner extends AbstractTestNGCucumberTests {

}