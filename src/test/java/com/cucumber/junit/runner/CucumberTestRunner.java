package com.cucumber.junit.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        plugin = {"pretty"},
        monochrome = true,
        tags = "@smoke",
        glue = "com.cucumber.junit",
        features = "classpath:features"
)
public class CucumberTestRunner {
}
