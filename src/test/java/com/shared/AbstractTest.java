package com.shared;

import com.codeborne.selenide.Configuration;
import com.config.GlobalConfiguration;
import com.util.BrickseekUtils;
import com.util.DriverUtils;
import com.util.WebFieldConsts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestContext;
import org.testng.annotations.*;

@Test
@ContextConfiguration
        (
                locations = {
                        "classpath:/config/test-config.xml",
                        "classpath:/config/driver-config.xml"
                }
        )
@PropertySource("classpath:/config/test-zipcodes.properties")
@Listeners(com.codeborne.selenide.testng.ScreenShooter.class)
public class AbstractTest extends AbstractTestNGSpringContextTests implements WebFieldConsts{

    @Autowired(required=true)
    @Qualifier("globalConfig")
    protected GlobalConfiguration config;

    @Autowired(required = true)
    @Qualifier("driverUtils")
    protected DriverUtils driverUtils;

    @Autowired(required = true)
    @Qualifier("brickUtil")
    protected BrickseekUtils brickseekUtils;

    @BeforeSuite
    public void setupSuite(ITestContext ctx){
        System.out.println("Starting Suite:"+ctx.getSuite().getName());
    }

    @AfterSuite
    public void teardownSuite(ITestContext ctx){
        System.out.println("Ending Suite:"+ctx.getSuite().getName());
        if( ! Configuration.holdBrowserOpen){
            driverUtils.getWebDriver().quit();
        }
    }

}
