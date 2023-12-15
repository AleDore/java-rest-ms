package com.alessio.api.factory;

import org.openapitools.client.ApiClient;
import org.openapitools.client.api.DefaultApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceApiClientFactory {

    @Value("${services.subscription.key}")
    private String subKey;

    private static String SUBSCRIPTION_KEY;

    @Value("${services.subscription.key}")
    public void setNameStatic(String name){
        ServiceApiClientFactory.SUBSCRIPTION_KEY = subKey;
    }
    
    private static DefaultApi instance;

    private ServiceApiClientFactory(){}

    public static synchronized DefaultApi getInstance() {
        if (instance == null) {
            ApiClient apiClient = new ApiClient();
            apiClient.setApiKey(SUBSCRIPTION_KEY);
            instance = new DefaultApi(apiClient);
        }
        return instance;
    }
}
