package com.alessio.api.services;

import org.openapitools.client.model.FiscalCodePayload;
import org.openapitools.client.model.LimitedProfile;
import org.springframework.stereotype.Service;

import com.alessio.api.utils.ServiceApiClientUtils;

@Service
public class ApiService {
    
    public LimitedProfile getProfile(String fiscalCode){
        var fnServiceApiClient = ServiceApiClientUtils.getInstance();
        FiscalCodePayload payload = new FiscalCodePayload().fiscalCode(fiscalCode);
        return fnServiceApiClient.getProfileByPOST(payload);
    }
}
