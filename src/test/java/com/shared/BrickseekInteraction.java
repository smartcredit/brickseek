package com.shared;

import com.event.BrickseekSearchEvent;
import com.model.BrickseekSearchResults;
import com.util.WebFieldConsts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrickseekInteraction extends AbstractTest {

    @Test
    public void openBrickseekWalmart(){
        driverUtils.getWebDriver().get(config.getUrlInfo().getBrickseek_walmart_url());
    }
    @Test
    public void openBrickseekTarget(){
        driverUtils.getWebDriver().get(config.getUrlInfo().getBrickseek_target_url());
    }

    @Test
    public void closeBrickseekWelcomeMsg(){
        WebDriverWait wdw = driverUtils.getWait();
        WebElement element = driverUtils.getWebDriver().findElement(By.id(WebFieldConsts.BRICKSEEK_WELCOME_MSG_CLOSE_ID));
        if(element.isDisplayed()){
            wdw.until(ExpectedConditions.presenceOfElementLocated(By.id(WebFieldConsts.BRICKSEEK_WELCOME_MSG_CLOSE_ID)));
            element.click();
        }
    }

    @Test
    public void clearBrickseekSearchFields(){
        brickseekUtils.clearSKU();
        /*brickseekUtils.clearUPC();*/
        brickseekUtils.clearZIP();
    }

    @Test
    @Parameters({"skuOrUpc", "zip"})
    public void fillBrickseekSearchFields(String skuOrUpc, String zip){
        brickseekUtils.fillField(SKU, skuOrUpc);
        brickseekUtils.fillField(WebFieldConsts.BRICKSEEK_ZIP, zip);
    }

    @Test
    public void brickseekSearch(){
        WebElement element = brickseekUtils.getElementByXPath(BRICKSEEK_SEARCH_BUTTON_XPATH);
        if(element != null && element.isEnabled()){
            element.click();
        }
    }

    @Test
    public void captureSearchResults(){
        WebElement prodElement = null; /*brickseekUtils.getElementByClassName(BRICKSEEK_PRODUCT_INFO_CLASSNAME);*/
        if(prodElement != null && prodElement.isDisplayed()) {
            BrickseekSearchResults bssr = new BrickseekSearchResults();
            bssr.setProductname(prodElement.getText());

            BrickseekSearchEvent bsse = new BrickseekSearchEvent(null, null, null, null, bssr);
            brickseekUtils.publishSearchEvent(bsse);
        }
    }

    @Test
    public void SearchByInput(){
        openBrickseekWalmart();
        closeBrickseekWelcomeMsg();
        System.out.println(config.skus.toString());
        System.out.println(config.zips.toString());
        for(int i=0; i<config.skus.length; i++){
            for(int j=0; j<config.zips.length; j++){
                clearBrickseekSearchFields();
                brickseekUtils.fillField(SKU, config.skus[i]);
                brickseekUtils.fillField(BRICKSEEK_ZIP, config.zips[j]);
                brickseekSearch();
                captureSearchResults();
            }
        }
    }
}
