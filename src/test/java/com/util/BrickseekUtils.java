package com.util;

import com.event.BrickseekSearchEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("brickUtil")
@Scope("thread")
public class BrickseekUtils implements  WebFieldConsts{

    @Autowired(required = true)
    @Qualifier("driverUtils")
    protected DriverUtils driverUtils;

    public void publishSearchEvent(BrickseekSearchEvent searchEvent){
        driverUtils.eventPublisher.publishEvent(searchEvent);
    }
    public void clearField(String name){
        WebElement we = driverUtils.getWebDriver().findElement(By.id(name));
        if(we != null){
            we.clear();
        }
    }
    public void clearSKU(){
        clearField(SKU);
    }
    public void clearUPC(){
        clearField(UPC);
    }
    public void clearZIP(){
        clearField(BRICKSEEK_ZIP);
    }
    public void fillField(String fieldName, String value){
        if(fieldName == null || value == null)
            return;
        WebElement webElement = driverUtils.getWebDriver().findElement(By.id(fieldName));
        if(webElement != null){
            webElement.sendKeys(value);
        }
    }
    public WebElement getElementById(String name){
        if(name == null){
            return null;
        }
        return driverUtils.getWebDriver().findElement(By.id(name));
    }
    public WebElement getElementByXPath(String name){
        if(name == null){
            return null;
        }
        return driverUtils.getWebDriver().findElement(By.xpath(name));
    }

    public WebElement getElementByClassName(String name){
        if(name == null){
            return null;
        }
        return driverUtils.getWebDriver().findElement(By.className(name));
    }

}
