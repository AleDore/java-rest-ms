package com.alessio.api.utils;

import org.openapitools.client.ApiClient;
import org.openapitools.client.api.DefaultApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceApiClientUtils {

    @Value("${services.subscription.key}")
    private String subKey;

    private static String SUBSCRIPTION_KEY;

    @Value("${services.subscription.key}")
    public void setNameStatic(String name){
        ServiceApiClientUtils.SUBSCRIPTION_KEY = subKey;
    }
    
    private static DefaultApi instance;

    private ServiceApiClientUtils(){}

    public static synchronized DefaultApi getInstance() {
        if (instance == null) {
            ApiClient apiClient = new ApiClient();
            apiClient.setApiKey(SUBSCRIPTION_KEY);
            apiClient.setDebugging(true);
            instance = new DefaultApi(apiClient);
        }
        return instance;
    }
}
