package com.example.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// RefreshScope is a bean in the context and has a public method to refresh all beans in the scope by clearing the target cache.
@RefreshScope
// use template engine - if annotated with controller
@Controller
public class SimpleController {
    
    @Value("${common.config}")
    private String config;

    @Value("${common.ver}")
    private String ver;

    @Value("${common.value}")
    private String encryptedValue;
    

    @RequestMapping("/config")
    public String getConfig(Model m) {

        m.addAttribute("ver", ver);

        //name of view
        return "config";
        
    }
}

