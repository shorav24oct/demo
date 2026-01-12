package com.example.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "mail")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class MailConfig {
    private String host;
    private String port;
    private String url;
}
