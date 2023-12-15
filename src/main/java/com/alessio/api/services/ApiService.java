package com.alessio.api.services;

import org.openapitools.client.model.FiscalCodePayload;
import org.openapitools.client.model.LimitedProfile;
import org.springframework.stereotype.Service;

import com.alessio.api.factory.ServiceApiClientFactory;

@Service
public class ApiService {
    
    public LimitedProfile getProfile(String fiscalCode){
        var fnServiceApiClient = ServiceApiClientFactory.getInstance();
        FiscalCodePayload payload = new FiscalCodePayload().fiscalCode(fiscalCode);
        return fnServiceApiClient.getProfileByPOST(payload);
    }
}
