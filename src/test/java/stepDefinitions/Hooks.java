package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        BaseClass.openBrowser();
    }

    @After
    public void tearDown() {
        BaseClass.closeBrowser();
    }
}