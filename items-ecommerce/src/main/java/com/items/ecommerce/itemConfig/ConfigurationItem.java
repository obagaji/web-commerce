package com.items.ecommerce.itemConfig;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
@RequiredArgsConstructor
public class ConfigurationItem {

    private final Logger LOG = LoggerFactory.getLogger(ConfigurationItem.class);

    @Bean
    public RestClient restClient()
    {
        return RestClient.builder()
                .baseUrl("http://localhost:9990/api/customer")
                .build();
    }
}
