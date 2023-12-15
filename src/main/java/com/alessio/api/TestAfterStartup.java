package com.alessio.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.alessio.api.services.ApiService;

@Component
public class TestAfterStartup {

    @Autowired
	private ApiService apiService;

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        System.out.println("Run after startup");
		var res = apiService.getProfile("AAAAAAAAAAAAAA");
        System.out.println(res);
    }
}
