package com.util;

import com.config.GlobalConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.codeborne.selenide.WebDriverRunner;

@Component
@Scope("thread")
public class DriverUtils {

    @Autowired(required=true)
    @Qualifier("globalConfig")
    protected GlobalConfiguration config;

    @Autowired
    protected ApplicationEventPublisher eventPublisher;

    public void waitSecs(long secs){
        waitMillis(secs * 1000);
    }

    public void waitMillis(long milliSecs){
        try{
            Thread.sleep(milliSecs);
        }catch(InterruptedException e){
            System.out.println("Interrupted while waiting for timeout" + milliSecs);
        }
    }

    public WebDriverWait getWait(){
        return new WebDriverWait(getWebDriver(), config.getMaxRequestWaitTime());
    }

    public WebDriverWait getWait(long secs){
        return new WebDriverWait(getWebDriver(), secs);
    }

    public WebDriver getWebDriver(){
        return WebDriverRunner.getWebDriver();
    }

}