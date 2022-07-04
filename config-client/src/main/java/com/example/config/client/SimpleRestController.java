package com.example.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// RefreshScope is a bean in the context and has a public method to refresh all beans in the scope by clearing the target cache.
@RefreshScope
// do not use template engine - if annotated with restcontroller
@RestController
public class SimpleRestController {
    
    @Value("${common.config}")
    private String config;

    @Value("${common.ver}")
    private String ver;

    @Value("${common.value}")
    private String encryptedValue;
    


    @RequestMapping("/rest/config")
    public ResponseModel getConfig() {

        ResponseModel response = new ResponseModel();
        response.setStatus(true);
        String message = config + " - " + ver + " - " + encryptedValue;
        response.setMessage(message);
        return response;
        
    }}

