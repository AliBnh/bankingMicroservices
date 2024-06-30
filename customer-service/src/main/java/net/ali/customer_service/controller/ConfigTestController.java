package net.ali.customer_service.controller;

import net.ali.customer_service.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestController {

    @Autowired
    private GlobalConfig globalConfig;

    @GetMapping("/global-config")
    public GlobalConfig getGlobalConfig() {
        return globalConfig;
    }

}
