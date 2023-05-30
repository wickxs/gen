package com.gen.testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.gen.steps"},
        features = {"src/test/resources/features"},
        tags = "@genReg"
)
public class GenTest {
}
