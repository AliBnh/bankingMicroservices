package net.ali.customer_service.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Getter @Setter
@RefreshScope @AllArgsConstructor @NoArgsConstructor
@ConfigurationProperties(prefix = "global.params")
public class GlobalConfig {
    private int p1;
    private int p2;
}
