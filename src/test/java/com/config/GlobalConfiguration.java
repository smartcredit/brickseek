package com.config;


import com.model.UserLoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/config/props/test-zipcodes.properties")
public class GlobalConfiguration {

    @Autowired
    @Qualifier("targetLoginInfo")
    private UserLoginInfo targetLoginInfo;

    @Autowired
    @Qualifier("walmartLoginInfo")
    private UserLoginInfo walmartLoginInfo;

    @Autowired
    @Qualifier("brickseekLoginInfo")
    private UserLoginInfo brickseekLoginInfo;

    @Autowired
    @Qualifier("urlInfo")
    private URLInfo urlInfo;

    @Value("#{'${brickseek.search.zips}'.split(',')}")
    public String[] zips;

    @Value("#{'${brickseek.search.skus}'.split(',')}")
    public String[] skus;


    private int maxWaitTime = 10;
    private int maxRequestWaitTime = 60;

    public UserLoginInfo getTargetLoginInfo() {
        return targetLoginInfo;
    }

    public void setTargetLoginInfo(UserLoginInfo targetLoginInfo) {
        this.targetLoginInfo = targetLoginInfo;
    }

    public UserLoginInfo getWalmartLoginInfo() {
        return walmartLoginInfo;
    }

    public void setWalmartLoginInfo(UserLoginInfo walmartLoginInfo) {
        this.walmartLoginInfo = walmartLoginInfo;
    }

    public UserLoginInfo getBrickseekLoginInfo() {
        return brickseekLoginInfo;
    }

    public void setBrickseekLoginInfo(UserLoginInfo brickseekLoginInfo) {
        this.brickseekLoginInfo = brickseekLoginInfo;
    }

    public URLInfo getUrlInfo() {
        return urlInfo;
    }

    public void setUrlInfo(URLInfo urlInfo) {
        this.urlInfo = urlInfo;
    }

    public int getMaxWaitTime() {
        return maxWaitTime;
    }

    public void setMaxWaitTime(int maxWaitTime) {
        this.maxWaitTime = maxWaitTime;
    }

    public int getMaxRequestWaitTime() {
        return maxRequestWaitTime;
    }

    public void setMaxRequestWaitTime(int maxRequestWaitTime) {
        this.maxRequestWaitTime = maxRequestWaitTime;
    }
}
