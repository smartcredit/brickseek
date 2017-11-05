package com.util;

import com.config.GlobalConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.codeborne.selenide.WebDriverRunner;

import javax.annotation.Nullable;

@Component
@Scope("thread")
public class DriverUtils {

    @Autowired(required=true)
    @Qualifier("globalConfig")
    protected GlobalConfiguration config;

    @Autowired
    protected ApplicationEventPublisher eventPublisher;

    public static final String SCROLL_ELEMENT_VERTICAL = "arguments[0].scrollTop + arguments[i]";

    public static final String SCROLL_ELEMENT_HOTIZONTAL = "arguments[0].scrollLeft + arguments[i]";

    public static ExpectedCondition<?> brickseekSearchCompleted(final String prevPageSrc){
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(@Nullable WebDriver input) {
                String currentPageSrc = input.getPageSource();
                return !currentPageSrc.equals(prevPageSrc);
            }

            public String toString(){
                return "Results search is not completed";
            }
        };
    }

    public static ExpectedCondition<?> welcomeMsgDisplayed(){
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(@Nullable WebDriver input) {
                WebElement webElement = input.findElement(By.id(WebFieldConsts.BRICKSEEK_WELCOME_MSG_CLOSE_ID));
                return webElement.isDisplayed();
            }

            public String toString(){
                return "Welcome message is not displayed";
            }
        };
    }

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

    public void scrollElementVertical(WebElement el, int scrollIncrement){
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript(SCROLL_ELEMENT_VERTICAL, new Integer((scrollIncrement)));
    }

    public void waitUntilSearchCompleted(String pageSrc){
        new WebDriverWait(getWebDriver(), config.getMaxRequestWaitTime())
                .until(brickseekSearchCompleted(pageSrc));
    }

    public WebElement waitUntilWelcomeMsgShown(){
        try {
            new WebDriverWait(getWebDriver(), config.getMaxRequestWaitTime())
                    .until(welcomeMsgDisplayed());
            return getWebDriver().findElement(By.id(WebFieldConsts.BRICKSEEK_WELCOME_MSG_CLOSE_ID));
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }

}
